package vn.codegym.demo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Student s1 = new Student(1,"Hoang");
        Student s2 = new Student(2,"Duc");
        Student s3 = new Student(3,"Khanh");
        s1.display();
        s2.display();
        s3.display();

        Student.change();

        s1.display();
        s2.display();
        s3.display();
    }
}