/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.unach.red.rnegocio.funciones;
import ec.edu.unach.red.accesodatos.*;
import ec.edu.unach.red.rnegocio.clases.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marlon
 */
public class FPelicula {
    public static List<Pelicula> obtener(){
        ArrayList<Pelicula> lsta=new ArrayList<Pelicula>();
        String sql="SELECT codigo, titulo, director, pais, \"codUsuario\", \"codCategoria\" FROM pelicula";        
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);
            Pelicula peli;
        while(cres.next()){
            peli=new Pelicula();
            peli.setCodigo(cres.getInt(1));
            peli.setTitulo(cres.getString(2));
            peli.setDirector(cres.getString(3));
            peli.setPais(cres.getString(4));
            peli.setUsuario(FUsuario.obtener(cres.getInt(5)));
            peli.setCategoria(FCategoria_Pelicula.obtener(cres.getInt(6)));
            lsta.add(peli);
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }         
    return lsta;
    }
    
    public static Pelicula obtener(int codigo){
        Pelicula pelicula=null;
        String sql="SELECT codigo, titulo, director, pais, \"codUsuario\", \"codCategoria\" FROM pelicula WHERE codigo=?";                           
        try {
            ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,codigo));  
            ConjuntoResultado cres=AccesoDatos.ejecutaQuery(sql,lstPar);
            while(cres.next()){
            pelicula=new Pelicula();
            pelicula.setCodigo(cres.getInt(1));
            pelicula.setTitulo(cres.getString(2));
            pelicula.setDirector(cres.getString(3));
            pelicula.setPais(cres.getString(4));  
            pelicula.setUsuario(FUsuario.obtener(cres.getInt(5)));
            pelicula.setCategoria(FCategoria_Pelicula.obtener(cres.getInt(6)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pelicula;
    }
    
    public static boolean insertar(Pelicula peli){
        boolean res=false;
        String sql= "INSERT INTO pelicula(codigo, titulo, director, pais, \"codUsuario\", \"codCategoria\") VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ArrayList<Parametro> lstPar= new ArrayList();
            lstPar.add(new Parametro(1,peli.getCodigo()));
            lstPar.add(new Parametro(2,peli.getTitulo()));
            lstPar.add(new Parametro(3,peli.getDirector()));
            lstPar.add(new Parametro(4,peli.getPais()));   
            lstPar.add(new Parametro(5,peli.getUsuario().getCodigo()));
            lstPar.add(new Parametro(6,peli.getCategoria().getCodigo()));
            res= AccesoDatos.ejecutaComando1(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
        return res;
    }
    
    public static boolean actualizar(Pelicula peli){
        boolean res=false;
        String sql= "UPDATE pelicula SET codigo=?, titulo=?, director=?, pais=?, \"codUsuario\"=?, \"codCategoria\"=? WHERE codigo="+peli.getCodigo();         
        try {
            ArrayList<Parametro> lstPar= new ArrayList();
            lstPar.add(new Parametro(1,peli.getCodigo()));
            lstPar.add(new Parametro(2,peli.getTitulo()));
            lstPar.add(new Parametro(3,peli.getDirector()));
            lstPar.add(new Parametro(4,peli.getPais()));
            lstPar.add(new Parametro(5,peli.getUsuario().getCodigo()));
            lstPar.add(new Parametro(6,peli.getCategoria().getCodigo()));
            res= AccesoDatos.ejecutaComando1(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
        return res;
    }
    
    public static boolean eliminar(Pelicula peli){
        boolean us=false;
        String sql= "DELETE FROM pelicula WHERE codigo="+peli.getCodigo();
        try {
             ArrayList<Parametro> lstPar= new ArrayList<>();
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql,lstPar);    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return us;
    }
    
}
