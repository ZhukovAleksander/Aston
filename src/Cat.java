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