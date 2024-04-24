public class Employe
{
    public static final int NB_ANNUITES_BASE = 47;
    public static final int LIMITE_BREVET = 5;

    private String nom;
    private boolean genre;// true pour Femme, false pour Homme
    private String canton;

    public Employe(String nom, boolean genre, String canton)
    {
        this.nom = nom;
        this.genre = genre;
        this.canton = canton;
    }

    public boolean estFemme()
    {
        return genre;
    }

    public String getCanton()
    {
        return canton;
    }

    public String getNom()
    {
        return nom;
    }

    @Override
    public String toString() {
        return civilite(genre) + this.nom + " habite " + this.canton;
    }

    private String civilite(boolean genre) {
        if (genre)
            return "Mme ";
        else
            return "M. ";
    }

}
