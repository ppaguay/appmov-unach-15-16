/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.unach.red.control;
import ec.edu.unach.red.rnegocio.clases.*;
import ec.edu.unach.red.rnegocio.funciones.*;
import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Marlon
 */
@ManagedBean
@SessionScoped

public class CPelicula {
    private List<Pelicula> lista;
    private Pelicula pelSel;
    private Pelicula pelNew;
    private Pelicula pelUpdate;
    private Pelicula pelDelete;
    private String codUsuario;
    private String codCategoria;
    private List<Usuario> listaUsuario;  
    private List<Categoria_Pelicula> listaCategoria;
    private Pelicula pelSelect;
    private Usuario userNew;
    private Categoria_Pelicula categNew;
    
    public CPelicula(){
        lista=FPelicula.obtener();
        pelNew=new Pelicula();
        pelUpdate=new Pelicula();
        pelDelete=new Pelicula();
        listaUsuario=FUsuario.obtener();
        listaCategoria=FCategoria_Pelicula.obtener();
        userNew=new Usuario();
        categNew=new Categoria_Pelicula();
    }
    
    public String cargarPeli(){
        Map requestMap= FacesContext.getCurrentInstance().
        getExternalContext().getRequestParameterMap();
        String codigo=(String) requestMap.get("pelicula");
        pelSel=FPelicula.obtener(Integer.parseInt(codigo));
        return "peliculaInfo";
    }
    
        
    public String insertar(){         
        pelNew.setUsuario(FUsuario.obtener(Integer.parseInt(codUsuario)));
        pelNew.setCategoria(FCategoria_Pelicula.obtener(Integer.parseInt(codCategoria)));
        FPelicula.insertar(pelNew);  
        lista=FPelicula.obtener();
        return "peliculas?transition=slide";        
    }
    
    public String actualizar(){        
        FPelicula.actualizar(pelSel);  
        lista=FPelicula.obtener();
        return "peliculas?transition=slide";
    }    
      
    public String eliminar(){
        FPelicula.eliminar(pelSel);
        lista=FPelicula.obtener();
        return "peliculas?transition=slide";
    }
    
    public String insertUsuario(){  
        FUsuario.insertar(userNew); 
        return "peliculas?transition=slide";        
    }
    
    public String insertCategoria(){  
        FCategoria_Pelicula.insertar(categNew);
        return "peliculas?transition=slide";        
    }

    public List<Pelicula> getLista() {
        return lista;
    }

    public void setLista(List<Pelicula> lista) {
        this.lista = lista;
    }     

    public Pelicula getPelSel() {
        return pelSel;
    }

    public void setPelSel(Pelicula pelSel) {
        this.pelSel = pelSel;
    }

    public Pelicula getPelNew() {
        return pelNew;
    }

    public void setPelNew(Pelicula pelNew) {
        this.pelNew = pelNew;
    }

    public Pelicula getPelUpdate() {
        return pelUpdate;
    }

    public void setPelUpdate(Pelicula pelUpdate) {
        this.pelUpdate = pelUpdate;
    }

    public Pelicula getPelDelete() {
        return pelDelete;
    }

    public void setPelDelete(Pelicula pelDelete) {
        this.pelDelete = pelDelete;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
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

    public Pelicula getPelSelect() {
        return pelSelect;
    }

    public void setPelSelect(Pelicula pelSelect) {
        this.pelSelect = pelSelect;
    }

    public List<Categoria_Pelicula> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(List<Categoria_Pelicula> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }

    public Usuario getUserNew() {
        return userNew;
    }

    public void setUserNew(Usuario userNew) {
        this.userNew = userNew;
    }

    public Categoria_Pelicula getCategNew() {
        return categNew;
    }

    public void setCategNew(Categoria_Pelicula categNew) {
        this.categNew = categNew;
    }
      
    
        
}
