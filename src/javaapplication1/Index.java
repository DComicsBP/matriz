package javaapplication1;

import java.util.concurrent.ThreadLocalRandom;

public class Index {
    
    static long [][] matrizA = new long[3][3];
    static long [][] matrizB = new long[3][3];
    static long [][] result = new long[3][3];
    static char letra = 'A';
    
    
    static long[][] geraMatriz(long matriz[][]) {
        System.out.println("Matriz " + letra);
        for (long[] m : matriz) {
            for (int j = 0; j < m.length; j++) {
                m[j] = ThreadLocalRandom.current().nextInt(1, 9);
                System.out.print(m[j] + "-");
            }
            System.out.println(""); 
        }
        letra++;
        return matriz;  
    }
    
    
    public static void main(String[] args) {
        matrizA = geraMatriz(matrizA);
        matrizB = geraMatriz(matrizB);

        MultiplicaMatriz mm = new MultiplicaMatriz(3,3);

        MatrizRun thread1 = new MatrizRun(mm);
        
        try {
            Thread t1 = new Thread(thread1);
            
            t1.start();
            t1.join();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
       System.out.println("Resultado: ");
       for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizB.length; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
}

class MultiplicaMatriz extends Index {
    private int a;
    private int b;
    
    public MultiplicaMatriz(int i, int j) {
        this.a = i;
        this.b = j;
    }
    
    public void multiplica(){
        int soma = 0;
        for (int l = 0; l < a; l++) {
            for (int m = 0; m < b; m++) {
                for (int i = 0; i < a; i++) {
                    soma += matrizA[l][i] * matrizB[i][m];
                }
                System.out.println("Resultado => "+ soma);
                result[l][m] = soma;
                soma = 0;
            }
        }
    }
}