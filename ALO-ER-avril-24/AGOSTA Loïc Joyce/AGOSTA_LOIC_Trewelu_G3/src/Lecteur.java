/*********************/
// LOIC AGOSTA
//
/*********************/

import java.util.ArrayList;

public class Lecteur {
    private String nom;
    private String numAdherent;
    private double tempsDeLecteureEnMinPP;
    private double tempsDeLectureHebdoMoyenEnHeures;
    ArrayList<Livre> lstLivres;

    public Lecteur(String nom, String numAdherent, double tempsDeLecteureEnMinPP, double tempsDeLectureHebdoMoyenEnHeures) {
        this.nom = nom;
        this.numAdherent = numAdherent;
        this.tempsDeLecteureEnMinPP = tempsDeLecteureEnMinPP;
        this.tempsDeLectureHebdoMoyenEnHeures = tempsDeLectureHebdoMoyenEnHeures;
        this.lstLivres = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public String getNumAdherent() {
        return numAdherent;
    }

    public double getTempsDeLecteureEnMinPP() {
        return tempsDeLecteureEnMinPP;
    }

    public double getTempsDeLectureHebdoMoyenEnHeures() {
        return tempsDeLectureHebdoMoyenEnHeures;
    }

    public ArrayList<Livre> getLstLivres() {
        return lstLivres;
    }

    public double calculTotalTempsLectureHeures() {
        double totalHeure = 0;

        for (Livre livre : lstLivres) {
            totalHeure += (livre.getNbPages() * this.tempsDeLecteureEnMinPP) / 60
                    * livre.getTypeLivre().getRatioLecture();
        }
        return totalHeure;
    }

    public double calculMoisLecture() {
        int heureEnMois = 40;
        return calculTotalTempsLectureHeures() / heureEnMois;
    }

    public void setLstLivres(ArrayList<Livre> listeLivresElla) {
        for (Livre l : listeLivresElla) {
            l = new Livre(l.getTitre(), l.getAuteur(), l.getNbPages(), l.getTypeLivre());
            lstLivres.add(l);
        }
    }

    public String toString() {
        String result = "";
        System.out.println(this.nom + " adhérent " + this.numAdherent + " a emprunté les livres suivants :");
        for (Livre livre: this.getLstLivres()) {
            result += livre.toString();
        }
        return result;
    }
}
