/* package Week2.ComplexNumber;

public class TestComplexNumber {

	public static void main(String[] args) {

		ComplexNumber lhs = new ComplexNumber(1, 2);
		ComplexNumber rhs = new ComplexNumber(3, 4);
		
		ComplexNumber result;
		
		result = lhs.add(rhs);
		System.out.println(result);
		
		result = lhs.sub(rhs);
		System.out.println(result);

		result = lhs.mult(rhs);
		System.out.println(result);
		
		result = lhs.div(rhs);
		
		try {
			rhs = new ComplexNumber();
			result = lhs.div(rhs);
		}
		catch (ArithmeticException e) {
			System.out.println(e);
		}
		
		System.out.println(result);
		
		System.out.println(lhs.mag());
		System.out.println(lhs.conj());
		System.out.println(lhs.sqrt());
		System.out.println(lhs.equals(rhs));
		
		rhs.setReal(1);
		rhs.setImag(2);
		System.out.println(lhs.equals(rhs));

		System.out.println(lhs.getReal() + " " + lhs.getImag());
		
	}

} */