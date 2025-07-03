public class Main {
    public static void main(String[] args) {
        Товар[] productsArray = new Товар[5];
        productsArray[0] = new Товар("имя1", "дата1", "производитель1", "страна1", "цена1", "статусКлиента1");
        productsArray[1] = new Товар("имя2", "дата2", "производитель2", "страна2", "цена2", "статусКлиента2");
        productsArray[2] = new Товар("имя3", "дата3", "производитель3", "страна3", "цена3", "статусКлиента3");
        productsArray[3] = new Товар("имя4", "дата4", "производитель4", "страна4", "цена4", "статусКлиента4");
        productsArray[4] = new Товар("имя5", "дата5", "производитель5", "страна5", "цена5", "статусКлиента5");
        for (Товар товар : productsArray) {
            товар.printInfo();
        }
    }
}

class Товар {
    public String name;
    public String date;
    public String manufacturer;
    public String country;
    public String price;
    public String customerStatus;

    /** возможно сделать значения приватными
     * class Товар {
     *     private String name;
     *     private String date;
     *     private String manufacturer;
     *     private String country;
     *     private String price;
     *     private String customerStatus;
     */


    public Товар (String name, String date, String manufacturer, String country, String price, String customerStatus) {
        this.name = name;
        this.date = date;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.customerStatus = customerStatus;
    }

    /** геттеры
     * public String getName() {
     *         return name;
     *     }
     *
     *     public String getDate() {
     *         return date;
     *     }
     *
     *     public String getManufacturer() {
     *         return manufacturer;
     *     }
     * public String getCountry() {
     *         return country;
     *     }
     *
     *     public double getPrice() {
     *         return price;
     *     }
     *
     *     public boolean isReserved() {
     *         return isReserved;
     *     }
     */

    public void printInfo() {
        System.out.println(name + " " + date + " " + manufacturer + " " + country + " " + price + " " + customerStatus);
    }
}