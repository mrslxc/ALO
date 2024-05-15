public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");

        Mouettes mouettes1 = new Mouettes(45, 80000, 50);
        Mouettes mouettes2 = new Mouettes(62, 85000, 60);

        Tram tram1 = new Tram(90, 640000, true, 6);
        Tram tram2 = new Tram(80, 430000, false, 4);

        System.out.println(mouettes1);
        System.out.println(mouettes2);
        System.out.println(tram1);
        System.out.println(tram2);

    }
}