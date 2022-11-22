import java.util.Arrays;
import java.util.Scanner;

/**
 * 创建于 IntelliJ IDEA.
 * 描述：
 * User: DR
 * Date: 2022-11-22
 * Time: 21:34
 */
public class IntArrStruct {
    int usedsize = 0;
    int size = 5;
    int[] arr = {0, 0, 0, 0, 0};

    public void myint_toString() {
        for (int i = 0; i < usedsize; i++) {
            if (arr[i] != 0) {
                System.out.printf("%d ", arr[i]);
            }
        }
        System.out.println();
    }

    public static void pos_add(IntArrStruct exp1, int x) {

        System.out.println();
        System.out.printf("请输入位置:");
        ;
        int pos = 0;
        Scanner temp = new Scanner(System.in);
        pos = temp.nextInt();
        System.out.println();

        if (pos < 0 || pos >= exp1.usedsize) {
            System.out.println("请输入有效地址!");
            pos_add(exp1, x);
        }
        if (exp1.usedsize == exp1.size) {
            exp1.isfull(exp1);
        }
        for (int i = exp1.usedsize - 1; i >= pos; i--) {
            exp1.arr[i + 1] = exp1.arr[i];
        }
        exp1.arr[pos] = x;
        exp1.usedsize++;
    }

    public static void add(IntArrStruct exp1, int x) {
        if (exp1.usedsize == exp1.size) {
            exp1.isfull(exp1);
        }
        exp1.arr[exp1.usedsize] = x;
        exp1.usedsize++;
    }

    private void isfull(IntArrStruct exp1) {
        size = size + 5;
        exp1.arr = Arrays.copyOf(exp1.arr, size);
    }

    private void intsize_toString() {
        System.out.println("arr=" + Arrays.toString(arr));
        System.out.printf("sub=[");
        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                System.out.printf("%d, ", i);
            } else {
                System.out.printf("%d]\n",i);
            }
        }
    }

    //保留为内部调试用
    public static void main(String[] args) {
        IntArrStruct e1 = new IntArrStruct();
        add(e1, 1);
        add(e1, 2);
        add(e1, 3);
        add(e1, 4);
        add(e1, 5);
        pos_add(e1, 8);
        //intarr数组打印(仅使用的)
        e1.myint_toString();
        //intarr全长打印(无论使用与否)
        e1.intsize_toString();

    }


}
