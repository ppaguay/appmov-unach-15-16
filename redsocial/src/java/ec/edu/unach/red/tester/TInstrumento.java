/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.unach.red.tester;
import ec.edu.unach.red.clases.*;
import ec.edu.unach.red.funciones.*;
import java.util.List;
/**
 *
 * @author Jefferson
 */
public class TInstrumento {
    public static void main (String [] args){
//    List<Instrumento> lista= FInstrumento.obtener();
//        for(Instrumento n: lista){
//            System.out.println(n.getCodins());
//            System.out.println(n.getUsuario().getNombre());
//            System.out.println(n.getCategoria().getDescripcion());
//            System.out.println(n.getDescripcion());
//            System.out.println(n.getMaterial());
//        }
         
         Usuario usu=new Usuario(1130,"Marta","zioan@haha","15023","mart","M");
         boolean nivss=FUsuario.insertar(usu);
         Categoria_instrumento cat=new Categoria_instrumento(9097,"cuerdas 2");
         boolean niz=FCategoria_instrumento.insertar(cat);
         Instrumento niv=new Instrumento(5050,usu,cat,"tambor","canela");
         boolean fa=FInstrumento.insertar(niv);
         
         
         
    }
}
