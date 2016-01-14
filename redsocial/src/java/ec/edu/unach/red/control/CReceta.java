/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.unach.red.control;
import ec.edu.unach.red.rnegocio.clases.*;
import ec.edu.unach.red.rnegocio.funciones.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.*;
import javax.faces.context.FacesContext;
@ManagedBean 
@SessionScoped
/**
 *
 * @author Ivancito
 */
public class CReceta 
{
    private List<Receta> lista;
    private Receta recSel;
    private Receta recNew;
    private Receta delRec;
    private Receta modRec;
    
    private List<Usuario> listaUsuario;
    private String codUsuario;
    
    private List<CategoriaReceta> listaCategoria;
    private String codCategoria;
    public CReceta ()
    {
        lista=FReceta.obtener();
        recNew= new Receta(); 
        
        listaUsuario=FUsuario.obtener();
        listaCategoria=FCategoriaReceta.obtener();
    }
    
    public String cargarReceta() {

        Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String codrec = (String) requestMap.get("receta");
        recSel = FReceta.obtener(Integer.parseInt(codrec));    
        return "recetainfo";
    }
    //insertar
     public String insertar(){
        recNew.setUsuario(FUsuario.obtener(Integer.parseInt(codUsuario)));
        recNew.setCategoria(FCategoriaReceta.obtener(Integer.parseInt(codCategoria)));
        FReceta.insertar(recNew);
        lista=FReceta.obtener();
        return "recetas?transition=slide";
    }
       //eliminar
    public String eliminar() {

        Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String codrec = (String) requestMap.get("recetae");
        delRec = FReceta.eliminar(Integer.parseInt(codrec));
        lista=FReceta.obtener();
        return "recetas?transition=slide";
    }

    //modif
//     public String modif(){
//        Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
//        String cod2 = (String) requestMap.get("receta2");
//        recNew.setUsuario(FUsuario.obtener(Integer.parseInt(codUsuario)));
//        recNew.setCategoria(FCategoria.obtener(Integer.parseInt(codCategoria)));
//        FReceta.modif(recNew, Integer.parseInt(cod2));
//        
//        lista=FReceta.obtener();
//        return "recetas?transition=slide";
//    }
    
    //modificar2
    
    public String modificar(){        
        FReceta.modificar(recSel);  
        lista=FReceta.obtener();
        return "recetas?transition=slide";
    } 

    public List<Receta> getLista() {
        return lista;
    }

    public void setLista(List<Receta> lista) {
        this.lista = lista;
    }

    public Receta getRecSel() {
        return recSel;
    }

    public void setRecSel(Receta recSel) {
        this.recSel = recSel;
    }

    public Receta getRecNew() {
        return recNew;
    }

    public void setRecNew(Receta recNew) {
        this.recNew = recNew;
    }

    public Receta getDelRec() {
        return delRec;
    }

    public void setDelRec(Receta delRec) {
        this.delRec = delRec;
    }

    public Receta getModRec() {
        return modRec;
    }

    public void setModRec(Receta modRec) {
        this.modRec = modRec;
    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public List<CategoriaReceta> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(List<CategoriaReceta> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }

    public String getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(String codCategoria) {
        this.codCategoria = codCategoria;
    }
    
    
}
