package javaapplication1;

public class MatrizRun implements Runnable {  
    
    private MultiplicaMatriz matriz;
    private int linha, coluna;
    
    public MatrizRun(MultiplicaMatriz matriz, int i ,int c) {
        this.matriz = matriz;
        this.linha = i;
        this.coluna = c;
    }
    
    @Override
    public void run() {
        matriz.multiplica(linha, coluna);
    }  
    
}
