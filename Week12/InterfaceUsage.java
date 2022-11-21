package Week12;

public class InterfaceUsage {

    public static void main(String[] args) {
        // -- instantiate some objects
        Class1 c1 = new Class1();
        Class2 c2 = new Class2();

        // -- note that this is illegal
        // Interface i = new Interface();

        // -- call some methods on the objects
        c1.ifacefunction(0);
        c2.ifacefunction(0);
        c1.Class1Method();
        c2.Class2Method();

        Interface iface;

        iface = c1;
        iface.ifacefunction(0);

        // -- can't do this because the iface interface is
        // not aware of the class method
        // iface.Class1Method();

        iface = c2;
        iface.ifacefunction(0);

        // -- can't do this because the iface interface is
        // not aware of the class method
        // iface.Class2Method();

        // -- to access the class methods from the iface interface
        // we must cast to the appropriate class. To cast to the
        // appropriate class we must know the appropriate class.
        // The instanceof operator provide this information
        iface = c1;

        // -- legal syntax but causes a runtime error -- don't do blind casting
        // ((Class2)iface).Class2Method();

        if (iface instanceof Class1) {
            ((Class1) iface).Class1Method();
        } else if (iface instanceof Class2) {
            ((Class2) iface).Class2Method();
        }

        iface = c2;
        if (iface instanceof Class1) {
            ((Class1) iface).Class1Method();
        } else if (iface instanceof Class2) {
            ((Class2) iface).Class2Method();
        }

    }
}
