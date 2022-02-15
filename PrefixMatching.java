import java.util.ArrayList;
import java.util.List;

public class PrefixMatching{
    public static void main(String[] args) {
        System.out.println("hello");
    }
    public ArrayList<Integer> solve(ArrayList<String> A, String B) {
        ArrayList<Integer> res = new ArrayList<>();
        List<String> arr = A;
        for (int i = 0; i < arr.size(); i++) {
            String temp = A.get(i);
            if(temp.indexOf(B)==0){
                res.add(i);
            }
        }
        ArrayList<Integer> finalRes = new ArrayList<>();
        if(res.isEmpty()){
            finalRes.add(-1);
            finalRes.add(-1);
        }
        else{
            finalRes.add(res.get(0));
            finalRes.add(res.get(res.size()-1));
        }
        return finalRes;
    }
}