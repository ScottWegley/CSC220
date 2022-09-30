package Week5.Week5Assignment;

public class TestFile {

    static LinkedQueue<String> q = new LinkedQueue<String>();
    static LinkedStack<String> s = new LinkedStack<String>();

    public static void main(String[] args) {
        queueTest();
        stackTest();
    }

    public static void stackTest(){
        s.push("mickeymouse");
        s.push("donaldduck");
        s.peek();
        s.pop();
        s.count();
        s.display();
        s.push("tweetybird");
        s.push("bugsbunny");
        s.push("rhodeisland");
        s.peek();
        s.pop();
        s.pop();
        s.count();
        s.display();
        s.push("minniemouse");
        s.push("marvinmartian");
        s.push("elmerfudd");
        s.push("roadrunner");
        s.peek();
        s.pop();
        s.pop();
        s.pop();
        s.count();
        s.display();
        s.push("wileecoyote");
        s.push("mickeymouse");
        s.push("donaldduck");
        s.peek();
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.count();
        s.display();
        while(s.count() != 0){
            s.pop();
        }
    }

    public static void queueTest(){
        q.push("mickeymouse");
        q.push("donaldduck");
        q.peek();
        q.pop();
        System.out.println(q.size());
        q.display();
        q.push("tweetybird", 1);
        q.push("bugsbunny", 1);
        q.push("rhodeislandred");
        q.peek();
        q.pop();
        q.pop();
        System.out.println(q.size());
        q.display();
        q.push("minniemouse",2);
        q.push("marvinmartian",1);
        q.push("elmerfudd");
        q.push("roadrunner");
        q.peek();
        q.pop();
        q.pop();
        q.pop();
        System.out.println(q.size());
        q.display();
        q.push("wileecoyote");
        q.push("mickeymouse", 2);
        q.push("donaldduck");
        q.peek();
        q.pop();
        q.pop();
        q.pop();
        q.pop();
        System.out.println(q.size());
        q.display();
        while(!q.empty()){
            q.pop();
        }
        q.display();
    }
}
