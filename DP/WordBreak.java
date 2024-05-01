/**
 * Date 05/01/2024
 * @author Priya
 * 
 * Given a string and a dictionary, split this string into multiple words such that
 * each word belongs in dictionary.
 * 
 * e.g peanutbutter -> pea nut butter
 * e.g Iliketoplay -> I like to play
 * 
 * Solution 
 * DP solution to this problem
 *      
 * Test cases
 * 1) String where entire string is in dictionary
 * 2) String which cannot be split into words which are in dictionary
 * 3) String which can be split into words which are in dictionary    
 */

class Solution {           
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[dp.length-1] = true;
        for(int i=s.length()-1;i>=0;--i){ // "catsandog"
            for(int j=0;j<wordDict.size();++j){
               String word = wordDict.get(j);  // cats
               int len = i + word.length();
               if(len>s.length()) continue;
                 if(s.startsWith(word,i)){
                    dp[i] = dp[i+word.length()];
                 }
                 if(dp[i]) break;
            }
        }
        return dp[0];
    }
}
// TC O(n*m*n)
// SC O(n)


