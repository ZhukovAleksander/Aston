abstract class Animal {
    private String name;
    private int maxRunDist;
    private int maxSwimDist;
    private boolean canSwim;

    private static int animalCount = 0;

    public Animal(String name, int maxRunDist, int maxSwimDist, boolean canSwim) {
        this.name = name;
        this.maxRunDist = maxRunDist;
        this.maxSwimDist = maxSwimDist;
        this.canSwim = canSwim;
        animalCount++;
    }

    public void run(int distance) {
        if (distance <= maxRunDist) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }

    public void swim(int distance) {
        if (!canSwim) {
            System.out.println(name + " не умеет плавать");
            return;
        }

        if (distance <= maxSwimDist) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не может проплыть " + distance + " м.");
        }
    }

    public String getName() {
        return name;
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}