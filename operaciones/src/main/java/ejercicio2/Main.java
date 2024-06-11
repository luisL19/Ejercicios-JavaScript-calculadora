package ejercicio2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la expresión matemática:");
        String expresion = scanner.nextLine();

        Calculadora calculadora = new Calculadora();
        double resultado = calculadora.evaluarExpresion(expresion);
        System.out.println("El resultado es: " + resultado);
    }
}


