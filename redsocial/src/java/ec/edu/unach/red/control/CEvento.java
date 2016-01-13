/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.unach.red.control;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
//import ec.edu.unach.evento.clases.*;
import ec.edu.unach.red.rnegocio.clases.*;
//import ec.edu.unach.evento.funciones.*;
import ec.edu.unach.red.rnegocio.funciones.*;
import java.util.*;
import javafx.scene.paint.Color;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
//import org.jboss.weld.manager.FieldProducerFactory;
@ManagedBean
@SessionScoped

/**
 *
 * @author user
 */
public class CEvento {
    private List<Evento> lista;
    private Evento asigSel;
    private Evento asigNew;
    private Evento delAsig;
    private Evento modAsig;
    
    private List<Usuario> listaUsuario;
    private String codUsuarioSel;
    
    private List<TipoEvento> listaTipoEvento;
    private String codTipoEventoSel;

    
    
    public CEvento() {
        lista =FEvento.obtener();
        asigNew=new Evento();
        listaUsuario=FUsuario.obtener();
        listaTipoEvento=FTipoEvento.obtener();
    }
    
     public String cargarEvento(){
    Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
    String evento = (String) requestMap.get("even");
    asigSel=FEvento.obtener(Integer.parseInt(evento));
    return "eventoinfo";
    }
     
    public String insertar() {
        asigNew.setCod_usuario(FUsuario.obtener(Integer.parseInt(codUsuarioSel)));
        asigNew.setCod_tipoevento(FTipoEvento.obtener(Integer.parseInt(codTipoEventoSel)));
        FEvento.insertar(asigNew);
        lista=FEvento.obtener();
        return "evento?transition=slide";
    }
    
    public String eliminar() {

        Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String codeven = (String) requestMap.get("evento");
        delAsig = FEvento.eliminar(Integer.parseInt(codeven));
         lista=FEvento.obtener();
        return "evento?transition=slide";
    }
    
    public String modif(){
        Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String cod2 = (String) requestMap.get("codeven");
        asigSel.setCod_usuario(FUsuario.obtener(Integer.parseInt(codUsuarioSel)));
        asigSel.setCod_tipoevento(FTipoEvento.obtener(Integer.parseInt(codTipoEventoSel)));
        FEvento.modif(asigSel, Integer.parseInt(cod2));
         lista=FEvento.obtener();
        return "evento?transition=slide";
    }
    
    public String modificar(){
        FEvento.modificar(asigSel);
        lista=FEvento.obtener();
        return "evento?transition=slide";
    }

    public List<Evento> getLista() {
        return lista;
    }

    public void setLista(List<Evento> lista) {
        this.lista = lista;
    }

    public Evento getAsigSel() {
        return asigSel;
    }

    public void setAsigSel(Evento asigSel) {
        this.asigSel = asigSel;
    }

    public Evento getAsigNew() {
        return asigNew;
    }

    public void setAsigNew(Evento asigNew) {
        this.asigNew = asigNew;
    }

    public Evento getDelAsig() {
        return delAsig;
    }

    public void setDelAsig(Evento delAsig) {
        this.delAsig = delAsig;
    }

    public Evento getModAsig() {
        return modAsig;
    }

    public void setModAsig(Evento modAsig) {
        this.modAsig = modAsig;
    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public String getCodUsuarioSel() {
        return codUsuarioSel;
    }

    public void setCodUsuarioSel(String codUsuarioSel) {
        this.codUsuarioSel = codUsuarioSel;
    }

    public List<TipoEvento> getListaTipoEvento() {
        return listaTipoEvento;
    }

    public void setListaTipoEvento(List<TipoEvento> listaTipoEvento) {
        this.listaTipoEvento = listaTipoEvento;
    }

    public String getCodTipoEventoSel() {
        return codTipoEventoSel;
    }

    public void setCodTipoEventoSel(String codTipoEventoSel) {
        this.codTipoEventoSel = codTipoEventoSel;
    }
    
    
    
    
    
    

    
}
