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
public class CategoriaReceta 
{
    private int codcat;
    private String descripcion;

    public CategoriaReceta() {
    }

    public CategoriaReceta(int codcat, String descripcion) {
        this.codcat = codcat;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCodcat() {
        return codcat;
    }

    public void setCodcat(int codcat) {
        this.codcat = codcat;
    }
    
    
}
