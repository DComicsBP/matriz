package javaapplication1;

public class MatrizRun implements Runnable {
    
    private int linha, coluna;
    Integer[][] matrizA = new Integer[3][3];
    Integer[][] matrizB = new Integer[3][3];
    Integer[][] matrizResultado = new Integer[3][3];
    
    
    public MatrizRun(Integer[][] matrizA, Integer[][] matrizB, Integer[][] matrizResultado, int l ,int c) {
        this.matrizA            = matrizA;
        this.matrizB            = matrizB;
        this.matrizResultado    = matrizResultado;
        this.linha              = l;
        this.coluna             = c;
    }
    
    @Override
    public void run() {
        int temp = 0;
         for(int x=0; x < matrizA.length; x++){
            temp += matrizA[linha][x] * matrizB[x][coluna];
        }
         matrizResultado[linha][coluna] = temp;
    }  
    
}
