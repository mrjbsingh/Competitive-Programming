package mockinterviewqst;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeating {
    public String firstNonRepeating(String arr){
        int len = arr.length();
        Map<Character, Integer> hmap = new HashMap<>();
        char ch;
        for(int i=0; i<len; i++){
            ch = arr.charAt(i);
            if(hmap.containsKey(ch)){
                int val = hmap.get(ch);
                hmap.put(ch, val+1);
            }
            else{
                hmap.put(ch,1);
            }
        }
        String ans ="";
        for(int i=0; i<len; i++){
            ch = arr.charAt(i);
            if(hmap.containsKey(ch) && hmap.get(ch)==1){
                ans +=ch;
                break;
            }
        }
        if(ans!=""){
            return ans;
        }else{
            return "error";
        }

    }
}
