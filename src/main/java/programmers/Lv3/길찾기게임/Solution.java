package programmers.Lv3.길찾기게임;

import java.util.*;

class Solution {
    private int N, idx;
    private int[][] answer;
    private List<Pos> list;
    public int[][] solution(int[][] nodeinfo) {
        // 초기화
        init(nodeinfo);
        // 풀이 과정
        solve();

        return answer;
    }

    private void solve(){
        // left, right 값 넣기
        Pos root = list.get(0);
        for(int i = 1; i < list.size(); i++){
            fillLeftRight(root, list.get(i));
        }

        // 전위 순회
        answer = new int[2][N];
        idx = 0;
        preorder(root);
        // 후위 순회
        idx = 0;
        postorder(root);
    }

    private void preorder(Pos cur){
        if(cur == null){
            return;
        }

        answer[0][idx++] = cur.num;
        preorder(cur.left);
        preorder(cur.right);
    }

    private void postorder(Pos cur){
        if(cur == null){
            return;
        }

        postorder(cur.left);
        postorder(cur.right);
        answer[1][idx++] = cur.num;
    }

    private void fillLeftRight(Pos parent, Pos child){
        if(parent.x > child.x){
            if(parent.left == null){
                parent.left = child;
            } else{
                fillLeftRight(parent.left, child);
            }
        } else{
            if(parent.right == null){
                parent.right = child;
            } else{
                fillLeftRight(parent.right, child);
            }
        }
    }

    private void init(int[][] nodeinfo){
        list = new ArrayList<>();
        N = nodeinfo.length;

        int num = 1;
        for(int[] ni : nodeinfo){
            list.add(new Pos(ni[0], ni[1], num, null, null));
            num++;
        }

        // 상위 degree 순으로 정렬
        list.sort((o1, o2) -> {
            if(o1.y == o2.y){
                return o1.x - o2.x;
            }

            return o2.y - o1.y;
        });
    }

    private class Pos{
        int x;
        int y;
        int num;
        Pos left;
        Pos right;

        public Pos(int x, int y, int num, Pos left, Pos right){
            this.x = x;
            this.y = y;
            this.num = num;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] solution = sol.solution(new int[][]{{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}});

        System.out.println("solution = " + Arrays.deepToString(solution));
    }
}
