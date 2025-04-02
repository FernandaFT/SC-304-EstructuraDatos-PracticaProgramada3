/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fl23029152_pp3;

/**
 *
 * @author fernandafajardo
 */
public class Fl23029152_PP3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArbolBinario arbol = new ArbolBinario();
        
        // a. Precargue el árbol con la siguiente secuencia: 50,20,80,15,30,60,40,90,75,33,82
        arbol.insertar(50);
        arbol.insertar(20);
        arbol.insertar(80);
        arbol.insertar(15);
        arbol.insertar(30);
        arbol.insertar(60);
        arbol.insertar(40);
        arbol.insertar(90);
        arbol.insertar(75);
        arbol.insertar(33);
        arbol.insertar(82);
        
        // b. imprima el árbol
        System.out.println("Árbol en inorden:");
        arbol.inOrden();
        System.out.println("\n");
        
        // c. y f. Invoque un método que elimina las hojas del árbol, y vuelva a imprimir el árbol
        arbol.eliminarHoja();
        System.out.println("Árbol después de eliminar hojas:");
        arbol.inOrden();
        System.out.println("\n");
        
        // d. y f. Invoque un método que elimine el nodo 30, y vuelva a imprimir el árbol
        arbol.eliminar(30);
        System.out.println("Árbol después de eliminar el nodo 30:");
        arbol.inOrden();
        System.out.println("\n");
        
        // e. y f. Usando un algoritmo de recorrido, multiplique por 10 cada elemento del árbol y actualícelo, vuelva a imprimir el árbol
        arbol.multiplicarXDiez();
        System.out.println("Árbol después de multiplicar cada nodo por 10:");
        arbol.inOrden();
    }
    
}
