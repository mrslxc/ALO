/**
 * @author Clément Vogt
 * @version Version 1.0
 */
public class Navigant extends Employe
{
    private int nbHeuresVol;

    public Navigant(String nom, boolean genre, String canton, int nbHeuresVol)
    {
        super(nom, genre, canton);
        this.nbHeuresVol = nbHeuresVol;
    }

    public int getNbHeuresVol()
    {
        return nbHeuresVol;
    }

    public void setNbHeuresVol(int nbHeuresVol) {
        this.nbHeuresVol = nbHeuresVol;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + nbHeuresVol + " heures de vol";
    }
}