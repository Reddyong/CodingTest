package programmers.Lv2.광물캐기;

import java.util.*;

class Solution {
    private int answer, pickSize;
    private PriorityQueue<Work> pq;
    public int solution(int[] picks, String[] minerals) {
        // 풀이 과정
        solve(picks, minerals);

        return answer;
    }

    private void solve(int[] picks, String[] minerals){
        // 1. 광물 묶음들을 구해서 다이아몬드, 철, 돌이 많은 순으로 정렬
        getWorks(picks, minerals);

        // 2. 광물 캐기
        getResult(picks);

    }

    private void getResult(int[] picks){
        answer = 0;

        while(!pq.isEmpty()){
            Work work = pq.poll();

            // 곡괭이가 남았는지 확인 후 곡괭이 종류 반환
            int idx = getPickIdx(picks);

            if(idx == -1){
                break;
            }

            // 곡괭이 종류에 따라 피로도 다르게 누적합
            if(idx == 0){
                answer += work.diamond;
                answer += work.iron;
                answer += work.stone;
            } else if(idx == 1){
                answer += 5 * work.diamond;
                answer += work.iron;
                answer += work.stone;
            } else {
                answer += 25 * work.diamond;
                answer += 5 * work.iron;
                answer += work.stone;
            }

            picks[idx]--;
        }
    }

    private int getPickIdx(int[] picks){
        for(int i = 0; i < 3; i++){
            if(picks[i] > 0){
                return i;
            }
        }

        return -1;
    }

    private void getWorks(int[] picks, String[] minerals){
        // 곡괭이의 수를 먼저 저장.
        pickSize = 0;

        for(int i = 0; i < 3; i++){
            pickSize += picks[i];
        }

        // 작업을 담을 우선순위 큐 설정.
        pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.diamond == o2.diamond){
                if(o1.iron == o2.iron){
                    return o2.stone - o1.stone;
                }
                return o2.iron - o1.iron;
            }

            return o2.diamond - o1.diamond;
        });

        // 우선순위 큐에 작업들 묶어서 담기
        int count = 0;
        int diamond = 0;
        int iron = 0;
        int stone = 0;
        for(int i = 0; i < minerals.length; i++){
            if(minerals[i].equals("diamond")){
                diamond++;
            } else if(minerals[i].equals("iron")){
                iron++;
            } else{
                stone++;
            }

            count++;

            if(count == 5 || i == minerals.length - 1){
                Work work = new Work(diamond, iron, stone);
                pq.add(work);

                count = 0;
                diamond = 0;
                iron = 0;
                stone = 0;
            }

            // 단, 곡괭이 수보다 작업이 넘어서는 경우는 작업 넣기 중단
            if(pq.size() >= pickSize){
                return;
            }
        }
    }

    private class Work{
        int diamond;
        int iron;
        int stone;

        public Work(int diamond, int iron, int stone){
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(new int[]{1, 3, 2}, new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"});
        int solution2 = sol.solution(new int[]{0, 1, 1}, new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
