/***
 * Classe Main, appelée par défaut dans les programmes Java
 */
public class Main {
    /***
     * méthode main, la première méthode appelée lors de l'exécution d'un programme Java
     * @param args : elle peut prendre en paramètre un tableau de strings, mais pour le moment on ne se soucie pas de ça.
     */
    public static void main(String[] args) {
        //instanciation d'un garage
        Garage garage = new Garage();
        //appel de la méthode getMoyenne
        garage.createDefaultGarage();

    }
}