public class Arret
{
    private String nomArret;
    private String nomZone;
    private int dureeVersSud, dureeVersNord;

    public String getNomArret()
    {
        return nomArret;
    }

    public String getNomZone()
    {
        return nomZone;
    }

    public int getDureeVersSud()
    {
        return dureeVersSud;
    }

    public int getDureeVersNord()
    {
        return dureeVersNord;
    }

    public Arret(String nomArret, String nomZone, int dureeVersSud, int dureeVersNord)
    {
        this.nomArret = nomArret;
        this.nomZone = nomZone;
        this.dureeVersSud = dureeVersSud;
        this.dureeVersNord = dureeVersNord;
    }

    @Override
    public String toString()
    {
        return "L'arrêt "+ nomArret +" est dans la zone " + nomZone;
    }
}
