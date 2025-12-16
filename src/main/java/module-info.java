module com.example.calculadoradeimcvesp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.calculadoradeimcvesp to javafx.fxml;
    exports com.example.calculadoradeimcvesp;
}