
/* hashmap sort this based on value
 222--> 7
 2--> 4
 233--> 1


 233--> 1
 233-->1
 233-->2

 2--> 4
 222--> 7
* */

import java.util.*;

public class AirAsiaQ1 {
//    Map<String, Integer> hmap = new HashMap<>();
//
//    public Map<String, Integer> sortMapBasedOnKey(){
//
//        ArrayList<KeyValuePair> keyValuePairs = new ArrayList<>();
//        for(Map.Entry<String, Integer> e: hmap.entrySet() ){
//            KeyValuePair keyValuePair = new KeyValuePair(e.getKey(), e.getValue());
//
//            keyValuePairs.add(keyValuePair);
//        }
//        Collections.sort(hmap.entrySet(), ( e1, e2)-> Integer.compare(e1.getValue(), e2.getValue()));
//
//    }
//
//    class KeyValuePair{
//        String key;
//        Integer val;
//        KeyValuePair(String key, Integer val ){
//            this.key = key;
//            this.val = val;
//        }
//    }
//
//    class SortBasedOnValue implements Comparator<KeyValuePair>{
//
//        @Override
//        public int compare(KeyValuePair kp1, KeyValuePair kp2) {
//            return Integer.compare(kp1.val, kp2.val);
//        }
//    }

    /*
    indiachinajapan   chinajapanindia

     indiachinajapanindiachinajapan

    ndiachinajapani
     */
    public static boolean isRotatedString(String str1, String str2){
        str1 = str1+str1;
        return str1.contains(str2) && str1.length() == str2.length();
    }

    public static void main(String[] args) {
        System.out.println(isRotatedString("a", "b"));
    }



}
