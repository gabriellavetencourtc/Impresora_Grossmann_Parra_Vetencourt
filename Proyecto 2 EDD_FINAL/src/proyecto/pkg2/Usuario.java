/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg2;


/**
 * La clase Usuario representa a un usuario en el sistema de impresión.
 * Cada usuario tiene un nombre y un tipo asociado.
 * La clase proporciona métodos para acceder y modificar el nombre y el tipo del usuario.
 *
 * @author daniela
 */
public class Usuario {

     /**
     * El nombre del usuario.
     */
    private String nombre;
     /**
     * El tipo de usuario (puede ser cualquier cadena).
     */
    private String tipo;

    
     /**
     * Constructor de la clase Usuario.
     *
     * @param nombre El nombre del usuario.
     * @param tipo   El tipo de usuario.
     */
    public Usuario(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

     /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    
    /**
     * Establece el nombre del usuario.
     *
     * @param nombre El nuevo nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

     /**
     * Obtiene el tipo de usuario.
     *
     * @return El tipo de usuario.
     */
    public String getTipo() {
        return tipo;
    }

     /**
     * Establece el tipo de usuario.
     *
     * @param tipo El nuevo tipo de usuario.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
   
    
    


}
