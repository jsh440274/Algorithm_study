//class Solution2 {
//    public int[][] arr;
//
//    public int[] solution(int[][] arr) {
//        int[] answer = new int[2];
//        this.arr = arr;
//
//
//        return answer;
//    }
//
//    public void divide(int i1, int i2, int j1, int j2) {
//        if (i1 == i2) {
//
//        }
//        divide(i1, (i1 + i2) / 2, j1, (j1 + j2) / 2);
//        divide(i1, (i1 + i2) / 2, (j1 + j2) / 2, j2);
//        divide((i1 + i2) / 2, i2, j1, (j1 + j2) / 2);
//        divide((i1 + i2) / 2, i2, (j1 + j2) / 2, j2);
//    }
//
//
//    public boolean check(int i1, int i2, int j1, int j2) {
//        boolean flag = true;
//
//
//        return false;
//    }
//}

class Solution2 {
    public static int[][] quadTree;
    public static int[] answer = new int[2];

    public int[] solution(int[][] arr) {
        this.quadTree = arr;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 1) {
                    answer[1]++;
                } else {
                    answer[0]++;
                }
            }
        }

        srcQuadTree(0, 0, arr.length);

        return answer;
    }

    public static int isAble(int row, int col, int size) {
        int t = quadTree[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (t != quadTree[i][j]) return -1;
            }
        }
        return t;
    }

    public static void srcQuadTree(int row, int col, int size) {
        int able = isAble(row, col, size);
        if (able != -1) {
            answer[able] -= (size * size);
            answer[able]++;

        } else {
            int newSize = size / 2;

            srcQuadTree(row, col, newSize);
            srcQuadTree(row, col + newSize, newSize);
            srcQuadTree(row + newSize, col, newSize);
            srcQuadTree(row + newSize, col + newSize, newSize);
        }
    }

}