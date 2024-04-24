import java.util.HashMap;

/**
 * @author Clément Vogt
 * @version Version 1.0
 */
public class DeService extends AuSol {
    private String specialite;

    private HashMap<String, Integer> hmDelta;

    public DeService(String nom, boolean genre, String canton, int anciennete, String specialite) {
        super(nom, genre, canton, anciennete);
        this.specialite = specialite;
        initHashMap();
    }

    private void initHashMap() {
        hmDelta = new HashMap<>();
        hmDelta.put("mécanicien",3);
        hmDelta.put("sécurité",1);
        hmDelta.put("bagagiste",2);
    }

    @Override
    public int calculerAnneesRestantes() {
        return super.calculerAnneesRestantes() - hmDelta.get(specialite);
    }

    @Override
    public String toString() {
        return super.toString() + " comme " + specialite;
    }
}
