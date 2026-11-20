
import modelo.Producto;
import modelo.Bebida;
import modelo.Comida;
import persistencia.ConexionBD;
import servicios.ReglaDescuento;
import servicios.ServicioDescuento;
import vista.VentanaCafeteria;
import javax.swing.SwingUtilities;

public class Principal {

    public static void main(String[] args) {

        // Probar conexion al iniciar la aplicacion
System.out.println("=== CONEXION A BASE DE DATOS ===");

System.out.println(ConexionBD.probarConexion());

System.out.println("----------------------");

        // Crear productos de la cafetería
        Producto bebida = new Bebida("Jugo natural", 8.0);
        Producto comida = new Comida("Sándwich", 12.0);

        // Demostrar herencia y polimorfismo
        System.out.println("=== CAFETERÍA ===");

        System.out.println(
            bebida.getTipo() + ": " + bebida.getNombre()
        );

        System.out.println(
            comida.getTipo() + ": " + comida.getNombre()
        );

        // Calcular total del pedido
        double total = bebida.getPrecio()
                     + comida.getPrecio();

        // Expresión lambda para calcular el descuento
        ReglaDescuento regla = monto ->
            monto > 10.0 ? monto * 0.15 : 0.0;

        // Crear el servicio de descuentos
        ServicioDescuento servicio =
            new ServicioDescuento(regla);

        // Calcular valores
        double descuento =
            servicio.calcularDescuento(total);

        double totalFinal =
            servicio.calcularTotalFinal(total);

        // Mostrar resultados
        System.out.println("----------------------");

        System.out.printf("Total: $%.2f%n", total);

        System.out.printf(
            "Descuento: $%.2f%n", descuento
        );

        System.out.printf(
            "Total final: $%.2f%n", totalFinal
        );

        // Probar un pedido sin descuento
        double pedidoPequeno = 10.0;

        System.out.println("----------------------");
        System.out.println("Prueba sin descuento:");

        System.out.printf(
            "Total final: $%.2f%n",
            servicio.calcularTotalFinal(pedidoPequeno)
        );

        // Iniciar la interfaz grafica
    SwingUtilities.invokeLater(() -> {
    VentanaCafeteria ventana = new VentanaCafeteria();
    ventana.setVisible(true);
        });
    }
}
