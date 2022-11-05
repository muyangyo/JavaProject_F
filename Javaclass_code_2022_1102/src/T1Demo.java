/**
 * 创建于 IntelliJ IDEA.
 * 描述：
 * User: DR
 * Date: 2022-11-02
 * Time: 18:14
 */
class Person1 {
    public Person1() {
        this("小张", 18);
        System.out.println("无参数构造方法");
        System.out.println("==============");
    }

    public Person1(String na, int y) {
        this.name = na;
        this.age = y;
        System.out.println("双参数构造方法");
        System.out.println("==============");
    }

    //普通成员变量（类似结构体成员变量）
    public String name;
    public int age;

    //静态成员变量
    public static int id;

    //普通成员方法
    public void Inf_Person() {
        System.out.println("姓名：" + this.name);
        System.out.println("年龄：" + this.age);
    }

    public void Print() {
        this.Inf_Person();
    }

    //静态成员方法
    public static void Inf_Static_Person(Person x) {
        System.out.println("姓名：" + x.name);
        System.out.println("年龄：" + x.age);
    }

}

public class T1Demo {
    public static void main1(String[] args) {
        Person1 exp1 = new Person1();
        exp1.Print();
    }
}

