/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.unach.red.rnegocio.funciones;
import ec.edu.unach.red.accesodatos.*;
import ec.edu.unach.red.rnegocio.clases.*;
import java.util.*;


/**
 *
 * @author USER
 */
public class FNoticia {
    public static List<Noticia> obtener(){
        ArrayList<Noticia> lst= new ArrayList<>();
        String sql= "select codigo, cod_usuario, titulo, descripcion, cod_categoria from noticia";
        try {
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql);
            Noticia not;
            while(cres.next()){
                not= new Noticia();
                not.setCodigo(cres.getInt(1));
                not.setUsuario(FUsuario.obtener(cres.getInt(2)));
                not.setTitulo(cres.getString(3));
                not.setDescripcion(cres.getString(4));
                not.setCategoria(FCategoriaNoticia.obtener(cres.getInt(5)));
                lst.add(not);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    public static boolean insertar(Noticia not){
        boolean res=false;
        String sql= "insert into noticia values(?,?,?,?,?)";
        try {
            ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,not.getCodigo()));
            lstPar.add(new Parametro(2,not.getUsuario().getCodigo()));
            lstPar.add(new Parametro(3,not.getTitulo()));
            lstPar.add(new Parametro(4,not.getDescripcion()));
            lstPar.add(new Parametro(5,not.getCategoria().getCodigo()));
            res= AccesoDatos.ejecutaComando1(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
        return res;
    }
    public static Noticia obtener(int codigo){
        Noticia noticia=null;
        String sql= "select codigo, cod_usuario, titulo, descripcion, cod_categoria from noticia where codigo=?";
        try {
             ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,codigo));
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql,lstPar);           
            while(cres.next()){
                noticia= new Noticia();
                noticia.setCodigo(cres.getInt(1));
                noticia.setUsuario(FUsuario.obtener(cres.getInt(2)));
                noticia.setTitulo(cres.getString(3));
                noticia.setDescripcion(cres.getString(4));
                noticia.setCategoria(FCategoriaNoticia.obtener(cres.getInt(5)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return noticia;
    }
    public static Noticia eliminar(int codigo)
    {
        Noticia noticia=null;
        String sql= "DELETE FROM noticia WHERE  codigo=?";
        try {
             ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,codigo)); 
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql,lstPar);           
            while(cres.next()){
                noticia= new Noticia();
                noticia.setCodigo(cres.getInt(1));
                noticia.setTitulo(cres.getString(2));
                noticia.setUsuario(FUsuario.obtener(cres.getInt(3)));
                noticia.setDescripcion(cres.getString(4));
                noticia.setCategoria(FCategoriaNoticia.obtener(cres.getInt(5)));
                 
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return noticia;
        
    }
     
public static boolean modificar(Noticia not){
         boolean res=false;
        String sql= " UPDATE noticia set cod_usuario=?, titulo=?, descripcion=?, cod_categoria=? where codigo=? ";
        try {
             ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,not.getUsuario().getCodigo()));
            lstPar.add(new Parametro(2,not.getTitulo()));
            lstPar.add(new Parametro(3,not.getDescripcion()));
            lstPar.add(new Parametro(4,not.getCategoria().getCodigo()));
            lstPar.add(new Parametro(5,not.getCodigo()));
            res=AccesoDatos.ejecutaComando(sql, lstPar);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }
}
