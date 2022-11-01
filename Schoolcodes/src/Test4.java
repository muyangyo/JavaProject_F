interface Dadlikedo {
    abstract void ride();

    abstract void basketball();
}

interface Momlikedo {
    abstract void sing();

    abstract void dance();
}

class Sonlikedo implements Dadlikedo, Momlikedo {

    @Override
    public void sing() {
        System.out.println("son喜欢唱歌");
    }

    @Override
    public void dance() {
        System.out.println("son喜欢跳舞");
    }

    @Override
    public void ride() {
        System.out.println("son喜欢骑车");
    }

    @Override
    public void basketball() {
        System.out.println("son喜欢篮球");
    }
}

public class Test4 {
    public static void main(String[] args) {
        Sonlikedo exp1 =new Sonlikedo();
        exp1.sing();
        exp1.dance();
        exp1.ride();
        exp1.basketball();
    }
}
