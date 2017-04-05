package es.uvigo.esei.pro2.core.referencias;

import es.uvigo.esei.pro2.core.Referencia;

/**
 *
 * @author Fran
 */
public class DocumentoWeb extends Referencia {

    private String url;
    private Fecha fecha;

    public DocumentoWeb(String autores, String titulo, int ano, TipoReferencia tipo) {
        super(autores, titulo, ano, tipo);
    }

    public DocumentoWeb(String autores, String titulo, int ano, TipoReferencia tipo, String url, Fecha fecha) {
        super(autores, titulo, ano, tipo);
        this.url = url;
        this.fecha = fecha;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        toret.append("DocumentoWeb: ");
        toret.append(super.toString());
        toret.append(" ; URL ");
        toret.append(getUrl());
        toret.append(" ; Fecha de consulta ");
        toret.append(getFecha().toString());
        return toret.toString();
    }

}
