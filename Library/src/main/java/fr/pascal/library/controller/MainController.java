package fr.pascal.library.controller;

// import fr.pascal.library.entity.Book;
import fr.pascal.library.entity.Rencontre;
import fr.pascal.library.entity.Titre;
import fr.pascal.library.entity.Est_programmee;
import fr.pascal.library.entity.Groupe;
import fr.pascal.library.utils.DataBaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.Date;
import com.mysql.cj.jdbc.CallableStatement;

import java.util.LinkedList;

public class MainController implements Initializable {

    @FXML
    private Button btnInsert, btnUpdate, btnDelete;
    @FXML
    private TextField tfId, tfTitle, tfAuthor, tfYear, tfPages;
    // @FXML private TableView<Book> tvBooks;
    @FXML
    private TableView<Rencontre> tvRencontre;
    @FXML
    private TableView<Groupe> tvGroupe;
    @FXML
    private TableView<Est_programmee> tvRencontreLieuEtGroupe;
    @FXML
    private TableColumn<Groupe, String> colDenominationGroupe;
    @FXML
    private TableColumn<Rencontre, Integer> colId;
    @FXML
    private TableColumn<Rencontre, String> colNomRencontre, colLieu, colPeriodicite;
    @FXML
    private ComboBox<String> cbTitre;
      @FXML
    private ComboBox<String> cbGroupeAvantRencontre;
     @FXML
    private ComboBox<String> cbTitreAvantGroupe;
    @FXML
    private TableColumn<Groupe, String> colNomGroupe;
   

    @FXML
    private TableColumn<Est_programmee, Date> colDateDebut;
    @FXML
    private TableColumn<Est_programmee, Date> colDateFin;
    @FXML
    private TableColumn<Est_programmee, String> colLieuPresta;
    @FXML
    private TableColumn<Est_programmee, String> colLieuRencontre;


    ObservableList<Titre> nomTitreList = FXCollections.observableArrayList();
    ObservableList<Groupe> nomGroupeList = FXCollections.observableArrayList();
    ObservableList<Est_programmee> nomRencontreTitreEtGroupeList = FXCollections.observableArrayList();

    @FXML
    void handleButtonAction(ActionEvent event) throws SQLException {
        if (event.getSource() == btnInsert) {
            // insertBook();
        } else if (event.getSource() == btnUpdate) {
            // updateBook();
        } else if (event.getSource() == btnDelete) {
            // deleteBook();
        }
    }

    // @FXML
    // void handleMouseAction() {
    // // Permet de récupérer les propriétés de l'item cliqué dans le TazbleView
    // Book book = tvBooks.getSelectionModel().getSelectedItem();
    // // On lie au clic l'objet book avec les TextField
    // tfId.setText(String.valueOf(book.getId()));
    // tfTitle.setText(book.getTitle());
    // tfAuthor.setText(book.getAuthor());
    // tfYear.setText(String.valueOf(book.getYear()));
    // tfPages.setText(String.valueOf(book.getPages()));
    // }
    @FXML
    void handleMouseAction() {
        // Permet de récupérer les propriétés de l'item cliqué dans le TableView
        Rencontre rencontre = tvRencontre.getSelectionModel().getSelectedItem();
        // On lie au clic l'objet book avec les TextField
        tfId.setText(String.valueOf(rencontre.get_id()));
        tfTitle.setText(rencontre.get_nomRencontre());

    }

    /* OUverture tableview rencontre et lancement de la requete stockée */
    /**
     * 
     * @return rencontreList
     */

    private ObservableList<Rencontre> getRencontreList() {
        ObservableList<Rencontre> rencontreList = FXCollections.observableArrayList();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = dataBaseConnection.getConnection();
        String query = "SELECT * FROM rencontre";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Rencontre rencontre = new Rencontre(rs.getInt("id_rencontre"), rs.getString("nom_rencontre"),
                        rs.getString("lieu_rencontre"), rs.getString("periodicite_rencontre"));
                rencontreList.add(rencontre);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur dans le SELECT Rencontre");
        }
        return rencontreList;
    }

    /**
     * Remplissage tableview Rencontre
     */
    private void displayTableViewRencontre() {
        ObservableList<Rencontre> listRencontre = getRencontreList();
        // On fait correspondre chacune des propriétés de l'objet rencontre avec chacune
        // des colonnes du TableView

        colId.setCellValueFactory(new PropertyValueFactory<Rencontre, Integer>("_id"));
        colNomRencontre.setCellValueFactory(new PropertyValueFactory<Rencontre, String>("_nomRencontre"));
        colLieu.setCellValueFactory(new PropertyValueFactory<Rencontre, String>("_lieuRencontre"));
        colPeriodicite.setCellValueFactory(new PropertyValueFactory<Rencontre, String>("_periodiciteRencontre"));
        tvRencontre.setItems(listRencontre);

    }

    // Méthodes de remplissages de comboBox cdTitre avec tous les titres de
    // repertoire
    private void RemplissageComboBoxTitre() {

        LinkedList<String> combo = new LinkedList<>();

        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = dataBaseConnection.getConnection();

        String query = "call affichageTitre";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {

                combo.add(rs.getString("nomTitre"));
            }
            cbTitre.getItems().addAll(combo);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERREUR DANS LA REQUETE Titre");
        }
    }

    // Remplissage de la tableView Groupe apres choix dans le combobox CbTitre
    @FXML
    private ObservableList<Groupe> RemplissageTvGroupe(ActionEvent event) throws SQLException {

        String res = cbTitre.getValue();
        System.out.println(res);

        nomGroupeList.clear();

        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = dataBaseConnection.getConnection();
        String query = "call quel_groupe_a_jouer_ce_titre(?)";
        // indispensable pour procedure stockee et fonctions
        CallableStatement cs = (CallableStatement) connection.prepareCall(query);

        cs.setString(1, res);// passage du titre à la procedure stockee
        cs.execute(); // execute la procedure
        try {
            ResultSet rs = cs.getResultSet();
            while (rs.next()) {
                Groupe NomGroupe = new Groupe();
                NomGroupe.set_DenominationGroupe(rs.getString("denomination_groupe"));
               
                nomGroupeList.add(NomGroupe);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur dans la requete nomGroupe");
        }
        connection.close();
        return nomGroupeList;
    }

    public void AffichageNomDesGroupes() {
        colNomGroupe.setCellValueFactory(new PropertyValueFactory<Groupe, String>("_DenominationGroupe"));
        tvGroupe.setItems(nomGroupeList);
    }

    // ==========================================================
    // Méthodes de remplissages de comboBox cdTitre avec tous les titres de
    // rencontre dans la table 'titre'
    private void RemplissageComboBoxTitreAvantGroupe() {

        LinkedList<String> combo = new LinkedList<>();

        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = dataBaseConnection.getConnection();

        // String query = "affichage_titres_repertoire";
        String query = "call affichageTitre";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {

                combo.add(rs.getString("nomTitre"));
            }
            cbTitreAvantGroupe.getItems().addAll(combo);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERREUR DANS LA REQUETE Repertoire pour comboTitreAvantGroupe ");
        }
    }
    
     // ==========================================================
    // Méthodes de remplissages de comboBox cbGroupe tous les noms des groupes 
    // dans la table groupe
 private void RemplissageComboBoxGroupeAvantRencontre() {

        LinkedList<String> combo = new LinkedList<>();

        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = dataBaseConnection.getConnection();

        // String query = "affichage_titres_repertoire";
         String query = "call affichage_groupes";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {

                combo.add(rs.getString("denomination_groupe"));
            }
            cbGroupeAvantRencontre.getItems().addAll(combo);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERREUR DANS LA REQUETE groupe comboGroupeAvantRencontre ");
        }
    }
    // Affichage de la tableViewREncontreLieuEtGroupe
    // @FXML
    // private ObservableList<Est_programmee> RemplissagetvRencontreLieuEtGroupe(ActionEvent event) throws SQLException {
    //     String res = cbGroupeAvantRencontre.getValue();

    //     nomRencontreTitreEtGroupeList.clear();

    //     DataBaseConnection dataBaseConnection = new DataBaseConnection();
    //     Connection connection = dataBaseConnection.getConnection();
    //     String query = "call ou_et_qui_a_interprete_ce_titre(?)";
    //     // indispensable pour procedure stockee et fonctions
    //     CallableStatement cs = (CallableStatement) connection.prepareCall(query);

    //     cs.setString(1, res);// passage du titre à la procedure stockee
    //     cs.execute(); // execute la procedure
    //     try {
    //         ResultSet rs = cs.getResultSet();
    //         while (rs.next()) {
    //            Est_programmee ligneGroupeLieu = new Est_programmee();
    //            ligneGroupeLieu.set_lieuPresentation("_lieuPresentation");
    //            System.out.println(rs);
    //             // ligneGroupeLieu.set_dateDebut(2021-10-04);
    //         //    ligneGroupeLieu.set_dateFin("_dateFin");
               
                                       
    //            nomRencontreTitreEtGroupeList.add(ligneGroupeLieu);
                 
    //         }
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         System.out.println("Erreur dans la requete ou_et_qui_a_interprete_ce_titre");
    //     }
    //     connection.close();
    //     return nomRencontreTitreEtGroupeList;
    // }

    // public void AffichageChampsRencontreEtGroupe() {
    //     colLieuPresta.setCellValueFactory(new PropertyValueFactory<Est_programmee, String>("_lieuPresentation"));
    //     tvRencontreLieuEtGroupe.setItems(nomRencontreTitreEtGroupeList);
    // }

    // fin

    // private void insertBook() throws SQLException {
    // String query = "INSERT INTO book VALUES ('" + tfId.getText() + "', '" +
    // tfTitle.getText() + "', '"
    // + tfAuthor.getText() + "', '" + tfYear.getText() + "', '" + tfPages.getText()
    // + "');";
    // executeQuery(query);
    // displayTableView();
    // }

    // private void deleteBook() throws SQLException {
    // String query = "DELETE FROM book WHERE id = '" + tfId.getText() + "'";
    // executeQuery(query);
    // displayTableView();
    // }

    // private void updateBook() throws SQLException {
    // String query = "UPDATE book SET title = '" + tfTitle.getText() + "', author =
    // '" + tfAuthor.getText()
    // + "', year = '" + tfYear.getText() + "', pages = '" + tfPages.getText() + "'
    // WHERE id = '"
    // + tfId.getText() + "';";
    // executeQuery(query);
    // displayTableView();
    // }

    // Méthode qui permet de factoriser la connection à la BDD, en même temps que
    // d'exécuter nos requêtes
    // private void executeQuery(String query) throws SQLException {
    // DataBaseConnection dataBaseConnection = new DataBaseConnection();
    // Connection connection = dataBaseConnection.getConnection();
    // try {
    // Statement statement = connection.createStatement();
    // statement.executeUpdate(query);
    // } catch (Exception e) {
    // e.printStackTrace();
    // System.out.println("Erreur SQL");
    // }
    // connection.close();
    // }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // getRencontreList();
        displayTableViewRencontre();
        RemplissageComboBoxTitre();
        RemplissageComboBoxTitreAvantGroupe();
        RemplissageComboBoxGroupeAvantRencontre();
        AffichageNomDesGroupes();
    }
}
