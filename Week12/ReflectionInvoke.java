package Week12;

import java.lang.reflect.*;

public class ReflectionInvoke {

	public static void main(String[] args) {
		String firstWord = "Hello, ";
		String secondWord = "World!";
		String bothWords = append(firstWord, secondWord);
		System.out.println(bothWords);
	}

	public static String append(String firstWord, String secondWord) 
	{
		String result = null;
		try {

			// -- set the runtime class for String
			Class<?> c = String.class;

			// -- set up an argument
			Class<?>[] parameterTypes = new Class<?>[] { String.class };

			Method concatMethod;
			Object[] arguments = new Object[] { secondWord };

			// -- call the concat method on the firstWord String object with the arguments
			// provided
			concatMethod = c.getMethod("concat", parameterTypes);
			result = (String) concatMethod.invoke(firstWord, arguments);
		} 
		catch (NoSuchMethodException e) {
			System.out.println(e);
		} 
		catch (IllegalAccessException e) {
			System.out.println(e);
		} 
		catch (InvocationTargetException e) {
			System.out.println(e);
		}
		return result;
	}
}
