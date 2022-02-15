
class First{
    int a;
    Second s;

    class Second{
        int b;
        Second(){
            System.out.println("2nd constructor");
        }
        void display(){
            System.out.println("2nd class");
        }
    }
    Second createObjSecond(){
        return new Second();
    }
    static class Third{
        void display(){
            System.out.println("3rd class");
        }
    }
    void display(){
        System.out.println("1st class");
    }
}
public class InnerClass {
    public static void main(String[] args) {
        First f = new First();
        //System.out.println(f.a);
        
        f.s = f.createObjSecond();
        f.s.display();
        First.Second sObj = f.new Second();
        sObj.display();
        //due to being static class
        First.Third thirdObj = new First.Third();  
        thirdObj.display();
    }
}