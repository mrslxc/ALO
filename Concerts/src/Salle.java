public class Salle {
    private int largeurSalle;
    private int longeurSalle;
    private int largeurScene;
    private int longeurScene;

    private Ville ville;

    // Création du constructeur pour la classe Salle
    public Salle(int largeurSalle, int longeurSalle, int largeurScene, int longeurScene, Ville ville) {
        this.largeurSalle = largeurSalle;
        this.longeurSalle = longeurSalle;
        this.largeurScene = largeurScene;
        this.longeurScene = longeurScene;
        this.ville = ville;
    }

    public int getLargeurSalle() {
        return largeurSalle;
    }

    public int getLongeurSalle() {
        return longeurSalle;
    }

    public Ville getVille() {
        return ville;
    }
    public int getLargeurScene() {
        return largeurScene;
    }

    public int getLongeurScene() {
        return longeurScene;}

    public int getSuperficie() {
        return longeurSalle * largeurSalle - largeurScene * longeurScene;
    }
}
