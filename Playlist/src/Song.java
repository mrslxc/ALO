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
