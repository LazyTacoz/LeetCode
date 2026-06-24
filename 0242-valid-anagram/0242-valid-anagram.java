class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
        {
            return false;
        }
        int[] arr = new int[26];
        for(int i=0; i<s.length();i++)
        {
            int a = s.charAt(i)-'a';
            int b = t.charAt(i)-'a';
            arr[a]++;
            arr[b]--;
        }
        for(int i=0;i<26;i++)
        {
            if(arr[i]!=0)
            {
                return false;
            }
        }
        return true;
    }
}