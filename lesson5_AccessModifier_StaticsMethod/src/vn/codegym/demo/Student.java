package vn.codegym.demo;

public class Student {
    private int rollno;
    private String name;
    private static String collage="BBDIT";
    Student(int r,String n){
        rollno=r;
        name=n;
    }
    static void change(){
        collage="CODEGYM";
    }
    void display(){
        System.out.println(rollno+" "+name+" "+collage);
    }
}
