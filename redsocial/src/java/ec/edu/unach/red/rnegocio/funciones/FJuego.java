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
 * @author COMPUTER
 */
public class FJuego {
    public static List<Juego> obtener(){
        ArrayList<Juego> lst= new ArrayList<>();
        String sql= "select codigo, cod_usuario, titulo, jugadores, cod_categoria from juego";
        try {
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql);
            Juego juego;
            while(cres.next()){
                juego= new Juego();
                juego.setCodigo(cres.getInt(1));
                juego.setUsuario(FUsuario.obtener(cres.getInt(2)));
                juego.setTitulo(cres.getString(3));
                juego.setJugadores(cres.getInt(4));
                juego.setCategoria(FCategoriaJuego.obtener(cres.getInt(5)));
                lst.add(juego);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    public static boolean insertar(Juego juego){
        boolean res=false;
        String sql= "insert into juego values(?,?,?,?,?)";
        try {
            ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,juego.getCodigo()));
            lstPar.add(new Parametro(2,juego.getUsuario().getCodigo()));
            lstPar.add(new Parametro(3,juego.getTitulo()));
            lstPar.add(new Parametro(4,juego.getJugadores()));
            lstPar.add(new Parametro(5,juego.getCategoria().getCodigo()));
            res= AccesoDatos.ejecutaComando1(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
        return res;
    }
    public static Juego obtener(int codigo){
        Juego juego=null;
        String sql= "select codigo, cod_usuario, titulo, jugadores, cod_categoria from juego where codigo=?";
        try {
             ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,codigo));
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql,lstPar);           
            while(cres.next()){
                juego= new Juego();
                juego.setCodigo(cres.getInt(1));
                juego.setUsuario(FUsuario.obtener(cres.getInt(2)));
                juego.setTitulo(cres.getString(3));
                juego.setJugadores(cres.getInt(4));
                juego.setCategoria(FCategoriaJuego.obtener(cres.getInt(5)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return juego;
    }
    public static Juego eliminar(int codigo)
    {
        Juego juego=null;
        String sql= "DELETE FROM juego WHERE  codigo=?";
        try {
             ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,codigo)); 
            ConjuntoResultado cres= AccesoDatos.ejecutaQuery(sql,lstPar);           
            while(cres.next()){
                juego= new Juego();
                juego.setCodigo(cres.getInt(1));
                juego.setTitulo(cres.getString(2));
                juego.setUsuario(FUsuario.obtener(cres.getInt(3)));
                juego.setJugadores(cres.getInt(4));
                juego.setCategoria(FCategoriaJuego.obtener(cres.getInt(5)));
                 
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return juego;
        
    }
     
public static boolean modificar(Juego juego){
         boolean res=false;
        String sql= " UPDATE juego set cod_usuario=?, titulo=?, jugadores=?, cod_categoria=? where codigo=? ";
        try {
             ArrayList<Parametro> lstPar= new ArrayList<>();
            lstPar.add(new Parametro(1,juego.getUsuario().getCodigo()));
            lstPar.add(new Parametro(2,juego.getTitulo()));
            lstPar.add(new Parametro(3,juego.getJugadores()));
            lstPar.add(new Parametro(4,juego.getCategoria().getCodigo()));
            lstPar.add(new Parametro(5,juego.getCodigo()));
            res=AccesoDatos.ejecutaComando(sql, lstPar);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }
}
