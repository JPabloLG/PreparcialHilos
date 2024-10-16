package co.edu.uniquindio;

public class HiloMultiplicacion implements Runnable{


    @Override
    public void run() {
        int numero = 2;
        int resultado = 1;
        for (int i = 1; i <= 10; i++) {
            resultado = resultado * numero;
            System.out.println("Hilo 2 - Multiplicación: " + resultado);
            try {
                Thread.sleep(1500); // Espera de 1.5 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
