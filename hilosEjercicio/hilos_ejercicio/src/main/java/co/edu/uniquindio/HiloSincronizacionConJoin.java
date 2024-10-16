package co.edu.uniquindio;

public class HiloSincronizacionConJoin {

    private static String variable = "";

    public static void main(String[] args) {
        long tac = System.currentTimeMillis(); // Tiempo inicial
        long tiempoFinal = tac + 20000; // Tiempo final: 20 segundos después

        while (System.currentTimeMillis() < tiempoFinal) {
            // Crear instancias de los hilos
            Hilo1 hilo1 = new Hilo1();
            Hilo2 hilo2 = new Hilo2();

            // Iniciar Hilo1 y esperar a que termine con join()
            try {
                hilo1.start();
                hilo1.join(); // Esperar a que Hilo1 termine

                // Iniciar Hilo2 y esperar a que termine con join()
                hilo2.start();
                hilo2.join(); // Esperar a que Hilo2 termine
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Han pasado 20 segundos. Fin del programa.");
    }

    // Hilo 1: Escribir en consola cierta información y concatenarla a una variable String durante 6 segundos
    static class Hilo1 extends Thread {
        @Override
        public void run() {
            try {
                variable = ""; // Reiniciar la variable
                long tiempoInicio = System.currentTimeMillis();
                while (System.currentTimeMillis() - tiempoInicio < 6000) {
                    variable += "rata"; // Concatenar "hola" a la variable
                    System.out.println("Hilo 1 escribe: " + variable);
                    Thread.sleep(1000); // Espera de 1 segundo
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Hilo 2: Leer la variable, mostrarla y borrar la información escrita por el Hilo 1
    static class Hilo2 extends Thread {
        @Override
        public void run() {
            // Mostrar la variable
            System.out.println("Hilo 2 lee: " + variable);
            // Borrar la información
            variable = "";
            System.out.println("Hilo 2 borra la variable");
        }
    }
}