import java.util.ArrayList;

public class Planetes {
    private String nomPlanete;
    private int rayonMoyen;
    private int circonferenceOrbite;
    private int nbSatellites;

    private ArrayList<String> satellites;

    public Planetes(String nomPlanete, int rayonMoyen, int circonferenceOrbite, int nbSatellites) {
        this.nomPlanete = nomPlanete;
        this.rayonMoyen = rayonMoyen;
        this.circonferenceOrbite = circonferenceOrbite;
        this.nbSatellites = nbSatellites;
    }

    public void ajouterSatellite (String satellite) {
        satellites.add(satellite);
    }

    public String getNomPlanete() {
        return nomPlanete;
    }

    public int getRayonMoyen() {
        return rayonMoyen;
    }

    public int getCirconferenceOrbite() {
        return circonferenceOrbite;
    }

    public int getNbSatellites() {
        return nbSatellites;
    }

    @Override
    public String toString() {
        System.out.println("Voici la liste des planètes du système solaire :");
        return "Nom : " + nomPlanete + " [rayon : " + rayonMoyen + " km]" + " [circonférence de l'orbite : " + circonferenceOrbite + " km]" +
                " [nombre de satellites : " + nbSatellites + "]";
    }
}
