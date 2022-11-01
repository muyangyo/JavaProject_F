abstract class Shape {
    abstract double getArea();

    abstract double getPerimeter();
}

class Rectangle extends Shape {
    int longth;
    int wide;

    Rectangle(int l, int w) {
        this.longth = l;
        this.wide = w;
    }

    @Override
    double getArea() {
        return this.longth * this.wide;

    }

    @Override
    double getPerimeter() {
        return (this.wide * 2 + this.longth * 2);
    }
}

class Circle extends Shape {
    int r;

    Circle(int x) {
        this.r = x;
    }

    @Override
    double getArea() {
        return this.r * this.r * Math.PI;
    }

    @Override
    double getPerimeter() {
        return 2 * Math.PI * this.r;
    }
}

public class Test3 {
    public static void main(String[] args) {
        Rectangle exp1 =new Rectangle(3,2);
        System.out.println(exp1.getArea());
        System.out.println(exp1.getPerimeter());

        Circle exp2 =new Circle(6);
        System.out.println(exp2.getArea());
        System.out.println(exp2.getPerimeter());
    }
}
