/**
 * @author Clément Vogt
 * @version Version 1.0
 */
public class Admin extends AuSol {
    private String referenceBureau;

    public Admin(String nom, boolean genre, String canton, int ancienneté, String referenceBureau) {
        super(nom, genre, canton, ancienneté);
        this.referenceBureau = referenceBureau;
    }

    @Override
    public String toString() {
        return super.toString() + " dans le bureau " + referenceBureau;
    }
}