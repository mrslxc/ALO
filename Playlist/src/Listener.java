import java.util.ArrayList;
import java.util.Formatter;
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

    // On crée une méthode "setplaylist" pour crée une playlist pour l'auditeur
    public void setPlayList(ArrayList<Song> listeMorceaux) {
        for (Song chanson : listeMorceaux) {
            chanson = new Song(chanson.getTitre(), chanson.getArtiste(), chanson.getDuree(), chanson.getGenre());
            morceaux.add(chanson);
        }
    }

    // On crée une méthode "afficherQuestion1" pour afficher les chansons de l'auditeur
    public void afficherQuestion1() {
        System.out.println("Quesiton 1 : ");
        System.out.println("Pour le vol suivant : " + vol.toString());
        System.out.println("L'auditeur " + this.nom + " a les chansons suivantes dans sa playlist :");

        for (Song chanson : morceaux) {
            System.out.println(chanson);
        }
    }

    public void afficherQuestion2() {
        System.out.println("\n");
        System.out.println("Question 2 : ");;
        afficherTotalTempsEcoute();
    }

    public void afficherQuestion4() {
        System.out.println("\n");
        System.out.println("Répartition des genres musicaux dans la playlist : (avec HashMap)");
        /* avec la méthode HashMap */afficherRepartitionGenreMusicaux();
        System.out.println("\n");
        System.out.println("Répartition des genres musicaux dans la playlist : (sans HashMap)");
        /* sans la méthode HashMap */afficherGenreMusicaux();
    }

    // Vos méthodes ici


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



    public void afficherTempsVolOKNotOK() {
        if (estTempsVolOK()) {
            System.out.println("\n");
            System.out.println("Question 3 : ");
            System.out.println("Le temps de vol de " + vol.getDuree() + " sera suffisant pour écouter la playlist en entier");
        } else {
            System.out.println("\n");
            System.out.println("Question 3 : ");
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



    public void afficherRepartitionGenreMusicaux() {
        HashMap<String, Integer> repartition = new HashMap<>();
        for (Song chanson : morceaux) {
            if (repartition.containsKey(chanson.getGenre())) {
                repartition.put(chanson.getGenre(), repartition.get(chanson.getGenre()) + 1);
            } else {
                repartition.put(chanson.getGenre(), 1);
            }
        }
        for (String genre : repartition.keySet()) {
            System.out.println(genre + " : " + repartition.get(genre));
        }
    }

    public void afficherGenreMusicaux() {
        // On crée une arraylist de la classe Song pour récupérer la variable "morceaux"
        ArrayList<Song> lstGerne = new ArrayList<>(morceaux);

        while (!lstGerne.isEmpty()) {
            String genre = lstGerne.get(0).getGenre();
            int compteur = 0;
            for (int i = 0; i < morceaux.size(); i++) {
                if (morceaux.get(i).getGenre().equals(genre)) {
                    compteur++;
                    lstGerne.remove(morceaux.get(i));
                }
            }
            System.out.println("Le genre " + genre + " est présent " + compteur + " fois dans la playlist");
        }
    }

    // Question 7 (à compléter dans le Main.java)
    public double getDiffMinutes(Song chanson1, Song chanson2) {
        double diff = 0;

        if (chanson1.getDuree() > chanson2.getDuree()) { // On récupère la variable de "Durée" à partir de "chanson"
            diff = chanson1.getDuree() - chanson2.getDuree(); // On fait la différence entre les deux chansons (chanson1 et chanson2)
        } else {
            diff = chanson2.getDuree() - chanson1.getDuree();
        }
        return diff;
    }

    public void afficherDiffMinutes(Song chanson1, Song chanson2) {
        Formatter format = new Formatter();
        double diff = getDiffMinutes(chanson1, chanson2);

        int minutes = (int) diff; // caster la partie entière de la différence, exemple : 4.5 -> 4
        double secondes = (diff - minutes) * 60; // caster la partie décimale de la différence, exemple : 4.5 -> 0.5 -> 30

        System.out.println("La différence de durée entre les chanosns " + chanson1 + " et " + chanson2 + " est de "
                + minutes + " minutes et " + secondes + " secondes");
    }

    public void getDiffMinutesPourToutesLesMusiques() {
        double diff = 0;

        for (Song song : morceaux) {
            for (Song song2 : morceaux) {
                getDiffMinutes(song, song2);
            }
        }
    }

    public String morceauLePlusLong() {
        Song morceau = morceaux.get(0);

        for (Song song: morceaux) {
            if (song.getDuree() > morceau.getDuree()) {
                morceau = song;
            }
        }
        return morceau.getTitre();
    }

    public void afficherMorceauPlusLong() {
        String morceau = morceauLePlusLong();

        System.out.println("\n");
        System.out.println("Question 5 : ");
        System.out.println("Le morceau le plus long est : " + morceau);
    }
}