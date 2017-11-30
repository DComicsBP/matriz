/****************************
 * Membros: Rafael, Daione, Paulo Roberto
 */


package javaapplication1;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Index {
    static Integer [][] matrizA = new Integer[3][3];
    static Integer [][] matrizB = new Integer[3][3];
    static Integer [][] matrizResultado = new Integer[3][3];;
    
    static Integer[][] geraMatriz(Integer matriz[][]) {
        for (Integer[] m : matriz) {
            for (int j = 0; j < m.length; j++) {
                m[j] = ThreadLocalRandom.current().nextInt(1, 15);
            }
        }
        return matriz;  
    }
    
    public static void main(String[] args) throws InterruptedException {
        matrizA = geraMatriz(matrizA);
        matrizB = geraMatriz(matrizB);
        matrizResultado = geraMatriz(matrizResultado);
        ArrayList<Thread> threads = new ArrayList<>();
        
       for (int linha = 0; linha < matrizA.length; linha++) {
            for (int coluna = 0; coluna < matrizB.length; coluna++) {
                threads.add(new Thread(new MatrizRun(matrizA,matrizB, matrizResultado, linha, coluna)));
            }
        }
       
        for (int i = 0; i < threads.size(); i++) {
              threads.get(i).start(); 
        }
        
        try {
            for (int i = 0; i < threads.size(); i++) {
              threads.get(i).join();
            }
        } catch (InterruptedException ex) { }
       
        System.out.println("Resultado");
        for (Integer[] matrizResultado1 : matrizResultado) {
            for (int j = 0; j < matrizResultado.length; j++) {
                System.out.print(matrizResultado1[j] + "-");
            }
            System.out.println(" ");
        }
    }
}