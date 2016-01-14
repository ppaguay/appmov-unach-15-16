/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.unach.red.control;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import ec.edu.unach.red.rnegocio.funciones.*;
import ec.edu.unach.red.rnegocio.clases.*;
import java.util.*;
import javax.faces.context.FacesContext;;


@ManagedBean
@SessionScoped
public class CChistes 
{
    private List<Chistes> lista;
    private Chistes chSel;
    private Chistes chNew;
    private Chistes delch;
    private Chistes modch;
    
    private List<Usuario> listaUsuario;
    private String codUsuario;
    
    private List<Categoria> listaCategoria;
    private String codCategoria;
    public CChistes ()
    {
        lista=FChistes.obtener();
        chNew= new Chistes(); 
        listaUsuario=FUsuario.obtener();
        listaCategoria=FCategoria.obtener();
    }
    
    public String cargarChiste() {

        Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String codch = (String) requestMap.get("chiste");
        chSel = FChistes.obtener(Integer.parseInt(codch));    
        return "chisteinfo";
    }
    //insertar
     public String insertar(){
        chNew.setUsuario(FUsuario.obtener(Integer.parseInt(codUsuario)));
        chNew.setCategoria(FCategoria.obtener(Integer.parseInt(codCategoria)));
        FChistes.insertar(chNew);
        lista=FChistes.obtener();
        return "chistess?transition=slide";
    }
 //eliminar
   public String eliminar(){        
    FChistes.eliminar(chSel.getCodigo_ch());
    lista=FChistes.obtener();
    return "chistess?transition=slide";

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
    
   public String modificar() {

        Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        chSel.setUsuario(FUsuario.obtener(Integer.parseInt(codUsuario)));
        chSel.setCategoria(FCategoria.obtener(Integer.parseInt(codCategoria)));
        FChistes.modificar(chSel);
        lista=FChistes.obtener();
        return "chistess?transition=slide";
    }


    public List<Chistes> getLista() {
        return lista;
    }

    public void setLista(List<Chistes> lista) {
        this.lista = lista;
    }

    public Chistes getChSel() {
        return chSel;
    }

    public void setChSel(Chistes chSel) {
        this.chSel = chSel;
    }

    public Chistes getChNew() {
        return chNew;
    }

    public void setChNew(Chistes chNew) {
        this.chNew = chNew;
    }

    public Chistes getDelch() {
        return delch;
    }

    public void setDelch(Chistes delch) {
        this.delch = delch;
    }

    public Chistes getModch() {
        return modch;
    }

    public void setModch(Chistes modch) {
        this.modch = modch;
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

    public List<Categoria> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(List<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }

    public String getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(String codCategoria) {
        this.codCategoria = codCategoria;
    }


    
}