/*********************/
// LOIC AGOSTA
//
/*********************/

public class Coord {
    int x;
    int y;

    Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    int distanceAvec(Coord autrePosition) {
            return Math.abs(x-autrePosition.x)+Math.abs(y-autrePosition.y);
    }

    public String toString() {
        return "("+x+", "+y+")";
    }
}
