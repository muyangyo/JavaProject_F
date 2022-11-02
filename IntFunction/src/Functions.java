/**
 * 创建于 IntelliJ IDEA.
 * 描述：
 * User: DR
 * Date: 2022-11-02
 * Time: 18:22
 */
public class Functions {
    //全部小写函数
    public static void charlow_print(String x) {
        System.out.println(x.toLowerCase());
    }

    //整形数组打印函数
    public static void print(int[] arr)  //可能这里的传参不规范，如果以后划掉了就是错的
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
    }
}
