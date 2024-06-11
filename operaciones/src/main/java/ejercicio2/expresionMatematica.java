package ejercicio2;

public class expresionMatematica {
    private String expresion;

    public expresionMatematica(String expresion) {
        this.expresion = expresion;
    }

    public double evaluar() {
        return evaluarExpresion(expresion);
    }

    private double evaluarExpresion(String expresion) {
        
        return evaluarExpresionSimple(expresion);
    }

    private double evaluarExpresionSimple(String expresion) {
       
        return evaluarExpresionSimpleRecursiva(expresion);
    }

    private double evaluarExpresionSimpleRecursiva(String expresion) {
    
        int nivelParentesis = 0;
        int indexOperador = -1;
        int nivelMenorPrecedencia = Integer.MAX_VALUE;

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);
            if (c == '(') {
                nivelParentesis++;
            } else if (c == ')') {
                nivelParentesis--;
            } else if (nivelParentesis == 0 && (c == '+' || c == '-' || c == '*' || c == '/')) {
                int precedencia = obtenerPrecedencia(c);
                if (precedencia <= nivelMenorPrecedencia) {
                    nivelMenorPrecedencia = precedencia;
                    indexOperador = i;
                }
            }
        }

        if (indexOperador != -1) {
            String parteIzquierda = expresion.substring(0, indexOperador);
            String parteDerecha = expresion.substring(indexOperador + 1);

            char operador = expresion.charAt(indexOperador);

            double valorIzquierda = evaluarExpresionSimpleRecursiva(parteIzquierda);
            double valorDerecha = evaluarExpresionSimpleRecursiva(parteDerecha);

            switch (operador) {
                case '+':
                    return valorIzquierda + valorDerecha;
                case '-':
                    return valorIzquierda - valorDerecha;
                case '*':
                    return valorIzquierda * valorDerecha;
                case '/':
                    if (valorDerecha == 0) {
                        throw new ArithmeticException("División por cero");
                    }
                    return valorIzquierda / valorDerecha;
            }
        }

        
        if (expresion.charAt(0) == '(' && expresion.charAt(expresion.length() - 1) == ')') {

            String subExpresion = expresion.substring(1, expresion.length() - 1);
            return evaluarExpresionSimpleRecursiva(subExpresion);
        }

       
        return Double.parseDouble(expresion);
    }

    private int obtenerPrecedencia(char operador) {
        
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0; 
        }
    }
}
