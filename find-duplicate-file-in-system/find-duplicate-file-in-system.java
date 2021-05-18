class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> hm = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(int i=0;i<paths.length;i++){
            String[] path = paths[i].split(" ");
            for(int j=1;j<path.length;j++){
                String file = path[j];
                String content = file.substring(file.indexOf("(")+1, file.indexOf(")"));
                List<String> fileList = hm.getOrDefault(content,new ArrayList<>());
                String filePath = path[0]+"/"+file.substring(0,file.indexOf("("));
                fileList.add(filePath);
                hm.put(content,fileList);
            }
        }
        
        for(String key : hm.keySet()){
            if(hm.get(key).size() > 1){
                res.add(hm.get(key));
            }
        }
        
        return res;
    }
}