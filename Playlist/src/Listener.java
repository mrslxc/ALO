import java.util.ArrayList;
import java.util.HashMap;

public class Listener {
    private String nom;
    private Flight vol;

    // On crée une arraylist de type "Song" pour y reprendre ses chansons
    private ArrayList<Song> morceaux;

    public Listener(String nom, Flight vol) {
        this.nom = nom;
        this.vol = vol;
        this.morceaux = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public Flight getVol() {
        return vol;
    }

    public ArrayList<Song> afficherPlaylist() {
        return morceaux;
    }

    // On crée une méthode "setplaylist" pour crée une playlist pour l'auditeur
    public void setPlayList(ArrayList<Song> listeMorceaux) {
        for (Song chanson : listeMorceaux) {
            chanson = new Song(chanson.getTitre(), chanson.getArtiste(), chanson.getDuree(), chanson.getGenre());
            morceaux.add(chanson);
        }
    }

    // On crée une méthode "afficherQuestion1" pour afficher les chansons de l'auditeur
    public void afficherQuestion1() {
        System.out.println("Pour le vol suivant : " + vol.toString());
        System.out.println("L'auditeur " + this.nom + " a les chansons suivantes dans sa playlist :");

        for (Song chanson : morceaux) {
            System.out.println(chanson);
        }
    }

    public double calculTotalEcouter() {
        double totalecoute = 0;
        double totalHeure = 0;

        for (Song chanson : morceaux) {
            totalecoute += chanson.getDuree();
        }
        totalHeure = totalecoute / 60;
        return totalHeure;
    }

    public void afficherTotalTempsEcoute() {
        double totalHeure = calculTotalEcouter();
        System.out.println("Le temps nécessaire pour écouter la playlist téléchargée est de " + totalHeure + " heures.");
    }

    public void afficherQuestion2() {
        System.out.println("\n");
        afficherTotalTempsEcoute();
    }

    public void afficherTempsVolOKNotOK() {
        if (estTempsVolOK()) {
            System.out.println("\n");
            System.out.println("Le temps de vol de " + vol.getDuree() + " sera suffisant pour écouter la playlist en entier");
        } else {
            System.out.println("\n");
            System.out.println("Le temps de vol de " + vol.getDuree() + " sera insuffisant pour écouter la playlist en entier");
        };
    }

    public boolean estTempsVolOK() {
        if (calculTotalEcouter() <= vol.getDuree()) {
            return true;
        } else {
            return false;
        }
    }

    public void afficherQuestion4() {
        System.out.println("\n");
        afficherRepartitionGenreMusicaux();
    }

    public void afficherRepartitionGenreMusicaux() {
        // Initialiser un HashMap pour stocker les compteurs de chaque genre
        HashMap<String, Integer> compteursGenres = new HashMap<>();

        // Parcourir chaque chanson dans la playlist
        for (Song chanson : morceaux) {
            String genre = chanson.getGenre().toLowerCase(); // Convertir en minuscules pour normaliser le genre

            // Incrémenter le compteur correspondant au genre de la chanson
            compteursGenres.put(genre, compteursGenres.get(genre) + 1);
        }

        // Afficher le nombre de chansons pour chaque genre
        for (String genre : compteursGenres.keySet()) {
            int compteur = compteursGenres.get(genre);
            System.out.println("Pour le genre " + genre + ", il y a " + compteur + " chansons dans la playlist.");
        }
    }

}