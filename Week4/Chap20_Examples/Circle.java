package Week4.Chap20_Examples;

public class Circle extends GeometricObject{

    private int _r;

    public Circle(int i) {
        _r = i;
    }

    @Override
    public double getArea() {
        return Math.PI * _r * _r;
    }

}
