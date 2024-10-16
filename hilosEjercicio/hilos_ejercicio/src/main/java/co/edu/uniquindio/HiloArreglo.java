package co.edu.uniquindio;

public class HiloArreglo implements Runnable{


    @Override
    public void run() {
        int[] arreglo = {1, 2, 3, 4, 5};
        for (int valor : arreglo) {
            System.out.println("Hilo 1 - Valor: " + valor);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
