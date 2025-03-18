package programmers.Lv2.방금그곡;

import java.util.*;

class Solution {
    private int max;
    private String answer;
    public String solution(String m, String[] musicinfos) {
        solve(m, musicinfos);

        return answer;
    }

    private void solve(String m, String[] musicinfos){
        m = replaceSharp(m);
        answer = "(None)";
        max = Integer.MIN_VALUE;

        for(String musicinfo : musicinfos){
            String[] split = musicinfo.split(",");
            String temp = replaceSharp(split[3]);
            int time = calcTime(split[0], split[1]);
            int sub = time / temp.length();
            int mod = time % temp.length();

            StringBuilder sb = new StringBuilder();

            if(time < m.length()){
                continue;
            }

            while(sub > 0){
                sb.append(temp);
                sub--;
            }

            sb.append(temp.substring(0, mod));
            String cur = sb.toString();

            if(cur.contains(m) && time > max){
                max = time;
                answer = split[2];
            }

        }
    }

    private int calcTime(String start, String end){
        String[] s = start.split(":");
        String[] e = end.split(":");

        int t1 = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
        int t2 = Integer.parseInt(e[0]) * 60 + Integer.parseInt(e[1]);

        return t2 - t1;
    }

    private String replaceSharp(String m){
        m = m.replace("A#", "a");
        m = m.replace("B#", "b");
        m = m.replace("C#", "c");
        m = m.replace("D#", "d");
        m = m.replace("E#", "e");
        m = m.replace("F#", "f");
        m = m.replace("G#", "g");

        return m;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String solution1 = sol.solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"});
        String solution2 = sol.solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"});
        String solution3 = sol.solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
    }
}
