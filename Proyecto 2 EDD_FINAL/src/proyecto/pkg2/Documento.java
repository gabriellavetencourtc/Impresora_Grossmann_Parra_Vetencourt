/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg2;

/**
 *
 * @author daniela
 */
/**
 * La clase Documento representa un documento con información asociada, incluyendo nombre, tamaño, tipo y usuario (si corresponde).
 */
public class Documento {

    private String usuario;
    private String nombre;
    private int tamaño;
    private String tipo;
    private int tiempoPorHoja;

      /**
     * Constructor de Documento para un documento asociado a un usuario.
     *
     * @param usuario Nombre del usuario asociado al documento
     * @param nombre Nombre del documento
     * @param tamaño Tamaño del documento
     * @param tipo Tipo del documento
     */
    public Documento(String usuario, String nombre, int tamaño, String tipo) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.tipo = tipo;
        this.tiempoPorHoja = tamaño*2;
    }

     /**
     * Constructor de Documento para un documento sin usuario asociado.
     *
     * @param nombre Nombre del documento
     * @param tamaño Tamaño del documento
     * @param tipo Tipo del documento
     */
    public Documento(String nombre, int tamaño, String tipo) {
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.tipo = tipo;
        this.tiempoPorHoja = tamaño*2;
    }
    
     /**
     * Método para obtener una representación del documento en forma de texto.
     *
     * @return Cadena de texto que representa la información del documento
     */
    public String Imprimir() {
       String aux = "";
        aux+="DOCUMENTO "+ "\n";
        aux+=nombre+ "\n";
        aux+=tamaño+ "\n";
        aux+=tipo + "\n\n";
        return aux;

    }
    /**
     * Método para obtener el tiempoPorHoja estimado de impresión del documento.
     *
     * @return Tiempo estimado de impresión del documento
     */
    public int getTiempoPorHoja() {
    return tiempoPorHoja;
}
     /**
     * Método para establecer el tiempoPorHoja estimado de impresión del documento.
     *
     * @param tiempo Tiempo estimado de impresión a establecer
     */
    public void setTiempoPorHoja(int tiempo) {
        this.tiempoPorHoja = tiempo;
    }

    /**
     * Método para obtener el nombre del usuario asociado al documento.
     *
     * @return Nombre del usuario asociado al documento
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Método para obtener el nombre del documento.
     *
     * @return Nombre del documento
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Método para obtener el tamaño del documento.
     *
     * @return Tamaño del documento
     */
    public int getTamaño() {
        return tamaño;
    }

    /**
     * Método para establecer el tamaño del documento.
     *
     * @param tamaño Nuevo tamaño para establecer al documento
     */
    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    /**
     * Método para obtener el tipo de documento.
     *
     * @return Tipo del documento
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Método para establecer el tipo de documento.
     *
     * @param tipo Nuevo tipo para establecer al documento
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
  
    
}
