package ejercicio2;
import java.util.*;


public class Calculadora {
    public double evaluarExpresion(String expresion) {
        expresionMatematica expresionMatematica = new expresionMatematica(expresion);
        return expresionMatematica.evaluar();
    }
}


