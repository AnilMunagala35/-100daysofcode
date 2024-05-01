class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String>map=new HashMap<>();

        String []arr=s.split(" ");

        if(arr.length!=pattern.length())
        return false;

        for(int i=0;i<pattern.length();i++)
        {
            char ch=pattern.charAt(i);
            if(map.containsKey(ch))  //if key character exist
             {
                   if(!map.get(ch).equals(arr[i])) //has to match with respective string 
                   return false;
             }
             else
             {
                  if(map.containsValue(arr[i])) //this string is already mapped to another key
                                               //this is not in fit in rule 
                  return false;

                  map.put(ch,arr[i]);
             }
           
        }

        return true;
    }
}
