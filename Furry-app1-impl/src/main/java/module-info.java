module com.example.furryapp1impl {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.furryapp1impl to javafx.fxml;
    exports com.example.furryapp1impl;
}