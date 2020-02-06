public class ParamPass4 {

    public static void main(String[] args) {
        Person a = new Person("张三");
        Person b = new Person("李四");

        System.out.println("交换前 a:" + a + " b:" + b);
        swap(a, b);
        System.out.println("交换后 a:" + a + " b:" + b);
    }


    public static void swap(Person a, Person b) {
        Person temp = a;
        a = b;
        b = temp;

        System.out.println("方法中 a:" + a + " b:" + b);
    }
}
