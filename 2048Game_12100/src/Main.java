import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Integer>[] map;
    public static ArrayList<Integer>[] copiedmap;
    public static int answer = 0;

    //
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        map = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                map[i].add(sc.nextInt());
            }
        }
        mapping(5, map);
        System.out.println(answer);
    }

    public static void mapping(int depth, ArrayList<Integer>[] map) {
        if (depth == 0) {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].size(); j++) {
                    answer = Math.max(answer, map[i].get(j));
                }
            }
        } else {
            for (int i = 1; i <= 4; i++) {
                copiedmap = copyMap(map);
                copiedmap = move(i, copiedmap);
                mapping(depth - 1, copiedmap);
            }
        }
    }

    public static ArrayList<Integer>[] move(int location, ArrayList<Integer>[] map) {
        int n = map.length;
        switch (location) {
            case 1://오른쪽
                for (int i = 0; i < n; i++) {
                    int prev = -1;
                    for (int j = map[i].size() - 1; j >= 0; j--) {
                        if (map[i].get(j) == 0) {
                            map[i].remove(j);
                        } else if (prev == -1 || map[i].get(j) != map[i].get(prev)) {
                            prev = j;
                        } else {
                            int temp = map[i].get(j);
                            map[i].remove(prev);
                            map[i].remove(j);
                            map[i].add(j, temp * 2);
                            prev = -1;
                        }
                    }
                    while (map[i].size() < n) {
                        map[i].add(0, 0);
                    }
                }
                break;
            case 2://왼쪽
                for (int i = 0; i < n; i++) {
                    int prev = -1;
                    for (int j = 0; j < map[i].size(); j++) {
                        if (map[i].get(j) == 0) {
                            map[i].remove(j);
                        } else if (prev == -1 || map[i].get(j) != map[i].get(prev)) {
                            prev = j;
                        } else {
                            int temp = map[i].get(j);
                            map[i].remove(j);
                            map[i].remove(prev);
                            map[i].add(prev, temp * 2);
                            prev = -1;
                        }
                    }
                    while (map[i].size() < n) {
                        map[i].add(0);
                    }
                }
                break;
            case 3://위
                for (int j = 0; j < n; j++) {
                    int index = 0;
                    int prev = -1;
                    for (int i = 0; i < n; i++) {
                        if (map[i].get(j) == 0) {//해당 칸이 비어있는 경우. index안바꿔도 됨.
                            map[i].remove(j);
                        } else {
                            int pushing = map[i].get(j);
                            if (prev == -1 || map[i].get(j) != map[prev].get(j)) {//넘어가는 경우
                                prev = index;
                                map[i].remove(j);
                                map[index].add(j, pushing);
                                index++;
                            } else {//같은 숫자 두개 연속으로 본 경우
                                int temp = map[prev].get(j);
                                map[prev].remove(j);
                                map[i].remove(j);
                                map[prev].add(j, temp * 2);
                                prev = -1;
                            }
                        }
                    }
                    while (index < n) {
                        map[index].add(j, 0);
                        index++;
                    }
                }
                break;
            case 4://아래
                for (int j = 0; j < n; j++) {
                    int index = n - 1;
                    int prev = -1;
                    for (int i = n - 1; i >= 0; i--) {
                        if (map[i].get(j) == 0) {//해당 칸이 비어있는 경우. index안바꿔도 됨.
                            map[i].remove(j);
                        } else {
                            int pushing = map[i].get(j);
                            if (prev == -1 || map[i].get(j) != map[prev].get(j)) {//넘어가는 경우
                                prev = index;
                                map[i].remove(j);
                                map[index].add(j, pushing);
                                index--;
                            } else {//같은 숫자 두개 연속으로 본 경우
                                int temp = map[prev].get(j);
                                map[prev].remove(j);
                                map[i].remove(j);
                                map[prev].add(j, temp * 2);
                                prev = -1;
                            }
                        }
                    }
                    while (index >= 0) {
                        map[index].add(j, 0);
                        index--;
                    }
                }
                break;
        }
        return map;
    }

    public static ArrayList[] copyMap(ArrayList[] originalMap) {
        ArrayList[] newMap = new ArrayList[originalMap.length];
        for (int i = 0; i < originalMap.length; i++) {
            newMap[i] = new ArrayList();
            for (int j = 0; j < originalMap[i].size(); j++) {
                newMap[i].add(originalMap[i].get(j));
            }
        }
        return newMap;
    }
}