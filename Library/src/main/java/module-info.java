/** gestion de sur un 'AIR DE JAVA'
 *  Base de donnees MYSQL
 *  Auteur Pascal Haas CDA 2021-2022
 *  FIchier modul-info.java
 *  Novembre 2021
 */
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