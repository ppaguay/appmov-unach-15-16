/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.unach.red.rnegocio.clases;

/**
 *
 * @author Pulpin
 */
public class Usuario {
    private int codigo;
    private String user;
    private String password;
    private String email;
    private String genero;

    public Usuario() {
    }

    public Usuario(int codigo, String user, String password, String email, String genero) {
        this.codigo = codigo;
        this.user = user;
        this.password = password;
        this.email = email;
        this.genero = genero;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    
}
