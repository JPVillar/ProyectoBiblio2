package es.uvigo.esei.pro2.core.referencias;

/**
 *
 * @author Fran
 */
public class Fecha {

    private String fecha;

    public Fecha(int dia, int mes, int anio) {
        fecha = String.format("%d/%d/%d", dia, mes, anio);
    }

    @Override
    public String toString() {
        return "Fecha{ " + fecha + " }";
    }

}
