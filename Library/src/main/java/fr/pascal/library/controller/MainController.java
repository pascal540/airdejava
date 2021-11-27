package fr.pascal.library.controller;

// import fr.pascal.library.entity.Book;
import fr.pascal.library.entity.Rencontre;
import fr.pascal.library.entity.Titre;
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
    private TableColumn<Rencontre, Integer> colId;
    @FXML
    private TableColumn<Rencontre, String> colNomRencontre, colLieu, colPeriodicite;
    @FXML
    private ComboBox<String> cbTitre;
    
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
    /*-------------------------------------------------------------------------------*/
    /* Remplissage table rencontre*/
    /*-------------------------------------------------------------------------------*/
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
            System.out.println("Erreur dans le SELECT *");
        }
        return rencontreList;
    }
    
    private void displayTableView() {
        ObservableList<Rencontre> listRencontre = getRencontreList();
        // On fait correspondre chacune des propriétés de l'objet rencontre avec chacune
        // des colonnes du TableView
        colId.setCellValueFactory(new PropertyValueFactory<Rencontre, Integer>("_id"));
        colNomRencontre.setCellValueFactory(new PropertyValueFactory<Rencontre, String>("_nomRencontre"));
        colLieu.setCellValueFactory(new PropertyValueFactory<Rencontre, String>("_lieuRencontre"));
        colPeriodicite.setCellValueFactory(new PropertyValueFactory<Rencontre, String>("_periodiciteRencontre"));
        tvRencontre.setItems(listRencontre);

    }
   // Méthodes de remplissages de comboBox cdTitre
    private void RemplissageComboBoxTitre() {

        LinkedList<String> combo = new LinkedList<>();

        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = dataBaseConnection.getConnection();

        String query = "call affichageTitre";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {

                combo.add(rs.getString("nom_titre"));
            }
            cbTitre.getItems().addAll(combo);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERREUR DANS LA REQUETE");
        }
    }

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
    private void executeQuery(String query) throws SQLException {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = dataBaseConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur SQL");
        }
        connection.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // getRencontreList();
        displayTableView();
        RemplissageComboBoxTitre();
    }
}
