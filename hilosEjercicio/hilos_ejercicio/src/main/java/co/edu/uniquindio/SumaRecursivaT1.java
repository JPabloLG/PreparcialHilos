package co.edu.uniquindio;

public class SumaRecursivaT1 extends Thread{
    private int N;
    private int resultado;

    public SumaRecursivaT1(int N) {
        this.N = N;
    }

    @Override
    public void run() {
        resultado = sumaRecursiva(N);
        System.out.println("Resultado de S2 (sumaRecursiva): " + resultado);
    }

    private int sumaRecursiva(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n + sumaRecursiva(n - 1);
        }
    }

    public int getResultado() {
        return resultado;
    }
}