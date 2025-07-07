public class Main {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("имя1", "дата1", "производитель1", "страна1", 1, true);
        productsArray[1] = new Product("имя2", "дата2", "производитель2", "страна2", 2, true);
        productsArray[2] = new Product("имя3", "дата3", "производитель3", "страна3", 3, false);
        productsArray[3] = new Product("имя4", "дата4", "производитель4", "страна4", 4, false);
        productsArray[4] = new Product("имя5", "дата5", "производитель5", "страна5", 5, false);

        for (int i = 0; i < productsArray.length; i++) {
            productsArray[i].printInfo();
        }
    }
}