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
        motaz.afficherQuestion5();
        motaz.afficherQuestion6();

        // Question 7
        Song song = new Song("title", "artist", 12, "rap");
        Song anotherSong = new Song("title2", "artist2", 10.90, "rap");

        //me.getDiffMinutes(song, anotherSong);
        System.out.println("Question 7");
        me.afficherQuestion7(song, anotherSong);
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
                Double dureeEnMin = scElements.nextDouble();
                
                //La string aurait ete valable si la ParseDuration aurait été valide
                //String dureeString = scElements.next();
                //Double dureeEnMin = scElements.parseDuration(dureeEnString);
                
                //--------------------- COMPLETER CETTE PARTIE DUCODE---------------------
                Song s = new Song(title, artist, dureeEnMin, genre);
                Song s2  = new Song(title, artist, dureeEnMin, genre);
                //--------------------- FIN ---------------------
                playList.add(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return playList;
    }
}
