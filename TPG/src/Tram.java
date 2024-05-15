import java.io.ObjectInputStream;

public class Tram extends Vehicules {
    boolean estBidirictionnel;
    int nbWagons;

    public Tram(int nbPassagersMaximum, int nbPrixAchat, boolean estBidirictionnel, int nbWagons) {
        super(nbPassagersMaximum, nbPrixAchat);
        this.estBidirictionnel = estBidirictionnel;
        this.nbWagons = nbWagons;
    }

    public boolean isEstBidirictionnel() {
        return estBidirictionnel;
    }

    public int getNbWagons() {
        return nbWagons;
    }

    @Override
    public String toString() {
        if (!isEstBidirictionnel()) {
            String resultBidirictionnel = "bidirictionnel";
            return super.toString() + getClass().getName() + "way (" + resultBidirictionnel + ") composé de "
                    + this.nbWagons + " Wagons";
        } else {
            String resultMonodirectionnel = "monodirectionnel";
            return super.toString() + getClass().getName() + "way (" + resultMonodirectionnel + ") composé de "
                    + this.nbWagons + " Wagons";
        }
    }
}
