import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class no3 {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> category = new HashSet<>();
        for (int i = 0; i < gems.length; i++) {
            category.add(gems[i]);
        }
        int count = category.size();
        int start = 0;
        int end = 0;
        HashMap<String, Integer> min_category = new HashMap<>();
        ArrayList<int[]> al_ans = new ArrayList<>();
        while (end < gems.length) {
            if (min_category.size() != count) {
                int temp = min_category.getOrDefault(gems[end], 0) + 1;
                min_category.put(gems[end], temp);
                end++;
            } else {
                int minus = min_category.get(gems[start]) - 1;
                if (minus == 0) {
                    min_category.remove(gems[start]);
                    if (al_ans.isEmpty() || al_ans.get(0)[0] > end - start - 1) {
                        al_ans = new ArrayList<>();
                    }
                    int[] putting = {end - start - 1, start, end};
                    al_ans.add(putting);
                } else {
                    min_category.put(gems[start], minus);
                }
                start++;
            }
        }
        if (min_category.size() == count && (al_ans.isEmpty() || end - start - 1 < al_ans.get(0)[0])) {
            answer[0] = start + 1;
            answer[1] = end;
        } else {
            answer[0] = al_ans.get(0)[1] + 1;
            answer[1] = al_ans.get(0)[2];
        }
        return answer;
    }

//    public int[] solution(String[] gems) {
//        int[] answer = new int[2];
//        HashMap<String, Integer> map = new HashMap<>();
//        for (int i = 0; i < gems.length; i++) {
//            int temp = 0;
//            if (map.containsKey(gems[i])) {
//                temp = map.get(gems[i]);
//            }
//            temp++;
//            map.put(gems[i], temp);
//        }
//
//        int index = gems.length - 1;
//        while (map.containsKey(gems[index])) {
//            int temp = map.get(gems[index]) -1;
//            if(temp == 0) break;
//            map.remove(gems[index]);
//            map.put(gems[index], temp--);
//            index--;
//        }
//        answer[1] = index+1;
//        index = 0;
//        while (map.containsKey(gems[index])) {
//            int temp = map.get(gems[index]) -1;
//            if(temp == 0) break;
//            map.remove(gems[index]);
//            map.put(gems[index], temp--);
//            index++;
//        }
//        answer[0] = index+1;
////        for(int i=0; i< )
//
//        return answer;
//    }

//    public static int gem_count = 0;
//    public static int[] answer = new int[2];
//
//    public int[] solution(String[] gems) {
//        answer[0] = 1;
//        answer[1] = gems.length;
//        Set<String> category = new HashSet<>();
//        for (int i = 0; i < gems.length; i++) {
//            if (!category.contains(gems[i])) {
//                category.add(gems[i]);
//            }
//        }
//        gem_count = category.size();
//        if (gem_count == 1) {
//            answer[0] = 1;
//            answer[1] = 1;
//            return answer;
//        } else if (gem_count == gems.length) {
//            return answer;
//        } else {
//            divide(gems, 0, gems.length);///
//        }
//
//        return answer;
//    }
//
//    public static void divide(String arr[], int start, int end) {
//        if (start < end) {
//            int mid = (start + end) / 2;
//            divide(arr, start, mid);
//            divide(arr, mid + 1, end);
//            conquer(arr, start, mid, end);
//        }
//    }
//
//    public static void conquer(String arr[], int start, int mid, int end) {
//        Set<String> temp_set = new HashSet<>();
//        int index = mid;
//        for (int i = mid - 1; i >= 0; i--) {
//            int temp_size = temp_set.size();
//            temp_set.add(arr[i]);
//            if (temp_size != temp_set.size()) {
//                index = i;
//            }
//        }
//        start = index;
//        index = mid;
//        for (int i = mid; i < end; i++) {
//            int temp_size = temp_set.size();
//            temp_set.add(arr[i]);
//            if (temp_size != temp_set.size()) {
//                index = i;
//            }
//        }
//        end = index;
//        if (temp_set.size() == gem_count) {
//            int original_size = answer[1] - answer[0];
//            int temp_size = end - start;
//            if (temp_size < original_size || (temp_size == original_size && start < answer[0])) {
//                answer[0] = start + 1;
//                answer[1] = end + 1;
//            }
//        }
//    }
}