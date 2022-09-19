package Week4.Chap20_Examples;

public class Rectangle extends GeometricObject{

    private int _w, _l;

    public Rectangle(int i, int j) {
        _l = i;
        _w = j;
    }

    @Override
    public double getArea() {
        return _l * _w;
    }

}
