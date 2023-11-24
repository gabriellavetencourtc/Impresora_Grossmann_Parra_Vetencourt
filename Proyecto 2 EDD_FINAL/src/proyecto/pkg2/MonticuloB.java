/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg2;
import java.time.LocalTime;

/**
 * La clase MonticuloB representa un montículo binario utilizado en el sistema de impresión.
 * Un montículo binario es una estructura de datos en forma de árbol binario,
 * donde el valor de cada nodo es menor o igual que los valores de sus nodos hijos.
 * Esta clase proporciona métodos para insertar, eliminar y manipular elementos en el montículo,
 * así como métodos para visualizar su contenido de diversas formas.
 *
 * @author daniela
 */
public class MonticuloB {

    
    /**
     * El arreglo que almacena los documentos en el montículo binario.
     */
    private Documento[] monticulo;
    
    /**
     * El tamaño actual del montículo binario.
     */
    private int actualSize;

    
    /**
     * Constructor de la clase MonticuloB.
     * Inicializa el montículo binario con un tamaño predeterminado de 50 elementos.
     */
    public MonticuloB() {
        this.monticulo = new Documento[50];
        actualSize = 0;
    }

     /**
     * Obtiene el arreglo que almacena los documentos en el montículo.
     *
     * @return El arreglo de documentos en el montículo.
     */
    public Documento[] getMonticulo() {
        return monticulo;
    }
     /**
     * Obtiene el tamaño actual del montículo binario.
     *
     * @return El tamaño actual del montículo.
     */

    public int getActualSize() {
        return actualSize;
    }

     /**
     * Calcula el índice del padre de un nodo en el montículo binario.
     *
     * @param i Índice del nodo para el cual se desea obtener el padre.
     * @return El índice del padre del nodo.
     */
    public int padre(int i) {
        return (i - 1) / 2;
    }

     /**
     * Calcula el índice del hijo izquierdo de un nodo en el montículo binario.
     *
     * @param i Índice del nodo para el cual se desea obtener el hijo izquierdo.
     * @return El índice del hijo izquierdo del nodo.
     */
    public int hijoIzquierdo(int i) {
        return 2 * i + 1;
    }

    /**
     * Calcula el índice del hijo derecho de un nodo en el montículo binario.
     *
     * @param i Índice del nodo para el cual se desea obtener el hijo derecho.
     * @return El índice del hijo derecho del nodo.
     */
    public int hijoDerecho(int i) {
        return 2 * i + 2;
    }

    
    /**
     * Intercambia dos elementos en el montículo binario dados sus índices.
     *
     * @param i Índice del primer elemento a intercambiar.
     * @param j Índice del segundo elemento a intercambiar.
     */
    public void intercambiar(int i, int j) {
        Documento temp = monticulo[i];
        monticulo[i] = monticulo[j];
        monticulo[j] = temp;
    }

     // Métodos para cálculos de índices en el montículo
    // (padre, hijo izquierdo, hijo derecho, intercambio, etc.)

    /**
     * Inserta un nuevo documento en el montículo binario y realiza el reordenamiento necesario.
     *
     * @param documento El documento a insertar en el montículo.
     */
    public void insertar(Documento documento) {
        if (actualSize == monticulo.length) {
            System.out.println("El montículo está lleno");
            return;
        }

        int i = actualSize;
        monticulo[i] = documento;
        actualSize++;
        ordenarMonticulo(i);

        LocalTime tiempoImpresion1 = LocalTime.ofSecondOfDay(monticulo[padre(i)].getTiempoPorHoja());
        LocalTime tiempoImpresion2 = LocalTime.ofSecondOfDay(monticulo[i].getTiempoPorHoja());

        while (i != 0 && tiempoImpresion1.isAfter(tiempoImpresion2)) {
            intercambiar(i, padre(i));
            i = padre(i);
        }

    }

    /**
     * Elimina el documento con el tiempo mínimo del montículo binario y realiza el reordenamiento necesario.
     */
    public void eliminarMin() {
        if (actualSize == 0) {
            System.out.println("El montículo está vacío");
        }

        int indexMin = -1;
        for (int i = 0; i < actualSize; i++) {
            if (monticulo[i].equals(monticulo[0])) {
                indexMin = i;
                break;
            }
        }
        monticulo[indexMin] = monticulo[actualSize - 1];
        actualSize--;

        ordenarMonticulo(indexMin);
    }

     /**
     * Reordena el montículo a partir de un índice dado para mantener sus propiedades.
     *
     * @param i El índice desde el cual comenzar la operación de reordenamiento.
     */
    public void ordenarMonticulo(int i) {
        int izquierdo = hijoIzquierdo(i);
        int derecho = hijoDerecho(i);
        int menor = i;

        if (izquierdo < actualSize) {
            LocalTime tiempoImpresion1 = LocalTime.ofSecondOfDay(monticulo[izquierdo].getTiempoPorHoja());
            LocalTime tiempoImpresion2 = LocalTime.ofSecondOfDay(monticulo[menor].getTiempoPorHoja());
            if (tiempoImpresion1.isBefore(tiempoImpresion2)) {
                menor = izquierdo;
            }
        }

        if (derecho < actualSize) {
            LocalTime tiempoImpresion3 = LocalTime.ofSecondOfDay(monticulo[derecho].getTiempoPorHoja());
            LocalTime tiempoImpresion4 = LocalTime.ofSecondOfDay(monticulo[menor].getTiempoPorHoja());
            if (tiempoImpresion3.isBefore(tiempoImpresion4)) {
                menor = derecho;
            }
        }

        if (menor != i) {
            intercambiar(i, menor);
            ordenarMonticulo(menor);
        }
    }

     /**
     * Busca un documento por su nombre en el montículo binario.
     *
     * @param nombreDocumento El nombre del documento a buscar.
     * @return true si se encuentra el documento, false en caso contrario.
     */
    public boolean buscarPorNombre(String nombreDocumento) {
        for (int i = 0; i < actualSize; i++) {
            if (monticulo[i].getNombre().equals(nombreDocumento)) {
                return true;
            }
        }
        return false;
    }


     /**
     * Retorna una representación en forma de cadena del contenido del montículo binario.
     *
     * @return Una cadena que representa el contenido del montículo.
     */
    public String MostrarCola() {
        String aux = "";
        for (int i = 0; i < actualSize; i++) {
            aux += "[" + monticulo[i].getNombre() + "] ";
        }
        return aux;
    }
     

     /**
     * Verifica si un índice dado corresponde a un hijo izquierdo en el montículo binario.
     *
     * @param i Índice del nodo a verificar.
     * @return true si el índice corresponde a un hijo izquierdo, false en caso contrario.
     */
    public boolean esHijoIzquierdo(int i) {
        return i % 2 != 0;
    }

     /**
     * Verifica si un índice dado corresponde a un hijo derecho en el montículo binario.
     *
     * @param i Índice del nodo a verificar.
     * @return true si el índice corresponde a un hijo derecho, false en caso contrario.
     */
    public boolean esHijoDerecho(int i) {
        return i % 2 == 0;
    }

}
