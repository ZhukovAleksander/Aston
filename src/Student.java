import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Student {
    String name;
    String group;
    int course;
    String grades;

    public Student(String name, String group, int course, String grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public String getGrades() {
        return grades;
    }

    public double averageGrade() {
        String[] gradeArray = this.grades.split(", ");
        double sum = 0;
        for (String grade : gradeArray) {
            sum += Integer.parseInt(grade.trim());
        }
        return sum / gradeArray.length;
    }

    public static void removeStudents(ArrayList<Student> students) {
        int i = 0;
        while (i < students.size()) {
            Student student = students.get(i);
            if (student.averageGrade() < 3) {
                students.remove(i);
            } else {
                i++;
            }
        }
    }

    public static void promoteStudents(ArrayList<Student> students) {
        for (Student student : students) {
            if (student.averageGrade() >= 3) {
                student.course++;
            }
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        System.out.println("Студенты " + course + " курса:");
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Студент1", "Группа1", 1, "5, 4, 5"));
        students.add(new Student("Студент2", "Группа2", 2, "4, 3, 5"));
        students.add(new Student("Студент3", "Группа3", 3, "5, 5, 5"));

        removeStudents(students);
        promoteStudents(students);
        Set<Student> studentSet = new HashSet<>(students);
        printStudents(studentSet, 3);
    }
}