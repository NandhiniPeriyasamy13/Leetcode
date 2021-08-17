class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        int n = cpdomains.length;

        HashMap<String, Integer> hm = new HashMap<>();
        
        for(int i=0;i<n;i++){
            String[] data = cpdomains[i].split(" ");
            String domain = data[1];
            while(!domain.equals("")){
                hm.put(domain, hm.getOrDefault(domain,0)+Integer.parseInt(data[0]));
                int index = domain.indexOf(".");
                if(index >= 0){
                    domain = domain.substring(index+1);
                }else{
                    domain = "";
                }
            }
        }
        
        List<String> ans = new ArrayList<>();
        
        for(String str : hm.keySet()){
            StringBuilder sb = new StringBuilder(String.valueOf(hm.get(str)));
            sb.append(" ");
            sb.append(str);
            ans.add(sb.toString());
        }
        
        return ans;
    }
}