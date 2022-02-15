public class Abc{
    public static void main(String[] args) {
        System.out.println("hello");
    }
    public int solve(String A) {
        int len = A.length();
        int indexX=-1, indexO=-1, min=Integer.MAX_VALUE;
        for(int i=0; i<len; i++){
            if(A.charAt(i)=='x'){
                if(indexO!=-1 && min>(i-indexO)){
                    min = i-indexO;
                    indexO =-1;
                }
                indexX = i;
            }
            else if (A.charAt(i) =='o'){
                if(indexX!=-1 && min>(i-indexX)){
                    min = i-indexX;
                    indexX =-1;
                }
                indexO = i;
            }
        }
        return (min!=Integer.MAX_VALUE)? min:-1;
    }
}