import java.util.Arrays;

public class ParamPass6 {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2};

        System.out.println("改变前 a:" + Arrays.toString(a));
        change(a);
        System.out.println("改变后 a:" + Arrays.toString(a));
    }


    public static void change(int[] a) {
        a = new int[]{3, 4};

        System.out.println("方法中 a:" + Arrays.toString(a));
    }
}
