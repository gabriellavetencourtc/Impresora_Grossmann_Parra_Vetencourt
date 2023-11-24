/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg2;

/**
 *
 * @author gabriellavetencourt
 */
/**
 * La clase Lista representa una lista enlazada genérica que almacena elementos de tipo T.
 *
 * @param <T> Tipo de elementos que se almacenarán en la lista.
 */
public class Lista<T> {

    private Nodo<T> pFirst;
    private int size;
    private Nodo<T> pLast;
    private Hashtable hs;

     /**
     * Constructor de la clase Lista.
     * Inicializa los atributos de la lista y crea una instancia de Hashtable.
     */
    public Lista() {
        this.pFirst = null;
        this.size = 0;
        this.pLast = null;
        this.hs = new Hashtable();
    }

    /**
     * Devuelve la Hashtable asociada a la lista.
     *
     * @return Hashtable asociada a la lista.
     */
    public Hashtable getHs() {
        return hs;
    }

     /**
     * Verifica si la lista está vacía.
     *
     * @return true si la lista está vacía, false en caso contrario.
     */
    public boolean esVacio() {
        return pFirst == null;
    }

     /**
     * Inserta un elemento al final de la lista.
     *
     * @param dato Elemento a insertar.
     */
    public void InsertarFinal(T dato) {
        Nodo newnodo = new Nodo(dato);
        Nodo aux = pFirst;
        if (esVacio()) {
            pFirst = newnodo;
        } else {
            while (aux.getpNext() != null) {
                aux = aux.getpNext();
            }
            aux.setpNext(newnodo);
        }
        size++;
    }


     /**
     * Obtiene un String que contiene la información de los documentos.
     *
     * @return String con la información de los documentos.
     */
    public String MostrarDoc() {
        Nodo aux1 = pFirst;
        int cont = 1;
        String aux = "";

        if (esVacio()) {
            aux += "La lista es vacía";
        } else {
            while (aux1 != null) {
                Documento doc = (Documento) aux1.getDato();
                aux += "DOCUMENTO " + cont + "\n";
                aux += "Nombre: " + doc.getNombre() + "\n";
                aux += "Tamaño: " + doc.getTamaño() + "\n";
                aux += "Tipo: " + doc.getTipo() + "\n\n";

                aux1 = aux1.getpNext();
                cont++;
            }
        }
        return aux;

    }

      /**
     * Genera un String que contiene la información de los documentos asociados a un usuario específico.
     *
     * @param nombreUsuario Nombre del usuario cuyos documentos se desean imprimir.
     * @return String con la información de los documentos asociados al usuario.
     */
    public String ImprimirPorUsuario(String nombreUsuario) {
        Nodo aux1 = pFirst;
        int cont = 1;
        String aux = "";

        if (esVacio()) {
            aux += "La lista es vacía";
        } else {
            while (aux1 != null) {
                Documento doc = (Documento) aux1.getDato();
                if (doc.getUsuario().equalsIgnoreCase(nombreUsuario)) {
                    aux += "DOCUMENTO " + cont + "\n";
                    aux += "Nombre: " + doc.getNombre() + "\n";
                    aux += "Tamaño: " + doc.getTamaño() + "\n";
                    aux += "Tipo: " + doc.getTipo() + "\n\n";
                }
                aux1 = aux1.getpNext();
                cont++;
            }
        }
        return aux;

    }

     /**
     * Obtiene un String que contiene la información de los documentos por usuario.
     *
     * @return String con la información de documentos por usuario.
     */
    public String TextAreaUD(Lista ldoc) {
        String print = "";
        Nodo aux = pFirst;

        if (!esVacio()) {
            while (aux != null) {
                Usuario us = (Usuario) aux.getDato();
                print += "\n" + us.getNombre() + "-->" + us.getTipo() + "\n";
                print += "Documentos: \n";

                Nodo aux2 = ldoc.getpFirst();

                while (aux2 != null) {
                    Documento doc = (Documento) aux2.getDato();
                    if (us.getNombre().equalsIgnoreCase(doc.getUsuario())) {
                        print += doc.getNombre() + "\n";
                    }
                    aux2 = aux2.getpNext();
                }
                aux = aux.getpNext();
            }

        }
        return print;
    }

    /**
     * Obtiene el índice de un documento según su nombre.
     *
     * @param nombre Nombre del documento a buscar.
     * @return Índice del documento si se encuentra, -1 si no se encuentra.
     */
    public int getIndex(String nombre) {
        Nodo aux = pFirst;
        int index = 0;
        int noEncontrado = -1;

        while (aux != null) {
            Documento doc = (Documento) aux.getDato();
            if (doc.getNombre().equalsIgnoreCase(nombre)) {
                return index;
            }
            aux = aux.getpNext();
            index++;
        }
        return noEncontrado;
    }

    /**
     * Genera una Hashtable con documentos asociados a un usuario específico.
     *
     * @param usuario Usuario para el que se generarán los documentos asociados.
     */
    public void HT(Usuario usuario) {
        Nodo aux = pFirst;
        Lista<Documento> ldocAux = new Lista<>();

        if (esVacio()) {
            System.out.println("La lista es vacía");

        } else {
            while (aux != null) {

                Documento doc = (Documento) aux.getDato();
                if (doc.getUsuario().equalsIgnoreCase(usuario.getNombre())) {

                    Documento docAux = new Documento(doc.getNombre(), doc.getTamaño(), doc.getTipo());
                    ldocAux.InsertarFinal(docAux);

                }
                aux = aux.getpNext();
            }

        }
        hs.put(usuario, ldocAux);

    }

     /**
     * Busca un usuario en la lista.
     *
     * @param nombre Nombre del usuario a buscar.
     * @return true si se encuentra el usuario, false en caso contrario.
     */
    public boolean buscarUsuario(String nombre) {
        Nodo aux = pFirst;
        if (!esVacio()) {
            while (aux != null) {
                Usuario us = (Usuario) aux.getDato();
                if (us.getNombre().equalsIgnoreCase(nombre)) {
                    return true;
                }
                aux = aux.getpNext();
            }

        }
        return false;
    }
    
    public boolean buscarDocumento(String nombre) {
        Nodo aux = pFirst;
        if (!esVacio()) {
            while (aux != null) {
                Documento doc = (Documento) aux.getDato();
                if (doc.getNombre().equalsIgnoreCase(nombre)) {
                    return true;
                }
                aux = aux.getpNext();
            }

        }
        return false;
    }
    
    /**
     * Elimina un usuario de la lista.
     *
     * @param nombre Nombre del usuario a eliminar.
     */

    public void eliminarUsuario(String nombre) {
        Nodo actual = pFirst;
        Nodo anterior = null;

        while (actual != null && ((Usuario) actual.getDato()).getNombre().equalsIgnoreCase(nombre)) {
            pFirst = actual.getpNext();
            actual = pFirst;
        }
        if (!esVacio()) {
            while (actual != null) {
                Usuario us = (Usuario) actual.getDato();
                if (us.getNombre().equalsIgnoreCase(nombre)) {
                    anterior.setpNext(actual.getpNext());
                } else {
                    anterior = actual;
                }
                actual = actual.getpNext();
            }

        }

    }
     /**
     * Elimina documentos asociados a un usuario específico.
     *
     * @param nombre Nombre del usuario cuyos documentos se eliminarán.
     */
    
    public void eliminarDocUs(String nombre){
        Nodo actual = pFirst;
        Nodo anterior = null;

        while (actual != null && ((Documento) actual.getDato()).getUsuario().equalsIgnoreCase(nombre)) {
            pFirst = actual.getpNext();
            actual = pFirst;
        }
        if (!esVacio()) {
            while (actual != null) {
                Documento doc = (Documento) actual.getDato();
                if (doc.getUsuario().equalsIgnoreCase(nombre)) {
                    anterior.setpNext(actual.getpNext());
                } else {
                    anterior = actual;
                }
                actual = actual.getpNext();
            }
        }
    }
    
     /**
     * Elimina un documento de la lista según su nombre.
     *
     * @param nombreDoc Nombre del documento a eliminar.
     */
    public void EliminarDoc(String nombreDoc){
        Nodo actual = pFirst;
        Nodo anterior = null;

        while (actual != null && ((Documento) actual.getDato()).getNombre().equalsIgnoreCase(nombreDoc)) {
            pFirst = actual.getpNext();
            actual = pFirst;
        }
        if (!esVacio()) {
            while (actual != null) {
                Documento doc = (Documento) actual.getDato();
                if (doc.getNombre().equalsIgnoreCase(nombreDoc)) {
                    anterior.setpNext(actual.getpNext());
                } else {
                    anterior = actual;
                }
                actual = actual.getpNext();
            }
        }   
    }

     /**
     * Elimina el último elemento de la lista.
     */
    public void EliminarFinal() {
        Nodo aux = pFirst;
        if (!esVacio()) {
            while (aux.getpNext().getpNext() != null) {
                aux = aux.getpNext();
            }
            aux.setpNext(null);
            size--;
        }
    }

     /**
     * Devuelve el primer nodo de la lista.
     *
     * @return Primer nodo de la lista.
     */
    public Nodo<T> getpFirst() {
        return pFirst;
    }

     /**
     * Establece el primer nodo de la lista.
     *
     * @param pFirst Nodo a establecer como el primer nodo de la lista.
     */
    public void setpFirst(Nodo<T> pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * Devuelve el tamaño actual de la lista.
     *
     * @return Tamaño actual de la lista.
     */
    public int getSize() {
        return size;
    }

     /**
     * Establece el tamaño de la lista.
     *
     * @param size Tamaño a establecer para la lista.
     */
    public void setSize(int size) {
        this.size = size;
    }

     /**
     * Devuelve el último nodo de la lista.
     *
     * @return Último nodo de la lista.
     */
    public Nodo<T> getpLast() {
        return pLast;
    }

    /**
     * Establece el último nodo de la lista.
     *
     * @param pLast Nodo a establecer como el último nodo de la lista.
     */
    public void setpLast(Nodo<T> pLast) {
        this.pLast = pLast;
    }

}
