/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.unach.red.tester;

import ec.edu.unach.red.rnegocio.funciones.FNivel;
import ec.edu.unach.red.rnegocio.clases.Nivel;
import java.util.*;


/**
 *
 * @author PAUL
 */
public class TNivel {
    public static void main(String[] args){
    
        List<Nivel> lista= FNivel.obtener();
        for(Nivel niv: lista){
            System.out.println(niv.getDescripcion());
        }
    }
}
