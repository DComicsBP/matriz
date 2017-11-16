package javaapplication1;

import java.util.concurrent.ThreadLocalRandom;

public class Matriz {  
    
    
   private long[][] matrizA = new long[3][3];
   private long[][] matrizB = new long[3][3];
   private long[][] matrizR; 
   char a = 'A';
    
    
    public Matriz(){
       this.matrizA = this._geraMatriz(matrizA);
       this.matrizB = this._geraMatriz(matrizB);
       this.matrizR = this.geraMatrizR(matrizA, matrizB);
    }
    
    
    
    private long[][] _geraMatriz(long matriz[][]) {
        System.out.println("Resultado Matriz "+this.a+": ");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = ThreadLocalRandom.current().nextInt(1, 9);
                System.out.print(matriz[i][j]+"-");
            } 
            System.out.println("");
            
            
        }
        
        this.a++;
        return matriz;  
    }

    
    
    private long[][] geraMatrizR(long[][] a, long[][] b){
        long[][] r = new long[3][3];
        for (int l = 0; l < a.length; l++) {
            for (int m = 0; m < a[l].length; m++) {
                for (int i = 0; i < a.length; i++) {
                    r[l][m] += a[l][i] * b[i][m];
                }
                System.out.print(r[l][m]+"-");
            }
            System.out.println("");
        }
        return r;  
    }
    
}
