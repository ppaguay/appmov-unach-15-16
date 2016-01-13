/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.unach.red.rnegocio.clases;

/**
 *
 * @author user
 */
public class usuario {
     private int codigo;
    private String nombre;
    private String correo;
    private String clave;
    private String nick;
    private String genero;

    public usuario() {
    }

    public usuario(int codigo, String nombre, String correo, String clave, String nick, String genero) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
        this.nick = nick;
        this.genero = genero;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getClave() {
        return clave;
    }

    public String getNick() {
        return nick;
    }

    public String getGenero() {
        return genero;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
    
}
