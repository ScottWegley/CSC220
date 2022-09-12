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
        double outReal = (this.realNum * rhs.getReal() + this.getImag() * rhs.getImag())/(rhs.getReal()*rhs.getReal() + rhs.getImag() * rhs.getImag());
        double outImag = (this.iNum * rhs.getReal() - this.realNum * rhs.getImag())/(rhs.getReal()*rhs.getReal() + rhs.getImag() * rhs.getImag());
        return new ComplexNumber(outReal, outImag);
    }

    public double mag() {
        return Math.sqrt(this.realNum * this.realNum + this.iNum * this.iNum);
    }

    public ComplexNumber conj() {
        return new ComplexNumber(this.realNum, -this.iNum);
    }

    public ComplexNumber sqrt() {
        if(this.iNum == 0){
            if(this.realNum < 0){
                return new ComplexNumber(0, Math.sqrt(-this.realNum));
            } else {
                return new ComplexNumber(Math.sqrt(this.realNum), 0);
            }
        } else {
            double outReal = (Math.sqrt((this.realNum + Math.sqrt(this.realNum*this.realNum + this.iNum*this.iNum))/2));
            double outImag = (Math.sqrt((-this.realNum + Math.sqrt(this.realNum*this.realNum + this.iNum*this.iNum))/2));
            return new ComplexNumber();
        }
    }

    public static void main(String[] args) {
        ComplexNumber testOne = new ComplexNumber(4,3);
        ComplexNumber testTwo = new ComplexNumber(1,2);
        System.out.println(testOne.conj() + " " + testOne.mag());
    }
}
