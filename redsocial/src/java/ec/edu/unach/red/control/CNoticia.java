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

/**
 *
 * @author USER
 */
@ManagedBean
@SessionScoped
public class CNoticia {
   private List<Noticia> lista;
  private Noticia notSel;
  private Noticia notNew;
  private List<CategoriaNoticia> listaCategoria;
  private String codCategoria;
  private List<Usuario> listaUsuario;
  private String codUsuario;
  
    public CNoticia(){
        lista= FNoticia.obtener();
        notNew= new Noticia();
        listaCategoria= FCategoriaNoticia.obtener();
        listaUsuario= FUsuario.obtener();
    }
   
     public String cargarNoticia(){
        Map requestMap= FacesContext.getCurrentInstance().
        getExternalContext().getRequestParameterMap();
        String customer=(String) requestMap.get("noticia");
//        eqSel=new Equipo(1,new Tipo(2,"Red"),"Teclado",5);
        notSel = FNoticia.obtener(Integer.parseInt(customer));
        return "noticiainfo";
     }
     
     public String insertar(){
        notNew.setCategoria(FCategoriaNoticia.obtener(Integer.parseInt(codCategoria)));
        notNew.setUsuario(FUsuario.obtener(Integer.parseInt(codUsuario)));
        FNoticia.insertar(notNew);
        lista=FNoticia.obtener();
        return "noticias?transition=slide";
    }
   //eliminar
   public String eliminar(){        
    FNoticia.eliminar(notSel.getCodigo());
    lista=FNoticia.obtener();
    return "noticias?transition=slide";

  }
       
  //modificar
    public String modificar() {

        Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        notSel.setUsuario(FUsuario.obtener(Integer.parseInt(codUsuario)));
        notSel.setCategoria(FCategoriaNoticia.obtener(Integer.parseInt(codCategoria)));
        FNoticia.modificar(notSel);
        lista=FNoticia.obtener();
        return "noticias?transition=slide";
    }

    public List<Noticia> getLista() {
        return lista;
    }

    public void setLista(List<Noticia> lista) {
        this.lista = lista;
    }

    public Noticia getNotSel() {
        return notSel;
    }

    public void setNotSel(Noticia notSel) {
        this.notSel = notSel;
    }

    public Noticia getNotNew() {
        return notNew;
    }

    public void setNotNew(Noticia notNew) {
        this.notNew = notNew;
    }

   
    public List<CategoriaNoticia> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(List<CategoriaNoticia> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }

    public String getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(String codCategoria) {
        this.codCategoria = codCategoria;
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

     
}
