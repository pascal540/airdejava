 /** gestion de sur un 'AIR DE JAVA'
 *  Base de donnees MYSQL
 *  Auteur Pascal Haas CDA 2021-2022
 *  FIchier classe
 *  Novembre 2021
 */
 package fr.pascal.library.entity;

 public class Membre {


     /**
      * Variables 
      */
     private int _id;
     private int _idGroupe;
     private int _idCivilite;
     private String _nomMembre;
     private String _prenomMembre;


/**Constructeurs
 * 
 * @param _id
 * @param _idGroupe
 * @param _idCivilite
 * @param _nomMembre
 * @param _prenomMembre
 */
    public Membre(int _id, int _idGroupe, int _idCivilite, String _nomMembre, String _prenomMembre) {
        this._id = _id;
        this._idGroupe = _idGroupe;
        this._idCivilite = _idCivilite;
        this._nomMembre = _nomMembre;
        this._prenomMembre = _prenomMembre;
    }

    public Membre() {
    }

    /**
     * Accesseurs
     */
    

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
     * @return int return the _idCivilite
     */
    public int get_idCivilite() {
        return _idCivilite;
    }

    /**
     * @param _idCivilite the _idCivilite to set
     */
    public void set_idCivilite(int _idCivilite) {
        this._idCivilite = _idCivilite;
    }

    /**
     * @return String return the _nomMembre
     */
    public String get_nomMembre() {
        return _nomMembre;
    }

    /**
     * @param _nomMembre the _nomMembre to set
     */
    public void set_nomMembre(String _nomMembre) {
        this._nomMembre = _nomMembre;
    }

    /**
     * @return String return the _prenomMembre
     */
    public String get_prenomMembre() {
        return _prenomMembre;
    }

    /**
     * @param _prenomMembre the _prenomMembre to set
     */
    public void set_prenomMembre(String _prenomMembre) {
        this._prenomMembre = _prenomMembre;
    }

}