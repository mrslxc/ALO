import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Flight vol = new Flight("Dubai", "Genève", 8.5);
        Listener motaz = new Listener("Motaz Azaiza", vol);
        ArrayList<Song> playList = readData("songs.txt");
        motaz.setPlayList(playList);
        motaz.afficherQuestion1();
        motaz.afficherQuestion2();


        Flight flightAms = new Flight("Genève", "Amsterdam", 0.5);
        Listener me = new Listener("Me myself & I", flightAms);
        me.setPlayList(playList); //on réutilise la même playlist
        me.afficherTempsVolOKNotOK();

        //motaz.afficherQuestion3();
        motaz.afficherQuestion4();
        motaz.afficherMorceauPlusLong();

        // Question 7
        Song song = new Song("title", "artist", 10.10, "rap");
        Song anotherSong = new Song("title2", "artist2", 12, "rap");

        //me.getDiffMinutes(song, anotherSong);
        System.out.println("Question 7");
        me.afficherDiffMinutes(song, anotherSong);
        //etc
    }

    public static ArrayList<Song> readData(String fileName) {
        ArrayList<Song> playList = new ArrayList<>();
        try {
            Scanner scLignes = new Scanner(new File(fileName));
            scLignes.nextLine();
            while(scLignes.hasNextLine()){
                Scanner scElements =  new Scanner(scLignes.nextLine());
                scElements.useDelimiter(";");
                String title = scElements.next();
                String artist = scElements.next();
                String genre = scElements.next();
                String dureeString = scElements.next();
                Double dureeEnMin = Song.parseDuration(dureeString);
                //--------------------- COMPLETER CETTE PARTIE DUCODE---------------------
                Song s = new Song(title, artist, dureeEnMin, genre);
                //--------------------- FIN ---------------------
                playList.add(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return playList;
    }

//    public static double casterMinutesEnSecondes(double duree) {
//        return dure;
//    }
}