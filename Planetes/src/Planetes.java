import java.util.ArrayList;

public class Planetes {
    private String nom;
    private int rayonMoyen;
    private  long circonference;
    private int nmbSatelite;
    private ArrayList<String> satelite;

    public Planetes(String nom, int rayonMoyen, long circonference, int nmbSatelite) {
        this.nom = nom;
        this.rayonMoyen = rayonMoyen;
        this.circonference = circonference;
        this.nmbSatelite = nmbSatelite;
    }

    public String getNom() {
        return nom;
    }

    public long getCirconference() {
        return circonference;
    }

    public int getNmbSatelite() {
        return nmbSatelite;
    }

    public int getRayonMoyen() {
        return rayonMoyen;
    }

    @Override
    public String toString() {
        if (this.getNmbSatelite() == 0) {
            return this.getNom() + " " + "[rayon: " + this.getRayonMoyen() +
                "] [circonférence de l'orbite : " + this.getCirconference()
                + "] [aucun satellite]";
        } else {
            return this.getNom() + "[rayon: " + this.getRayonMoyen() +
                "] [circonférence de l'orbite : " + this.getCirconference()
                + "] [" + this.getNmbSatelite() + " satellites]";
        }
    }
}