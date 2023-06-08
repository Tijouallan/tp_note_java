module com.example.tp_note_java {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tp_note_java to javafx.fxml;
    exports com.example.tp_note_java;
}