import java.util.Scanner;
/**
 * 创建于 IntelliJ IDEA.
 * 描述：
 * User: DR
 * Date: 2022-12-02
 * Time: 20:04
 */
public class Arithmetic_1 {
    //以下为求最小公倍数和最小公约数的算法
    public static void main(String[] args) {
        long a, b;//两个数
        Scanner e1 = new Scanner(System.in);
        System.out.println("请输入两个数字:");
        a = e1.nextInt();
        b = e1.nextInt();

        long max_gy = 0; //最大公约数
        long min_gb = 0; //最小公倍数

        long fz = a;//分子
        long fm = b;//分母
        long yu = 0;
        //先求最小公约数
        while ((yu = fz % fm) != 0) {
            fz = fm;
            fm = yu;
        }
        max_gy = fm;
        min_gb = (a * b) / max_gy;
        System.out.println("最小的公倍数为:" + min_gb);
        System.out.println("最大的公约数为:" + max_gy);
    }
}
