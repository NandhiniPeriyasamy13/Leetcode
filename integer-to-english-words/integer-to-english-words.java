class Solution {
    public static final String HUNDRED = "Hundred";
    public static final String THOUSAND = "Thousand";
    public static final String MILLION = "Million";
    public static final String BILLION = "Billion";
    public static final String TRILLION = "Trillion";
    
    public String numberToWords(int num) {
        if(num == 0)
            return "Zero";
        
       
        
        Stack<String> s = new Stack<>();
        int count = 1;
        
        while(num > 0){
            StringBuilder sb = new StringBuilder();
            int n = num %1000;
            while(n>0){
                if(n>99){
                    sb.append(getOneDigitString(n/100)+" "+ "Hundred"+ " ");
                    n = n%100;
                }else if(n>=20){
                    sb.append(getTwoDigitString(n/10)+ " ");
                    n = n%10;
                }else if(n>=10 && n<=19){
                    sb.append(getTwoDigitString(n) + " ");
                    n = 0;
                }else{
                    sb.append(getOneDigitString(n)+ " ");
                    n =0;
                }
            }
            
            
            num /= 1000;
            if(count > 1 && sb.length() > 0){
               sb.append(convertDigitToString(count));
            }
            if(sb.length() > 0){
                s.add(sb.toString().trim());
            }
            count++;
           
        }
        
        
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            sb.append(s.pop().trim()+ " ");
        }
        
        return sb.toString().trim();
    }
    
    
    
    private String convertDigitToString(int num){
        switch(num){
            case 2:
                return "Thousand";
            case 3:
                return "Million";
            case 4:
                return "Billion";
            default:
                return "Trillion";
        }
    }
    
    private String getTwoDigitString(int num){
        switch(num){
            case 10:
                return "Ten";
            case 11:
                return "Eleven";
            case 12:
                return "Twelve";
            case 13:
                return "Thirteen";
            case 14: 
                return "Fourteen";
            case 15:
                return "Fifteen";
            case 16:
                return "Sixteen";
            case 17:
                return "Seventeen";
            case 18:
                return "Eighteen";
            case 19:
                return "Nineteen";
            case 2:
                return "Twenty";
            case 3:
                return "Thirty";
            case 4:
                return "Forty";
            case 5:
                return "Fifty";
            case 6:
                return "Sixty";
            case 7:
                return "Seventy";
            case 8:
                return "Eighty";
            default:
                return "Ninety";
        }
    }
    
    private String getOneDigitString(int num){
        switch(num){
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            default:
                return "Nine";
        }
    }
    
}