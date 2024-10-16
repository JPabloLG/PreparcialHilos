package co.edu.uniquindio;

public class HiloNombre extends Thread{

    @Override
    public void run() {
        String nombreHilo = Thread.currentThread().getName();
        for (int i = 1; i <= 15; i++) {
            System.out.println("Hilo 3 - Nombre del hilo: " + nombreHilo);
            try {
                Thread.sleep(500); // Espera de 500 ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
