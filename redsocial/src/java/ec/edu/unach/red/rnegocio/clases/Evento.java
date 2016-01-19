/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.unach.red.rnegocio.clases;

/**
 *
 * @author oscunach
 */
public class Evento {
    private int cod_evento;
    private String nombre;
    private  String direccion;
    private Usuario cod_usuario;
    private TipoEvento cod_tipoevento;

    public Evento() {
    }

    public Evento(int cod_evento, String nombre, String direccion, Usuario cod_usuario, TipoEvento cod_tipoevento) {
        this.cod_evento = cod_evento;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cod_usuario = cod_usuario;
        this.cod_tipoevento = cod_tipoevento;
    }

    public int getCod_evento() {
        return cod_evento;
    }

    public void setCod_evento(int cod_evento) {
        this.cod_evento = cod_evento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Usuario getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(Usuario cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public TipoEvento getCod_tipoevento() {
        return cod_tipoevento;
    }

    public void setCod_tipoevento(TipoEvento cod_tipoevento) {
        this.cod_tipoevento = cod_tipoevento;
    }
    
    
    
   
    
    
}
