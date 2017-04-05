/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uvigo.esei.pro2.core.referencias;

import es.uvigo.esei.pro2.core.Referencia;

/**
 *
 * @author Fran
 */
public class Libro extends Referencia {

    public enum TipoFormato {
        PAPEL, ELECTRONICO
    };

    private String editorial;
    private String isbn;
    private TipoFormato formato;

    public Libro(String autores, String titulo, int ano, TipoReferencia tipo) {
        super(autores, titulo, ano, tipo);
    }

    public Libro(String autores, String titulo, int ano, TipoReferencia tipo, String editorial, String isbn, TipoFormato formato) {
        super(autores, titulo, ano, tipo);
        this.editorial = editorial;
        this.isbn = isbn;
        this.formato = formato;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public TipoFormato getFormato() {
        return formato;
    }

    public void setFormato(TipoFormato formato) {
        this.formato = formato;
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        toret.append("Libro: ");
        toret.append(super.toString());
        toret.append("Editorial ");
        toret.append(getEditorial());
        toret.append(" ; ISBN ");
        toret.append(getIsbn());
        toret.append(" ; Formato ");
        toret.append(getFormato());

        return toret.toString();
    }
}
