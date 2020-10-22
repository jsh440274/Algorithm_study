import java.util.ArrayList;

class Solution2 {
    public static int[] answer;
    public static int n;
    public static int[] d;
    public static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>>[] offset = new ArrayList[4];


    public int[] solution(int n) {
        this.n = n;
        int maxIndex = n % 2 == 0 ? (n + 1) * (n / 2) : n * (n / 2) + n;
        answer = new int[maxIndex];
        for (int i = 0; i < 4; i++) {
            ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
            offset[i] = temp;
        }
        ArrayList<Integer> tt = new ArrayList<>();
        tt.add(1);
        offset[1].add(tt);

        ArrayList<Integer> t1 = new ArrayList<>();
        t1.add(1);
        ArrayList<Integer> t2 = new ArrayList<>();
        t2.add(2);
        t2.add(3);
        offset[2].add(t1);
        offset[2].add(t2);

        ArrayList<Integer> t11 = new ArrayList<>();
        t11.add(1);
        ArrayList<Integer> t22 = new ArrayList<>();
        t22.add(2);
        t22.add(6);
        ArrayList<Integer> t33 = new ArrayList<>();
        t33.add(3);
        t33.add(4);
        t33.add(5);
        offset[3].add(t11);
        offset[3].add(t22);
        offset[3].add(t33);

        int loop = n / 3;
        int starting = n % 3;
        res = offset[starting];

        int last = 0;
        for (int i = 1; i < starting; i++) {
            last += i;
        }

        d = new int[loop + 1];
        d[0] = 1;
        for (int i = 0; i < loop; i++) {
            d[i + 1] = (n - 1 - i) * 3;
            if (i != 0) {
                d[i] += d[i - 1];
            }
        }

        for (int i = 0; i < loop; i++) {
            triangle(loop - i);
        }

        int index = 0;
        for (int i = 0; i < res.size(); i++) {
            ArrayList<Integer> temp = res.get(i);
            for (int j = 0; j < temp.size(); j++) {
                answer[index] = temp.get(j);
                index++;
            }
        }

        return answer;
    }

    public static void triangle(int loop) {
        int max = d[loop];
        int min = d[loop - 1];
        int size = res.size();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        res.add(0, temp);
        for (int i = 0; i < size; i++) {
            temp = new ArrayList<>();
            temp.add(min);
            temp.addAll(res.get(i + 1));
            temp.add(max);
            res.add(temp);
            min++;
            max--;
        }
        temp = new ArrayList<>();
        for (int i = 0; i < res.get(res.size() - 1).size(); i++) {
            temp.add(min + i);
        }
        res.add(temp);
    }
}