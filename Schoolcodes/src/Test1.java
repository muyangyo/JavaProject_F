import java.util.Scanner;

interface Show_ans {
    abstract void add(int a, int b);

    abstract void sub(int a, int b);

    abstract void mul(int a, int b);

    abstract void div(int a, int b);
}

class Compute implements Show_ans {

    @Override
    public void add(int a, int b) {
        System.out.println("加法:"+(a + b));
    }

    @Override
    public void sub(int a, int b) {
        System.out.println("减法:"+(a - b));
    }

    @Override
    public void mul(int a, int b) {
        System.out.println("乘法:"+(a * b));
    }

    @Override
    public void div(int a, int b) {
        System.out.println("除法:"+(a / b));
    }
}

public class Test1 {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        Compute com = new Compute();
        com.add(a, b);
        com.sub(a, b);
        com.mul(a, b);
        com.div(a, b);
    }
}
