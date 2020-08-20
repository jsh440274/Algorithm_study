public class Test {
    public static void main(String[] args) {
        //마라톤
//        Marathon s = new Marathon();
//
//        String[] a = {"mislav", "stanko", "mislav", "ana"};
//        String[] b = {"stanko", "ana", "mislav"};
//
//        String answer = s.solution(a,b);
//
//        System.out.println(answer);

        //모의고사
//        MoiTest s = new MoiTest();
//
//        int[] a = {1, 3, 2, 4, 2};
//        int [] answer = s.solution(a);
//        for(int i=0; i<answer.length; i++){
//            System.out.print(answer[i] + "  ");
//        }

        //K번째 수
//        K_num s = new K_num();
//
//        int[] a = {1, 5, 2, 6, 3, 7, 4};
//        int [][] b = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
//        int [] answer = s.solution(a,b);
//        for(int i=0; i<answer.length; i++){
//            System.out.print(answer[i] + "  ");
//        }

        //체육복 도난사건
//        PE_clothes s = new PE_clothes();
//
//        int n = 5	;
//        int[] a = {2,4};
//        int[] b = {1,3,5};
//        int answer = s.solution(n, a, b);
//        System.out.print(answer);

        //가운데 글자
//        Middle_char s = new Middle_char();
//        String a = "Solutio";
//        String answer = s.solution(a);
//        System.out.print(answer);

        //문자열 내림차순

//        Descending_order_string s = new Descending_order_string();
//        String a = "ZbcdWRWWefag";
//        String answer = s.solution(a);
//        System.out.print(answer);

        //이상한 문자 만들기
//        Strange_char s = new Strange_char();
//        String a = "try hello world";
//        String answer = s.solution(a);
//        System.out.print(answer);

        //캐시
//        int a = 2;
//        String[] b = {"Jeju", "Pangyo", "NewYork", "newyork"};
//        Cache s = new Cache();
//        int answer = s.solution(a, b);
//        System.out.println(answer);

        //카카오 4블럭
//        int a = 4;
//        int b = 5;
//        String[] c = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
//        Kakao_4blocks s = new Kakao_4blocks();
//        int answer = s.solution(a, b, c);
//        System.out.println(answer);

        //no1
//        String a = "aabbaccc";
//        no1 s = new no1();
//        int answer = s.solution(a);
//        System.out.println(answer);


        //no2
//        String a = "()))((()";
//        no2 s = new no2();
//        String answer = s.solution(a);
//        System.out.println(answer);

        //no3
        String[] a = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] b = {"fro??", "????o", "fr???", "fro???", "pro?"};
        no3 s = new no3();
        int[] answer = s.solution(a, b);
        for (int i=0; i< answer.length; i++){
            System.out.println(answer[i] + " ");
        }

        //no4
//        String[] a = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
//        String[] b = {"fro??", "????o", "fr???", "fro???", "pro?"};
//        no4 s = new no4();
//        int[] answer = s.solution(a, b);
//        for (int i=0; i< answer.length; i++){
//            System.out.println(answer[i] + " ");
//        }
    }
}
