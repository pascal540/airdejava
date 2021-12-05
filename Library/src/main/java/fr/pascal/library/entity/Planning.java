package fr.pascal.library.entity;

import java.sql.Date;
import java.sql.Time;


public class Planning {

    /**
     * Variables
     */

    private String _lieuRencontre;
    private String _nomRencontre;
    private Time _heureDebut;
    private Time _heureFin;
    private String _lieuPresentation;
    private Date _datePassageGroupe;

/**
 * Constructeur
 * @param _lieuRencontre
 * @param _nomRencontre
 * @param _heureDebut
 * @param _heureFin
 * @param _lieuPresentation
 */
    public Planning(String _lieuRencontre, String _nomRencontre, Time _heureDebut, Time _heureFin, String _lieuPresentation, Date _datePassageGroupe) {
        this._lieuRencontre = _lieuRencontre;
        this._nomRencontre = _nomRencontre;
        this._heureDebut = _heureDebut;
        this._heureFin = _heureFin;
        this._lieuPresentation = _lieuPresentation;
        this._datePassageGroupe = _datePassageGroupe;
    }

    public Planning() {
    }


    /**
     * Accesseurs
     */

    public String get_lieuRencontre() {
        return this._lieuRencontre;
    }

    public void set_lieuRencontre(String _lieuRencontre) {
        this._lieuRencontre = _lieuRencontre;
    }

    public String get_nomRencontre() {
        return this._nomRencontre;
    }

    public void set_nomRencontre(String _nomRencontre) {
        this._nomRencontre = _nomRencontre;
    }

    public Time get_heureDebut() {
        return this._heureDebut;
    }

    public void set_heureDebut(Time _heureDebut) {
        this._heureDebut = _heureDebut;
    }

    public Time get_heureFin() {
        return this._heureFin;
    }

    public void set_heureFin(Time _heureFin) {
        this._heureFin = _heureFin;
    }

    public String get_lieuPresentation() {
        return this._lieuPresentation;
    }

    public void set_lieuPresentation(String _lieuPresentation) {
        this._lieuPresentation = _lieuPresentation;
    }

    /**
     * @return Date return the _dateRencontre
     */
    public Date get_datePassageGroupe() {
        return _datePassageGroupe;
    }

    /**
     * @param _dateRencontre the _dateRencontre to set
     */
    public void set_datePassageGroupe(Date _dateRencontre) {
        this._datePassageGroupe = _dateRencontre;
    }

}