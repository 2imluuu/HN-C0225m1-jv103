package Student;

public class StudentDemo {
    public static void main(String[] args) {
        Student.changce();
        Student s1 = new Student(1,"A");
        Student s2 = new Student(2,"B");
        Student s3 = new Student(3,"C");

        s1.display();
        s2.display();
        s3.display();
    }
}
