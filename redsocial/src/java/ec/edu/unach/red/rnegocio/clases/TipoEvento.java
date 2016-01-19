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
public class TipoEvento {
     private int cod_tipoevento;
    private String descripcion;   

    public TipoEvento() {
    }

    public TipoEvento(int cod_tipoevento, String descripcion) {
        this.cod_tipoevento = cod_tipoevento;
        this.descripcion = descripcion;
    }

    public int getCod_tipoevento() {
        return cod_tipoevento;
    }

    public void setCod_tipoevento(int cod_tipoevento) {
        this.cod_tipoevento = cod_tipoevento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    
    
}
