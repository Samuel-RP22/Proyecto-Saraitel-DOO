package co.edu.uco.libreriauco.pruebas;

import  co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;

public class PruebasTexto {

    public static void main(String[] args) {
        
        String miVariable = "   mi casa es azul   ";
        
        System.out.println(miVariable);
        System.out.println(UtilTexto.getUtilTexto().obtenerLongitudCadena(miVariable));
        System.out.println(UtilTexto.getUtilTexto().obtenerLongitudCadena(miVariable, true));
    }
}
