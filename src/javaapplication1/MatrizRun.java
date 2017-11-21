package javaapplication1;

public class MatrizRun implements Runnable {  
    
    private MultiplicaMatriz matriz;
            
    public MatrizRun(MultiplicaMatriz matriz) {
        this.matriz = matriz;
    }
    
    @Override
    public void run() {
          matriz.multiplica();
    }
    
}
