/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fl23029152_pp3;

/**
 *
 * @author fernandafajardo
 */
public class ArbolBinario {
    
    private Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    

    /***
     * Elimina las hojas del árbol binario, una hoja es un nodo que no tiene hijos (ni izq ni derecha).
     * Método wrapper
     * @author Fernanda Fajardo
     */
    public void eliminarHoja(){
        raiz = eliminarHojaRec(raiz);
    }
    
    /***
     * Método recursivo que elimina las hojas de árbol binario.
     * @param actual Nodo actual que se está procesando
     * @return Nodo modificado después de eliminar las hojas de sus subárboles
     * @author Fernanda Fajardo
     */
    private Nodo eliminarHojaRec(Nodo actual){
        
        if(actual == null){
            return null;
        }
        
        if(actual.getIzq() == null && actual.getDerecha() == null){
            return null; // si es una hoja, se elimina
        }
        
        actual.setIzq(eliminarHojaRec(actual.getIzq()));
        actual.setDerecha(eliminarHojaRec(actual.getDerecha()));
        return actual;
    }
    
    /***
     * Multiplica por diez el valor de todos los nodos del árbol binario
     * @author Fernanda Fajardo
     */
    public void multiplicarXDiez(){
        multiplicarXDiezRec(raiz);
    }
    
    /***
     * Método recursivo que multiplica por diez el valor de cada nodo en el árbol binario
     * @param actual Nodo actual que se está procesando
     * @author Fernanda Fajardo
     */
    private void multiplicarXDiezRec(Nodo actual) {
        
        if (actual != null) {
            actual.setDato(actual.getDato() * 10);
            multiplicarXDiezRec(actual.getIzq());
            multiplicarXDiezRec(actual.getDerecha());
        }   
    }
    
    
    
    //Método wrapper
    public void insertar(int dato){
        raiz = insertarRec(raiz, dato);
    }
    
    //Método recursivo
    private Nodo insertarRec(Nodo nodoActual, int valor){
        //Caso 1: El nodo actual está vacío
        if(nodoActual == null){
            return new Nodo(valor); //Condición de parada
        }else{
            //Caso 2: Que el nodo a insertar sea menos a la rama actual
            if(valor < nodoActual.getDato()){
                nodoActual.setIzq(insertarRec(nodoActual.getIzq(),valor));
            }else if(valor > nodoActual.getDato()){
                nodoActual.setDerecha(insertarRec(nodoActual.getDerecha(),valor));
            }
        }
        return nodoActual;
    }
    
    //Recorridos de árboles
    public void inOrden(){
        inOrdenRec(raiz);
    }
    
    //Método recursivo que recorre el árbol en inOrden
    private void inOrdenRec(Nodo actual){
        if(actual != null){
            inOrdenRec(actual.getIzq()); // Vuelva a entrar recursivamente, pero evaluando el hijo izq
            System.out.println(actual.getDato() + " ");
            inOrdenRec(actual.getDerecha()); // Vuelva a entrar recursivamente, pero evaluando el hijo derecha
        }
    }
    
    //Método wrapper preOrden
    public void preOrden(){
        preOrdenRec(raiz);
    }
    
    //Método recursivo que recorre el árbol en preOrden
    private void preOrdenRec(Nodo actual){
        if(actual != null){
            System.out.println(actual.getDato() + " ");
            preOrdenRec(actual.getIzq()); // Vuelva a entrar recursivamente, pero evaluando el hijo izq
            preOrdenRec(actual.getDerecha()); // Vuelva a entrar recursivamente, pero evaluando el hijo derecha
        }
    }
    
    //Método wrapper postOrden
    public void postOrden(){
        postOrdenRec(raiz);
    }
    
    //Método recursivo que recorre el árbol en postOrden
    private void postOrdenRec(Nodo actual){
        if(actual != null){
            postOrdenRec(actual.getIzq()); // Vuelva a entrar recursivamente, pero evaluando el hijo izq
            postOrdenRec(actual.getDerecha()); // Vuelva a entrar recursivamente, pero evaluando el hijo derecha
            System.out.println(actual.getDato() + " ");
        }
    }
    
    //Método wrapper postOrden
    public void eliminar(int valor){
        raiz = eliminarRec(raiz, valor);
    }
    
    //Método recursivo que elimina
    private Nodo eliminarRec (Nodo actual, int valor){
        // Condición de parada
        if (actual == null) return actual;
        
        //Buscar el nodo a la izquierda o a la derecha.
        if (valor < actual.getDato()){  // Vamos a busarlo en la izquierda del arbol
            actual.setIzq(eliminarRec(actual.getIzq(),valor));
        }else if (valor > actual.getDato()){    // Vamos a buscarlo a la derecha del arbol.
            actual.setDerecha(eliminarRec(actual.getDerecha(),valor));
        }else{      // YA lo encontré. Es igual.
            // Caso 1: Nodo sin hijos. (Hoja)
            if (actual.getIzq() == null && actual.getDerecha() == null){
                return null;   // Elimina la hoja y la sustituye por un null.
            }
            // Caso 2: Nodo con un hijo
            if (actual.getIzq() == null)
                return actual.getDerecha();
            else if (actual.getDerecha() == null)
                return actual.getIzq();
            
            // Caso 3: Nodo con 2 hijos.
            Nodo sucesor = minValorSucedor(actual.getDerecha()); // Nos devuelve el sucedor del # que queremos eliminar.
            actual.setDato(sucesor.getDato());  //Ya tenemos remplazado el valor.
            actual.setDerecha(eliminarRec(actual.getDerecha(),sucesor.getDato()));
        }
        return actual;
    }
    private Nodo minValorSucedor(Nodo nodo){
        while(nodo.getIzq() != null){
            nodo = nodo.getIzq();
        }
        return nodo;
    }
    
    public int obtenerNivel(int valor, int nivel){
        return obtenerNivelRec(raiz,valor, nivel);
    }
    
    private int obtenerNivelRec(Nodo actual, int valor, int nivel){
        if(actual == null) return -1;
        
        if(actual.getDato() == valor) return nivel; // Si encuentro el valor retorno su nivel
        int nivelIzq = obtenerNivelRec(actual.getIzq(), valor, nivel +1);
        if(nivelIzq != -1) return nivelIzq; //Significa que encontre el valor que ando buscando;
        return obtenerNivelRec(actual.getDerecha(), valor, nivel +1);
    }
    
    public int obtenerAltura(Nodo actual){
        if(actual == null) return -1;
        int alturaIzq = obtenerAltura(actual.getIzq());
        int alturaDer = obtenerAltura(actual.getDerecha());
        int alturaMayor = Math.max(alturaIzq, alturaDer) +1; // Compara cual de las 2 ramas es mas larga
        return alturaMayor;
    }
}
