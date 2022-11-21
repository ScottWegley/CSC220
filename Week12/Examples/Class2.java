package Week12.Examples;

public class Class2 implements Interface {

	public String id = "Class2";
	
	public Class2 ()
	{
		System.out.println("Class 2 constructor");
	}
	
	public Class2 (String id)
	{
		this.id = id;
	}
	
	public int ifacefunction(int p) {
		System.out.println("Class 2 Interface Method");
		return 0;
	}


	public void Class2Method ()
	{
		System.out.println("Class 2 Method");
	}
	
	public String toString()
	{
		return "toString: " + id;
	}

}
