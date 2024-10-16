package co.edu.uniquindio;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {

        //Primera parte del ejercicio--------------------------------------------------------------------------------------
        //Se usan las clases de hiloarreglo, hilo multiplicacion, hilonombre
        // Crear instancias de los hilos
        /*Thread hilo1 = new Thread(new HiloArreglo());
        Thread hilo2 = new Thread(new HiloMultiplicacion());
        Thread hilo3 = new Thread(new HiloNombre());

        // Iniciar los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();*/



        //Segunda parte del ejercicio--------------------------------------------------------------------------------------
        //Se usan las clases contarvocalest2 y sumarecursivat1
        // S1: Inicializar N y palabra
        int N = 10;
        String palabra = "otorrinolaringologia";

        // Crear instancias de los hilos T1 y T2
        SumaRecursivaT1 t1 = new SumaRecursivaT1(N);
        ContarVocalesT2 t2 = new ContarVocalesT2(palabra);

        // Iniciar los hilos
        t1.start();
        t2.start();

        // Utilizar join para esperar que ambos hilos terminen
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // S4: Multiplicar el resultado de S2 y S3 e imprimir
        int resultado = t1.getResultado() * t2.getResultado();
        System.out.println("Resultado final (S4): " + resultado);


        //Tercera parte del ejercicio-----------------------------------------------------------------------------------------------------
        //Está en la clase HIloSincronizacionConJoin

    }

}