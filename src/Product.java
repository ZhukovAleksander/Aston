class Product {
    private String name;
    private String productionDate;
    private String manufacturer;
    private String country;
    private double price;
    private boolean isReserved;

    public Product(String name, String productionDate, String manufacturer,
                   String country, double price, boolean isReserved) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.isReserved = isReserved;
    }

    public String getName() {
        return name;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getCountry() {
        return country;
    }

    public double getPrice() {
        return price;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void printInfo() {
        System.out.println("Название: " + getName());
        System.out.println("Дата производства: " + getProductionDate());
        System.out.println("Производитель: " + getManufacturer());
        System.out.println("Страна происхождения: " + getCountry());
        System.out.println("Цена: " + getPrice() + " руб.");
        System.out.println("Забронирован: " + (isReserved() ? "Да" : "Нет"));
        System.out.println();
    }
}