package es.uvigo.esei.pro2.core.referencias;

import es.uvigo.esei.pro2.core.Referencia;

/**
 *
 * @author Fran
 */
public class ArticuloRevista extends Referencia {

    private String doi;
    private int volumen;
    private int numero;
    private int paginaInicio;
    private int paginaFin;

    public ArticuloRevista(String autores, String titulo, int ano) {
        super(autores, titulo, ano);
    }

    public ArticuloRevista(String autores, String titulo, int ano, String doi, int volumen, int numero, int paginaInicio, int paginaFin) {
        super(autores, titulo, ano);
        this.doi = doi;
        this.volumen = volumen;
        this.numero = numero;
        this.paginaInicio = paginaInicio;
        this.paginaFin = paginaFin;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setPaginaInicio(int paginaInicio) {
        this.paginaInicio = paginaInicio;
    }

    public void setPaginaFin(int paginaFin) {
        this.paginaFin = paginaFin;
    }

    public String getDoi() {
        return doi;
    }

    public int getVolumen() {
        return volumen;
    }

    public int getNumero() {
        return numero;
    }

    public int getPaginaInicio() {
        return paginaInicio;
    }

    public int getPaginaFin() {
        return paginaFin;
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        toret.append("ArticuloRevista: ");
        toret.append(super.toString());
        toret.append(" ; DOI ");
        toret.append(getDoi());
        toret.append(" ; Volumen ");
        toret.append(getVolumen());
        toret.append(" ; Numero ");
        toret.append(getNumero());
        toret.append(" ; Pagina de inicio ");
        toret.append(getPaginaInicio());
        toret.append(" ; Pagina de fin ");
        toret.append(getPaginaFin());

        return toret.toString();
    }
}
