import java.time.LocalDate;

public class Personne {
    private String prenom;
    private String nom;
    private int age;
    private LocalDate dateNaissance;

    public Personne(String prenom, String nom, int age, LocalDate dateNaissance) {
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
        this.dateNaissance = dateNaissance;
    }

    @Override
    public String toString() {
        return "Information de la personne " + prenom + " " + nom + " : " + " | Age : " +
                age + " | Date de naissance : " + dateNaissance;
    }
}
