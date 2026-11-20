
package modelo;

public class Bebida extends Producto {

    public Bebida(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public String getTipo() {
        return "Bebida";
    }
}
