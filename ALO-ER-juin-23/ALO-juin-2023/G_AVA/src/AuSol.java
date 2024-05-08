public class AuSol extends Employe {
    private int anciennete;

    public AuSol(String nom, boolean genre, String canton, int anciennete) {
        super(nom, genre, canton);
        this.anciennete = anciennete;
    }

    public int getAnciennete() {
        return anciennete;
    }

    public int calculerAnneeRestantes() {
        return Employe.NB_ANNUITES_BASE - anciennete;
    }

    @Override
    public String toString() {
        return super.toString() + " travaille " ;
    }
}