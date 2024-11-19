package programmers.Lv2.JadenCase문자열만들기;

public class Solution {
    private char[] sentence;
    public String solution(String s) {
        init(s);

        return solve();
    }

    private String solve(){
        String ans = "";

        if(Character.isAlphabetic(sentence[0])){
            sentence[0] = Character.toUpperCase(sentence[0]);
        }

        for(int i = 1; i < sentence.length; i++){
            if(sentence[i - 1] == ' ' && Character.isAlphabetic(sentence[i])){
                sentence[i] = Character.toUpperCase(sentence[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < sentence.length; i++){
            sb.append(sentence[i]);
        }

        return sb.toString();
    }

    private void init(String s){
        s = s.toLowerCase();
        sentence = s.toCharArray();
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String solution1 = sol.solution("3people unFollowed me");
        String solution2 = sol.solution("for the last week");

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
