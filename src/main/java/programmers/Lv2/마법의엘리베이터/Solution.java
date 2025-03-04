package programmers.Lv2.마법의엘리베이터;

class Solution {
    private int cur;
    private int half;
    private int mod;
    private int answer;
    public int solution(int storey) {
        solve(storey);

        return answer;
    }

    private void solve(int storey){
        answer = 0;
        cur = 10;

        if(storey == 5){
            answer = 5;
            return;
        }

        while(storey != 0){
            half = cur / 2;
            mod = storey % cur;

            if(mod > half){
                answer += (cur - mod) / (cur / 10);
                storey += (cur - mod);
            } else if(mod < half){
                answer += mod / (cur / 10);
                storey -= mod;
            } else{
                if((storey - half) % (cur * 10) >= (cur * 10) / 2){
                    answer += 5;
                    storey += mod;
                } else{
                    answer += 5;
                    storey -= mod;
                }
            }

            cur *= 10;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(16);
        int solution2 = sol.solution(2554);

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
