class Solution {

    Map<Character, String> map = new HashMap<>();
    List<String> ans = new ArrayList<>();

    public void helper(String digits, String curr, int curr_index)
    {
        if(curr.length() == digits.length())
        {
            ans.add(curr);
            return;
        }

        // Get letters corresponding to current digit
        String letters = map.get(digits.charAt(curr_index));

        // Try every letter
        for(int i = 0; i < letters.length(); i++)
        {
            helper(digits, curr + letters.charAt(i), curr_index + 1);
        }
    }

    public List<String> letterCombinations(String digits)
    {
        if(digits.length() == 0)
            return ans;

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        helper(digits, "", 0);

        return ans;
    }
}