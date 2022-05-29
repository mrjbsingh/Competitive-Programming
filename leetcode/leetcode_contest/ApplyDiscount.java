package leetcode.leetcode_contest;

/*
https://leetcode.com/problems/apply-discount-to-prices/
 */
class ApplyDiscount {
    public String discountPrices(String sentence, int discount) {
        sentence=" "+sentence+" ";
        int len= sentence.length();

        StringBuilder newStr = new StringBuilder();
        for(int i=0; i<sentence.length(); i++){
            newStr.append(sentence.charAt(i));
            if(sentence.charAt(i)==' ' ){
                if(i+1<len && sentence.charAt(i+1)=='$'){
                    if( i+2<len && '0'<= sentence.charAt(i+2) && '9'>= sentence.charAt(i+2)){
                        //System.out.println(" hmm "+sentence.charAt(i+2));
                        int start = i+2;
                        int end = start;
                        while(end<len &&'0'<= sentence.charAt(end) && '9'>= sentence.charAt(end)){
                            //System.out.println(" loop "+sentence.charAt(end));
                            end++;
                        }

                        //System.out.println(" start "+ sentence.charAt(start) +" end "+ sentence.charAt(end));
                        if(end<len && sentence.charAt(end)==' '){
                            Long num = Long.parseLong(sentence.substring(start, end));
                            //System.out.println(num);
                            String newPrice = getDiscount(num, discount);
                            newStr.append('$'+newPrice);
                        }else{
                            newStr.append(sentence.substring(start-1, end));
                        }

                        i=end-1;
                    }
                }
            }
        }


        return newStr.substring(1, newStr.length()-1);
    }
    public String getDiscount(Long num, int d){
        double price= num*1.0 - (1.0*d*num)/100.0;
        return String.format("%.2f", price);
    }
}