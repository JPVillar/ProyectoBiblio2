/*  Definición de la clase Bibliografia
 *  Una bibliografia esta compuesta de referencias bibliograficas
*/

package es.uvigo.esei.pro2.core;

/**
 *
 * @author nrufino
 */
public class Bibliografia {
    private Referencia[] referencias;
    private int numReferencias;

    /** Nueva Coleccion con un num. max. de referencias.
     * @param maxReferencias el num. max. de referencias, como entero.
     */
    public Bibliografia(int maxReferencias)
    {
        numReferencias = 0;
        referencias = new Referencia[ maxReferencias  ];
    }

    /**
     * Devuelve la referencia en pos
     * @param pos el lugar de la referencia en el vector de referencias
     * @return el objeto Referencia correspondiente.
     */
    public Referencia get(int pos) throws Exception
    {
        if ( pos >= getNumReferencias() ) {
            throw new Exception ("get(): sobrepasa la pos: " + ( pos + 1 ) + " / " + getMaxReferencias() );       
        }

        return referencias[ pos ];
    }

    /** Devuelve el num. de referencias creadas.
     * @return el num. de referencias disponibles, como entero.
     */
    public int getNumReferencias()
    {
        return numReferencias;
    }

    /** Devuelve el max. de numReferenciass
     * @return el num. de referencias max,, como entero
     */
    public int getMaxReferencias()
    {
        return referencias.length;
    }

    /** Inserta una nueva referencia
     * @param r el nuevo objeto Referencia
     */
    public void inserta(Referencia r) throws Exception
    {
        final int maxReferencias = getMaxReferencias();

        if ( getNumReferencias() >= maxReferencias ) {
            throw new Exception("inserta(): sobrepasa max.: " + getMaxReferencias() );
        }

        referencias[ numReferencias ] = r;
        ++numReferencias;
    }

    /** Elimina una referencia
     * @param pos el lugar de la referencia en el vector de referencias
     */
    public void elimina(int pos)throws Exception
    {
        if ( pos >= getNumReferencias() ){
            throw new Exception("elimina(): sobrepasa el número de referencias : "
                                + getNumReferencias());           
        }
        referencias [ pos ] = referencias [ --numReferencias ];
    }
    
    /** Devuelve el contenido de todas las Referenciass
     * @return el String con el contenido
     */
    public String toString(){
        StringBuilder toret;
        final int numReferencias = getNumReferencias();

        toret = new StringBuilder();
        if ( numReferencias > 0 ) {
            for (int i = 0; i < numReferencias; i++) {
                toret.append (( i + 1 ) + ". " );
                toret.append(referencias [i].toString() + "\n");
            }
        } else {
            toret.append("No hay referencias." );
        }
        
        return toret.toString();
    }            
}
