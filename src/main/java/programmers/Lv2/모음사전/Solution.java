package programmers.Lv2.모음사전;

class Solution {
    private int answer;
    private int count;
    private String[] words = new String[]{"A", "E", "I", "O", "U"};
    public int solution(String word) {
        answer = 0;
        count = 0;
        dfs(0, "", word);

        return answer;
    }

    private void dfs(int depth, String cur, String word){
        if(cur.equals(word)){
            answer = count;
            return;
        }

        if(depth == 5){
            return;
        }
        for(int i = 0; i < 5; i++){
            count++;
            dfs(depth + 1, cur + words[i], word);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution("AAAAE");
        int solution2 = sol.solution("AAAE");
        int solution3 = sol.solution("I");
        int solution4 = sol.solution("EIO");

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
        System.out.println("solution4 = " + solution4);
    }
}
