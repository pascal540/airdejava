 package fr.pascal.library.entity;

 public class Specialite {
    
    /**
     * Variables
     */
     private int _id;
     private String _typeSpecialite;

    /** Constructeur s
     * 
     * @param _id
     * @param _typeSpecialite
     */
    public Specialite(int _id, String _typeSpecialite) {
        this._id = _id;
        this._typeSpecialite = _typeSpecialite;
    }

    public Specialite() {
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
     * @return String return the _typeSpecialite
     */
    public String get_typeSpecialite() {
        return _typeSpecialite;
    }

    /**
     * @param _typeSpecialite the _typeSpecialite to set
     */
    public void set_typeSpecialite(String _typeSpecialite) {
        this._typeSpecialite = _typeSpecialite;
    }

}