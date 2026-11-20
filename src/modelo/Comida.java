
package modelo;

public class Comida extends Producto {

    public Comida(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public String getTipo() {
        return "Comida";
    }
}
