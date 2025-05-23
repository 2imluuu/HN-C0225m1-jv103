public class Demo {
    public static void main(String[] args) {
        System.out.println(add(10,10));
        System.out.println(sub(10,10));
        System.out.println(div(10,10));
        System.out.println(mul(10,10));
    };
    public static int add(int a, int b){
        return a+b;
    }
    public static int sub(int a, int b){
        return a-b;
    }
    public static int div(int a, int b){
        return a/b;
    }
    public static int mul(int a, int b){
        return a*b;
    }
}
