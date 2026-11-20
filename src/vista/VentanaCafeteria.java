
package vista;

import javax.swing.*;
import java.awt.*;

import persistencia.ConexionBD;
import servicios.ReglaDescuento;
import servicios.ServicioDescuento;

public class VentanaCafeteria extends JFrame {

    private final JTextField campoMonto;
    private final JButton botonCalcular;
    private final JTextArea areaResultados;
    private final ServicioDescuento servicio;

    public VentanaCafeteria() {

        ReglaDescuento regla = monto ->
            monto > 10.0 ? monto * 0.15 : 0.0;

        servicio = new ServicioDescuento(regla);

        setTitle("Sistema de Descuentos - Cafeteria");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal =
            new JPanel(new BorderLayout(10, 10));

        panelPrincipal.setBorder(
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        JLabel titulo =
            new JLabel("SISTEMA DE DESCUENTOS");

        titulo.setFont(new Font(
            "Arial", Font.BOLD, 20
        ));

        titulo.setHorizontalAlignment(
            SwingConstants.CENTER
        );

        panelPrincipal.add(titulo, BorderLayout.NORTH);

        JPanel panelCentral =
            new JPanel(new BorderLayout(10, 10));

        JPanel panelEntrada =
            new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel etiquetaMonto =
            new JLabel("Total del pedido: $");

        campoMonto = new JTextField(12);

        botonCalcular =
            new JButton("Calcular Descuento");

        panelEntrada.add(etiquetaMonto);
        panelEntrada.add(campoMonto);
        panelEntrada.add(botonCalcular);

        panelCentral.add(
            panelEntrada, BorderLayout.NORTH
        );

        areaResultados = new JTextArea();
        areaResultados.setEditable(false);
        areaResultados.setFont(
            new Font("Monospaced", Font.PLAIN, 14)
        );

        panelCentral.add(
            new JScrollPane(areaResultados),
            BorderLayout.CENTER
        );

        panelPrincipal.add(
            panelCentral, BorderLayout.CENTER
        );

        setContentPane(panelPrincipal);

        botonCalcular.addActionListener(
            e -> calcularDescuento()
        );

        campoMonto.addActionListener(
            e -> calcularDescuento()
        );

        // Verificar SQLite al iniciar la ventana
        areaResultados.append(
            "=== ESTADO DE LA BASE DE DATOS ===\n"
        );

        areaResultados.append(
            ConexionBD.probarConexion() + "\n\n"
        );
    }

    private void calcularDescuento() {

        try {

            String entrada = campoMonto.getText()
                .trim().replace(",", ".");

            double total = Double.parseDouble(entrada);

            if (!Double.isFinite(total) || total < 0) {
                throw new IllegalArgumentException(
                    "Ingrese un monto válido no negativo."
                );
            }

            double descuento =
                servicio.calcularDescuento(total);

            double totalFinal =
                servicio.calcularTotalFinal(total);

            areaResultados.append(
                "=== RESULTADO DEL PEDIDO ===\n"
            );

            areaResultados.append(
                String.format("Total: $%.2f%n", total)
            );

            areaResultados.append(
                String.format(
                    "Descuento: $%.2f%n", descuento
                )
            );

            areaResultados.append(
                String.format(
                    "Total final: $%.2f%n", totalFinal
                )
            );

            areaResultados.append(
                "------------------------------\n"
            );

        } catch (NumberFormatException ex) {

            areaResultados.append(
                "ERROR: Ingrese un número válido.\n"
            );

        } catch (IllegalArgumentException ex) {

            areaResultados.append(
                "ERROR: " + ex.getMessage() + "\n"
            );
        }
    }
}
