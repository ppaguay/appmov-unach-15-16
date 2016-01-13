/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.unach.red.control;
import ec.edu.unach.red.rnegocio.clases.prestamo;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import ec.edu.unach.red.rnegocio.clases.*;
import ec.edu.unach.red.rnegocio.funciones.*;
import java.util.*;
import javax.faces.context.FacesContext;
/**
 *
 * @author Xavier
 */
@ManagedBean
@SessionScoped
public class Cprestamo {
    private List<prestamo> lista;
    private prestamo prSel;
    private prestamo prNew;
    private List<usuario> listaUsu;
    private String codUsuSel;
    private List<libro> listaconce;
    private String codConceSel;

    public Cprestamo() {
        lista=Fprestamo.obtener();
        prNew=new prestamo();
        listaUsu=Fusuario.obtener();
        listaconce=Flibro.obtener();
    }
    
     public String cargarprestamo(){
         Map requestMap= FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
        String codus=(String) requestMap.get("prestamo");		
        prSel=Fprestamo.obtenerprestamo(Integer.parseInt(codus));
//        usSel=new usuario(1,"Paul","Primero");
        
        return "prestamoinfo";
    }
    public String insertar(){
        prNew.setCodigous(Fusuario.obtenerusuario(Integer.parseInt(codUsuSel)));
        prNew.setCodigolib(Flibro.obtenerconce(Integer.parseInt(codConceSel)));
        Fprestamo.insertar(prNew);
        lista=Fprestamo.obtener();
        return "prestamos?transition=slide";
    }
     public String delete() {
        Fprestamo.delete(prSel.getCodigopres());
        lista=Fprestamo.obtener();
        return "prestamos?transition=slide";
    }
    
     public String modificar() {
        prSel.setCodigous(Fusuario.obtenerusuario(Integer.parseInt(codUsuSel)));
        prSel.setCodigolib(Flibro.obtenerconce(Integer.parseInt(codConceSel)));
        Fprestamo.modificar(prSel.getCodigopres(),prSel.getCodigous(),prSel.getCodigolib(),prSel.getDescripcion());
        
        lista=Fprestamo.obtener();
        return "prestamos?transition=slide";
    }
     
    
    public List<prestamo> getLista() {
        return lista;
    }

    public void setLista(List<prestamo> lista) {
        this.lista = lista;
    }

    public prestamo getPrSel() {
        return prSel;
    }

    public void setPrSel(prestamo prSel) {
        this.prSel = prSel;
    }

    public prestamo getPrNew() {
        return prNew;
    }

    public void setPrNew(prestamo prNew) {
        this.prNew = prNew;
    }

    public List<usuario> getListaUsu() {
        return listaUsu;
    }

    public void setListaUsu(List<usuario> listaUsu) {
        this.listaUsu = listaUsu;
    }

    public String getCodUsuSel() {
        return codUsuSel;
    }

    public void setCodUsuSel(String codUsuSel) {
        this.codUsuSel = codUsuSel;
    }

    public List<libro> getListaconce() {
        return listaconce;
    }

    public void setListaconce(List<libro> listaconce) {
        this.listaconce = listaconce;
    }

    public String getCodConceSel() {
        return codConceSel;
    }

    public void setCodConceSel(String codConceSel) {
        this.codConceSel = codConceSel;
    }
    
    
    
    
    
    
    
    
    
}
