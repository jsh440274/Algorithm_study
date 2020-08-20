import java.util.ArrayList;

class no2 {
    public static char[] arr_oper = {'*', '+', '-'};//연산자들
    public static ArrayList<Long> nums = new ArrayList<>();//expression 숫자들
    public static ArrayList<Character> opers = new ArrayList<>();//expression 연산자들
    public static ArrayList<Character> list_opers = new ArrayList<>();//연산자 우선순위 리스트
    public static boolean[] visited = new boolean[3];//연산자들 순열 돌릴때 사용
    public static long answer = 0;

    public long solution(String expression) {
        String[] arr_nums = expression.split("\\+|\\-|\\*");//연산자 기준으로 나눔
        int index = 0;
        for (int i = 0; i < arr_nums.length; i++) {
            nums.add(Long.parseLong(arr_nums[i]));
            index += arr_nums[i].length();//charAt(index)는 무조건 연산자임. 숫자 다음에 무조건 연산자 나오기로 돼있으니까
            if (index < expression.length()) {
                char oper = expression.charAt(index);
                index++;
                opers.add(oper);
            }
        }
        oper_order(3);//연산자 우선순위 정해서 최솟값 구하기
        return answer;
    }

    public static void oper_order(int depth) {//연산자 우선순위 정하기. 다 정하면 calc로 연산
        if (depth == 0) {
            calc();
        } else {
            for (int i = 0; i < 3; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    list_opers.add(arr_oper[i]);
                    oper_order(depth - 1);
                    list_opers.remove(list_opers.size() - 1);
                    visited[i] = false;

                }
            }
        }
    }

    public static void calc() {//연산자 우선순위 정한거 대로 값 구함. 가장 작은 값을 answer로
        long temp = 0;
        ArrayList<Long> temp_nums = new ArrayList<>();
        ArrayList<Character> temp_opers = new ArrayList<>();
        for (int i = 0; i < opers.size(); i++) {//깊은 복사.......ArrayList그대로 할당하면 얕은 복사라서 원래거까지 바뀜 ㄷㄷ
            temp_nums.add(nums.get(i));
            temp_opers.add(opers.get(i));
        }
        temp_nums.add(nums.get(nums.size() - 1));
        for (int i = 0; i < list_opers.size(); i++) {//list_opers에 저장해놓은 우선순위대로 연산 진행함.
            for (int j = 0; j < temp_opers.size(); j++) {//temp_num(인덱스) 랑 temp_num(인덱스+1)를 temp_opers(인덱스)로 연산
                if (temp_opers.get(j) == list_opers.get(i)) {
                    long a = temp_nums.get(j);//이건 디버깅 편하라고 그냥 할당해줌
                    long b = temp_nums.get(j + 1);
                    if (list_opers.get(i) == '*') {
                        temp = a * b;
                    } else if (list_opers.get(i) == '+') {
                        temp = a + b;
                    } else {
                        temp = a - b;
                    }
                    temp_opers.remove(j);//어레이 리스트에서 사용한 애들 지워줌. 지워 줘도 뒤에 애들이 땡겨져 오니까 j--만 해주면 가능
                    temp_nums.remove(j + 1);//얘먼저 안하고 temp_nums.remove(j)두번 해도 되는데 헷갈릴까봐 이렇게함.
                    temp_nums.remove(j);
                    temp_nums.add(j, temp);//연산자랑 연산된 숫자들 두개 지우고 그 대신 연산 결과값만 j자리에 다시 넣어줌.
                    j--;
                }
            }
        }//다 정상적으로 끝나면 temp_num리스트에 하나만 남음.
        temp = temp_nums.get(0);//야도 디버깅 편하라고 그냥 해줌.
        answer = Math.max(answer, Math.abs(temp));
    }
}