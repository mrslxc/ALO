public class AuSol extends Employe {
    private int anciennete;

    public AuSol(String nom, boolean genre, String canton, int anciennete) {
        super(nom, genre, canton);
        this.anciennete = anciennete;
    }

    @Override
    public String toString() {
        return super.toString() + " travaille " ;
    }
}