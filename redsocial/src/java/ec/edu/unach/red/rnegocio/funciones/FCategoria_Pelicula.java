/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.unach.red.rnegocio.funciones;
import ec.edu.unach.red.accesodatos.*;
import ec.edu.unach.red.rnegocio.clases.*;
import java.util.*;
import org.apache.catalina.startup.Catalina;
/**
 *
 * @author Marlon
 */
public class FCategoria_Pelicula {
    public static List<Categoria_Pelicula> obtener(){
        ArrayList<Categoria_Pelicula> lsta=new ArrayList<Categoria_Pelicula>();
        String sql="SELECT codigo, descripcion FROM categoria";        
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql);
            Categoria_Pelicula cat;
        while(cres.next()){
            cat=new Categoria_Pelicula();
            cat.setCodigo(cres.getInt(1));
            cat.setDescripcion(cres.getString(2));            
            lsta.add(cat);
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  
        return lsta;
    }
    
    public static Categoria_Pelicula obtener(int codigo){
        Categoria_Pelicula categoria=null;
        String sql="SELECT codigo, descripcion FROM categoria WHERE codigo=?";                           
        try {
            ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,codigo));  
            ConjuntoResultado cres=AccesoDatos.ejecutaQuery(sql,lstPar);
            while(cres.next()){
            categoria=new Categoria_Pelicula();
            categoria.setCodigo(cres.getInt(1)); 
            categoria.setDescripcion(cres.getString(2));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return categoria;
    }
    
    public static boolean insertar(Categoria_Pelicula cat){
        boolean res=false;
        String sql= "INSERT INTO categoria(codigo, descripcion) VALUES (?, ?)";
        try {
            ArrayList<Parametro> lstPar= new ArrayList();
            lstPar.add(new Parametro(1,cat.getCodigo()));
            lstPar.add(new Parametro(2,cat.getDescripcion()));
            res= AccesoDatos.ejecutaComando1(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
        return res;
    }
    
    public static boolean actualizar(Categoria_Pelicula cat){
        boolean res=false;
        String sql= "UPDATE categoria SET codigo=?, descripcion=? WHERE codigo="+cat.getCodigo();         
        try {
            ArrayList<Parametro> lstPar= new ArrayList();
            lstPar.add(new Parametro(1,cat.getCodigo()));
            lstPar.add(new Parametro(2,cat.getDescripcion()));
            res= AccesoDatos.ejecutaComando1(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
        return res;
    }
}
