module com.gvlocke.weatherapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires org.apache.httpcomponents.httpclient;
    requires org.apache.httpcomponents.httpcore;
    requires org.jetbrains.annotations;
    requires com.google.gson;

    opens com.gvlocke.weatherapp to javafx.fxml;
    exports com.gvlocke.weatherapp;
}