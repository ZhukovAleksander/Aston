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