import java.util.ArrayList;

class Solution3 {
    public static ArrayList<Integer> al = new ArrayList<>();
    public static ArrayList<Integer> res = new ArrayList<>();
    public static int[] a;
    public static boolean[] erased;

    public int solution(int[] a) {
        int answer = 0;
        this.a = a;
        erased = new boolean[a.length];

        popping(a.length, false);

        answer = res.size();

        return answer;
    }

    public static void popping(int count, boolean flag) {
        if (count == 1) {
            int in = 0;
            for (int i = 0; i < erased.length; i++) {
                if (!erased[i]) {
                    in = a[i];
                }
            }
            if (!res.contains(in)) {
                res.add(in);
            }
            return;
        } else {
            for (int i = 0; i < a.length; i++) {
                if (erased[i]) {
                    continue;
                }
                int p = a[i];
                int b = a[i + 1];
                int bIndex = i + 1;
                if (erased[bIndex]) {
                    boolean find = false;
                    for (int j = i + 1; j < a.length; j++) {
                        if (!erased[j]) {
                            b = a[j];
                            bIndex = j;
                            find = true;
                            break;
                        }
                    }
                    if (!find) {
                        for (int j = i - 1; j >= 0; j--) {
                            if (!erased[j]) {
                                b = a[j];
                                bIndex = j;
                                find = true;
                                break;
                            }
                        }
                    }
                    if (!find) {
                        return;
                    }
                }
                int temp = p;
                erased[i] = true;
                if (p > b) {
                    if (flag) {
                        return;
                    } else {
                        flag = true;
                    }
                }
                popping(count - 1, flag);
                erased[i] = false;
                temp = b;
                erased[bIndex] = true;
                if (p < b) {
                    if (flag) {
                        return;
                    } else {
                        flag = true;
                    }
                }
                popping(count - 1, flag);
                erased[bIndex] = false;
            }
        }
    }
}