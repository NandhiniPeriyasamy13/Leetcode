class Solution {
    String pattern = "", patternCount = "";
    int inputLength = 0, patternLength = 0;
    int[][] patternDp;
    public boolean isMatch(String s, String p) {
        inputLength = s.length();
        for(int i=0;i<p.length();i++){
            Character ch = p.charAt(i);
            if(ch == '*') {
                pattern += '.';
                patternCount += '*';
            }else if(ch == '?'){
                pattern += '.';
                patternCount += '1';
            }else {
                pattern += ch;
                patternCount += '1';
            }
        }
        patternLength = pattern.length();
        patternDp = new int[inputLength+1][patternLength+1];
        for(int i=0;i<inputLength+1;i++){
            Arrays.fill(patternDp[i],-1);
        }
        return isMatch(s,0,0);
    }

    private boolean isMatch(String input, int inputIndex, int patternIndex){
        //Base conditions
        if(patternDp[inputIndex][patternIndex] != -1){
            if(patternDp[inputIndex][patternIndex] == 0){
                return false;
            }else {
                return true;
            }
        }

        if(inputIndex == inputLength && patternIndex == patternLength){
            return true;
        }

        if(patternIndex == patternLength){
            return false;
        }
        boolean isMatched;
        if(inputIndex == inputLength){
            if(patternCount.charAt(patternIndex) == '*'){
                isMatched = isMatch(input,inputIndex,patternIndex+1);
            }else {
                isMatched = false;
            }
            populatedpArray(isMatched,inputIndex,patternIndex);
            return isMatched;
        }
        //Core Logic
        if(doesInputMatchesPattern(input,inputIndex,patternIndex)){
            if(patternCount.charAt(patternIndex) == '1'){
                isMatched = isMatch(input,inputIndex+1,patternIndex+1);
            }else {
                isMatched = isMatch(input,inputIndex+1, patternIndex+1) ||
                        isMatch(input, inputIndex, patternIndex+1) ||
                        isMatch(input, inputIndex+1, patternIndex);
            }
            populatedpArray(isMatched,inputIndex,patternIndex);
            return isMatched;
        }else{
            // if(patternCount.charAt(patternIndex) == '*'){
            //     isMatched = isMatch(input, inputIndex, patternIndex+1);
            // }else {
            //     isMatched = false;
            // }
            isMatched = false;
            populatedpArray(isMatched,inputIndex,patternIndex);
            return isMatched;
        }
    }

    private void populatedpArray(boolean isMatched, int inputIndex, int patternIndex){
            if(isMatched){
                patternDp[inputIndex][patternIndex] = 1;
            }else {
                patternDp[inputIndex][patternIndex] = 0;
            }
    }

    private boolean doesInputMatchesPattern(String input, int inputIndex, int patternIndex) {
        if(pattern.charAt(patternIndex) == '.'){
            return true;
        }

        if(input.charAt(inputIndex) == pattern.charAt(patternIndex)){
            return true;
        }

        return false;
    }
}