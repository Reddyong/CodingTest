package programmers.Lv2.주차요금계산;

import java.util.*;

class Solution {
    private Map<Integer, Car> map;
    private int[] answer;
    public int[] solution(int[] fees, String[] records) {
        solve(fees, records);

        return answer;
    }

    private void solve(int[] fees, String[] records){
        map = new HashMap<>();
        for(String record : records){
            String[] split = record.split(" ");

            int carNum = Integer.parseInt(split[1]);
            String inOrOut = split[2];

            String[] clock = split[0].split(":");
            int hour = Integer.parseInt(clock[0]);
            int minute = Integer.parseInt(clock[1]);

            int time = hour * 60 + minute;

            if(inOrOut.equals("IN")){
                if(map.containsKey(carNum)){
                    Car prev = map.get(carNum);

                    map.put(carNum, new Car(time, prev.total));
                }else{
                    map.put(carNum, new Car(time, 0));
                }
            }else{
                Car prev = map.get(carNum);

                map.put(carNum, new Car(-1, prev.total + (time - prev.time)));
            }
        }

        List<Integer> list = new ArrayList<>();

        for(int num : map.keySet()){
            Car car = map.get(num);

            if(car.time != -1){
                int endTime = 60 * 23 + 59;
                map.put(num, new Car(0, car.total + endTime - car.time));
            }

            list.add(num);
        }

        answer = new int[map.size()];

        Collections.sort(list, (o1, o2) -> o1 - o2);

        for(int i = 0; i < answer.length; i++){
            Car car = map.get(list.get(i));
            answer[i] = totalPrice(fees, car.total);
        }
    }

    private int totalPrice(int[] fees, int time){
        if(time <= fees[0]){
            return fees[1];
        }

        time -= fees[0];

        if(time % fees[2] == 0){
            return fees[1] + fees[3] * (time / fees[2]);
        }

        return fees[1] + fees[3] * (time / fees[2] + 1);
    }

    private class Car{
        int time;
        int total;

        public Car(int time, int total){
            this.time = time;
            this.total = total;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution1 = sol.solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
        int[] solution2 = sol.solution(new int[]{120, 0, 60, 591}, new String[]{"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"});
        int[] solution3 = sol.solution(new int[]{1, 461, 1, 10}, new String[]{"00:00 1234 IN"});

        System.out.println("solution1 = " + Arrays.toString(solution1));
        System.out.println("solution2 = " + Arrays.toString(solution2));
        System.out.println("solution3 = " + Arrays.toString(solution3));
    }
}