package programmers.Lv3.기지국설치;

class Solution {
    private int answer;
    public int solution(int n, int[] stations, int w) {
        solve(n, stations, w);

        return answer;
    }

    private void solve(int n, int[] stations, int w){
        answer = 0;
        int start = 1;
        int gap = 2 * w + 1;

        for(int station : stations){
            int end = station - w;

            if(end <= start){
                start = station + w + 1;
                continue;
            }

            int temp = end - start;

            if(temp % gap == 0){
                answer += (temp / gap);
            } else{
                answer += (temp / gap + 1);
            }

            start = station + w + 1;
        }

        if(start <= n){
            int end = n + 1;
            int temp = end - start;

            if(temp % gap == 0){
                answer += (temp / gap);
            } else{
                answer += (temp / gap + 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(11, new int[]{4, 11}, 1);
        int solution2 = sol.solution(16, new int[]{9}, 2);

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
