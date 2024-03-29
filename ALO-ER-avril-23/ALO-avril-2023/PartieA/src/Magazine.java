//vos noms et prénoms ici

public class Magazine {
    private String titre;
   private String frequence;


   // Création d'un constructeur
   public Magazine(String titre, String frequence) {
       this.titre = titre;
       this.frequence = frequence;
   }

   public int getFrequence() {
       return nbSemaine();
   }

   public String getTitre() {
       return titre;
   }

    public int nbSemaine() {
        return switch (frequence) {
            case "hebdo" -> 1;
            case "bimensuel" -> 2;
            case "mensuel" -> 4;
            case "bimestriel" -> 8;
            default -> 0;
        }

        /*
        if (this.frequence = "hebdo") {
            return 1;
        } else if (this.frequence = "bimensuel") {
            return 2;
        } else if (this.frequence = "mensuel") {
            return 4;
        } else if (this.frequence = "bimestriel") {
            return 8;
        } else {
            return 0;
        }
        */
   }

    public String toString() {
        return this.titre + " est un " + this.frequence;
   }
}
