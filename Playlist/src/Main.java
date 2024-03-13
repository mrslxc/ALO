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
        motaz.afficherQuestion4();

        Flight flightAms = new Flight("Genève", "Amsterdam", 0.5);
        Listener me = new Listener("Me myself & I", flightAms);
        me.setPlayList(playList); //on réutilise la même playlist
        me.afficherTempsVolOKNotOK();

        //motaz.afficherQuestion3();
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
}