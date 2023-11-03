module com.gvlocke.weatherapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.gvlocke.weatherapp to javafx.fxml;
    exports com.gvlocke.weatherapp;
}