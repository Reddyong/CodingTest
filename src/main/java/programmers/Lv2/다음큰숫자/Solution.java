package programmers.Lv2.다음큰숫자;

public class Solution {
    public int solution(int n) {
        int answer = solve(n);
        return answer;
    }

    private int solve(int n){
        String cur = Integer.toBinaryString(n);
        int count = totalOne(cur);

        while(true){
            n++;
            cur = Integer.toBinaryString(n);

            int temp = totalOne(cur);

            if(count == temp){
                return n;
            }
        }
    }

    private int totalOne(String cur){
        int cnt = 0;

        for(int i = 0; i < cur.length(); i++){
            if(cur.charAt(i) == '1'){
                cnt++;
            }
        }

        return cnt;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(78);
        int solution2 = sol.solution(15);

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
