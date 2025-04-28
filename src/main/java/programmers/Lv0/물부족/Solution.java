package programmers.Lv0.물부족;

class Solution {
    public int solution(int storage, int usage, int[] change) {
        int total_usage = 0;
        for(int i=0; i<change.length; i++){
            // 현재 값에서 퍼센테이지 값 증가 또는 감소시키기
            usage += usage * change[i] / 100;
            total_usage += usage;

            // 기본 저장소보다 큰 경우는 현재 인덱스 달 이후에 물이 부족해지는 경우
            if(total_usage > storage){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(5141, 500, new int[]{10, -10, 10, -10, 10, -10, 10, -10, 10, -10});
        int solution2 = sol.solution(1000, 2000, new int[]{-10, 25, -33});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
