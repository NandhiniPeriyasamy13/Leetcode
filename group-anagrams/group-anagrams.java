class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            int[] arr = new int[26];
            String str = strs[i];
            for(int j=0;j<str.length();j++){   
                int index = str.charAt(j) - 'a';
                arr[index]++;
            }
            String key = Arrays.toString(arr);
            List<String> list = hm.getOrDefault(key, new ArrayList<>());
            list.add(str);
            hm.put(key,list);
        }
        
        for(List<String> val : hm.values()){
            ans.add(val);
        }
        return ans;
    }
    
}