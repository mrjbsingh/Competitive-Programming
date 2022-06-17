package dynamicprograming;

import java.util.Arrays;

public class RegularExpressionMatch {

    public int isMatch(final String R, final String S) {
        int n = R.length();
        int m = S.length();
        boolean match[][] = new boolean[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if(i==0 && j==0){
                    match[i][j] = true;
                }
                if(i==0){
                    match[i][j] = false;
                }
                if(j==0 && i>0){
                    match[i][j] = R.charAt(i) =='*' ? match[i-1][j]: false;
                }else{
                    if(R.charAt(i) == S.charAt(i) || R.charAt(i) == '?'){
                        match[i][j] = match[i-1][j-1];
                    }
                    else if(R.charAt(i) == '*'){
                        match[i][j] = match[i-1][j] || match[i][j-1];
                    }
                    else {
                        match[i][j] = false;
                    }
                }
            }
        }
        return match[n][m]? 1:0;
    }

}
