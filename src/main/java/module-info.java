module com.dam.di.calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.dam.di.calculator to javafx.fxml;
    exports com.dam.di.calculator;
}