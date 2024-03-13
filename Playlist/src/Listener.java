import java.util.ArrayList;

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
        calculerRepartitionGenreMusicaux();
    }

    public void calculerRepartitionGenreMusicaux() {
        int compteurPop = 0;
        int compteurRock = 0;
        int compteurRap = 0;
        int compteurClassique = 0;
        int compteurJazz = 0;
        int compteurAutre = 0;

        for (Song chanson : morceaux) {
            if (chanson.getGenre().equals("Pop")) {
                compteurPop++;
            } else if (chanson.getGenre().equals("Rock")) {
                compteurRock++;
            } else if (chanson.getGenre().equals("Rap")) {
                compteurRap++;
            } else if (chanson.getGenre().equals("Classique")) {
                compteurClassique++;
            } else if (chanson.getGenre().equals("Jazz")) {
                compteurJazz++;
            } else {
                compteurAutre++;
            }
        }
        System.out.println("La playlist contient " + compteurPop + " chansons de genre Pop");
        System.out.println("La playlist contient " + compteurRock + " chansons de genre Rock");
        System.out.println("La playlist contient " + compteurRap + " chansons de genre Rap");
        System.out.println("La playlist contient " + compteurClassique + " chansons de genre Classique");
        System.out.println("La playlist contient " + compteurJazz + " chansons de genre Jazz");
        System.out.println("La playlist contient " + compteurAutre + " chansons de genre Autre");
    }
}
