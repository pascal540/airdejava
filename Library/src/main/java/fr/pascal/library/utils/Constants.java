/** gestion de sur un 'AIR DE JAVA'
 *  Base de donnees MYSQL
 *  Auteur Pascal Haas CDA 2021-2022
 *  FIchier constantes.java
 *  Novembre 2021
 */

package fr.pascal.library.utils;

public interface Constants {
    String DB = "airjava";
    String USER = "root";
    String SOCKET = "3306";
    String PASSWORD = "";
    String URL = "jdbc:mysql://localhost:" + SOCKET + "/" + DB;
}
