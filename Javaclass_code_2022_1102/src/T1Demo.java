/**
 * 创建于 IntelliJ IDEA.
 * 描述：
 * User: DR
 * Date: 2022-11-02
 * Time: 18:14
 */
class Person {
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

    //静态成员方法
    public static void Inf_Static_Person(Person x) {
        System.out.println("姓名：" + x.name);
        System.out.println("年龄：" + x.age);
    }

}

public class T1Demo {
    public static void main(String[] args) {
        //初始化
        Person exp1 = new Person();
        exp1.name = "张三";
        exp1.age = 18;
        //普通成员变量调用普通方法
        exp1.Inf_Person();
        //同指对象
        Person exp2 = exp1;
        exp2.Inf_Person();

        //普通成员变量调用静态方法只能传参
        Person.Inf_Static_Person(exp1);
    }
}

