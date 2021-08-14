class Solution {
    public String alienOrder(String[] words) {
        
        
        HashMap<Character, List<Character>> hm = createGraph(words);
        
        if(hm == null)
            return "";
        
        int[] indegree = new int[26];

        StringBuilder sb = new StringBuilder();
        if(words.length == 1){
            sb.append(words[0]);
            addCharToMap(words[0], hm);
        }
        
        Queue<Character> q = new LinkedList<>();
        
        for(char chr : hm.keySet()){
            List<Character> list = hm.get(chr);
            if(list.isEmpty()){
                sb.append(chr+"");
            }else{
                for(char ch : list){
                    indegree[ch - 'a']++;
                }
            }
        }
        
        for(char ch : hm.keySet()){
            if(indegree[ch - 'a'] == 0){
                q.add(ch);
            }
        }
        
        boolean[] visited = new boolean[26];
        
        StringBuilder ans = new StringBuilder();
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                char ch = q.poll();
                if(visited[ch-'a']){
                    return "";
                }
                visited[ch-'a'] = true;
                ans.append(ch+"");
                List<Character> list = hm.getOrDefault(ch, new ArrayList<>());
                for(char chr : list){
                    indegree[chr - 'a']--;
                    if(indegree[chr - 'a'] == 0){
                        q.add(chr);
                    }
                }
            }
        }
        
        for(int i=0;i<sb.length();i++){
            char ch = sb.charAt(i);
            if(!visited[ch-'a']){
                ans.append(ch);
            }
        }
        
        if(ans.length() != hm.size()){
            return "";
        }
        
        return ans.toString();
    }
    
    
    private HashMap<Character, List<Character>> createGraph(String[] words){
        HashMap<Character, List<Character>> hm = new HashMap<>();
        
        int n = words.length;
        
        for(int i=0;i<n-1;i++){
            String str1 = words[i];
            String str2 = words[i+1];
            if(str1.length() > str2.length() && str1.startsWith(str2)){
                return null;
            }
            int len = Math.min(str1.length(), str2.length());
            for(int j=0;j<len;j++){
                List<Character> list = hm.getOrDefault(str1.charAt(j), new ArrayList<>());
                if(str1.charAt(j) != str2.charAt(j)){
                    list.add(str2.charAt(j));
                    len = j+1;
                    hm.put(str1.charAt(j), list);
                    hm.put(str2.charAt(j), hm.getOrDefault(str2.charAt(j), new ArrayList<>()));
                    break;
                }
                hm.put(str1.charAt(j), list);
            }
        
            if(str1.length() != len){
                addCharToMap(str1.substring(len), hm);
            }
            if(str2.length() != len){
                addCharToMap(str2.substring(len), hm);
            }
        }
        return hm;
    }
    
    private void addCharToMap(String str, HashMap<Character, List<Character>> hm){
        int n = str.length();
        for(int i=0;i<n;i++){
            hm.put(str.charAt(i), hm.getOrDefault(str.charAt(i), new ArrayList<>()));
        }
    }
}