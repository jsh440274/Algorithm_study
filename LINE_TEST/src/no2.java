//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class no2 {
//    public static void k_factorial(ArrayList<Integer> numbers, int k, int n) {
//        if (n != 0) {
//            int fact = factorial(n);
//            if (k % fact != 0) {
//                if (k > fact) {
//                    System.out.print(numbers.remove(k / fact));
//                    k_factorial(numbers, k - (fact * (k / fact)), n - 1);
//                } else {
////                    System.out.print();
//                    k_factorial(numbers, k, n - 1);
//                }
//            }
//            else {
//                System.out.print(numbers.remove(k / fact));
//                for (int i = 0; i < numbers.size(); i++) {
//                    System.out.print(numbers.get(i));
//                }
//            }
//        }
//    }
//
//    public static int factorial(int k) {
//        if (k <= 1) return k;
//        else {
//            return factorial(k - 1) * k;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String a = sc.nextLine();
//        int b = sc.nextInt();
//
//        String[] input = a.split(" ");
//        ArrayList<Integer> numbers = new ArrayList<>();
//        for (int i = 0; i < input.length; i++) {
//            numbers.add(Integer.parseInt(input[i]));
//        }
//        numbers.sort(null);
//        k_factorial(numbers, b, numbers.size());
//    }
//}