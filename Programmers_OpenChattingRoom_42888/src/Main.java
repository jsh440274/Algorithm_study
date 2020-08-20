public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        String record[] = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};

        String[] res = s.solution(record);

        for (String i : res) {
            System.out.println(i);
        }
    }
}
