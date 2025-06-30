package ArraysList;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> ml = new MyList<>(10);

        ml.add(1);
        ml.add(2);
        ml.add(3);
        ml.add(4);
        System.out.println(ml.get(2));

        ml.add(1,5);
    }
}
