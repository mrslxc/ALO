//vos noms et prénoms ici

public class TestAboMagClient
{
    public static void main(String[] args)
    {
          //testCreationMagazines();//nécessite une classe Magazine fonctionnelle
          System.out.println("------------------------------------------------------");
          //testCreationClientsSansAbo();//nécessite une classe Client fonctionnelle
          System.out.println("------------------------------------------------------");
          //testCreationAboDirect();//nécessite les classes Magazine et Abo fonctionnelles
          System.out.println("------------------------------------------------------");
          //testAjoutAbo();//nécessite les classes Magazine, Abo et Client fonctionnelles sauf méthode listerAbo()
          System.out.println("------------------------------------------------------");
          testTotal(); //nécessite tout !
    }

    private static void testCreationMagazines()
    {
        Magazine m_LeTemps = new Magazine("Le temps week-end", "hebdo");
        System.out.println(m_LeTemps);
        Magazine m_Femina = new Magazine("Femina", "hebdo");
        System.out.println(m_Femina);
        Magazine m_TV8 = new Magazine("TV8", "hebdo");
        System.out.println(m_TV8);
        Magazine m_Bilan = new Magazine("Bilan", "mensuel");
        System.out.println(m_Bilan);
        Magazine m_Moins = new Magazine("Moins!", "bimestriel");
        System.out.println(m_Moins);
        Magazine m_Galaxies = new Magazine("Galaxies", "trimestriel");
        System.out.println(m_Galaxies);
    }

    private static void testCreationClientsSansAbo()
    {
        Client c_122 = new Client(122, "J. Ziegler");
        System.out.println(c_122);
        Client c_215 = new Client(215, "P. Fischer");
        System.out.println(c_215);
        Client c_382 = new Client(382, "J.-F. Thomas");
        System.out.println(c_382);;
    }

    private static void testCreationAboDirect()
    {
        Magazine m_LeTemps = new Magazine("Le temps week-end", "hebdo");
        System.out.println(m_LeTemps);
        Magazine m_Femina = new Magazine("Femina", "hebdo");
        System.out.println(m_Femina);
        Magazine m_TV8 = new Magazine("TV8", "hebdo");
        System.out.println(m_TV8);
        Magazine m_Bilan = new Magazine("Bilan", "mensuel");
        System.out.println(m_Bilan);
        Magazine m_Moins = new Magazine("Moins!", "bimestriel");
        System.out.println(m_Moins);
        Magazine m_Galaxies = new Magazine("Galaxies", "trimestriel");
        System.out.println(m_Galaxies);

        Abo a_TV8 = new Abo(26, 215, m_TV8, 10, 12, 2022, 104);
        System.out.println(a_TV8);
        Abo a_Bilan = new Abo(89, 215, m_Bilan, 7, 6, 2022, 12);
        System.out.println(a_Bilan);

        Abo a_LeTemps = new Abo(12, 122, m_LeTemps, 1, 2, 2022, 52);
        System.out.println(a_LeTemps);
        Abo a_Moins = new Abo(15, 122, m_Moins, 19, 2, 2021, 6);
        System.out.println(a_Moins);

        Abo a_Galaxies = new Abo(12, 382, m_Galaxies, 24, 2, 2023, 4);
        System.out.println(a_Galaxies);
    }

    private static void testAjoutAbo()
    {
        Magazine m_LeTemps = new Magazine("Le temps week-end", "hebdo");
        System.out.println(m_LeTemps);
        Magazine m_Femina = new Magazine("Femina", "hebdo");
        System.out.println(m_Femina);
        Magazine m_TV8 = new Magazine("TV8", "hebdo");
        System.out.println(m_TV8);
        Magazine m_Bilan = new Magazine("Bilan", "mensuel");
        System.out.println(m_Bilan);
        Magazine m_Moins = new Magazine("Moins!", "bimestriel");
        System.out.println(m_Moins);
        Magazine m_Galaxies = new Magazine("Galaxies", "trimestriel");
        System.out.println(m_Galaxies);

        Client c_122 = new Client(122, "J. Ziegler");
        System.out.println(c_122);
        Client c_215 = new Client(215, "P. Fischer");
        System.out.println(c_215);
        Client c_382 = new Client(382, "J.-F. Thomas");
        System.out.println(c_382);;

        c_122.ajouterAbo(12, m_LeTemps, 1, 2, 2022, 52);
        c_122.ajouterAbo(15,  m_Moins, 19, 2, 2021, 6);

        c_382.ajouterAbo(12,  m_Galaxies, 24, 2, 2023, 4);

        c_215.ajouterAbo(26, m_TV8, 10, 12, 2022, 104);
        c_215.ajouterAbo(89, m_Bilan, 7, 6, 2022, 12);

        System.out.println(c_122);
        System.out.println(c_215);
        System.out.println(c_382);
    }

    private static void testTotal()
    {
        Magazine m_LeTemps = new Magazine("Le temps week-end", "hebdo");
        System.out.println(m_LeTemps);
        Magazine m_Femina = new Magazine("Femina", "hebdo");
        System.out.println(m_Femina);
        Magazine m_TV8 = new Magazine("TV8", "hebdo");
        System.out.println(m_TV8);
        Magazine m_Bilan = new Magazine("Bilan", "mensuel");
        System.out.println(m_Bilan);
        Magazine m_Moins = new Magazine("Moins!", "bimestriel");
        System.out.println(m_Moins);
        Magazine m_Galaxies = new Magazine("Galaxies", "trimestriel");
        System.out.println(m_Galaxies);

        System.out.println("-----------------------------------------");

        Client c_122 = new Client(122, "J. Ziegler");
        System.out.println(c_122);
        Client c_215 = new Client(215, "P. Fischer");
        System.out.println(c_215);
        Client c_382 = new Client(382, "J.-F. Thomas");
        System.out.println(c_382);;

        System.out.println("-----------------------------------------");

        c_122.ajouterAbo(12, m_LeTemps, 1, 2, 2022, 52);
        c_122.ajouterAbo(15,  m_Moins, 19, 2, 2021, 6);

        c_382.ajouterAbo(12,  m_Galaxies, 24, 2, 2023, 4);

        c_215 .ajouterAbo(26, m_TV8, 10, 12, 2022, 104);
        c_215.ajouterAbo(89, m_Bilan, 7, 6, 2022, 12);

        System.out.println("-----------------------------------------");

        System.out.println(c_122);
        c_122.afficherDetailsAbo();
        System.out.println("-----------------------------------------");
        System.out.println(c_215);
        c_215.afficherDetailsAbo();
        System.out.println("-----------------------------------------");
        System.out.println(c_382);
        c_382.afficherDetailsAbo();
    }
}
