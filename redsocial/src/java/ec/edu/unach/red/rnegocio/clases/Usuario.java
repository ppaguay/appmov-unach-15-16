/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.unach.red.rnegocio.clases;

/**
 *
 * @author Ivancito
 */
public class Usuario 
{
    private int codigo;
    private String nombre;
    private String email;
    private String clave;
    private String nick;
    private String genero;

    public Usuario() {
    }

    public Usuario(int codusuario, String nombres, String email, String clave, String nick, String genero) {
        this.codigo = codusuario;
        this.nombre = nombres;
        this.email = email;
        this.clave = clave;
        this.nick = nick;
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codusuario) {
        this.codigo = codusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombres) {
        this.nombre = nombres;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
    
    
}
