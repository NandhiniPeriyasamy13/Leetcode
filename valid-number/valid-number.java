import static java.lang.Character.isDigit;
class Solution {
    public boolean isNumber(String s) {
        s = s.toLowerCase();
        if(s.startsWith("e"))
            return false;
        if(s.contains("e")){
            String part1 = s.substring(0,s.indexOf('e'));
            String part2 = s.substring(s.indexOf('e'));
            return (isValidDecimal(part1) || isValidInteger(part1)) && isValidExponential(part2);
        }else if(s.contains(".")){
            return isValidDecimal(s);
        }else{
            return isValidInteger(s);
        }
    }

    private boolean isValidDecimal(String s){
        long count = s.chars().filter(ch -> ch == '.').count();
        if(count != 1)
            return false;

        String[] str = s.split("\\.");
        if(str.length < 1)
            return false;

        String part1 = str[0];

        if (!isValidInt(part1)) return false;
        if(str.length > 1) {
            String part2 = str[1];
            for (int i = 0; i < part2.length(); i++) {
                if (!isDigit(part2.charAt(i)))
                    return false;
            }
        }else if(part1.equals("+") || part1.equals("-")){
            return false;
        }
        return true;
    }

    private boolean isValidInt(String part1) {
        for(int i=0;i<part1.length();i++){
            if(part1.charAt(i) == '+' || part1.charAt(i) == '-'){
                if( i != 0){
                    return false;
                }
            }else if(!isDigit(part1.charAt(i))){
                return false;
            }
        }
        return true;
    }

    private boolean isValidExponential(String s){
        if(s.length() <2)
            return false;
        for(int i=0;i<s.length();i++){
            if(i == 0){
                if(s.charAt(i) != 'e'){
                    return false;
                }
            }
        }
        return isValidInteger(s.substring(1));
    }

    private boolean isValidInteger(String s){
        if(s.length() == 1 && !isDigit(s.charAt(0)))
            return false;
        return  (isValidInt(s));
    }
}