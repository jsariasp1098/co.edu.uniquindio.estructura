import java.util.Scanner;

public class punto11 {
    
    static class NodoPolinomio {
        int coeficiente;
        int exponente;
        
        public NodoPolinomio(int coeficiente, int exponente) {
            this.coeficiente = coeficiente;
            this.exponente = exponente;
        }
        
        @Override
        public String toString() {
            return coeficiente + "x^" + exponente;
        }
    }   
// recursivo para calcular el valor del exponente
    private static double evaluarTermino(int coeficiente, int exponente, double x) {

        double resultado = coeficiente;
        for (int i = 0; i < exponente; i++) {
            resultado *= x;
        }
        return resultado;
    }

    private static double evaluarPolinomio(ListaSimple<NodoPolinomio> polinomio, double x) {
        double resultado = 0;
        
        for (NodoPolinomio termino : polinomio) {
            resultado += evaluarTermino(termino.coeficiente, termino.exponente, x);
        }
        
        return resultado;
    }   

    private static void imprimirPolinomio(ListaSimple<NodoPolinomio> polinomio) {
        boolean primero = true;
        
        for (NodoPolinomio termino : polinomio) {
            if (!primero && termino.coeficiente > 0) {
                System.out.print(" + ");
            } else if (!primero && termino.coeficiente < 0) {
                System.out.print(" - ");
                termino.coeficiente = Math.abs(termino.coeficiente);
            } else if (primero && termino.coeficiente < 0) {
                System.out.print("-");
                termino.coeficiente = Math.abs(termino.coeficiente);
            }
            
            if (termino.exponente == 0) {
                System.out.print(termino.coeficiente);
            } else if (termino.exponente == 1) {
                System.out.print(termino.coeficiente + "x");
            } else {
                System.out.print(termino.coeficiente + "x^" + termino.exponente);
            }
            
            primero = false;
        }
        System.out.println();
    }
    
    private static void imprimirTablaValores(ListaSimple<NodoPolinomio> polinomio, double[] valoresX) {
        System.out.println("\nTabla de valores del polinomio:");
        System.out.println("x\t|\tf(x)");
        for (double x : valoresX) {
            double resultado = evaluarPolinomio(polinomio, x);
            System.out.printf("%.1f\t|\t%.4f\n", x, resultado);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaSimple<NodoPolinomio> polinomio = new ListaSimple<>();
        System.out.println("Ingrese los términos del polinomio. Para finalizar, ingrese 0 0");
        
        boolean continuar = true;
        while (continuar) {
            System.out.print("\nIngrese coeficiente: ");
            int coeficiente = scanner.nextInt();
            
            System.out.print("Ingrese exponente: ");
            int exponente = scanner.nextInt();
            
            // Si ambos valores son 0 se sale del ciclo
            if (coeficiente == 0 && exponente == 0) {
                continuar = false;
            } else if (coeficiente != 0) { // Solo se agrega términos con coeficiente diferente de 0
                polinomio.agregarfinal(new NodoPolinomio(coeficiente, exponente));
            }
        }
        
        if (polinomio.estaVacia()) {
            System.out.println("No se ingresaron vaalores validos.");
            return;
        }
        
        // Imprimir el polinomio
        System.out.println("\nPolinomio representado:");
        imprimirPolinomio(polinomio);
        
        // Solicitar los valores de tabulacion
        System.out.print("\nIngrese el valor inicial de x: ");
        double xInicial = scanner.nextDouble();
        
        System.out.print("Ingrese el valor final de x: ");
        double xFinal = scanner.nextDouble();
        
        System.out.print("Ingrese el incremento para x: ");
        double incremento = scanner.nextDouble();
        
        // Crear el arreglo de valores de x
        int numPuntos = (int)((xFinal - xInicial) / incremento) + 1;
        double[] valoresX = new double[numPuntos];
        
        double valorX = xInicial;
        for (int i = 0; i < numPuntos; i++) {
            valoresX[i] = valorX;
            valorX += incremento;
        }
        
        // Imprimir tabla de valores
        imprimirTablaValores(polinomio, valoresX);
        
        scanner.close();
    }
}
