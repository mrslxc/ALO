public class Admin extends AuSol {
    private String referenceBureau;

    public Admin(String nom, boolean genre, String canton, int anciennete, String referenceBureau) {
        super(nom, genre, canton, anciennete);
        this.referenceBureau = referenceBureau;
    }
    @Override
    public String toString() {
        return super.toString() + " dans le bureau " + this.referenceBureau;
    }
}