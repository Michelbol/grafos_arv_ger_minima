/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhografosarvoregeradoraminima;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 *
 * @author miche
 */
public class Grafo{
    private List<Aresta> aresta;
    private List<Vertice> vertice;
    private int nro_grupos;

    public int getNro_grupos() {
        return nro_grupos;
    }

    public void setNro_grupos(int nro_grupos) {
        this.nro_grupos = nro_grupos;
    }

    public List<Aresta> getAresta() {
        return aresta;
    }

    public void setAresta(List<Aresta> aresta) {
        this.aresta = aresta;
    }

    public List<Vertice> getVertice() {
        return vertice;
    }

    public void setVertice(List<Vertice> vertice) {
        this.vertice = vertice;
    }
    
    public int distanciaEntreVertices(Vertice v1, Vertice v2){
        return 999;
    }
    
    public void setAllVerticeBranco(){
        for(Vertice v: this.vertice){
            v.setCor(Cor.Branco);
        }
    }
    public void setAllCompConexZero(){
        for(Vertice v: this.vertice){
            v.setCompConex(0);
        }
    }
    
    public void addAresta(Aresta aresta){
        List arestas = this.getAresta();
        arestas.add(aresta);
        this.setAresta(arestas);
    }
    public void addVertice(Vertice vertice){
        List vertices = this.getVertice();
        vertices.add(vertice);
        this.setVertice(vertices);
    }

    public Grafo() {
        List<Vertice> v = new ArrayList();
        List<Aresta> a = new ArrayList();
        this.setAresta(a);
        this.setVertice(v);
    }

    @Override
    public String toString() {
        return "Grafo{" + "aresta=" + aresta + ",\n      vertice=" + vertice + '}';
    }
    
    public void initForBuscaLargura(Vertice s){
        for(Vertice v: this.vertice){
            v.setCor(Cor.Branco);
            v.setDistancia(Integer.MAX_VALUE);
            v.setPredecessor(null);
            if (v.equals(s)){
                s.setCor(Cor.Cinza);
                s.setDistancia(0);
            }
        }
    }
    
    public boolean maior(int x, int y){
        return x > y;
    }
    
    public Grafo limpaGrafo(Grafo g){
        for(Vertice v: g.getVertice()){
            v.setLow(0);
            v.setInitTmpDesc(0);
            v.setFinalTmpDesc(0);
            v.setCor(Cor.Branco);
            v.setCompConex(0);
            v.setDistancia(0);
            v.setPredecessor(null);
            v.setIsPontoArticulacao(false);
        }
        return g;
    }
    
        public void imprimeListaAdjacencia(){
        List<Vertice>   vertices  = this.getVertice();
        List<Aresta>    arestas   = this.getAresta();
        
        for(int i = 0; i < vertices.size(); i++){
            Vertice vertice = vertices.get(i);
            System.out.print("["+ vertice.getNome() +"]");
            List<Vertice> adjacentes = vertice.getAdjacentes();
            for(int j = 0; j < adjacentes.size(); j++){
                Vertice adjacente = adjacentes.get(j);
                if(j==0){
                    System.out.print("->");
                }
                System.out.print("["+ adjacente.getNome()+"]");
                if((j+1) != adjacentes.size()){
                    System.out.print("[]->");
                }else{
                    System.out.print("[/]");
                }
            }
            System.out.println("");
        }
    }
    public int verificaVerticeGrafo(Vertice u){
        for(int i = 0; i < this.vertice.size(); i++){
            if(this.vertice.get(i).equals(u)){
                return i;
            }
        }
        return -1;
    }
    
    public void calcDistanciaPontos(){
        int vertices_length = vertice.size();
        for(int i = 0; i < vertices_length; i++){
            Vertice vertice1 = vertice.get(i);
           for(int j = i+1; j < vertices_length; j++){
               Vertice vertice2 = vertice.get(j);
               Aresta aresta1 = new Aresta(vertice1,vertice2);
               int cateto1 = Math.abs(vertice1.getCoordenadaX() - vertice2.getCoordenadaX());
               int cateto2 = Math.abs(vertice1.getCoordenadaY() - vertice2.getCoordenadaY());
               double cateto1quadrado = Math.pow(cateto1, 2);
               double cateto2quadrado = Math.pow(cateto2, 2);
               aresta1.setPeso(Math.sqrt(cateto1quadrado+cateto2quadrado));
               aresta.add(aresta1);
               vertice.get(i).addAdjacente(vertice2);
               vertice.get(j).addAdjacente(vertice1);
           }  
        }
    }
    
    public Grafo ArvoreGeradoraMinimaPrim(){
        this.limpaGrafo(this);
        double custo_caminho = 0;
        Grafo g = new Grafo();
        g.setNro_grupos(nro_grupos);
        List<Vertice> caminho_minimo = new ArrayList<Vertice>();
        List<Aresta> aresta = new ArrayList<Aresta>();
        caminho_minimo.add(vertice.get(0));
        while(vertice.size() != caminho_minimo.size()){
            int caminho_length = caminho_minimo.size();
            double custo_real = 0;
            Vertice melhor_v = null;
            Vertice melhor_u = null;
            double custo_adjacente = Double.POSITIVE_INFINITY;
            for(int j = 0; j < caminho_length; j++){
                Vertice u = caminho_minimo.get(j);
                int caminho_length2 = u.getAdjacentes().size();
                double custo_aresta = 0;
                for(int i = 0; i < caminho_length2; i++){ 
                    Vertice v = u.getAdjacentes().get(i);
                    if(caminho_minimo.contains(v)){
                        continue;
                    }
                    double cateto1quadrado = Math.pow(Math.abs(u.getCoordenadaX() - v.getCoordenadaX()), 2);
                    double cateto2quadrado = Math.pow(Math.abs(u.getCoordenadaY() - v.getCoordenadaY()), 2);
                    custo_aresta = Math.sqrt(cateto1quadrado+cateto2quadrado);
                    double temp_custo = custo_caminho+custo_aresta;
                    if(temp_custo <= custo_adjacente ){
                        custo_real = custo_aresta;
                        custo_adjacente = temp_custo;
                        melhor_v = v;
                        melhor_u = u;
                    }
                }
            }
            if(melhor_v != null){
                aresta.add(new Aresta(melhor_u,melhor_v, custo_real));
                melhor_u.addAdjacente2(melhor_v);
                melhor_v.addAdjacente2(melhor_u);
                custo_caminho = custo_adjacente;
                caminho_minimo.add(melhor_v);
            }
        }
        g.setVertice(caminho_minimo);
        g.setAresta(aresta);
        Collections.sort(aresta);
        return g;
    }
    
    public void criarGrupos(){
        List<Aresta> removidas = new ArrayList<Aresta>();
        for(int i = 0; i < nro_grupos-1; i++){
            int aresta_size = aresta.size()-1;
            Aresta aresta_rem = aresta.get(aresta_size);
            Vertice v1 = aresta_rem.getV1();
            Vertice v2 = aresta_rem.getV2();
            List<Vertice> v = v1.getAdjacentes_prim();
            v.remove(v.indexOf(v2));
            v1.setAdjacentes_prim(v);
            List<Vertice> u = v2.getAdjacentes_prim();
            u.remove(u.indexOf(v1));
            v2.setAdjacentes_prim(u);
            removidas.add(aresta_rem);
            aresta.remove(aresta_size);
        }
        for(Aresta a : removidas){
            Vertice v = a.getV1();
            Vertice u = a.getV2();
//            System.out.println(v);
            buscaEmProfundidadeConex(v, 0);
            System.out.println("");
            buscaEmProfundidadeConex(u, 0);
            System.out.println("");
        }
        System.out.println("");
    }
    public void buscaEmProfundidadeConex(Vertice v, int compConex){
        v.setCor(Cor.Cinza);
        v.setCompConex(compConex);
        for(Vertice vertice : v.getAdjacentes_prim()){
            if (vertice.getCor() == Cor.Branco){
                buscaEmProfundidadeConex(vertice, compConex);
            }
        }
        if(!v.isIsImprimido()){
            System.out.print(v.getNome()+" ");
            v.setIsImprimido(true);
        }
        v.setCor(Cor.Preto);
    }
    public void limparAdjacentes(){
        for(Vertice v : vertice){
            v.setAdjacentes(null);
        }
    }
}
