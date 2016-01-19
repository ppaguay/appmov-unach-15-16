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
public class Aplicacion {
    private int codigo;
  private Usuario usuario;
  private Tipoaplicacion tipoaplicacion;
  private String nombre;
  private String descripcion;

    public Aplicacion() {
    }

    public Aplicacion(int codigo, Usuario usuario, Tipoaplicacion tipoaplicacion, String nombre, String descripcion) {
        this.codigo = codigo;
        this.usuario = usuario;
        this.tipoaplicacion = tipoaplicacion;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tipoaplicacion getTipoaplicacion() {
        return tipoaplicacion;
    }

    public void setTipoaplicacion(Tipoaplicacion tipoaplicacion) {
        this.tipoaplicacion = tipoaplicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
  
  
    
}
