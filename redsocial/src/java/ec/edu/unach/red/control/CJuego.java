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
import javax.faces.context.FacesContext;;
import java.util.*;
/**
 *
 * @author COMPUTER
 */
@ManagedBean
@SessionScoped
public class CJuego {
  private List<Juego> lista;
  private Juego juegoSel;
  private Juego juegoNew;
  private List<CategoriaJuego> listaCategoria;
  private String codCategoria;
  private List<Usuario> listaUsuario;
  private String codUsuario;
  
  public CJuego(){
        lista= FJuego.obtener();
        juegoNew= new Juego();
        listaCategoria= FCategoriaJuego.obtener();
        listaUsuario= FUsuario.obtener();
    }
   
     public String cargarJuego(){
        Map requestMap= FacesContext.getCurrentInstance().
        getExternalContext().getRequestParameterMap();
        String customer=(String) requestMap.get("juego");
        juegoSel = FJuego.obtener(Integer.parseInt(customer));
        return "juegoinfo";
     }
     
     public String insertar(){
        juegoNew.setCategoria(FCategoriaJuego.obtener(Integer.parseInt(codCategoria)));
        juegoNew.setUsuario(FUsuario.obtener(Integer.parseInt(codUsuario)));
        FJuego.insertar(juegoNew);
        lista=FJuego.obtener();
        return "juego?transition=slide";
    }
   //eliminar
   public String eliminar(){        
    FJuego.eliminar(juegoSel.getCodigo());
    lista=FJuego.obtener();
    return "juego?transition=slide";

  }
       
  //modificar
    public String modificar() {

        Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        juegoSel.setUsuario(FUsuario.obtener(Integer.parseInt(codUsuario)));
        juegoSel.setCategoria(FCategoriaJuego.obtener(Integer.parseInt(codCategoria)));
        FJuego.modificar(juegoSel);
        lista=FJuego.obtener();
        return "juego?transition=slide";
    }

    public List<Juego> getLista() {
        return lista;
    }

    public void setLista(List<Juego> lista) {
        this.lista = lista;
    }

    public Juego getJuegoSel() {
        return juegoSel;
    }

    public void setJuegoSel(Juego juegoSel) {
        this.juegoSel = juegoSel;
    }

    public Juego getJuegoNew() {
        return juegoNew;
    }

    public void setJuegoNew(Juego juegoNew) {
        this.juegoNew = juegoNew;
    }

    public List<CategoriaJuego> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(List<CategoriaJuego> listaCategoria) {
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
