package es.uvigo.esei.pro2.core.referencias;

import es.uvigo.esei.pro2.core.Referencia;

/**
 *
 * @author JPVillar
 */
public class Tesis extends Referencia {

    String uni;

    public Tesis(String uni, String autores, String titulo, int ano) {
        super(autores, titulo, ano);
        this.uni = uni;
    }

    public String getUni() {
        return uni;
    }

    public void setUni(String uni) {
        this.uni = uni;
    }

    public String toString() {
        StringBuilder toret = new StringBuilder();
        toret.append("Tesis: ");
        toret.append(super.toString());
        toret.append("Universidad: ");
        toret.append(getUni() + "\n");

        return toret.toString();
    }
}
