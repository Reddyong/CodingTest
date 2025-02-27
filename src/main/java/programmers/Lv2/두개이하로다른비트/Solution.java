package programmers.Lv2.두개이하로다른비트;

import java.util.Arrays;

class Solution {
    private long[] answer;
    public long[] solution(long[] numbers) {
        solve(numbers);

        return answer;
    }

    private void solve(long[] numbers){
        answer = new long[numbers.length];

        for(int i = 0; i < numbers.length; i++){
            long cur = numbers[i];

            if(cur % 2 == 0){
                answer[i] = cur + 1;
            } else{
                answer[i] = getResult(cur);
            }
        }
    }

    private long getResult(long cur){
        String bin = Long.toBinaryString(cur);

        char[] binaryChar = bin.toCharArray();
        int idx = binaryChar.length;

        for(int i = idx - 1; i >= 0; i--){
            if(bin.charAt(i) == '0'){
                idx = i;
                bin = bin.substring(0, i) + "10" + bin.substring(i + 2);
                break;
            }
        }

        if(idx == binaryChar.length){
            bin = "10" + bin.substring(1);
        }

        return Long.parseLong(bin, 2);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        long[] solution = sol.solution(new long[]{2, 7});

        System.out.println("solution = " + Arrays.toString(solution));
    }
}
