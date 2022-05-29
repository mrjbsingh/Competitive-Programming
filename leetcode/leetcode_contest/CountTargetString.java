package leetcode.leetcode_contest;
/*
https://leetcode.com/contest/weekly-contest-295/problems/rearrange-characters-to-make-target-string/
 */
public class CountTargetString {
    public int rearrangeCharacters(String s, String target) {
        int freq[] = new int[27];
        int j=0, count=0;

        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i)-'a']++;
        }
        boolean flag=true;
        while(flag){
            for(int i=0; i<target.length(); i++){
                if(freq[target.charAt(i)-'a']>0){
                    freq[target.charAt(i)-'a']--;
                }
                else{
                    flag= false;
                    break;
                }
            }
            if(flag)
                count++;
        }

        return count;
    }
}
