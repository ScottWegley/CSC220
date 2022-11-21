package Week12;

import java.awt.Rectangle;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

// -- Reflection demonstration
//    Reflection is commonly used by programs which require the ability to examine or modify the runtime behavior 
//    of applications running in the Java virtual machine. This is a relatively advanced feature and should be used 
//    only by developers who have a strong grasp of the fundamentals of the language. With that caveat in mind, 
//    reflection is a powerful technique and can enable applications to perform operations which would otherwise be impossible.
public class ReflectionDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        try {
            // -- get the class to be instantiated
            // must supply the fully qualified (with package) class name
            System.out.print("Class to reflect: ");
            String classtoreflect = kb.next();

            // -- construct an object for test purposes only
            // Rectangle r = new Rectangle();

            // -- get the runtime class from the object
            // the Class<?> allows us to no have to cast (since we don't know what we're
            // casting)
            // Class<?> cn = r.getClass();

            System.out.println("Classname");
            System.out.println("=========");

            // -- get the name of the class
            // String clname = cn.getName(); // -- can get the name of an instantiated
            // object too
            String clname = classtoreflect;
            // -- get the class descriptor for the class named in clname (same as
            // Object.getClass())
            // note that the Class<?>.toString method puts the word "class " or "interface "
            // in front of the class name
            Class<?> c = Class.forName(clname);
            System.out.println(c);

            // -- get class access modifiers
            System.out.println("Access Modifiers");
            System.out.println("================");
            int m = c.getModifiers();
            if (Modifier.isPublic(m))
                System.out.println("\tpublic");
            if (Modifier.isAbstract(m))
                System.out.println("\tabstract");
            if (Modifier.isFinal(m))
                System.out.println("\tfinal");

            // -- get inheritance structure
            System.out.println("Inheritance Tree");
            System.out.println("================");
            Class<?> subclass = c;
            Class<?> superclass = subclass.getSuperclass();
            while (superclass != null) {
                String className = superclass.getName();
                System.out.println("\t" + className);
                subclass = superclass;
                superclass = subclass.getSuperclass();
            }

            // -- get interfaces implemented
            System.out.println("Interfaces Implemented");
            System.out.println("================");
            Class<?>[] ifaces = c.getInterfaces();
            for (Class<?> i : ifaces) {
                System.out.println("\t" + i.getName());
            }

            // -- get member variables
            System.out.println("Member Variables");
            System.out.println("================");
            Field[] publicFields = c.getFields();
            for (int i = 0; i < publicFields.length; i++) {
                String fieldName = publicFields[i].getName();
                Class<?> typeClass = publicFields[i].getType();
                String fieldType = typeClass.getName();
                System.out.println("\tName: " + fieldName + ", Type: " + fieldType);
            }

            // -- get constructors
            System.out.println("Class Constructors");
            System.out.println("==================");
            Constructor<?>[] theConstructors = c.getConstructors();
            for (int i = 0; i < theConstructors.length; i++) {
                System.out.print("\t" + c.getName() + "( ");
                Class<?>[] parameterTypes = theConstructors[i].getParameterTypes();
                for (int k = 0; k < parameterTypes.length; k++) {
                    String parameterString = parameterTypes[k].getName();
                    System.out.print(parameterString + " ");
                }
                System.out.println(")");
            }

            // -- get method information
            System.out.println("Class Methods");
            System.out.println("=============");
            Method[] theMethods = c.getMethods();
            for (int i = 0; i < theMethods.length; i++) {
                String methodString = theMethods[i].getName();
                System.out.println("\tName: " + methodString);
                String returnString = theMethods[i].getReturnType().getName();
                System.out.println("\t\tReturn Type: " + returnString);
                Class<?>[] parameterTypes = theMethods[i].getParameterTypes();
                System.out.print("\t\tParameter Types:");
                for (int k = 0; k < parameterTypes.length; k++) {
                    String parameterString = parameterTypes[k].getName();
                    System.out.print(" " + parameterString);
                }
                System.out.println();
            }

        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}