/**
 * 创建于 IntelliJ IDEA.
 * 描述：
 * User: DR
 * Date: 2022-11-04
 * Time: 10:48
 */
class Person {
    //普通成员变量（类似结构体成员变量）
    public String name;
    public int age;
    //静态成员变量
    public static int id;

    //构造代码块
    {
        age = 100;
        System.out.println("age = " + age + "\n" + "构造代码块");
        System.out.println("=================================");
    }

    //静态代码块
    static {
        id = 10;//只能访问静态数据成员
        System.out.println("id = " + id + "\n" + "静态代码块");
        System.out.println("=================================");
    }

    //普通成员方法
    public void Inf_Person() {
        System.out.println("姓名：" + this.name);
        System.out.println("年龄：" + this.age);
    }
}

public class T2Demo {
    public static void main(String[] args) {
        { //直接使用{}定义，普通方法块
            int x = 10;
            System.out.println("x1 = " + x);
        }
        int x = 100;
        System.out.println("x2 = " + x);
        System.out.println("=================================");

        Person exp1 = new Person();
        System.out.println(exp1);
        System.out.println("                                 ");

        Person exp2 = new Person();
        System.out.println(exp2);
    }
}
