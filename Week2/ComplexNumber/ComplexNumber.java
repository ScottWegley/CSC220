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

    public void setReal(double r){
        realNum = r;
    }

    public void setImag(double i){
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

    public static void main(String[] args) {
        ComplexNumber test = new ComplexNumber();
        System.out.println(test.toString());
    }
}
