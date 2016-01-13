/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.unach.red.control;

import ec.edu.unach.red.rnegocio.funciones.FEstudiante;
import ec.edu.unach.red.rnegocio.funciones.FNivel;
import ec.edu.unach.red.rnegocio.clases.Nivel;
import ec.edu.unach.red.rnegocio.clases.Estudiante;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.*;
import javax.faces.context.FacesContext;
/**
 *
 * @author PAUL
 */
@ManagedBean
@SessionScoped
public class CEstudiantes {
    private List<Estudiante> lista;
    private Estudiante estSel;
    private Estudiante estNew;
    private List<Nivel> listaNivel;
    private String codNivSel;
    public CEstudiantes(){
        lista= FEstudiante.obtener();
        estNew= new Estudiante();
        listaNivel=FNivel.obtener();
    }
    public String cargarEstudiante(){
        Map requestMap= FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
        String customer=(String) requestMap.get("estudiante");        
        estSel=new Estudiante(1,"Paul",new Nivel(1,"Primero"));
        return "estudianteinfo";
    }
    public String insertar(){
        estNew.setNivel(FNivel.obtener(Integer.parseInt(codNivSel)));
        FEstudiante.insertar(estNew);
        lista=FEstudiante.obtener();
        return "estudiantes?transition=slide";
    }
    
    public List<Estudiante> getLista() {
        return lista;
    }

    public void setLista(List<Estudiante> lista) {
        this.lista = lista;
    }

    public Estudiante getEstSel() {
        return estSel;
    }

    public void setEstSel(Estudiante estSel) {
        this.estSel = estSel;
    }

    public Estudiante getEstNew() {
        return estNew;
    }

    public void setEstNew(Estudiante estNew) {
        this.estNew = estNew;
    }

    public List<Nivel> getListaNivel() {
        return listaNivel;
    }

    public void setListaNivel(List<Nivel> listaNivel) {
        this.listaNivel = listaNivel;
    }

    public String getCodNivSel() {
        return codNivSel;
    }

    public void setCodNivSel(String codNivSel) {
        this.codNivSel = codNivSel;
    }
    
    
}
