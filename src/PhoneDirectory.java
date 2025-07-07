import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneDirectory {
    public Map<String, List<String>> directory;

    public PhoneDirectory() {
        directory = new HashMap<>();
    }

    public void add(String secondName, String phone) {
        if (!directory.containsKey(secondName)) {
            directory.put(secondName, new ArrayList<>());
        }
        directory.get(secondName).add(phone);
    }

    public List<String> get(String secondName) {
        return directory.getOrDefault(secondName, new ArrayList<>());
    }

    public static void main(String[] args) {
        PhoneDirectory phoneBook = new PhoneDirectory();

        phoneBook.add("Иванов", "123-456");
        phoneBook.add("Петров", "789-012");
        phoneBook.add("Сидоров", "555-123");
        phoneBook.add("Иванов", "999-999");

        System.out.println("Иванов: " + phoneBook.get("Иванов"));
        System.out.println("Петров: " + phoneBook.get("Петров"));
        System.out.println("Сидоров: " + phoneBook.get("Сидоров"));
        System.out.println("Кузнецов: " + phoneBook.get("Кузнецов"));
    }
}