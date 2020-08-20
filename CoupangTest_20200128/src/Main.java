import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        no1 no1 = new no1();
        no2 no2 = new no2();
        no3 no3 = new no3();

        int[][] n = {{},};


//        int[] positions = {6, -10, 2, -6};
//        int[] result = no1.solution(6,	-10,	10, positions);
//        for (int i = 0; i < result.length; i++) {
//            System.out.print(result[i] + "  ");
//        }


//        no2.solution();
//        System.out.println();


        String[] logs = {"12:00:00.100 0.400", "12:00:00.200 0.500", "12:00:00.300 0.100", "12:00:00.400 0.600", "12:00:00.500 0.200", "12:00:00.600 0.400"};
        int[] answer = no3.solution(2, logs);
        System.out.println(answer[0] + "  " + answer[1]);
    }
}

