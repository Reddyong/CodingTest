package programmers.Lv3.다단계칫솔판매;

import java.util.*;

class Solution {
    private int N;
    private int[] answer, parent;
    private Map<String, Integer> map;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 초기 세팅 및 map 세팅
        init(enroll);
        // 풀이 과정
        solve(referral, seller, amount);

        return answer;
    }

    private void solve(String[] referral, String[] seller, int[] amount){
        // 1. parent 배열 만들기
        makeParentArr(referral);

        // 2. 누적 판매액 구하기
        makeSum(seller, amount);
    }

    private void makeSum(String[] seller, int[] amount){
        int len = seller.length;

        for(int i = 0; i < len; i++){
            // 시작 판매원 id
            int curId = map.get(seller[i]);

            // 초기 판매액
            int curMoney = amount[i] * 100;

            // 부모가 -1인 경우까지 진행
            while(curId != -1){
                // 1원 미만인 경우에는 이득 분배를 멈춘다
                if(curMoney < 1){
                    break;
                }

                int next = curMoney / 10;
                curMoney -= next;

                answer[curId] += curMoney;

                curId = parent[curId];
                curMoney = next;
            }
        }
    }

    private void makeParentArr(String[] referral){
        for(int i = 0; i < N; i++){
            if(referral[i].equals("-")){
                parent[i] = -1;
                continue;
            }

            int pNum = map.get(referral[i]);
            parent[i] = pNum;
        }
    }

    private void init(String[] enroll){
        N = enroll.length;
        answer = new int[N];
        parent = new int[N];

        map = new HashMap<>();
        for(int i = 0; i < N; i++){
            map.put(enroll[i], i);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution1 = sol.solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}, new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"}, new String[]{"young", "john", "tod", "emily", "mary"}, new int[]{12, 4, 2, 5, 10});
        int[] solution2 = sol.solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}, new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"}, new String[]{"sam", "emily", "jaimie", "edward"}, new int[]{2, 3, 5, 4});

        System.out.println("solution1 = " + Arrays.toString(solution1));
        System.out.println("solution2 = " + Arrays.toString(solution2));
    }
}
