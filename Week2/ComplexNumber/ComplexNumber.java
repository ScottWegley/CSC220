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

    public ComplexNumber mult(ComplexNumber rhs) {
        return new ComplexNumber(rhs.getReal() * this.realNum, rhs.getImag() * this.iNum);
    }

    public ComplexNumber div(ComplexNumber rhs) throws ArithmeticException{
        if(rhs.getReal() == 0 && rhs.getImag() == 0) {
            throw new ArithmeticException("Denominator cannot equal 0");
        }
        return new ComplexNumber((this.realNum * rhs.getReal() + this.getImag() * rhs.getImag())/(rhs.getReal()*rhs.getReal() + rhs.getImag() * rhs.getImag()),(this.iNum * rhs.getReal() - this.realNum * rhs.getImag())/(rhs.getReal()*rhs.getReal() + rhs.getImag() * rhs.getImag()));
    }

    public static void main(String[] args) {
        ComplexNumber testOne = new ComplexNumber(2,3);
        ComplexNumber testTwo = new ComplexNumber(4,5);
        System.out.println(testOne.mult(testTwo));
    }
}
