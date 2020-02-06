public class ParamPass0 {

    public static void main(String[] args) {
        int a = 1;

        System.out.println("改变前 a:" + a);
        change(a);
        System.out.println("改变后 a:" + a);
    }


    public static void change(int a) {
        a = 2;
        System.out.println("方法中 a:" + a);
    }
}
