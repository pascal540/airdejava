 package fr.pascal.library.entity;

public class Region {

    /**
     * Variables
     */
    private int _id;
    private String _nomRegion;



    /**
     * Constructeurs
     * @param _id
     * @param _nomRegion
     */    public Region(int _id, String _nomRegion) {
            this._id = _id;
            this._nomRegion = _nomRegion;
    }

    public Region() {
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
     * @return String return the _nomRegion
     */
    public String get_nomRegion() {
        return _nomRegion;
    }

    /**
     * @param _nomRegion the _nomRegion to set
     */
    public void set_nomRegion(String _nomRegion) {
        this._nomRegion = _nomRegion;
    }

}