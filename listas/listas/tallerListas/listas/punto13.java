
public class punto13 {
    public static int maximaDistancia(ListaSimple<Integer> lista, int x) {
        // Caso base: lista vacia
        if (lista.estaVacia()) {
            return 0;
        }
        
        // Iniciar la metodo recursivo, recorriendo desde el índice 0 hasta el final
        return maximaDistanciaRecursivo(lista, x, 0, -1, 0);
    }   
    private static int maximaDistanciaRecursivo(ListaSimple<Integer> lista, int x, int indiceActual, int ultimoIndice, int maxDistancia) {
        if (indiceActual >= lista.getTamanio()) {
            return maxDistancia;
        }

        Integer valorActual = lista.obtenerValorNodo(indiceActual);
        
        // Si el valor actual es igual a x
        if (valorActual != null && valorActual.equals(x)) {
            // si ya se encontro antes entonces  
            if (ultimoIndice != -1) {
                int distanciaActual = indiceActual - ultimoIndice;
                //se actualiza si se encontro y es necesario
                if (distanciaActual > maxDistancia) {
                    maxDistancia = distanciaActual;
                }
            }
            // donde se encontro el ltimo, se inicia denuevo para mirar si se encuentra otro mas lejos
            ultimoIndice = indiceActual;
        }
        return maximaDistanciaRecursivo(lista, x, indiceActual + 1, ultimoIndice, maxDistancia);
    }
    
    public static void main(String[] args) {
        ListaSimple<Integer> lista = new ListaSimple<>();
        lista.agregarfinal(9);
        lista.agregarfinal(4);
        lista.agregarfinal(6);
        lista.agregarfinal(8);
        lista.agregarfinal(4);
        lista.agregarfinal(5);
        lista.agregarfinal(4);
        lista.agregarfinal(4);
        
        // Imprimir la lista
        System.out.println("Lista:");
        lista.imprimirLista();
        // x es la clave osea es lo que se va buscar
        int x = 4;
        int maxDistancia = maximaDistancia(lista, x);
        System.out.println("La distancia entre dos elementos con la clave " + x + " es: " + maxDistancia);
    }
}
