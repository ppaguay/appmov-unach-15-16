/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.unach.red.rnegocio.clases;

/**
 *
 * @author PAUL
 */
public class Estudiante {
    private int codigo;
    private String nombre;
    private Nivel nivel;

    public Estudiante() {
    }

    public Estudiante(int codigo, String nombre, Nivel nivel) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
