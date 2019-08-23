/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhografosarvoregeradoraminima;

import java.util.Comparator;

/**
 *
 * @author miche
 */
public class Aresta implements Comparable<Aresta>{
    private Vertice v1;
    private Vertice v2;
    private double peso;

    public Vertice getV1() {
        return v1;
    }

    public void setV1(Vertice v1) {
        this.v1 = v1;
    }

    public Vertice getV2() {
        return v2;
    }

    public void setV2(Vertice v2) {
        this.v2 = v2;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "{" + "v1=" + v1.getNome() + ", v2=" + v2.getNome() + ", peso="+ peso +"}\n";
    }
    
    public Aresta(Vertice v1, Vertice v2) {
        this.v1 = v1;
        this.v2 = v2;
    }
    public Aresta(Vertice v1, Vertice v2, double peso) {
        this.v1 = v1;
        this.v2 = v2;
        this.peso = peso;
    }
    @Override
    public int compareTo(Aresta o1) {
        return Double.compare(this.peso, o1.getPeso());
    }


    
}
