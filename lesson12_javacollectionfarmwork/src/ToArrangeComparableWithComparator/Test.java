package ToArrangeComparableWithComparator;

import  java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class Test {
    public static void main(String[] args) {
        Student student1 = new Student("A",12,"HN");
        Student student2 = new Student("B",23,"BG");
        Student student3 = new Student("C",11,"BV");
        Student student4 = new Student("D",15,"SG");

        List<Student> list = new ArrayList<Student>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        Collections.sort(list);

        for(Student student : list){
            System.out.println(student.toString());
        }

        AgeComparator ageComparator = new AgeComparator();
        Collections.sort(list,ageComparator);
        System.out.printf("so sanh tuoi: ");
        System.out.println();
        for(Student student : list){
            System.out.println(student.toString());
        }
    }
}
