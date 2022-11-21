package Week12.Examples;

public class Class1 implements Interface {

    public String id = "Class1";

    public Class1() {
        System.out.println("Class 1 constructor");
    }

    public Class1(String id) {
        this.id = id;
    }

    public int ifacefunction(int p) {
        System.out.println("Class 1 Interface Method");
        return 0;
    }

    public void Class1Method() {
        System.out.println("Class 1 Method");
    }

    public String toString() {
        return "toString: " + id;
    }

}
