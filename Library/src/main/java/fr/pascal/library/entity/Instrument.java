  package fr.pascal.library.entity;

public class Instrument {
    

    /**
     * Variables
     */

    private int _id;
    private String _nomInstrument;
    private String _typeInstrument;

/**
 * Constructeur
 * @param _id
 * @param _nomInstrument
 * @param _typeInstrument
 */
    public Instrument(int _id, String _nomInstrument, String _typeInstrument) {
        this._id = _id;
        this._nomInstrument = _nomInstrument;
        this._typeInstrument = _typeInstrument;
    }

    public Instrument() {
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
     * @return String return the _nomInstrument
     */
    public String get_nomInstrument() {
        return _nomInstrument;
    }

    /**
     * @param _nomInstrument the _nomInstrument to set
     */
    public void set_nomInstrument(String _nomInstrument) {
        this._nomInstrument = _nomInstrument;
    }

    /**
     * @return String return the _typeInstrument
     */
    public String get_typeInstrument() {
        return _typeInstrument;
    }

    /**
     * @param _typeInstrument the _typeInstrument to set
     */
    public void set_typeInstrument(String _typeInstrument) {
        this._typeInstrument = _typeInstrument;
    }

}
    
