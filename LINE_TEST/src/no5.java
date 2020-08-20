//import java.util.Scanner;
//
//public class no5 {
//    public static void shortest_route(int x, int y, int a, int b) {
//        if (x > a || y > b) {
//            System.out.println("fail");
//        } else {
//            System.out.println(route_count(x, y));
//            System.out.println(x + y);
//        }
//    }
//
//    public static int route_count(int x, int y) {
//        if (x == 0 || y == 0) {
//            return 1;
//        } else {
//            return route_count(x - 1, y) + route_count(x, y - 1);
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//
//        int x = sc.nextInt();
//        int y = sc.nextInt();
//
//        shortest_route(x, y, a, b);
//    }
//}