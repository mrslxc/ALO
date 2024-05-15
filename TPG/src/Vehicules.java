public class Vehicules {
    int nbPassagersMaximum;
    int prixAchat;

    public Vehicules(int nbPassagersMaximum, int prixAchat) {
        this.nbPassagersMaximum = nbPassagersMaximum;
        this.prixAchat = prixAchat;
    }

    @Override
    public String toString() {
        return "vehicules (prix: CHF " + prixAchat + ") de type : ";
    }
}
