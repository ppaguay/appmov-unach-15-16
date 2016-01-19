/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.unach.red.control;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import ec.edu.unach.red.funciones.*;
import ec.edu.unach.red.clases.*;
import java.util.*;
import javax.faces.context.FacesContext;;
/**
 *
 * @author Jefferson
 */
@ManagedBean
@SessionScoped
public class CInstrumento {
    private List<Instrumento> lista;
    private Instrumento eqSel;
    private Instrumento inssel;
    private Instrumento insnew;
    private Instrumento insmod;
    private Instrumento insdel;
    private List<Usuario> listausuario;
    private String codusuario;
    private List<Categoria_instrumento> listacategoria;
    private String codcategoria;

    public CInstrumento() {
        insnew= new Instrumento();
        lista=FInstrumento.obtener();
        listausuario=FUsuario.obtener();
        listacategoria=FCategoria_instrumento.obtener();
    }
    
     public String cargarInstrumento(){
        Map requestMap= FacesContext.getCurrentInstance().
        getExternalContext().getRequestParameterMap();
        String codins=(String) requestMap.get("instrumento");
        eqSel = FInstrumento.obtener(Integer.parseInt(codins));
        return "instrumentoinfo";
    }
    
      //insertar
       public String insertar(){
        insnew.setUsuario(FUsuario.obtener(Integer.parseInt(codusuario)));
        insnew.setCategoria(FCategoria_instrumento.obtener(Integer.parseInt(codcategoria)));
        FInstrumento.insertar(insnew);
        lista=FInstrumento.obtener();
        return "instrumentos?transition=slide";
    }
       //eliminar
    public String eliminar(){        
    FInstrumento.eliminar(eqSel.getCodins());
    lista=FInstrumento.obtener();
    return "instrumentos?transition=slide";

  }
       //modificar
    public String modificar() {

        Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        //String codcar = (String) requestMap.get("codcar");
        eqSel.setUsuario(FUsuario.obtener(Integer.parseInt(codusuario)));
        eqSel.setCategoria(FCategoria_instrumento.obtener(Integer.parseInt(codcategoria)));
        FInstrumento.modificar(eqSel);
        lista=FInstrumento.obtener();
        return "instrumentos?transition=slide";
    }

    public List<Instrumento> getLista() {
        return lista;
    }

    public void setLista(List<Instrumento> lista) {
        this.lista = lista;
    }

    public Instrumento getEqSel() {
        return eqSel;
    }

    public void setEqSel(Instrumento eqSel) {
        this.eqSel = eqSel;
    }

    public Instrumento getInssel() {
        return inssel;
    }

    public void setInssel(Instrumento inssel) {
        this.inssel = inssel;
    }

    public Instrumento getInsnew() {
        return insnew;
    }

    public void setInsnew(Instrumento insnew) {
        this.insnew = insnew;
    }

    public Instrumento getInsmod() {
        return insmod;
    }

    public void setInsmod(Instrumento insmod) {
        this.insmod = insmod;
    }

    public Instrumento getInsdel() {
        return insdel;
    }

    public void setInsdel(Instrumento insdel) {
        this.insdel = insdel;
    }

    public List<Usuario> getListausuario() {
        return listausuario;
    }

    public void setListausuario(List<Usuario> listausuario) {
        this.listausuario = listausuario;
    }

    public String getCodusuario() {
        return codusuario;
    }

    public void setCodusuario(String codusuario) {
        this.codusuario = codusuario;
    }

    public List<Categoria_instrumento> getListacategoria() {
        return listacategoria;
    }

    public void setListacategoria(List<Categoria_instrumento> listacategoria) {
        this.listacategoria = listacategoria;
    }

    public String getCodcategoria() {
        return codcategoria;
    }

    public void setCodcategoria(String codcategoria) {
        this.codcategoria = codcategoria;
    }
    
    
}
