package es.uvigo.esei.pro2.ui;

import es.uvigo.esei.pro2.core.Bibliografia;
import es.uvigo.esei.pro2.core.Referencia;
import es.uvigo.esei.pro2.core.referencias.ArticuloRevista;
import es.uvigo.esei.pro2.core.referencias.DocumentoWeb;
import es.uvigo.esei.pro2.core.referencias.Fecha;
import es.uvigo.esei.pro2.core.referencias.Libro;
import es.uvigo.esei.pro2.excepciones.MaximoReferenciasException;
import es.uvigo.esei.pro2.excepciones.NumeroReferenciasException;
import es.uvigo.esei.pro2.excepciones.PosicionReferenciasException;

import java.util.Scanner;

/**
 * Interfaz de lin. de comando
 */
public class Ilc {

    /**
     * Realiza el reparto de la funcionalidad ler = lee, evalua, repite
     */
    public void ler() {
        int op;

        // Lee el num. max. de referencias
        int maxReferencias = leeNum("Num. max. referencias: ");

        // Prepara
        Bibliografia coleccion = new Bibliografia(maxReferencias);

        // Bucle ppal
        do {
            System.out.println("\nGestión bibliográfica");

            op = menu(coleccion);

            try {
                switch (op) {
                    case 0:
                        System.out.println("Fin.");
                        break;
                    case 1:
                        insertaReferencia(coleccion);
                        break;
                    case 2:
                        modificaReferencia(coleccion);
                        break;
                    case 3:
                        eliminaReferencia(coleccion);
                        break;
                    case 4:
                        System.out.println(coleccion.toString());
                        break;
                    case 5:
                        listarReferencias(coleccion);
                        break;
                    default:
                        System.out.println("No es correcta esa opción ( "
                                + op + " )");
                }
            } catch (NumberFormatException e) {
                System.err.println("\nERROR: " + e.getMessage());

            } catch (PosicionReferenciasException e) {
                System.err.println("\nERROR: " + e.getMessage());

            } catch (NumeroReferenciasException e) {
                System.err.println("\nERROR: " + e.getMessage());

            } catch (MaximoReferenciasException e) {
                System.err.println("\nERROR: " + e.getMessage());

            } catch (Exception e) {
                System.err.println("\nERROR: " + e.getMessage());
            }
        } while (op != 0);

    }

    /**
     * Lee un num. de teclado
     *
     * @param msg El mensaje a visualizar.
     * @return El num., como entero
     */
    private int leeNum(String msg) {
        boolean repite;
        int toret = 0;
        Scanner teclado = new Scanner(System.in);

        do {
            repite = false;
            System.out.print(msg);

            try {
                toret = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException exc) {
                repite = true;
            }
        } while (repite);

        return toret;
    }

    /**
     * Presenta un menu con las opciones, y permite seleccionar una.
     *
     * @return la opcion seleccionada, como entero
     */
    private int menu(Bibliografia coleccion) {
        int toret;

        do {
            System.out.println("Número de referencias bibliográficas: "
                    + coleccion.getNumReferencias()
                    + " / " + coleccion.getMaxReferencias());
            System.out.println(
                    "\n1. Inserta nueva referencia\n"
                    + "2. Modifica referencia\n"
                    + "3. Elimina referencia\n"
                    + "4. Listar referencias\n"
                    + "0. Salir\n");
            toret = leeNum("Selecciona: ");
        } while (toret < 0
                && toret > 4);

        System.out.println();
        return toret;
    }

    /**
     * Lista las referencias segun el tipo de objeto que se elige
     *
     * @param coleccion La coleccion en la que se inserta la referencia.
     */
    private void listarReferencias(Bibliografia coleccion) {
        char tipoReferencia;
        do {
            tipoReferencia = leeCaracter("Introduce el tipo de referencia a listar(L: Libro, A: Articulo revista, D: Documento web): ");
        } while ((tipoReferencia != 'L') && (tipoReferencia != 'A') && (tipoReferencia != 'D'));
        System.out.println(coleccion.toString(tipoReferencia));
    }

    /**
     * Crea una nueva referencia y la inserta en la coleccion
     *
     * @param coleccion La coleccion en la que se inserta la referencia.
     */
    private void insertaReferencia(Bibliografia coleccion) throws MaximoReferenciasException {
        char tipoReferencia;
        Referencia r = null;
        do {
            tipoReferencia = leeCaracter("Introduce el tipo de referencia (L: Libro, A: Articulo revista, D: Documento web): ");
        } while ((tipoReferencia != 'L') && (tipoReferencia != 'A') && (tipoReferencia != 'D'));
        switch (tipoReferencia) {
            case 'L':
                r = new Libro("", "", tipoReferencia, Referencia.TipoReferencia.LIBRO);
                break;
            case 'A':
                r = new ArticuloRevista("", "", tipoReferencia, Referencia.TipoReferencia.ARTICULOREVISTA);
                break;
            case 'D':
                r = new DocumentoWeb("", "", tipoReferencia, Referencia.TipoReferencia.LIBRO);
                break;
        }

        modificaReferencia(r);
        coleccion.inserta(r);
    }

    /**
     * Borra una referencia por su num.
     *
     * @param coleccion La coleccion en el que se elimina la referencia
     */
    private void eliminaReferencia(Bibliografia coleccion) throws Exception {
        coleccion.elimina(leeNumReferencia(coleccion));
    }

    /**
     * Modifica una referencia existente.
     *
     * @param coleccion La coleccion de la cual modificar una referencia.
     */
    private void modificaReferencia(Bibliografia coleccion) throws Exception {
        if (coleccion.getNumReferencias() > 0) {
            this.modificaReferencia(coleccion.get(leeNumReferencia(coleccion)));
        } else {
            System.out.println("La coleccion no contiene referencias.");
        }
    }

    private void modificaReferencia(Referencia r) {
        String info;
        char tipoReferencia;
        String dia;
        String mes;
        String anno;

        Scanner teclado = new Scanner(System.in);
        Referencia.TipoReferencia etiqueta;

        // Autores
        System.out.print("Autores de la referencia ");
        if (r.getAutores().length() > 0) {
            System.out.print("[" + r.getAutores() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if (info.length() > 0) {
            r.setAutores(info);
        }

        // Titulo
        System.out.print("Titulo de la referencia ");
        if (r.getTitulo().length() > 0) {
            System.out.print("[" + r.getTitulo() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if (info.length() > 0) {
            r.setTitulo(info);
        }

        // Ano
        System.out.print("Ano de la referencia ");
        if (r.getAno() > 0) {
            System.out.print("[" + r.getAno() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if (info.length() > 0) {
            r.setAno(Integer.parseInt(info));
        }

        // Tipo de referencia          
        if (r instanceof Libro) {
            Libro libro = (Libro) r;
            System.out.print("Editorial?");
            info = teclado.nextLine().trim();
            libro.setEditorial(info);
            System.out.print("ISBN?");
            info = teclado.nextLine().trim();
            libro.setIsbn(info);
            do {
                tipoReferencia = leeCaracter("Introduce el formato del libro (P: papel, E: electronico): ");
            } while ((tipoReferencia != 'P') && (tipoReferencia != 'E'));
            switch (tipoReferencia) {
                case 'P':
                    libro.setFormato(Libro.TipoFormato.PAPEL);
                    break;
                case 'E':
                    libro.setFormato(Libro.TipoFormato.ELECTRONICO);
                    break;
            }
        } else if (r instanceof ArticuloRevista) {
            ArticuloRevista revista = (ArticuloRevista) r;
            System.out.print("Titulo revista?");
            info = teclado.nextLine().trim();
            revista.setTitulo(info);
            System.out.print("Doi?");
            info = teclado.nextLine().trim();
            revista.setDoi(info);
            System.out.print("Volumen?");
            info = teclado.nextLine().trim();
            revista.setVolumen(Integer.parseInt(info));
            System.out.print("Numero?");
            info = teclado.nextLine().trim();
            revista.setNumero(Integer.parseInt(info));
            System.out.print("Pagina inicio?");
            info = teclado.nextLine().trim();
            revista.setPaginaInicio(Integer.parseInt(info));
            System.out.print("Pagina fin?");
            info = teclado.nextLine().trim();
            revista.setPaginaFin(Integer.parseInt(info));
        } else if (r instanceof DocumentoWeb) {
            DocumentoWeb web = (DocumentoWeb) r;
            System.out.print("URL?");
            info = teclado.nextLine().trim();
            web.setUrl(info);
            System.out.print("Dia?");
            dia = teclado.nextLine().trim();
            System.out.print("Mes?");
            mes = teclado.nextLine().trim();
            System.out.print("Año?");
            anno = teclado.nextLine().trim();
            web.setFecha(new Fecha(Integer.parseInt(dia), Integer.parseInt(mes), Integer.parseInt(anno)));
        }
    }

    /**
     * Lee del teclado un nuevo num. de referencia
     *
     * @param coleccion La colección de la que se obtiene el max.
     * @return el num. de referencias, como entero.
     */
    private int leeNumReferencia(Bibliografia coleccion) {
        final int numReferencias = coleccion.getNumReferencias();
        int toret;

        toret = leeNum("Introduzca num. de referencia (1..." + numReferencias + "): ");

        return toret - 1;
    }

    /**
     * Lee un caracter del teclado
     *
     * @param men Mensaje a visualizar
     * @return el caracter introducido por el usuario
     */
    private char leeCaracter(String men) {
        Scanner teclado = new Scanner(System.in);

        System.out.print(men);
        return (teclado.nextLine().trim().charAt(0));
    }

}
