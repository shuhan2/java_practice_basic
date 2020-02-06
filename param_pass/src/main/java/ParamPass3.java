import java.util.Arrays;

public class ParamPass3 {

    public static void main(String[] args) {
        int[] a = new int[]{1};
        int[] b = new int[]{2};

        System.out.println("交换前 a:" + Arrays.toString(a) + " b:" + Arrays.toString(b));
        swap(a, b);
        System.out.println("交换后 a:" + Arrays.toString(a) + " b:" + Arrays.toString(b));
    }


    public static void swap(int[] a, int[] b) {
        int[] temp = a;
        a = b;
        b = temp;

        System.out.println("方法中 a:" + Arrays.toString(a) + " b:" + Arrays.toString(b));
    }
}
