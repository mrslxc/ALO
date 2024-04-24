public class DeService extends AuSol {
    private String specialite;

    public DeService(String nom, boolean genre, String canton, int anciennete, String specialite) {
        super(nom, genre, canton, anciennete);
        this.specialite = specialite;
    }
}
