interface Animal{
    public abstract void run();
}

class Bird implements Animal{
    @Override
    public void run() {
        System.out.println("Animal的bird实现");
    }
}
class Fish implements Animal{

    @Override
    public void run() {
        System.out.println("Animal的Fish实现");
    }
}

public class Test2 {
    public static void main(String[] args) {
        Fish exp1 =new Fish();
        Bird exp2 =new Bird();
        exp1.run();
        exp2.run();
    }
}
