package programmers.Lv3.베스트앨범;

import java.util.*;
import java.util.stream.Collectors;

import java.util.*;

class Solution {
    private Map<String, Integer> totalMap;
    private List<Music> musicList;
    private List<String> genreList;
    private int[] answer;
    public int[] solution(String[] genres, int[] plays) {
        init(genres, plays);
        solve(genres, plays);

        return answer;
    }

    private void solve(String[] genres, int[] plays){
        musicList = new ArrayList<>();

        for(int i = 0; i < genres.length; i++){
            musicList.add(new Music(genres[i], plays[i], i));
        }

        Collections.sort(musicList, (o1, o2) -> {
            if(totalMap.get(o2.genre).equals(totalMap.get(o1.genre))){
                return o2.play - o1.play;
            }
            return totalMap.get(o2.genre) - totalMap.get(o1.genre);
        });

        List<Integer> ans = new ArrayList<>();

        String prev = musicList.get(0).genre;
        int count = 0;
        for(int i = 0; i < musicList.size(); i++){
            Music cur = musicList.get(i);

            if(!cur.genre.equals(prev)){
                count = 0;
            }

            if(count == 2 && cur.genre.equals(prev)){
                continue;
            }

            ans.add(cur.idx);
            count++;
            prev = cur.genre;
        }

        answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            answer[i] = ans.get(i);
        }
    }

    private void init(String[] genres, int[] plays){
        totalMap = new HashMap<>();
        genreList = new ArrayList<>();

        for(int i = 0; i < genres.length; i++){
            totalMap.put(genres[i], totalMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        for(String genre : totalMap.keySet()){
            genreList.add(genre);
        }

        Collections.sort(genreList, (o1, o2) -> totalMap.get(o2) - totalMap.get(o1));
    }

    private class Music{
        String genre;
        int play;
        int idx;

        public Music(String genre, int play, int idx){
            this.genre = genre;
            this.play = play;
            this.idx = idx;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution = sol.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});

        System.out.println("solution = " + Arrays.toString(solution));
    }
}