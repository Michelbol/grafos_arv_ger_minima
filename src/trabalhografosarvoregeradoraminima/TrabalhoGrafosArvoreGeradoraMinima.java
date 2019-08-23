/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhografosarvoregeradoraminima;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author User
 */
public class TrabalhoGrafosArvoreGeradoraMinima {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
        try{
            System.out.println("Exemplo Professor");
            exemploProfessor();
            System.out.println("Exemplo 1");
            exemplo1();
            System.out.println("Exemplo 2");
            exemplo2();
            System.out.println("Exemplo 3");
            exemplo3();
        }catch(Exception e){
            System.out.println("Exception: "+ e);
        }
    }
    
    public static void exemploProfessor() throws IOException{
        //=======================================Exemplo Professor============================================================================//
        /**/Grafo grafo = lerGrafo(new File(".").getCanonicalPath()+"\\src\\trabalhografosarvoregeradoraminima\\newfile.txt");/**/
        /**/System.out.println("Nro Vertices: "+ grafo.getVertice().size());                                                        /**/
        /**/System.out.println("Nro de Grupos: "+ grafo.getNro_grupos());
        /**/grafo.calcDistanciaPontos();
        /**/Grafo Agm = grafo.ArvoreGeradoraMinimaPrim();
        /**/Agm.criarGrupos();
        /**/
        /**/System.out.println("====================================================================================================");
        //============================================================================================================================//
    }
    
    public static void exemplo1() throws IOException{
        //=======================================Exemplo 1============================================================================//
        /**/Grafo grafo2 = lerGrafo(new File(".").getCanonicalPath()+"\\src\\trabalhografosarvoregeradoraminima\\exemplo1.txt");/**/
        /**/System.out.println("Nro Vertices: "+ grafo2.getVertice().size());                                                        /**/
        /**/System.out.println("Nro de Grupos: "+ grafo2.getNro_grupos());
        /**/grafo2.calcDistanciaPontos();
        /**/Grafo Agm2 = grafo2.ArvoreGeradoraMinimaPrim();
        /**/Agm2.criarGrupos();
        /**/
        /**/System.out.println("====================================================================================================");
        //============================================================================================================================//
    }
    public static void exemplo2() throws IOException{
        //=======================================Exemplo 2============================================================================//
        /**/Grafo grafo3 = lerGrafo(new File(".").getCanonicalPath()+"\\src\\trabalhografosarvoregeradoraminima\\exemplo2.txt");/**/
        /**/System.out.println("Nro Vertices: "+ grafo3.getVertice().size());                                                        /**/
        /**/System.out.println("Nro de Grupos: "+ grafo3.getNro_grupos());
        /**/grafo3.calcDistanciaPontos();
        /**/Grafo Agm3 = grafo3.ArvoreGeradoraMinimaPrim();
        /**/Agm3.criarGrupos();
        /**/
        /**/System.out.println("====================================================================================================");
        //============================================================================================================================//
    }
    
    public static void exemplo3() throws IOException{
        //=======================================Exemplo 3============================================================================//
        /**/Grafo grafo4 = lerGrafo(new File(".").getCanonicalPath()+"\\src\\trabalhografosarvoregeradoraminima\\exemplo3.txt");/**/
        /**/System.out.println("Nro Vertices: "+ grafo4.getVertice().size());                                                        /**/
        /**/System.out.println("Nro de Grupos: "+ grafo4.getNro_grupos());
        /**/grafo4.calcDistanciaPontos();
        /**/Grafo Agm4 = grafo4.ArvoreGeradoraMinimaPrim();
        /**/Agm4.criarGrupos();
        /**/
        /**/System.out.println("====================================================================================================");
        //============================================================================================================================//
    }
    
    
    public static Grafo lerGrafo(String path){
        try {
            Grafo grafo = new Grafo();
            FileReader arq = new FileReader(path);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            String linha_split[]    = linha.split(" ");
            int nro_vertices        = Integer.parseInt(linha_split[0]);
            int nro_grupos          = Integer.parseInt(linha_split[1]);
            grafo.setNro_grupos(nro_grupos);
            int count = 1;
            linha = lerArq.readLine();
            while(linha != null){
                linha_split = linha.split(" ");
                Vertice u           = new Vertice(Integer.toString(count), Integer.parseInt(linha_split[0]), Integer.parseInt(linha_split[1]));
                grafo.addVertice(u);
                linha = lerArq.readLine();
                count++;
            }
            arq.close();
            if(nro_vertices != grafo.getVertice().size()){
                System.out.println("Erro!! Número de vertices não são iguais a quantidade informada");
                return null;
            }
            return grafo;
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
            e.getMessage());
            return null;
        }
    }
}