package com.example.calculadoradeimcvesp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TelaCalculoController {

    @FXML
    private Label lbResultado;

    @FXML
    private TextField tfAltura;

    @FXML
    private TextField tfPeso;

    @FXML
    void cliqueCalcular(ActionEvent event) {
        String pesoString = tfPeso.getText();
        String alturaString = tfAltura.getText();
        if (pesoString.isBlank() || alturaString.isBlank()) {
            lbResultado.setText("Informe os valores antes de calcular.");
            lbResultado.setStyle("-fx-text-fill: #B22222");
        } else {
            try {
                double peso = Double.parseDouble(pesoString.replace(",", "."));
                double altura = Double.parseDouble(alturaString.replace(",", "."));
                if (peso > 0 && altura > 0) {
                    double imc = peso / Math.pow(altura, 2);
                    String categoria = (String) IMCApplication.getDadosEnviados();
                    switch (categoria) {
                        case "ADULTO" -> {
                            if (imc < 18.5) {
                                lbResultado.setText("BAIXO PESO");
                                lbResultado.setStyle("-fx-text-fill: #B22222");
                            } else if (imc >= 18.5 && imc < 25) {
                                lbResultado.setText("PESO NORMAL");
                                lbResultado.setStyle("-fx-text-fill: #008000");
                            } else if (imc >= 25 && imc < 30) {
                                lbResultado.setText("SOBREPESO");
                                lbResultado.setStyle("-fx-text-fill: #FFFF00");
                            } else if (imc >= 30 && imc < 35) {
                                lbResultado.setText("Obesidade Classe I");
                                lbResultado.setStyle("-fx-text-fill: #B22222");
                            } else if (imc >= 35 && imc < 40) {
                                lbResultado.setText("Obesidade Classe II");
                                lbResultado.setStyle("-fx-text-fill: #B22222");
                            } else {
                                lbResultado.setText("Obesidade Classe III");
                                lbResultado.setStyle("-fx-text-fill: #B22222");
                            }
                        }
                        case "IDOSO" -> {
                            if (imc <= 22) {
                                lbResultado.setText("BAIXO PESO");
                                lbResultado.setStyle("-fx-text-fill: #B22222");
                            } else if (imc > 22 && imc < 27) {
                                lbResultado.setText("PESO NORMAL");
                                lbResultado.setStyle("-fx-text-fill: #008000");
                            } else {
                                lbResultado.setText("SOBREPESO");
                                lbResultado.setStyle("-fx-text-fill: #B22222");
                            }
                        }
                    }
                } else {
                    lbResultado.setText("Digite apenas números reais positivos " +
                            "para peso e/ou altura.");
                    lbResultado.setStyle("-fx-text-fill: #B22222");
                }
            } catch (NumberFormatException nfe) {
                lbResultado.setText("Digite apenas números reais positivos" +
                        " para peso e/ou altura.");
                lbResultado.setStyle("-fx-text-fill: #B22222");
            }
        }
    }

    @FXML
    void cliqueVoltar(ActionEvent event) {
        tfAltura.clear();
        tfPeso.clear();
        lbResultado.setText("");
        IMCApplication.trocarTela("PRINCIPAL", null);
    }

}
