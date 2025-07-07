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

class Bowl {
    private int foodAmount;

    public Bowl(int initialFood) {
        this.foodAmount = Math.max(initialFood, 0);
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("В миску добавили " + amount + " единиц еды");
        }
    }

    public boolean decreaseFood(int amount) {
        if (amount <= 0) return false;
        if (foodAmount >= amount) {
            foodAmount -= amount;
            return true;
        }
        return false;
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}

class Cat extends Animal {
    private static int catCount = 0;
    private boolean isFed;

    public Cat(String name) {
        super(name, 200, 0, false);
        this.isFed = false;
        catCount++;
    }

    public void eat(Bowl bowl, int amount) {
        if (bowl.decreaseFood(amount)) {
            isFed = true;
            System.out.println(getName() + " поел " + amount + " единиц еды");
        } else {
            System.out.println(getName() + " не смог поесть, в миске недостаточно еды");
        }
    }

    public boolean isFed() {
        return isFed;
    }

    public static int getCatCount() {
        return catCount;
    }
}

class Dog extends Animal {
    private static int dogCount = 0;

    public Dog(String name) {
        super(name, 500, 10, true);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }
}

public class Main {
    public static void main(String[] args) {
        Bowl bowl = new Bowl(30);
        Cat[] cats = {
                new Cat("Барсик"),
                new Cat("Мурзик"),
                new Cat("Рыжик"),
                new Cat("Васька")
        };

        System.out.println("Еды в миске: " + bowl.getFoodAmount());

        // Кормим всех котов
        for (Cat cat : cats) {
            cat.eat(bowl, 10);
        }

        System.out.println("\nСостояние сытости котов:");
        for (Cat cat : cats) {
            System.out.println(cat.getName() + ": " + (cat.isFed() ? "сыт" : "голоден"));
        }

        System.out.println("\nОстаток еды в миске: " + bowl.getFoodAmount());

        bowl.addFood(20);
        cats[3].eat(bowl, 10);
        System.out.println(cats[3].getName() + " теперь " +
                (cats[3].isFed() ? "сыт" : "голоден"));
    }
}