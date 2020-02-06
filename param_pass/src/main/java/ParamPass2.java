public class ParamPass2 {

    public static void main(String[] args) {
        int a = 1;
        int b = 2;

        System.out.println("交换前 a:" + a + " b:" + b);
        swap(a, b);
        System.out.println("交换后 a:" + a + " b:" + b);
    }


    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;

        System.out.println("方法中 a:" + a + " b:" + b);
    }
}
