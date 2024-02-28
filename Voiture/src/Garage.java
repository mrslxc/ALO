public class Garage {
    //déclaration ET initialisation d'une voiture banale avec le constructeur par défaut

    private Voiture[] garage;

    public Garage() {
        this.garage = createDefaultGarage();
        // Remplir le tableau des données de garage
    }
    public Voiture[] createDefaultGarage() {

        Voiture banale = new Voiture();

        Voiture ferrari;
        //initialisation à l'aide de l'instance de classe Voiture, et en utilisant le constructeur avec 4 paramètres
        ferrari = new Voiture("ferrari", "rouge", 2024, 20000);
        //exemple d'instanciation avec le constructeur avec 2 paramètres
        Voiture batMobile = new Voiture("Bat Mobile", "noir matte");

        Voiture rollsRoyce = new Voiture("Rolls Royce", "gris anthracite", 2024, 10);

        //changement de couleur de la Rolls grâce au setter
        rollsRoyce.setCouleur("Vert forêt");
        //changement de l'année de la ferrarie grâce au setter
        ferrari.setAnnee(2023);

        banale.setAnnee(2000);
        banale.setCouleur("rose");
        banale.setKm(150000);
        banale.setMarque("Renault");

        System.out.println("Mon garage be like : ");

        Voiture[] garage = new Voiture[] { banale, ferrari, batMobile, rollsRoyce };
        return garage;
    }

    public int getMoyenne() {
        for (Voiture voiture : garage) { //foreach
            System.out.println(voiture);
        }

        System.out.println("Mes voitures ont une moyenne de km : ");
        double somme = 0;
        for (Voiture voiture : garage) {
            somme += voiture.getKm();
        }
        double moyenne = somme / garage.length;
        System.out.println(moyenne);

        //une voiture sur deux
        /*for (int i=0; i< garage.length; i+=2) {
            System.out.println(garage[i]);
        }*/
        return (int) moyenne;
    }
}
