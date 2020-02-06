import java.util.Arrays;

public class ParamPass6 {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2};

        System.out.println("交换前 a:" + Arrays.toString(a));
        swap(a);
        System.out.println("交换后 a:" + Arrays.toString(a));
    }


    public static void swap(int[] a) {
        a = new int[]{3, 4};

        System.out.println("方法中 a:" + Arrays.toString(a));
    }
}
