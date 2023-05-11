module com.example.datetimedemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.datetimedemo to javafx.fxml;
    exports com.example.datetimedemo;
}