public class Flight {
    private String villeDepart;
    private String villeDestination;
    private double duree;

    public Flight(String villeDepart, String villeDestination, double duree) {
        this.villeDepart = villeDepart;
        this.villeDestination = villeDestination;
        this.duree = duree;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public String getVilleDestination() {
        return villeDestination;
    }

    public double getDuree() {
        return duree;
    }

    public String toString() {
        return "départ de " + this.villeDepart + ", avec destination " + this.villeDestination + " " +
                "à une durée de " + this.duree + " heures";
    }
}
