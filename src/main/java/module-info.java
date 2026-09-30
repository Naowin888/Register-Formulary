module org.example.registerformulary {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.registerformulary to javafx.fxml;
    exports org.example.registerformulary;
}