module fr.pascal.library {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;

    opens fr.pascal.library.entity to javafx.base;
    opens fr.pascal.library to javafx.fxml;
    exports fr.pascal.library;
    exports fr.pascal.library.controller;
    opens fr.pascal.library.controller to javafx.fxml;
}