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
}