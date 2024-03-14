public class Song {
    private String titre;
    private String artiste;
    private double duree;
    private String genre;

    public Song(String titre, String artiste, double duree, String genre) {
        this.titre = titre;
        this.artiste = artiste;
        this.duree = duree;
        this.genre = genre;
    }
    public static double parseDuration(String duration) {
        // Divisez la chaîne en parties en utilisant le point comme séparateur
        String[] parts = duration.split("//,");

        // Convertissez la partie des minutes en minutes
        int minutes = Integer.parseInt(parts[0]);

        // Convertissez la partie des secondes en secondes et divisez par 60 pour obtenir une valeur en minutes
        double seconds = Double.parseDouble(parts[1]);

        // Retourne la somme des minutes et des secondes
        return minutes + seconds;
    }

    public String getTitre() {
        return titre;
    }

    public String getArtiste() {
        return artiste;
    }

    public double getDuree() {
        return duree;
    }

    public String getGenre() {
        return genre;
    }

    public String toString() {
        return "'" + this.titre + "', de " + this.artiste + " avec commme genre " + this.genre + ", dure " + this.duree + " minutes";
    }
}
