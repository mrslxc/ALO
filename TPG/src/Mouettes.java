public class Mouettes extends Vehicules {
    int nbGilets;

    public Mouettes(int nbPassagersMaximum, int prixAchat, int nbGilets) throws Exception {
        super(nbPassagersMaximum, prixAchat);
        this.nbGilets = nbGilets;
    }

    public int getNbGilets() {
        return nbGilets;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(super.toString());
        if (nbGilets < nbPassagersMaximum) {
            result.append("Mouettes").append(" avec ").append(this.nbGilets).append(" gilets de secours " );
        }
        return result.toString();
    }
}
