import java.util.*;

class Solution {
    public int solution(String skill, String[] skilll_trees) {
        int answer = 0;
        ArrayList<String> tree = new ArrayList<>(Arrays.asList(skilll_trees));
        Iterator<String> it = tree.iterator();

        while (it.hasNext()) {
            if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
                it.remove();
            }
        }
        answer = tree.size();
        return answer;
    }

//    public int solution(String skill, String[] skill_trees) {
//        int answer = 0;
//        ArrayList<Character> tree = new ArrayList<>();
//        Set<Character> skill_set = new HashSet<>();
//
//        for (int i = 0; i < skill.length(); i++) {
//            tree.add(skill.charAt(i));
//            skill_set.add(skill.charAt(i));
//        }
//
//        for (String s : skill_trees) {
//            int index = 0;
//            boolean possible = true;
//            for (int i = 0; i < s.length(); i++) {
//                if (!skill_set.contains(s.charAt(i))) {
//                    continue;
//                } else {
//                    if (tree.get(index) == s.charAt(i)) {
//                        index++;
//                    } else {
//                        possible = false;
//                        break;
//                    }
//                }
//            }
//            if (possible) {
//                answer++;
//            }
//        }
//        return answer;
//    }
}