import java.util.Arrays;

public class ParamPass5 {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2};

        System.out.println("交换前 a:" + Arrays.toString(a));
        swap(a);
        System.out.println("交换后 a:" + Arrays.toString(a));
    }


    public static void swap(int[] a) {
        int temp = a[0];
        a[0] = a[1];
        a[1] = temp;

        System.out.println("方法中 a:" + Arrays.toString(a));
    }
}
