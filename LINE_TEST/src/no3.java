//import java.util.Scanner;
//
//public class no3 {
//    public static int bathroom_count(int[][] bathroom_table) {
//        int bathroom_count = 1;
//        for (int i = 0; i < bathroom_table.length; i++) {
//            for (int j = i + 1; j < bathroom_table.length; j++) {
//                if ((bathroom_table[j][0] > bathroom_table[i][0] && bathroom_table[j][0] < bathroom_table[i][1]) || (bathroom_table[j][1] > bathroom_table[i][0] && bathroom_table[j][1] < bathroom_table[i][1])) {
//                    bathroom_count++;
//                    break;
//                }
//            }
//        }
//
//        return bathroom_count;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//
//        int[][] bathroom_table = new int[a][2];
//
//        for (int i = 0; i < a; i++) {
//            bathroom_table[i][0] = sc.nextInt();
//            bathroom_table[i][1] = sc.nextInt();
//        }
//        System.out.println(bathroom_count(bathroom_table));
//    }
//}
