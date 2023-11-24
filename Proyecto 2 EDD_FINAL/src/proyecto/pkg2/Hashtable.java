/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg2;

import javax.swing.JOptionPane;

/**
 *
 * @author daniela
 */
/**
 * Clase Hashtable que implementa una tabla hash simple con funcionalidad básica.
 * Permite almacenar pares clave-valor y realizar operaciones como inserción, obtención y eliminación.
 */
public class Hashtable {

    private int capacity;
    private Object[] keys;
    private Object[] values;
    private int size;
    private int index;

     /**
     * Constructor por defecto de la clase Hashtable.
     * Inicializa la capacidad, claves, valores, tamaño y un índice.
     */
    public Hashtable() {
        this.capacity = 100;
        this.keys = new Object[capacity];
        this.values = new Object[capacity];
        this.size = 0;
        this.index = -1;
    }

    /**
     * Obtiene el tamaño actual de la tabla hash.
     *
     * @return El tamaño actual de la tabla hash.
     */
    public int getSize() {
        return size;
    }

     /**
     * Establece el tamaño de la tabla hash.
     *
     * @param size El tamaño a establecer en la tabla hash.
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    /**
     * Devuelve la capacidad actual de la tabla hash.
     *
     * @return La capacidad actual de la tabla hash.
     */
    public int getCapacity() {
        return capacity;
    }
    /**
    * Establece la capacidad de la tabla hash.
    *
    * @param capacity La nueva capacidad a establecer en la tabla hash.
    */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    /**
    * Obtiene un array de las claves almacenadas en la tabla hash.
    *
    * @return Un array de claves almacenadas en la tabla hash.
    */
    public Object[] getKeys() {
        return keys;
    }
    
    /**
    * Establece un nuevo array de claves para la tabla hash.
    *
    * @param keys El nuevo array de claves a establecer en la tabla hash.
    */
    public void setKeys(Object[] keys) {
        this.keys = keys;
    }
    /**
    * Obtiene un array de los valores almacenados en la tabla hash.
    *
    * @return Un array de valores almacenados en la tabla hash.
    */
    public Object[] getValues() {
        return values;
    }

    /**
    * Establece un nuevo array de valores para la tabla hash.
    *
    * @param values El nuevo array de valores a establecer en la tabla hash.
    */
    public void setValues(Object[] values) {
        this.values = values;
    }

    /**
     * Calcula el índice hash para una clave dada.
     *
     * @param key La clave para calcular el índice hash.
     * @return El índice hash calculado para la clave.
     */
    private int hash(Object key) {
        return Math.abs(key.hashCode() % capacity);
    }

     /**
     * Inserta un par clave-valor en la tabla hash.
     *
     * @param key   La clave a insertar.
     * @param value El valor asociado a la clave.
     */
    public void put(Object key, Object value) {
        int index = hash(key);
        keys[index] = key;
        values[index] = value;
        size++;
    }

    /**
     * Obtiene el valor asociado a una clave dada en la tabla hash.
     *
     * @param key La clave cuyo valor se quiere obtener.
     * @return El valor asociado a la clave proporcionada o null si no existe.
     */
    public Object get(Object key) {
        int index = hash(key);

        if (keys[index] != null && keys[index].equals(key)) {
            this.index = index;
            return values[index];
        }
        return null;
    }

    
    /**
     * Busca una clave y devuelve la clave del usuario si existe en la tabla hash.
     *
     * @param nombreUsuario El nombre del usuario para buscar la clave.
     * @return La clave del usuario si se encuentra, de lo contrario, null.
     */
    public Object getKey(Object nombreUsuario) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null && keys[i] instanceof Usuario) {
                Usuario us = (Usuario) keys[i];
                if (us.getNombre().equals(nombreUsuario)) {
                    return keys[i]; // Devuelve el usuario si se encuentra
                }
            }
        }
        return null; // Si no se encuentra el usuario
    }
    /**
     * Imprime la tabla hash con sus elementos clave-valor.
     */
    public void printHashtable() {
        System.out.println("Hashtable:");
        for (int i = 0; i < capacity; i++) {
            if (keys[i] != null) {
                Lista<Documento> ldoc = (Lista) values[i];
                this.index = i;
                Usuario us = (Usuario) keys[i];
                System.out.println("Index: " + i + ", Key: " + us.getNombre() + ", Value: \n" + ldoc.MostrarDoc());
            }
        }
    }
    //Verificar si el key está en el hashtable   

     /**
     * Verifica si la tabla hash contiene una clave asociada al nombre de usuario proporcionado.
     *
     * @param nombreUsuario El nombre del usuario para verificar su existencia.
     * @return true si la tabla contiene la clave, false en caso contrario.
     */
    public boolean contieneUsuario(String nombreUsuario) {
        for (int i = 0; i < capacity; i++) {

            if (keys[i] != null && keys[i] instanceof Usuario) {
                Usuario us = (Usuario) keys[i];
                if (us.getNombre().equals(nombreUsuario)) {
                    return true;
                }
            }
        }
        return false;
    }

      /**
     * Elimina una entrada de la tabla hash asociada al nombre de usuario proporcionado.
     *
     * @param nombreUsuario El nombre del usuario cuya entrada se eliminará de la tabla.
     */
    public void remove(String nombreUsuario) {
        int index = -1;

        for (int i = 0; i < capacity; i++) {
            if (keys[i] != null && keys[i] instanceof Usuario) {
                Usuario usuario = (Usuario) keys[i];
                if (usuario.getNombre().equals(nombreUsuario)) {
                    index = i;
                    break;
                }
            }
        }
        if (index != -1) {
            keys[index] = null;
            values[index] = null;
            size--;
        }
    }

      /**
     * Elimina un documento de la tabla hash por su nombre en la lista de documentos asociados.
     *
     * @param nombreDocumento El nombre del documento a eliminar de la lista de documentos.
     */
   public void removeDocument(String nombreDocumento) {
    for (int i = 0; i < capacity; i++) {
        if (values[i] != null && values[i] instanceof Lista) {
            Lista listaDocumentos = (Lista) values[i];
            Nodo aux = listaDocumentos.getpFirst();

            while (aux != null) {
                Documento documento = (Documento) aux.getDato();

                if (documento.getNombre().equals(nombreDocumento)) {
                    listaDocumentos.EliminarDoc(nombreDocumento);
                    break;
                }
                
                aux = aux.getpNext(); // Mover el incremento dentro del if
            }
        }
    }
}


}
