
public class Main {
    public static void main(String[] args) {
        Park park = new Park();

        Park.Attraction attraction1 = park.new Attraction("Аттракцион 1", "10:00-22:00", 500);
        Park.Attraction attraction2 = park.new Attraction("Аттракцион 2", "12:00-22:00", 800);
        Park.Attraction attraction3 = park.new Attraction("Аттракцион 3", "13:00-22:00", 300);

        attraction1.printInfo();
        attraction2.printInfo();
        attraction3.printInfo();
    }
}