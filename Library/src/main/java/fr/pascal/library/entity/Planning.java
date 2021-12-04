package fr.pascal.library.entity;

//import fr.pascal.library.entity.Groupe;

public class Planning {

    /**
     * Variables
     */
    private Groupe _denominationGroupe;
    private Rencontre _lieuRencontre;
    private Rencontre _nomRencontre;

 
/**
 * Constructeur
 * @param _denominationGroupe
 * @param _lieuRencontre
 * @param _nomRencontre
 */

   public Planning(Groupe _denominationGroupe, Rencontre _lieuRencontre, Rencontre _nomRencontre) {
        this._denominationGroupe = _denominationGroupe;
        this._lieuRencontre = _lieuRencontre;
        this._nomRencontre = _nomRencontre;
    }

    public Planning() {
    }
     
    /**
     * Accesseurs
     */
    /**
     * @return Groupe return the _denominationGroupe
     */
    public Groupe get_denominationGroupe() {
        return _denominationGroupe;
    }

    /**
     * @param _denominationGroupe the _denominationGroupe to set
     */
    public void set_denominationGroupe(Groupe _denominationGroupe) {
        this._denominationGroupe = _denominationGroupe;
    }

    /**
     * @return Rencontre return the _lieuRencontre
     */
    public Rencontre get_lieuRencontre() {
        return _lieuRencontre;
    }

    /**
     * @param _lieuRencontre the _lieuRencontre to set
     */
    public void set_lieuRencontre(Rencontre _lieuRencontre) {
        this._lieuRencontre = _lieuRencontre;
    }

    /**
     * @return Rencontre return the _nomRencontre
     */
    public Rencontre get_nomRencontre() {
        return _nomRencontre;
    }

    /**
     * @param _nomRencontre the _nomRencontre to set
     */
    public void set_nomRencontre(Rencontre _nomRencontre) {
        this._nomRencontre = _nomRencontre;
    }

}