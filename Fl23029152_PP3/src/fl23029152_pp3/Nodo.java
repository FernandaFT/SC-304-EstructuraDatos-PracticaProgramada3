/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fl23029152_pp3;

/**
 *
 * @author fernandafajardo
 */
public class Nodo {
    
    private int dato;
    private Nodo izq;
    private Nodo derecha;

    public Nodo(int dato) {
        this.dato = dato;
        this.izq = null;
        this.derecha = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }  
}
