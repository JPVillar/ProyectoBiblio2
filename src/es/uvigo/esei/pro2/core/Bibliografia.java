/*  Definición de la clase Bibliografia
 *  Una bibliografia esta compuesta de referencias bibliograficas
 */
package es.uvigo.esei.pro2.core;

import es.uvigo.esei.pro2.core.referencias.ArticuloRevista;
import es.uvigo.esei.pro2.core.referencias.DocumentoWeb;
import es.uvigo.esei.pro2.core.referencias.Libro;
import es.uvigo.esei.pro2.excepciones.MaximoReferenciasException;
import es.uvigo.esei.pro2.excepciones.NumeroReferenciasException;
import es.uvigo.esei.pro2.excepciones.PosicionReferenciasException;

/**
 *
 * @author nrufino
 */
public class Bibliografia {

    private Referencia[] referencias;
    private int numReferencias;

    /**
     * Nueva Coleccion con un num. max. de referencias.
     *
     * @param maxReferencias el num. max. de referencias, como entero.
     */
    public Bibliografia(int maxReferencias) {
        numReferencias = 0;
        referencias = new Referencia[maxReferencias];
    }

    /**
     * Devuelve la referencia en pos
     *
     * @param pos el lugar de la referencia en el vector de referencias
     * @return el objeto Referencia correspondiente.
     */
    public Referencia get(int pos) throws PosicionReferenciasException {
        if (pos >= getNumReferencias()) {
            throw new PosicionReferenciasException("get(): sobrepasa la pos: " + (pos + 1) + " / " + getMaxReferencias());
        }
        return referencias[pos];
    }

    /**
     * Devuelve el num. de referencias creadas.
     *
     * @return el num. de referencias disponibles, como entero.
     */
    public int getNumReferencias() {
        return numReferencias;
    }

    /**
     * Devuelve el max. de numReferenciass
     *
     * @return el num. de referencias max,, como entero
     */
    public int getMaxReferencias() {
        return referencias.length;
    }

    /**
     * Inserta una nueva referencia
     *
     * @param r el nuevo objeto Referencia
     */
    public void inserta(Referencia r) throws MaximoReferenciasException {
        final int maxReferencias = getMaxReferencias();
        if (getNumReferencias() >= maxReferencias) {
            throw new MaximoReferenciasException("inserta(): sobrepasa max.: " + getMaxReferencias());
        }
        referencias[numReferencias] = r;
        ++numReferencias;
    }

    /**
     * Elimina una referencia
     *
     * @param pos el lugar de la referencia en el vector de referencias
     */
    public void elimina(int pos) throws NumeroReferenciasException {
        if (pos >= getNumReferencias()) {
            throw new NumeroReferenciasException("elimina(): sobrepasa el número de referencias : "
                    + getNumReferencias());
        }
        referencias[pos] = referencias[--numReferencias];
    }

    /**
     * Devuelve el contenido de todas las Referenciass
     *
     * @return el String con el contenido
     */
    public String toString(char opcion) {
        StringBuilder toret;
        final int numReferencias = getNumReferencias();
        toret = new StringBuilder();
        if (numReferencias > 0) {
            switch (opcion) {
                case 'L':
                    for (int i = 0; i < numReferencias; i++) {
                        if (referencias[i] instanceof Libro) {
                            toret.append((i + 1) + ". ");
                            toret.append(referencias[i].toString() + "\n");
                        }
                    }
                    break;
                case 'A':
                    for (int i = 0; i < numReferencias; i++) {
                        if (referencias[i] instanceof ArticuloRevista) {
                            toret.append((i + 1) + ". ");
                            toret.append(referencias[i].toString() + "\n");
                        }
                    }
                    break;
                case 'D':
                    for (int i = 0; i < numReferencias; i++) {
                        if (referencias[i] instanceof DocumentoWeb) {
                            toret.append((i + 1) + ". ");
                            toret.append(referencias[i].toString() + "\n");
                        }
                    }
                    break;
                default:
                    for (int i = 0; i < numReferencias; i++) {
                        toret.append((i + 1) + ". ");
                        toret.append(referencias[i].toString() + "\n");
                    }
            }
        } else {
            toret.append("No hay referencias.");
        }
        if (toret.length() == 0) {
            System.out.println("No hay referencias de ese tipo");
        }
        return toret.toString();
    }
}
