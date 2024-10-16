package co.edu.uniquindio;

public class ContarVocalesT2 extends Thread {
    private String palabra;
    private int resultado;

    public ContarVocalesT2(String palabra) {
        this.palabra = palabra;
    }

    @Override
    public void run() {
        resultado = contarVocales(palabra);
        System.out.println("Resultado de S3 (contarVocales): " + resultado);
    }

    private int contarVocales(String palabra) {
        int contador = 0;
        String vocales = "aeiouAEIOU";
        for (char c : palabra.toCharArray()) {
            if (vocales.indexOf(c) != -1) {
                contador++;
            }
        }
        return contador;
    }

    public int getResultado() {
        return resultado;
    }
}
