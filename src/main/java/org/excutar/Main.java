package org.excutar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent; // Mudamos aqui
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Verifique se o caminho é /Tela.fxml ou /View/Tela.fxml conforme sua pasta resources
            URL arquivoFXML = getClass().getResource("/View/Tela.fxml");

            if (arquivoFXML == null) {
                // Tentativa secundária caso o arquivo esteja na raiz de resources
                arquivoFXML = getClass().getResource("/Tela.fxml");
            }

            FXMLLoader loader = new FXMLLoader(arquivoFXML);

            // USANDO PARENT: Isso aceita AnchorPane, StackPane, VBox, etc la no scenebuild
            Parent root = loader.load();

            Scene scene = new Scene(root, 800, 600);
            primaryStage.setTitle("Hortifrúti Desktop");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            System.err.println("Erro ao carregar a tela:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}