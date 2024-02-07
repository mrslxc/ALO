public class Voiture {
    private String marque;

    private String couleur;

    private int annee;

    private double km;

    private String etatVoiture;

    // Création d'un constructeur avec les propriétés
    public Voiture(String marque, String couleur, int annee, double km, String etatVoiture) {
        this.marque = marque;
        this.couleur = couleur;
        this.annee = annee;
        this.km = km;
        this.etatVoiture = etatVoiture;
    }

    // Création des accesseurs
    public String getMarque() {
        return marque;
    }

    public String getCouleur() {
        return couleur;
    }

    public int getAnnee() {
        return annee;
    }

    public double getKm() {
        return km;
    }

    public String getEtatVoiture() {
        return etatVoiture;
    }

    @Override
    public String toString() {
        return "Marque : " + getMarque() + " | Couleur : " + getCouleur() + " | Année : " + getAnnee() +
                " | Kilométrage : " + getKm() + " | Etat : " + getEtatVoiture();
    }
}
