package Week5.Week5Assignment.MySolution;

public class TestFile {

    static LinkedQueue<String> m = new LinkedQueue<String>();

    public static void main(String[] args) {
        
    }

    public void queueTest(){
        m.push("mickeymouse");
        m.push("donaldduck");
        m.peek();
        m.pop();
        System.out.println(m.size());
        m.display();
        m.push("tweetybird", 1);
        m.push("bugsbunny", 1);
        m.push("rhodeislandred");
        m.peek();
        m.pop();
        m.pop();
        System.out.println(m.size());
        m.display();
        m.push("minniemouse",2);
        m.push("marvinmartian",1);
        m.push("elmerfudd");
        m.push("roadrunner");
        m.peek();
        m.pop();
        m.pop();
        m.pop();
        System.out.println(m.size());
        m.display();
        m.push("wileecoyote");
        m.push("mickeymouse", 2);
        m.push("donaldduck");
        m.peek();
        m.pop();
        m.pop();
        m.pop();
        m.pop();
        System.out.println(m.size());
        m.display();
        while(!m.empty()){
            m.pop();
        }
        m.display();
    }
}
