public class Voiture {
    private String marque;
    private String couleur;
    private int annee;
    private double km;

    /***
     * constructeur par défaut, valeurs à vide
     */
    public Voiture() {
        this("","",0,0);
        //System.out.println("Constructeur sans param");
    }

    /***
     * constructeur avec deux paramètres
     * @param m marque
     * @param c couleur
     */
    public Voiture(String m, String c) {
        this(m, c, 0,0);
        //System.out.println("Constructeur avec 2 param, marque : " + m + " couleur : " + c);
    }
    /***
     * constructeur avec 4 paramètres
     * @param m marque
     * @param c couleur
     * @param a année
     * @param k km
     */
    public Voiture(String m, String c, int a, double k) {
        // System.out.println("Constructeur avec 4 param, marque : " + m + " couleur : " + c + " annee : "+ a + " km: " + k);
        this.marque = m;
        this.couleur = c;
        this.annee = a;
        this.km = k;
    }
    public String getMarque() {
        return this.marque;
    }

    public String getCouleur() {
        return this.couleur;
    }

    public int getAnnee() {
        return this.annee;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public double getKm(){
        return this.km;
    }

    public String getKmFormatted(){
        return String.format("%,.2f", this.km);
    }

    /***
     * setter pour changer la couleur de la voiture depuis une autre classe
     * @param c
     */
    public void setCouleur(String c) {
        this.couleur = c;
    }

    /***
     * setter pour changer l'année avec contrôle sur la saisie pour pas avoir d'année dans le futur
     * @param a
     */
    public void setAnnee(int a){
        if(a > 2024) {
            this.annee = 2024;
        } else {
            this.annee = a;
        }
    }

    /***
     * méthode de calcul de l'état de la voiture en fonction de son année et ses km
     * @return
     */
    public String getEtat() {
        String etat = "";

        if ((this.annee >= 2019 && this.km <= 10000) || (this.km ==0)) {
            etat = "Comme neuve";
        } else if (this.annee >= 2014 && this.km <= 50000) {
            etat = "Etat moyen";
        } else {
            etat = "Bof";
        }
        return etat;
    }

    /***
     * méthode toString, permettant d'avoir un affichage de l'objet et ses propriétés sous la forme d'une chaîne
     * @return
     */
    @Override
    public String toString() {
        return "Cette voiture est de la marque : '" + this.getMarque() +
                "' et de la couleur : '" + this.getCouleur() + "', son année est : "
                + this.getAnnee() + " et son kilométrage est de : " + this.getKmFormatted()  + " et son état est : " + getEtat();
    }

}