package javaapplication1;


import java.util.logging.Level;
import java.util.logging.Logger;

public class Matriz implements Runnable{

   

    @Override
    public void run() {
                long[][] a = {{7,8,9},{4,5,6},{7,8,9}};
                long[][] b = {{7,8,9},{4,5,6},{7,8,9}};
                long[][] c = new long[3][3]; 
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    c[i][j]+= a[i][k]*b[k][j];
                    try {
                        Thread.sleep(c[i][j]);
                    } catch (InterruptedException ex) {
                    
                        ex.getStackTrace();
                    }
                    
                }
                System.out.print(c[i][j]+ "-");
                 } 
           
        System.out.println("");

        }
        
    }
    
}
