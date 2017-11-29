package javaapplication1;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Index {
    
    static int [][] matrizA = new int[3][3];
    static int [][] matrizB = new int[3][3];
    static int [][] result = new int[3][3];
    static char letra = 'A'; //Não encrenca com isso!!!!!!
    
    
    static int[][] geraMatriz(int matriz[][]) {
        System.out.println("Matriz " + letra);
        for (int[] m : matriz) {
            for (int j = 0; j < m.length; j++) {
                m[j] = ThreadLocalRandom.current().nextInt(1, 9);
                System.out.print(m[j] + "-");
            }
            System.out.println(""); 
        }
        letra++;
        return matriz;  
    }
    
    
    public static void main(String[] args) throws InterruptedException {
        matrizA = geraMatriz(matrizA);
        matrizB = geraMatriz(matrizB);
        ArrayList<Thread> threads = new ArrayList<>();

       for (int linha = 0; linha < matrizA.length; linha++) {
            for (int coluna = 0; coluna < matrizB.length; coluna++) {
                MatrizRun t = new MatrizRun(new MultiplicaMatriz(), linha, coluna);
                threads.add(new Thread(t));
            }
        }
       
        System.out.println("\n");
        for (int i = 0; i < threads.size(); i++) {
              threads.get(i).start();
              System.out.println(threads.get(i).getName()+" => "+threads.get(i).getState());
              
              
              threads.get(i).join();
              System.out.println(threads.get(i).getName()+" => "+threads.get(i).getState());
        }
        
       
        System.out.println("\n\nResultado");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[i][j]+"-");
            }
            System.out.println(" ");
        }
        
        
        
    }
    
}

class MultiplicaMatriz extends Index {
  
    public void multiplica(int linha, int coluna){
        int soma = 0;
        for(int x=0; x < matrizA.length; x++){
            soma += matrizA[linha][x] * matrizB[x][coluna];
        }
        result[linha][coluna] = soma;
    }
}