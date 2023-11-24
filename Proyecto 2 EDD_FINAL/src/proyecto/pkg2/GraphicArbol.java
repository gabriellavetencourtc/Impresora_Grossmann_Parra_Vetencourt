/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg2;

/**
 *
 * @author gabriellavetencourt
 */
import java.awt.Graphics;
import javax.swing.JPanel;
/**
 * Clase para visualizar gráficamente un montículo binario en un panel en forma de "árbol".
 */
public class GraphicArbol extends JPanel{
     private MonticuloB monticulo;
    public static final int DIAMETRO = 30;
    public static final int RADIO = DIAMETRO / 2;
    public static final int ANCHO = 30;
    public static final int NIVEL_Y = 50;
    public static final int ESPACIO_ENTRE_NODOS = 50;

    /**
     * Establece el montículo que se dibujará.
     * 
     * @param monticulo El montículo binario a dibujar.
     */
    public void setMonticulo(MonticuloB monticulo) {
        this.monticulo = monticulo;
        repaint();
    }

     /**
     * Método de dibujo del montículo binario en el panel.
     * 
     * @param g Gráfico en el que se dibujará el montículo.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        dibujarMonticulo(g, getWidth() / 2, NIVEL_Y, 0);
    }
    
    /**
     * Dibuja el montículo binario en el panel.
     * 
     * @param g       Gráfico en el que se dibujará el montículo.
     * @param x       Posición en el eje x del nodo actual.
     * @param y       Posición en el eje y del nodo actual.
     * @param indice  Índice del nodo actual en el montículo.
     */
    public void dibujarMonticulo(Graphics g, int x, int y, int indice) {
        if (indice < monticulo.getActualSize()) {
            g.drawOval(x, y, DIAMETRO, DIAMETRO);
            g.drawString(monticulo.getMonticulo()[indice].getNombre(), x + 8, y + 18);

            int hijoIzquierdoIndice = monticulo.hijoIzquierdo(indice);
            int hijoDerechoIndice = monticulo.hijoDerecho(indice);

            if (hijoIzquierdoIndice < monticulo.getActualSize()) {
                // Dibujar línea al hijo izquierdo
                int xIzquierdo = x - ESPACIO_ENTRE_NODOS;
                int yIzquierdo = y + ESPACIO_ENTRE_NODOS;
                g.drawLine(x + RADIO, y + RADIO, xIzquierdo + RADIO, yIzquierdo + RADIO);
                dibujarMonticulo(g, xIzquierdo, yIzquierdo, hijoIzquierdoIndice);
            }

            if (hijoDerechoIndice < monticulo.getActualSize()) {
                // Dibujar línea al hijo derecho
                int xDerecho = x + ESPACIO_ENTRE_NODOS;
                int yDerecho = y + ESPACIO_ENTRE_NODOS;
                g.drawLine(x + RADIO, y + RADIO, xDerecho + RADIO, yDerecho + RADIO);
                dibujarMonticulo(g, xDerecho, yDerecho, hijoDerechoIndice);
            }
        }
    }
    
    
}
