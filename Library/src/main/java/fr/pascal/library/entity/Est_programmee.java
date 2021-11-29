package fr.pascal.library.entity;

import java.sql.Time;
import java.sql.Date;

public class Est_programmee {

    /*
    Variables
    */

    private int _idRencontre;
    private int idGroupe;
    private Date _datePassageGroupe;
    private Time _dateDebut;
    private Time _dateFin;
    private String _lieuPresentation;
    private String _titrePresente;
    private String _tempsPrevu;

/**
 * ----------------------------------Constructeur--------------------------
 */

    public Est_programmee(int _idRencontre, int idGroupe, Date _datePassageGroupe, Time _dateDebut, Time _dateFin, String _lieuPresentation, String _titrePresente, String _tempsPrevu) {
        this._idRencontre = _idRencontre;
        this.idGroupe = idGroupe;
        this._datePassageGroupe = _datePassageGroupe;
        this._dateDebut = _dateDebut;
        this._dateFin = _dateFin;
        this._lieuPresentation = _lieuPresentation;
        this._titrePresente = _titrePresente;
        this._tempsPrevu = _tempsPrevu;
    }


    public Est_programmee() {
    }
    /*
    ---------------------------------------Accesseurs-------------------------------------
    */
    
    /**
     * @return int return the _idRencontre
     */
    public int get_idRencontre() {
        return _idRencontre;
    }

    /**
     * @param _idRencontre the _idRencontre to set
     */
    public void set_idRencontre(int _idRencontre) {
        this._idRencontre = _idRencontre;
    }

    /**
     * @return int return the idGroupe
     */
    public int getIdGroupe() {
        return idGroupe;
    }

    /**
     * @param idGroupe the idGroupe to set
     */
    public void setIdGroupe(int idGroupe) {
        this.idGroupe = idGroupe;
    }

    /**
     * @return Date return the _datePassageGroupe
     */
    public Date get_datePassageGroupe() {
        return _datePassageGroupe;
    }

    /**
     * @param _datePassageGroupe the _datePassageGroupe to set
     */
    public void set_datePassageGroupe(Date _datePassageGroupe) {
        this._datePassageGroupe = _datePassageGroupe;
    }

    /**
     * @return Time return the _dateDebut
     */
    public Time get_dateDebut() {
        return _dateDebut;
    }

    /**
     * @param _dateDebut the _dateDebut to set
     */
    public void set_dateDebut(Time _dateDebut) {
        this._dateDebut = _dateDebut;
    }

    /**
     * @return Time return the _dateFin
     */
    public Time get_dateFin() {
        return _dateFin;
    }

    /**
     * @param _dateFin the _dateFin to set
     */
    public void set_dateFin(Time _dateFin) {
        this._dateFin = _dateFin;
    }

    /**
     * @return String return the _lieuPresentation
     */
    public String get_lieuPresentation() {
        return _lieuPresentation;
    }

    /**
     * @param _lieuPresentation the _lieuPresentation to set
     */
    public void set_lieuPresentation(String _lieuPresentation) {
        this._lieuPresentation = _lieuPresentation;
    }

    /**
     * @return String return the _titrePresente
     */
    public String get_titrePresente() {
        return _titrePresente;
    }

    /**
     * @param _titrePresente the _titrePresente to set
     */
    public void set_titrePresente(String _titrePresente) {
        this._titrePresente = _titrePresente;
    }

    /**
     * @return String return the _tempsPrevu
     */
    public String get_tempsPrevu() {
        return _tempsPrevu;
    }

    /**
     * @param _tempsPrevu the _tempsPrevu to set
     */
    public void set_tempsPrevu(String _tempsPrevu) {
        this._tempsPrevu = _tempsPrevu;
    }

}