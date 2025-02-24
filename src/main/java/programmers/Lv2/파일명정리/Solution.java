package programmers.Lv2.파일명정리;

import java.util.*;

class Solution {
    private File[] fileArr;
    private String[] answer;
    public String[] solution(String[] files) {
        init(files);
        solve(files);

        return answer;
    }

    private void solve(String[] files){
        for(int idx = 0; idx < files.length; idx++){
            int startIdx = 0;
            int endIdx = files[idx].length();
            for(int i = 0; i < files[idx].length(); i++){
                if(Character.isDigit(files[idx].charAt(i))){
                    startIdx = i;
                    break;
                }
            }

            for(int i = startIdx; i < files[idx].length(); i++){
                if(!Character.isDigit(files[idx].charAt(i))){
                    endIdx = i;
                    break;
                }
            }

            String head = files[idx].substring(0, startIdx).toLowerCase();
            int number = Integer.parseInt(files[idx].substring(startIdx, endIdx));

            File file = new File(head, number, idx);
            fileArr[idx] = file;
        }

        Arrays.sort(fileArr, (o1, o2) -> {
            if(o1.head.equals(o2.head)){
                if(o1.number == o2.number){
                    return o1.idx - o2.idx;
                }

                return o1.number - o2.number;
            }

            return o1.head.compareTo(o2.head);
        });

        for(int i = 0; i < fileArr.length; i++){
            int idx = fileArr[i].idx;

            answer[i] = files[idx];
        }
    }

    private void init(String[] files){
        fileArr = new File[files.length];
        answer = new String[files.length];
    }

    private class File{
        String head;
        int number;
        int idx;

        public File(String head, int number,int idx){
            this.head = head;
            this.number = number;
            this.idx = idx;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] solution1 = sol.solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"});
        String[] solution2 = sol.solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"});

        System.out.println("solution1 = " + Arrays.toString(solution1));
        System.out.println("solution2 = " + Arrays.toString(solution2));
    }
}
