/* package Week5.Week5Assignment.Solution;

package LinkedList;

import Week4.Chap24.MyLinkedList;
import Week5.Ch25.HuffmanCode.Tree.Node;

public class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Integer> l = new MyLinkedList<Integer>();

        for (int i = 0; i < 3; ++i) {
            l.addFront(new Node<Integer>(i));
        }
        System.out.println(l);

        System.out.println("====");
        for (int i = 0; i < 3; ++i) {
            l.addBack(new Node<Integer>(i));
        }
        System.out.println(l);
        System.out.println("====");

        l.addLoc(new Node<Integer>(-1), -1);
        System.out.println(l);
        System.out.println("====");

        l.addLoc(new Node<Integer>(l.getSize() + 1), l.getSize() + 1);
        System.out.println(l);
        System.out.println("====");

        l.addLoc(new Node<Integer>(l.getSize() / 2), l.getSize() / 2);
        System.out.println(l);
        System.out.println("====");

        l.removeFront();
        System.out.println(l);
        System.out.println("====");

        l.removeBack();
        System.out.println(l);
        System.out.println("====");

        l.removeLoc(3);
        System.out.println(l);
        System.out.println("====");

        l = new MyLinkedList<Integer>();
        l.addFront(new Node<Integer>(1));
        l.removeFront();
        l.addFront(new Node<Integer>(1));
        l.removeBack();
        l.addFront(new Node<Integer>(1));
        l.addBack(new Node<Integer>(2));
        l.addBack(new Node<Integer>(3));
        System.out.println(l);
        System.out.println("====");
        l.removeLoc(2);
        System.out.println(l);
        System.out.println("====");

        l.addFront(new Node<Integer>(5));
        System.out.println(l);
        System.out.println("====");

        for (int i = 0; i < l.getSize(); ++i) {
            System.out.println("Node: " + l.getLoc(i));
        }
        System.out.println("Node: " + l.getFront());
        System.out.println("Node: " + l.getBack());

    }

} */