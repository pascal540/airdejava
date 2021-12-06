/** gestion de sur un 'AIR DE JAVA'
 *  Base de donnees MYSQL
 *  Auteur Pascal Haas CDA 2021-2022
 *  FIchier MainController.java
 *  Novembre 2021
 */
package fr.pascal.library.controller;

import fr.pascal.library.entity.Rencontre;

import fr.pascal.library.entity.Titre;
import fr.pascal.library.entity.Est_programmee;
import fr.pascal.library.entity.Groupe;
 
import fr.pascal.library.entity.Membre;
import fr.pascal.library.entity.Planning;
 
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
import javafx.scene.control.Spinner; 
import javafx.scene.control.cell.PropertyValueFactory;

// import java.lang.reflect.Member;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ResourceBundle;
import java.util.Date;
import com.mysql.cj.jdbc.CallableStatement;

import java.util.LinkedList;

public class MainController implements Initializable {

    @FXML
    private Button btnInsert, btnUpdate, btnDelete;
    @FXML
    private TextField tfNomInstrument, tfTitreAjoute,tfDureeAjoute;
    // @FXML private TableView<Book> tvBooks;
    @FXML
    private TableView<Rencontre> tvRencontre;
    @FXML
    private TableView<Groupe> tvGroupe;
    // @FXML
    // private TableView<Est_programmee> tvRencontreLieuEtGroupe;1
   @FXML
   private TableView<Rencontre> tvRencontreTitreEtGroupe;
    
    @FXML
    private TableColumn<Groupe, String> colDenominationGroupe;
    @FXML
    private TableColumn<Rencontre, Integer> colId;
    @FXML
    private TableColumn<Rencontre, String> colNomRencontre, colLieu, colPeriodicite; 
    @FXML
    private TableColumn<Rencontre, String> ColRencontre; // pour requete titre et groupe

    
    @FXML
    private ComboBox<String> cbTitre;
      @FXML
    private ComboBox<String> cbGroupeAvantRencontre;
     @FXML
    private ComboBox<String> cbTitreAvantGroupe;
    @FXML
    private TableColumn<Groupe, String> colNomGroupe;

    // requete 3 et Tvmembre
     @FXML
    private TableColumn<Membre, String> colMembre;
    @FXML
    private TableView<Membre> tvMembreRencontreSpecialite;
    @FXML
    private ComboBox<String> CbRencontrAvSpecialite;

    @FXML
    private ComboBox<String> CbSpecialiteAvantMembre;
    @FXML
    private TableColumn<Membre, String> colNomMembre,colPrenomMembre;


    @FXML
    private TableColumn<Est_programmee, Date> colDateDebut;
    @FXML
    private TableColumn<Est_programmee, Date> colDateFin;
    @FXML
    private TableColumn<Est_programmee, String> colLieuPresta;
    @FXML
    private TableColumn<Est_programmee, String> colLieuRencontre;

    // Partie recherche titre dans pays ou region d'une certaine durée
    @FXML
    private ComboBox<String> cbPays;

    @FXML
    private ComboBox<String> cbRegion;

    @FXML
    private TableView<Titre> TvTitreEtDuree;

    @FXML
    private TableColumn<Titre, String> colTitre;
     @FXML
    private TableColumn<Titre, Integer> colDuree;
     
    @FXML
    private Spinner<Integer> spDureeTitre;

    // partie recherche rencontre suivant X groupes
    @FXML
    private Button btChercheRencontreXGroupeJoue;
    @FXML
    private Spinner<Integer> spNbGroupe;
   
    // partie recherche rencontre avec tel instrument  utilisé ?
    @FXML
    private ComboBox<String> cbInstrument;
   
    @FXML
    private TableView<Rencontre> tvRencontreInstrument;
    @FXML
    private TableColumn<Rencontre, String> colNomRencontreInstrument;

    // partie cherche planning suivant lieu rencontre et groupe
    @FXML
    private TableView<Planning> tvPlanningRencontre;
    @FXML
    private ComboBox<String> cbLieuRencontre;
    @FXML
    private ComboBox<String> cbGroupeRencontre;
     @FXML
    private TableColumn<Planning, Date> colDate;

    @FXML
    private TableColumn< Planning, Time> colDebut;
    
    @FXML
    private TableColumn<Planning, Time> colFin;
    @FXML
    private TableColumn<Planning, String> colRencontrePlanning;

     @FXML
    private ComboBox<String> cbInstrumentCrud;
     @FXML
    private ComboBox<String> cbTitreaSupprimer;

    ObservableList<Titre> nomTitreList = FXCollections.observableArrayList();
    ObservableList<Groupe> nomGroupeList = FXCollections.observableArrayList();
    ObservableList<Rencontre> nomRencontreList = FXCollections.observableArrayList();
    ObservableList<Membre> nomMembreList = FXCollections.observableArrayList();
    ObservableList<Titre> nomTitreEtDuree = FXCollections.observableArrayList();
    ObservableList<Rencontre> nomRencontreSuivantNbGroupesList = FXCollections.observableArrayList();
    ObservableList<Rencontre> nomRencontreAvecInstrumentList  = FXCollections.observableArrayList();
    ObservableList<Planning> nomPlanningList = FXCollections.observableArrayList();
 
 
    @FXML
    void handleButtonAction(ActionEvent event) throws SQLException {
        if (event.getSource() == btnInsert) {
            insertTitre();
        } else if (event.getSource() == btnUpdate) {
             updateInstrument();
        } else if (event.getSource() == btnDelete) {
             deleteTitre();
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
        // et de lafficher ans le textefield correspondant
        // Rencontre rencontre = tvRencontre.getSelectionModel().getSelectedItem();
        // On lie au clic l'objet book avec les TextField
        // tfId.setText(String.valueOf(rencontre.get_id()));
        // tfTitle.setText(rencontre.get_nomRencontre());

    }

    /* OUverture tableview rencontre et lancement de la requete stockée */
    /**
     * 
     * @return rencontreList
     */

     
    /**
     * Remplissage tableview Rencontre  
     */
//     private void displayTableViewRencontre() {
//       ObservableList<Rencontre> listRencontre = getRencontreList();
//         // On fait correspondre chacune des propriétés de l'objet rencontre avec chacune
//         // des colonnes du TableView

//          colId.setCellValueFactory(new PropertyValueFactory<Rencontre, Integer>("_id"));
//          colNomRencontre.setCellValueFactory(new PropertyValueFactory<Rencontre, String>("_nomRencontre"));
//          colLieu.setCellValueFactory(new PropertyValueFactory<Rencontre, String>("_lieuRencontre"));
//         colPeriodicite.setCellValueFactory(new PropertyValueFactory<Rencontre, String>("_periodiciteRencontre"));
//         tvRencontre.setItems(listRencontre);

//  }

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
             cbTitreaSupprimer.getItems().addAll(combo);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERREUR DANS LA REQUETE Titre");
        }
    }

    // Remplissage de la tableView Groupe apres choix dans le combobox CbTitre
    @FXML
    private ObservableList<Groupe> RemplissageTvGroupe(ActionEvent event) throws SQLException {

        String res = cbTitre.getValue();
        // System.out.println(res);

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
            cbGroupeRencontre.getItems().addAll(combo); // pour la requete planning
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERREUR DANS LA REQUETE groupe comboGroupeAvantRencontre ");
        }
    }
    // Affichage de la tableViewREncontreLieuEtGroupe
     @FXML
     private ObservableList<Rencontre> RemplissageRencontreAPresChoixTitreEtGroupe( ActionEvent event) throws SQLException
      {
         String res = cbTitreAvantGroupe.getValue();
         String res2 = cbGroupeAvantRencontre.getValue();
        nomRencontreList.clear();
    //   System.out.println(res);
    //    System.out.println(res2);
          DataBaseConnection dataBaseConnection = new DataBaseConnection();
         Connection connection = dataBaseConnection.getConnection();
         String query = "call rencontre_avec_titre_groupe(?,?)";
         // indispensable pour procedure stockee et fonctions
         CallableStatement cs = (CallableStatement) connection.prepareCall(query);

         cs.setString(1, res);// passage du titre à la procedure stockee
          cs.setString(2, res2);// passage du groupe à la procedure stockee
    
         cs.execute(); // execute la procedure
         try {
             ResultSet rs = cs.getResultSet();
             while (rs.next()) {
                Rencontre ligneRencontre = new Rencontre();
                ligneRencontre.set_nomRencontre(rs.getString("NOM_RENCONTRE"));
                // System.out.println(rs);
                                                   
               nomRencontreList.add(ligneRencontre);
                 
             }
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println("Erreur dans la requete ou_et_qui_a_interprete_ce_titre");
         }
         connection.close();
         return nomRencontreList;
     }

     public void AffichageNomDesRencontres() {
         ColRencontre.setCellValueFactory(new PropertyValueFactory<Rencontre, String>("_nomRencontre"));
         tvRencontreTitreEtGroupe.setItems(nomRencontreList);
     }

     private void RemplissageComboBoxRencontre() {

         LinkedList<String> combo = new LinkedList<>();

         DataBaseConnection dataBaseConnection = new DataBaseConnection();
         Connection connection = dataBaseConnection.getConnection();

         String query = "call afficheRencontre";

         try {
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query);
             while (rs.next()) {

                 combo.add(rs.getString("nom_rencontre"));
             }
             CbRencontrAvSpecialite.getItems().addAll(combo);
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println("ERREUR DANS LA REQUETE Rencontre");
         }
     }

     private void RemplissageComboBoxSpecialite() {

         LinkedList<String> combo = new LinkedList<>();

         DataBaseConnection dataBaseConnection = new DataBaseConnection();
         Connection connection = dataBaseConnection.getConnection();

         String query = "call afficheSpecialite";

         try {
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query);
             while (rs.next()) {

                 combo.add(rs.getString("type_specialite"));
             }
             CbSpecialiteAvantMembre.getItems().addAll(combo);
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println("ERREUR DANS LA REQUETE Specialite");
         }
     }

      @FXML
     private ObservableList<Membre> RemplissageMembreApresRencontreEtSpecialite( ActionEvent event) throws SQLException
     {
         String res = CbRencontrAvSpecialite.getValue();
         String res2 = CbSpecialiteAvantMembre.getValue();
          nomMembreList.clear();
         //   System.out.println(res);
         //    System.out.println(res2);
         DataBaseConnection dataBaseConnection = new DataBaseConnection();
         Connection connection = dataBaseConnection.getConnection();
         String query = "call quelle_membre_a_specialite(?,?)";
         // indispensable pour procedure stockee et fonctions
         CallableStatement cs = (CallableStatement) connection.prepareCall(query);

         cs.setString(1, res);// passage du titre à la procedure stockee
         cs.setString(2, res2);// passage du groupe à la procedure stockee

         cs.execute(); // execute la procedure
         try {
             ResultSet rs = cs.getResultSet();
             while (rs.next()) {
                 Membre ligneMembre = new Membre();
                 ligneMembre.set_nomMembre(rs.getString("nom_membre"));
                 ligneMembre.set_prenomMembre(rs.getString("prenom_membre"));
                //   System.out.println(rs);

                nomMembreList.add(ligneMembre);

             }
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println("Erreur dans la requete quelle_membre_a_specialite");
         }
         connection.close();
         return nomMembreList;
     }
      public void AffichageNomDesMembres() {
          colNomMembre.setCellValueFactory(new PropertyValueFactory<Membre, String>("_nomMembre"));
          colPrenomMembre.setCellValueFactory(new PropertyValueFactory<Membre, String>("_prenomMembre"));
         tvMembreRencontreSpecialite.setItems(nomMembreList);
     }

     // Partie durée d'un titre entré et pays ou region et affichage titre et durée
    private void RemplissageComboBoxPays() {

        LinkedList<String> combo = new LinkedList<>();

        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = dataBaseConnection.getConnection();

        String query = "call affichagePays";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {

                combo.add(rs.getString("nom_Pays"));
            }
            cbPays.getItems().addAll(combo);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERREUR DANS LA REQUETE Pays");
        }
    }

    private void RemplissageComboBoxRegion() {

        LinkedList<String> combo = new LinkedList<>();

        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = dataBaseConnection.getConnection();

        String query = "call affichageRegion";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {

                combo.add(rs.getString("nom_Region"));
            }
            cbRegion.getItems().addAll(combo);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERREUR DANS LA REQUETE Region");
        }
    }
    
    @FXML
     private ObservableList<Titre> RemplissageTitreApresChoixPaysRegion( ActionEvent event) throws SQLException
     {
         Integer res = spDureeTitre.getValue();
         String res2 = cbPays.getValue();
         String res3 = cbRegion.getValue();
        nomTitreEtDuree.clear();
     
          DataBaseConnection dataBaseConnection = new DataBaseConnection();
         Connection connection = dataBaseConnection.getConnection();
         String query = "call quelTitrePaysRegion(?,?,?)";
         // indispensable pour procedure stockee et fonctions
         CallableStatement cs = (CallableStatement) connection.prepareCall(query);
            cs.setInt(1, res); //duree
         cs.setString(2, res2);// pays
          cs.setString(3, res3);// region
        //   System.out.println(res);
        //   System.out.println(res2);
        //   System.out.println(res3);
         cs.execute(); // execute la procedure
         try {
             ResultSet rs = cs.getResultSet();
             while (rs.next()) {
                // System.out.println(rs);
                Titre ligneTitre = new Titre();
                ligneTitre.set_nomTitre(rs.getString("nomTitre"));
                ligneTitre.set_duree(rs.getInt("duree"));
                //  System.out.println( ligneTitre.get_nomTitre());
                                                   
               nomTitreEtDuree.add(ligneTitre);
                 
             }
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println("Erreur dans la requete quelTitrePaysRegion");
         }
         connection.close();
         return nomTitreEtDuree;
     }

     public void AffichageTitreEtDuree() {
         colTitre.setCellValueFactory(new PropertyValueFactory<Titre, String>("_nomTitre"));
         colDuree.setCellValueFactory(new PropertyValueFactory<Titre, Integer>("_duree"));
         TvTitreEtDuree.setItems(nomTitreEtDuree);
     }

     // Affichage des rencontres ou 'N' groupes ont joues 
    @FXML
     private ObservableList<Rencontre> RemplissageRencontreSuivantLesGroupes( ActionEvent event) throws SQLException
     {
         Integer res = spNbGroupe.getValue();
         
        nomRencontreSuivantNbGroupesList.clear();
     
          DataBaseConnection dataBaseConnection = new DataBaseConnection();
         Connection connection = dataBaseConnection.getConnection();
         String query = "call rencontre_avec_n_groupe(?)";
         // indispensable pour procedure stockee et fonctions
         CallableStatement cs = (CallableStatement) connection.prepareCall(query);
         cs.setInt(1, res); //nbGroupes           
         cs.execute();  
         try {
             ResultSet rs = cs.getResultSet();
             while (rs.next()) {
                // System.out.println(rs);
                Rencontre ligneRencontre = new Rencontre();
                ligneRencontre.set_nomRencontre(rs.getString("nom_rencontre"));                                                               
                nomRencontreSuivantNbGroupesList.add(ligneRencontre);
                 
             }
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println("Erreur dans la requete rencontre_avec_n_groupe");
         }
         connection.close();
         return  nomRencontreSuivantNbGroupesList;
     }

     public void AffichageRencontreNGroupes() {
         colNomRencontre.setCellValueFactory(new PropertyValueFactory<Rencontre, String>("_nomRencontre"));
         tvRencontre.setItems(nomRencontreSuivantNbGroupesList);
     }

     // Affichage des rencontres ou tel instruent est joue 
     private void RemplissageComboBoxInstrument() {

         LinkedList<String> combo = new LinkedList<>();

         DataBaseConnection dataBaseConnection = new DataBaseConnection();
         Connection connection = dataBaseConnection.getConnection();

         String query = "call affichageInstrument";

         try {
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query);
             while (rs.next()) {

                 combo.add(rs.getString("nom_instrument"));
             }
             cbInstrument.getItems().addAll(combo);
              cbInstrumentCrud.getItems().addAll(combo);
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println("ERREUR DANS LA REQUETE affichageInstrument");
         }
     }
    
    @FXML
     private ObservableList<Rencontre> RemplissageRencontreAvecInstrument( ActionEvent event) throws SQLException
     {
         String res = cbInstrument.getValue();
         
       nomRencontreAvecInstrumentList.clear();
     
          DataBaseConnection dataBaseConnection = new DataBaseConnection();
         Connection connection = dataBaseConnection.getConnection();
         String query = "call rencontre_quel_instrument(?)";
         // indispensable pour procedure stockee et fonctions
         CallableStatement cs = (CallableStatement) connection.prepareCall(query);
         cs.setString(1, res); //nbGroupes           
         cs.execute();  
         try {
             ResultSet rs = cs.getResultSet();
             while (rs.next()) {
                // System.out.println(rs);
                Rencontre ligneRencontre = new Rencontre();
                ligneRencontre.set_nomRencontre(rs.getString("nom_rencontre"));                                                               
                nomRencontreAvecInstrumentList.add(ligneRencontre);
                 
             }
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println("Erreur dans la requete rencontre_quel_instrument");
         }
         connection.close();
         return  nomRencontreAvecInstrumentList;
     }
 public void AffichageRencontreInstrument() {
        colNomRencontreInstrument.setCellValueFactory(new PropertyValueFactory<Rencontre, String>("_nomRencontre"));
         tvRencontreInstrument.setItems(nomRencontreAvecInstrumentList);
     }

     // partie affichage planning suivant lieu de rencontre et groupe
     // Méthodes de remplissages de comboBox lieu rencontre et groupe : groupe est deja rempli
     
    private void RemplissageComboBoxLieuRencontre() {

        LinkedList<String> combo = new LinkedList<>();

        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = dataBaseConnection.getConnection();

        String query = "call affichageLieuRencontre";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {

                combo.add(rs.getString("lieu_rencontre"));
            }
            cbLieuRencontre.getItems().addAll(combo);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERREUR DANS LA REQUETE affichageLieuRencontre");
        }
    }
     
@FXML
     private ObservableList<Planning> RemplissagePlanning( ActionEvent event) throws SQLException
     {
         String res = cbLieuRencontre.getValue();
         String res2 = cbGroupeRencontre.getValue();
        // System.out.println(res);
        // System.out.println(res2);
         nomPlanningList.clear();
         DataBaseConnection dataBaseConnection = new DataBaseConnection();
         Connection connection = dataBaseConnection.getConnection();
         String query = "call planning_rencontre_lieu_groupe(?,?)";
         // indispensable pour procedure stockee et fonctions
         CallableStatement cs = (CallableStatement) connection.prepareCall(query);
         cs.setString(1, res); //lieu de la rencontre du combo
         cs.setString(2, res2); //nom du groupe du combo
         cs.execute();
         try {
             ResultSet rs = cs.getResultSet();
             while (rs.next()) {
                 Planning lignePlanning = new Planning();
                 lignePlanning.set_nomRencontre(rs.getString("nom_rencontre"));
               
                 lignePlanning.set_heureDebut(rs.getTime("heure_debut_presentation"));
                 lignePlanning.set_heureFin(rs.getTime("heure_fin_presentation"));
                 lignePlanning.set_datePassageGroupe(rs.getDate("date_passage_groupe"));
                 
                 nomPlanningList.add(lignePlanning);

             }
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println("Erreur dans la requete planning_rencontre_lieu_groupe");
         }
         connection.close();
         return nomPlanningList;
     }

     public void AffichagePlanning() {
         // les champs correspondent aux champs de la classe Planning 
         colDebut.setCellValueFactory(new PropertyValueFactory<Planning, Time>("_heureDebut"));
         colFin.setCellValueFactory(new PropertyValueFactory<Planning, Time>("_heureFin"));
         colDate.setCellValueFactory(new PropertyValueFactory<Planning, Date>("_datePassageGroupe"));
         colRencontrePlanning.setCellValueFactory(new PropertyValueFactory<Planning, String>("_nomRencontre"));

         tvPlanningRencontre.setItems(nomPlanningList);
     }
    

    private void deleteTitre() throws SQLException {
      String query = "DELETE FROM titre WHERE nomTitre = '" + cbTitreaSupprimer.getValue() + "'";
      executeQuery(query);
    // displayTableView();
    //
     }

    private void updateInstrument() throws SQLException {
    //   System.out.println(cbInstrumentCrud);
    //   System.out.println(tfNomInstrument.getText());
      String query ="UPDATE instrument SET nom_instrument= '"+ tfNomInstrument.getText() +"'"+
              " where nom_instrument ='" + cbInstrumentCrud.getValue()+"'";
    //   System.out.println( query);
      executeQuery(query);
    //    displayTableView();
    //  
    }

    private void  insertTitre() throws SQLException {
        String query = "INSERT INTO titre ("+ "idtitre" +"," +"nomTitre"+"," +"duree" +")"
                + " VALUES" + " (" + "null" + "," +"'"+ tfTitreAjoute.getText()+"'" + "," +tfDureeAjoute.getText() + ")";
        //  System.out.println(query);          
         executeQuery(query);               
    }
    
    /* Méthode qui permet de factoriser la connection à la BDD, en même temps que
     d'exécuter nos requêtes*/

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
        
        //displayTableViewRencontre();
        RemplissageComboBoxTitre();
        RemplissageComboBoxTitreAvantGroupe();
        RemplissageComboBoxGroupeAvantRencontre();
        RemplissageComboBoxInstrument();
        AffichageNomDesGroupes();
        AffichageNomDesRencontres();
        RemplissageComboBoxRencontre();
        RemplissageComboBoxSpecialite();
        AffichageNomDesMembres();
        RemplissageComboBoxPays();
        RemplissageComboBoxRegion();
        AffichageTitreEtDuree();
        AffichageRencontreNGroupes();
        AffichageRencontreInstrument();
        RemplissageComboBoxLieuRencontre();
        AffichagePlanning();

    }
}
