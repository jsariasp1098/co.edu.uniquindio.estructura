import java.io.*;

public class punto12 {
    private static double calcularMedia(ListaSimple<Double> lista) {
        double suma = 0;
        int n = 0;
        
        for (Double valor : lista) {
            suma += valor;
            n++;
        }
        
        if (n == 0) return 0;
        return suma / n;
    }

    private static double calcularDesviacionEstandar(ListaSimple<Double> lista, double media) {
        double sumaNodos = 0;
        int n = 0;
        
        for (Double valor : lista) {
            sumaNodos += Math.pow(valor - media, 2);
            n++;
        }
        
        if (n <= 1) return 0; //por criterio no se puede calcular con 0 o 1 valores men 
        return Math.sqrt(sumaNodos / (n - 1));
    }
    
    private static ListaSimple<Double> leerNumerosDesdeArchivo(String nombreArchivoOriginal) {
        ListaSimple<Double> lista = new ListaSimple<>();
        
        // men aca puse la ruta del numeros, arrojaba error 
        String rutaFija = "tallerListas/listas/numeros.txt";
        File archivo = new File(rutaFija);
        
        if (!archivo.exists()) {
            System.out.println("ERROR: No se encontro el archivo numeros.txt");
            return lista;
        }
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String linea;
            int lineaActual = 0;
            
            while ((linea = reader.readLine()) != null) {
                lineaActual++;
                linea = linea.trim();
                
                // Saltar lineas vacias
                if (linea.isEmpty()) {
                    continue;
                }
                
                try {
                    // Intentar convertir a double con un parseo  
                    double numero = Double.parseDouble(linea);
                    lista.agregarfinal(numero);
                } catch (NumberFormatException e) {
                    System.out.println("Error en linea " + lineaActual + ": '" + linea + "' no es un nuero valido.");
                }
            }
            
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: No se pudo leer el archivo numeros.txt");
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        
        return lista;
    }
    
    public static void main(String[] args) {
        String nombreArchivo = "numeros.txt";
        ListaSimple<Double> numeros = leerNumerosDesdeArchivo(nombreArchivo);
        
        if (numeros.estaVacia()) {
            System.out.println("No se pudieron leer numeros del archivo.");
            return;
        }
        
        // Calcular la media
        double media = calcularMedia(numeros);
        
        // Calcular la desviación estándar
        double desviacionEstandar = calcularDesviacionEstandar(numeros, media);

        System.out.println("\nResultados:");
        System.out.println("- Cantidad de numeros: " + contarElementos(numeros));
        System.out.printf("- Media: %.4f\n", media);
        System.out.printf("- desviacion estandar: %.4f\n", desviacionEstandar);
        
    }
    
    private static int contarElementos(ListaSimple<Double> lista) {
        int contador = 0;
        for (Double valor : lista) {
            contador++;
        }
        return contador;
    }
}
