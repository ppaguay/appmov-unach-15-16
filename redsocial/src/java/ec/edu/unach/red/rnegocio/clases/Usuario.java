/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.unach.red.rnegocio.clases;

/**
 *
 * @author Mars
 */
public class Usuario {
    private int cod_usuario;
  private String nombre;
  private String email;
  private String clave;
  private String nick ;
  private String genero;

    public Usuario() {
    }

    public Usuario(int cod_usuario, String nombre, String email, String clave, String nick, String genero) {
        this.cod_usuario = cod_usuario;
        this.nombre = nombre;
        this.email = email;
        this.clave = clave;
        this.nick = nick;
        this.genero = genero;
    }

    public int getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
  
  
  
    
}
