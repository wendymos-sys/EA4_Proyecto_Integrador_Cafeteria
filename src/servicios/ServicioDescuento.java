
package servicios;

public class ServicioDescuento {

    private final ReglaDescuento regla;

    public ServicioDescuento(ReglaDescuento regla) {
        if (regla == null) {
            throw new IllegalArgumentException(
                "La regla de descuento no puede ser nula"
            );
        }

        this.regla = regla;
    }

    public double calcularDescuento(double total) {

        validarTotal(total);

        double descuento = regla.calcularDescuento(total);

        if (!Double.isFinite(descuento)
                || descuento < 0 || descuento > total) {
            throw new IllegalArgumentException(
                "El descuento calculado no es válido"
            );
        }

        return descuento;
    }

    public double calcularTotalFinal(double total) {

        return total - calcularDescuento(total);
    }

    private void validarTotal(double total) {

        if (!Double.isFinite(total) || total < 0) {
            throw new IllegalArgumentException(
                "El total debe ser un valor válido"
            );
        }
    }
}
