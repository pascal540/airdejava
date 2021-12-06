/** gestion de sur un 'AIR DE JAVA'
 *  Base de donnees MYSQL
 *  Auteur Pascal Haas CDA 2021-2022
 *  FIchier classe
 *  Novembre 2021
 */
package fr.pascal.library.entity;


import java.util.Date;

public class Repertoire {

/**
 * Variables
 */
    private int _id;
    private int _idGroupe;
    private Date _dateApparitionTitre;
    private String _nomAuteurRepertoire;
    private String _prenomAuteurRepertoire;

/**
 * Constructeur
 * @param _id
 * @param _idGroupe
 * @param _titreRepertoire
 * @param _dateApparitionTitre
 * @param _nomAuteurRepertoire
 * @param _prenomAuteurRepertoire
 */
    public Repertoire(int _id, int _idGroupe,  Date _dateApparitionTitre, String _nomAuteurRepertoire, String _prenomAuteurRepertoire) {
        this._id = _id;
        this._idGroupe = _idGroupe;
        this._dateApparitionTitre = _dateApparitionTitre;
        this._nomAuteurRepertoire = _nomAuteurRepertoire;
        this._prenomAuteurRepertoire = _prenomAuteurRepertoire;
    }

    public Repertoire() {

    }
   
    

    /**
     * @return int return the _id
     */
    public int get_id() {
        return _id;
    }

    /**
     * @param _id the _id to set
     */
    public void set_id(int _id) {
        this._id = _id;
    }

    /**
     * @return int return the _idGroupe
     */
    public int get_idGroupe() {
        return _idGroupe;
    }

    /**
     * @param _idGroupe the _idGroupe to set
     */
    public void set_idGroupe(int _idGroupe) {
        this._idGroupe = _idGroupe;
    }

    
    /**
     * @return Date return the _dateApparitionTitre
     */
    public Date get_dateApparitionTitre() {
        return _dateApparitionTitre;
    }

    /**
     * @param _dateApparitionTitre the _dateApparitionTitre to set
     */
    public void set_dateApparitionTitre(Date _dateApparitionTitre) {
        this._dateApparitionTitre = _dateApparitionTitre;
    }

    /**
     * @return String return the _nomAuteurRepertoire
     */
    public String get_nomAuteurRepertoire() {
        return _nomAuteurRepertoire;
    }

    /**
     * @param _nomAuteurRepertoire the _nomAuteurRepertoire to set
     */
    public void set_nomAuteurRepertoire(String _nomAuteurRepertoire) {
        this._nomAuteurRepertoire = _nomAuteurRepertoire;
    }

    /**
     * @return String return the _prenomAuteurRepertoire
     */
    public String get_prenomAuteurRepertoire() {
        return _prenomAuteurRepertoire;
    }

    /**
     * @param _prenomAuteurRepertoire the _prenomAuteurRepertoire to set
     */
    public void set_prenomAuteurRepertoire(String _prenomAuteurRepertoire) {
        this._prenomAuteurRepertoire = _prenomAuteurRepertoire;
    }

}