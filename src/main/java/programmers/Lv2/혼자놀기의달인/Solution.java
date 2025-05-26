package programmers.Lv2.혼자놀기의달인;

import java.util.*;

class Solution {
    private int answer;
    private int[] parent, temp;
    private List<Integer> list;
    public int solution(int[] cards) {
        // 초기화
        init(cards);
        // 풀이 과정
        solve();

        return answer;
    }

    private void solve(){
        for(int i = 1; i < temp.length; i++){
            // 방문한적 있는 상자인지 판단
            if(parent[i] != -1){
                continue;
            }

            int count = 1;
            int from = i;
            int to = temp[i];
            parent[from] = i;

            // 다시 자기 자신한테 돌아올때까지 하나의 그룹으로 묶음
            while(from != to){
                parent[to] = from;
                to = temp[to];
                count++;
            }

            // 그룹으로 묶은 상자의 수 리스트에 추가
            list.add(count);
        }

        // 곱셈의 최댓값 구하기 위해 정렬
        Collections.sort(list);

        // 1번 상자 그룹을 제외하고 남는 상자가 없는 경우
        if(list.size() == 1){
            answer = 0;
            return;
        }

        answer = list.get(list.size() - 1) * list.get(list.size() - 2);
    }

    private void init(int[] cards){
        parent = new int[cards.length + 1];
        temp = new int[cards.length + 1];
        list = new ArrayList<>();
        Arrays.fill(parent, -1);

        for(int i = 0; i < cards.length; i++){
            temp[i + 1] = cards[i];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(new int[]{8, 6, 3, 7, 2, 5, 1, 4});
        System.out.println("solution = " + solution);
    }
}
