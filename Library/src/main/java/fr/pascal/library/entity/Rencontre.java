package fr.pascal.library.entity;

import java.util.Date;

public class Rencontre {

    /**
     * Variables
     * 
     */
    private int _id;
    private int _idOrganisateur;
    private String _nomRencontre;
    private String _lieuRencontre;
    private Date _dateDebutDeroulement;
    private Date _dateFinDeroulement;
    private String _periodiciteRencontre;

    /**
     * Constructeur
     */

    public Rencontre(int id, int idOrganisateur, String nomRencontre, String lieuRencontre, Date dateDebutDeroulement,
            Date dateFinDeroulement, String periodiciteRencontre) {
        this._id = id;
        this._idOrganisateur = idOrganisateur;
        this._nomRencontre = nomRencontre;
        this._lieuRencontre = lieuRencontre;
        this._dateDebutDeroulement = dateDebutDeroulement;
        this._dateFinDeroulement = dateFinDeroulement;
        this._periodiciteRencontre = periodiciteRencontre;

    }

    public Rencontre(int id, String nomRencontre, String lieuRencontre, String periodiciteRencontre) {
        this._id = id;
        this._nomRencontre = nomRencontre;
        this._lieuRencontre = lieuRencontre;
        this._periodiciteRencontre = periodiciteRencontre;
    }

    public Rencontre() {

    }

    /**
     * 
     * Getters et setters
     * 
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
     * @return int return the _idOrganisateur
     */
    public int get_idOrganisateur() {
        return _idOrganisateur;
    }

    /**
     * @param _idOrganisateur the _idOrganisateur to set
     */
    public void set_idOrganisateur(int _idOrganisateur) {
        this._idOrganisateur = _idOrganisateur;
    }

    /**
     * @return string return the _nomRencontre
     */
    public String get_nomRencontre() {
        return _nomRencontre;
    }

    /**
     * @param _nomRencontre the _nomRencontre to set
     */
    public void set_nomRencontre(String _nomRencontre) {
        this._nomRencontre = _nomRencontre;
    }

    /**
     * @return string return the _lieuRencontre
     */
    public String get_lieuRencontre() {
        return _lieuRencontre;
    }

    /**
     * @param _lieuRencontre the _lieuRencontre to set
     */
    public void set_lieuRencontre(String _lieuRencontre) {
        this._lieuRencontre = _lieuRencontre;
    }

    /**
     * @return date return the _dateDebutDeroulement
     */
    public Date get_dateDebutDeroulement() {
        return _dateDebutDeroulement;
    }

    /**
     * @param _dateDebutDeroulement the _dateDebutDeroulement to set
     */
    public void set_dateDebutDeroulement(Date _dateDebutDeroulement) {
        this._dateDebutDeroulement = _dateDebutDeroulement;
    }

    /**
     * @return date return the _dateFinDeroulement
     */
    public Date get_dateFinDeroulement() {
        return _dateFinDeroulement;
    }

    /**
     * @param _dateFinDeroulement the _dateFinDeroulement to set
     */
    public void set_dateFinDeroulement(Date _dateFinDeroulement) {
        this._dateFinDeroulement = _dateFinDeroulement;
    }

    /**
     * @return string return the _periodiciteRencontre
     */
    public String get_periodiciteRencontre() {
        return _periodiciteRencontre;
    }

    /**
     * @param _periodiciteRencontre the _periodiciteRencontre to set
     */
    public void set_periodiciteRencontre(String _periodiciteRencontre) {
        this._periodiciteRencontre = _periodiciteRencontre;
    }

}