package fr.pascal.library.entity;


public class Titre {

    /*
    Variables 
    */

    private int _id;
    private String _nomTitre;
    private int _duree;
    
    /*
    Constructeurs
    */
    public Titre (int id,String nomTitre,int duree)
    {
        this._id = id;
        this._nomTitre = nomTitre;
        this._duree = duree;
    }

    public Titre() {

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
     * @return String return the _nomTitre
     */
    public String get_nomTitre() {
        return _nomTitre;
    }

    /**
     * @param _nomTitre the _nomTitre to set
     */
    public void set_nomTitre(String _nomTitre) {
        this._nomTitre = _nomTitre;
    }

    /**
     * @return int return the _duree
     */
    public int get_duree() {
        return _duree;
    }

    /**
     * @param _duree the _duree to set
     */
    public void set_duree(int _duree) {
        this._duree = _duree;
    }

}