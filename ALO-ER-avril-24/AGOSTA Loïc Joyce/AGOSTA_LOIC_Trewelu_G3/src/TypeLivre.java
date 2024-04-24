/*********************/
// LOIC AGOSTA
//
/*********************/

public class TypeLivre {
    private String libelleType;
    private double ratioLecture;

    public TypeLivre(String libelleType, double ratioLecture) {
        this.libelleType = libelleType;
        this.ratioLecture = ratioLecture;
    }

    public String getLibelleType() {
        return libelleType;
    }

    public double getRatioLecture() {
        return ratioLecture;
    }

    @Override
    public String toString() {
        return this.libelleType + this.ratioLecture;
    }
}
