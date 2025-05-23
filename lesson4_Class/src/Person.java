public class Person {
    String name;
    int age;
    String speak(){
        return " hello ";
    }
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public Person(){};

    public Person(String name){
        this.name = name;
    }
}
