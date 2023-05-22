class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
     Map<String,String> parents = new HashMap<>();
     Map<String,String> owners = new HashMap<>();
     Map<String,TreeSet<String>> unions = new HashMap<>();
     
     // set up parents and owner set
     for(List<String> account : accounts){
         for(int i = 1 ; i<account.size();i++){
             parents.put(account.get(i),account.get(i));
             owners.put(account.get(i),account.get(0));
         }
     }

// change the parents set
// same user email must be putted as the same key (user's first email)
     for(List<String> account : accounts){
         String firstEmail = find(account.get(1), parents);
         for(int i =2 ; i< account.size();i++){
             parents.put(find(account.get(i),parents), firstEmail);
         }
     }

     // add each unique email as the key and same user email in value of unions
     for(List<String> account: accounts){
         String firstEmail = find(account.get(1),parents);
        if(!unions.containsKey(firstEmail)) unions.put(firstEmail, new TreeSet());
         for(int i = 1; i < account.size();i++){
             unions.get(firstEmail).add(account.get(i));
         }
     }

     List<List<String>> res = new ArrayList<>();
     // GET all the emails in unions set, key of the set is unique emails
     for(String email : unions.keySet()){
         List<String> emails = new ArrayList<>(unions.get(email));
         emails.add(0,owners.get(email));
         res.add(emails);
     }
     return res;
    }

    public String find(String s,Map<String,String> map){
        while(s !=map.get(s)) {
            //path compression
            map.put(s,map.get(map.get(s)));
            s =map.get(s);
        }
        
        return s;
    }
}