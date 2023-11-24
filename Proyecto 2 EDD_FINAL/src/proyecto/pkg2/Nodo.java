/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg2;

/**
 *
 * @author gabriellavetencourt
 */
public class Nodo<T> {

    private T dato;
    private Nodo<T> pNext;

/**
     * Constructor de la clase Nodo.
     *
     * @param dato El dato que se va a almacenar en el nodo.
     */
    public Nodo(T dato) {
        this.dato = dato;
        this.pNext = null;
    }

    /**
     * Obtiene el dato almacenado en el nodo.
     *
     * @return El dato almacenado en el nodo.
     */
    public T getDato() {
        return dato;
    }
    
/**
     * Establece un nuevo dato en el nodo.
     *
     * @param dato El nuevo dato a ser almacenado en el nodo.
     */
    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     * Obtiene la referencia al siguiente nodo.
     *
     * @return La referencia al siguiente nodo.
     */
    public Nodo<T> getpNext() {
        return pNext;
    }
    
/**
     * Establece la referencia al siguiente nodo.
     *
     * @param pNext La referencia al siguiente nodo.
     */
    public void setpNext(Nodo<T> pNext) {
        this.pNext = pNext;
    }
}

