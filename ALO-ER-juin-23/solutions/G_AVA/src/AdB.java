public class AdB extends Navigant
{
    private boolean longCourrier;

    public AdB(String nom, boolean genre, String canton, int nbHeuresVol, boolean longCourrier)
    {
        super(nom, genre, canton, nbHeuresVol);
        this.longCourrier = longCourrier;
    }
}