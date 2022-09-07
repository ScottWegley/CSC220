package Week2.ComplexNumber;

public class ComplexNumber {

    private double realNum, iNum;

    public ComplexNumber() {
        realNum = 0;
        iNum = 0;
    }

    public ComplexNumber(double _r, double _i) {
        realNum = _r;
        iNum = _i;
    }

    public ComplexNumber(ComplexNumber rhs) {
        realNum = rhs.getReal();
        iNum = rhs.getImag();
    }

    public void setReal(double r) {
        realNum = r;
    }

    public void setImag(double i) {
        iNum = i;
    }

    public double getReal() {
        return realNum;
    }

    public double getImag() {
        return iNum;
    }

    public String toString() {
        return realNum + ((iNum < 0) ? (" - " + Math.abs(iNum)) : (" + " + iNum)) + "i";
    }

    public ComplexNumber add(ComplexNumber rhs) {
        return new ComplexNumber(this.realNum + rhs.getReal(), this.iNum + rhs.getImag());
    }

    public ComplexNumber sub(ComplexNumber rhs) {
        return new ComplexNumber(this.realNum - rhs.getReal(), this.iNum - rhs.getImag());
    }

    public static void main(String[] args) {
        ComplexNumber test = new ComplexNumber(1, -1);
        System.out.println(test.toString());
    }
}
