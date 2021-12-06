/** gestion de sur un 'AIR DE JAVA'
 *  Base de donnees MYSQL
 *  Auteur Pascal Haas CDA 2021-2022
 *  FIchier classe
 *  Novembre 2021
 */
package fr.pascal.library.entity;

public class Pays {
    /**
     * Variables
     */
    private int _id;
    private String _nomPays;

/**
 * Constructeurs
 * @param _id
 * @param _nomPays
 */
    public Pays(int _id, String _nomPays) {
        this._id = _id;
        this._nomPays = _nomPays;
    }


    public Pays() {
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
     * @return String return the _nomPays
     */
    public String get_nomPays() {
        return _nomPays;
    }

    /**
     * @param _nomPays the _nomPays to set
     */
    public void set_nomPays(String _nomPays) {
        this._nomPays = _nomPays;
    }

}