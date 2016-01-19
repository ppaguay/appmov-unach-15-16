/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.unach.red.rnegocio.funciones;
import ec.edu.unach.red.rnegocio.clases.CategoriaReceta;
import ec.edu.unach.red.accesodatos.*;
import java.util.*;
import ec.edu.unach.red.rnegocio.clases.*;
/**
 *
 * @author Ivancito
 */
public class FCategoriaReceta 
{
    public static List<CategoriaReceta> obtener()          
    {
        ArrayList<CategoriaReceta> list=new ArrayList<>();
        String sql="select codcat,descripcion from categoria_receta";
        try 
        {
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql);
            CategoriaReceta cat;
            while(cres.next())
            {
                cat = new CategoriaReceta();
                cat.setCodcat(cres.getInt(1));
                cat.setDescripcion(cres.getString(2));
                list.add(cat);                                       
            }
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());            
        }
        return list;          
    }
    
    public static boolean insertar(CategoriaReceta cat)
    {
        boolean resp = false;
        String sql = "insert into categoria_receta values(?,?)";
        try 
        { 
            ArrayList<Parametro> listPar = new ArrayList<>();
            listPar.add(new Parametro(1, cat.getCodcat()));
            listPar.add(new Parametro(2, cat.getDescripcion()));
            resp = AccesoDatos.ejecutaComando1(sql, listPar);           
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
        return resp;
        
    }
     public static CategoriaReceta obtener(int codigo){
        CategoriaReceta cat=null;
        String sql= "select codcat, descripcion from categoria_receta where codcat=?";
        try {
             ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,codigo));
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql,lstPar);           
            while(cres.next()){
                cat= new CategoriaReceta();
                cat.setCodcat(cres.getInt(1));
                cat.setDescripcion(cres.getString(2));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cat;
    }
}
