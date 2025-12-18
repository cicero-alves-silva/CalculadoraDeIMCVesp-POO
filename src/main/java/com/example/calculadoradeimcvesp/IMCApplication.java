package com.example.calculadoradeimcvesp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class IMCApplication extends Application {
    private static Stage palco;
    private static Scene cenaPrincipal;
    private static Scene cenaCalculo;
    private static Object dadosEnviados;

    @Override
    public void start(Stage stage) throws IOException {
        palco = stage;
        FXMLLoader fxmlLoaderTelaPrincipal = new FXMLLoader(IMCApplication.class.getResource("tela-principal.fxml"));
        cenaPrincipal = new Scene(fxmlLoaderTelaPrincipal.load());
        FXMLLoader fxmlLoaderTelaCalculo = new FXMLLoader(IMCApplication.class.getResource("tela-calculo.fxml"));
        cenaCalculo = new Scene(fxmlLoaderTelaCalculo.load());
        palco.setMaximized(true);
        palco.setTitle("Calculadora de IMC");
        palco.setScene(cenaPrincipal);
        palco.show();
    }

    public static void trocarTela(String nomeDaTela, Object dadosEnviados){
        IMCApplication.dadosEnviados = dadosEnviados;
        palco.setMaximized(false);
        switch (nomeDaTela) {
            case "PRINCIPAL" -> palco.setScene(cenaPrincipal);
            case "CALCULO" -> palco.setScene(cenaCalculo);
        }
        palco.setMaximized(true);
    }

    public static Object getDadosEnviados() {
        return dadosEnviados;
    }

    public static void main(String[] args) {
        launch();
    }
}