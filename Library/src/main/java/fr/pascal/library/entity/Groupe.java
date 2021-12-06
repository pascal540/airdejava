/** gestion de sur un 'AIR DE JAVA'
 *  Base de donnees MYSQL
 *  Auteur Pascal Haas CDA 2021-2022
 *  FIchier classe
 *  Novembre 2021
 */
package fr.pascal.library.entity;


public class Groupe {

    /*
    Variables 
    */

    private int _id;
    private int _idPays;
    private int _idCorrespondant;
    private int _idRegion;
    private String _DenominationGroupe;
    
    /*
    Constructeurs
    */

    public Groupe(int _id, int _idPays, int _idCorrespondant, int _idRegion, String _DenominationGroupe) {
        this._id = _id;
        this._idPays = _idPays;
        this._idCorrespondant = _idCorrespondant;
        this._idRegion = _idRegion;
        this._DenominationGroupe = _DenominationGroupe;
    }

    public Groupe(String _DenominationGroupe) {
        this._DenominationGroupe = _DenominationGroupe;
    }
    
    public Groupe() {
        
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
     * @return int return the _idPays
     */
    public int get_idPays() {
        return _idPays;
    }

    /**
     * @param _idPays the _idPays to set
     */
    public void set_idPays(int _idPays) {
        this._idPays = _idPays;
    }

    /**
     * @return int return the _idCorrespondant
     */
    public int get_idCorrespondant() {
        return _idCorrespondant;
    }

    /**
     * @param _idCorrespondant the _idCorrespondant to set
     */
    public void set_idCorrespondant(int _idCorrespondant) {
        this._idCorrespondant = _idCorrespondant;
    }

    /**
     * @return int return the _idRegion
     */
    public int get_idRegion() {
        return _idRegion;
    }

    /**
     * @param _idRegion the _idRegion to set
     */
    public void set_idRegion(int _idRegion) {
        this._idRegion = _idRegion;
    }

    /**
     * @return String return the _DenominationGroupe
     */
    public String get_DenominationGroupe() {
        return _DenominationGroupe;
    }

    /**
     * @param _DenominationGroupe the _DenominationGroupe to set
     */
    public void set_DenominationGroupe(String _DenominationGroupe) {
        this._DenominationGroupe = _DenominationGroupe;
    }

}