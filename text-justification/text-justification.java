class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i=0;
        while(i<words.length){
            int len = 0; 
            StringBuilder sb = new StringBuilder();
            int k=i;
            int wordlen = 0;
            int numWords = 0;
            while(k<words.length){
                if(len+words[k].length() <= maxWidth){
                    sb.append(words[k]);
                    len += words[k].length();
                    wordlen += words[k].length();
                    numWords++;
                }else{
                    break;
                }
                
                if(len < maxWidth){
                    sb.append(" ");
                    len += 1;
                }
                k++;
                //System.out.println(sb.toString());
            }
            
            //justify spaces
            if(k == words.length){
                int numSpaces = maxWidth-sb.length();
                for(int l=0;l<numSpaces;l++){
                    sb.append(" ");
                }
                res.add(sb.toString());
            }else{
            if(numWords > 1){
                int numSpaces = (maxWidth-wordlen)/(numWords-1);
                int extraSpace = (maxWidth-wordlen)%(numWords-1);
                String[] str = sb.toString().split(" ");
                sb = new StringBuilder();
                for(int j=0;j<str.length;j++){
                    sb.append(str[j]);
                    if(j==str.length-1){
                        break;
                    }

                    for(int l=0;l<numSpaces;l++){
                        sb.append(" ");
                    }
                    if(extraSpace > 0){
                        sb.append(" ");
                        extraSpace--;
                    }
                }
                res.add(sb.toString());
                //System.out.println(sb.toString());
            }else{
                int numSpaces = maxWidth-wordlen-1;
                for(int l=0;l<numSpaces;l++){
                    sb.append(" ");
                }
                res.add(sb.toString());
                //System.out.println(sb.toString());
            }
            }
            i=k;
        }
        return res;
    }
    
    
}