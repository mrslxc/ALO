public class Ville {
    private String nomVille;
    private double nbMaxSpectateursAuMetreCarre;
    // Création du constructeur de la classe Ville
    public Ville(String nomVille, double nbMaxSpectacteursAuMetreCarre) {
        this.nomVille = nomVille;
        this.nbMaxSpectateursAuMetreCarre = nbMaxSpectacteursAuMetreCarre;
    }

    public String getNomVille() {
        return nomVille;
    }

    public double getNbMaxSpectateursAuMetreCarre() {
        return nbMaxSpectateursAuMetreCarre;
    }
}
