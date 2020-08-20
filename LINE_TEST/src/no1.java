//import java.util.PriorityQueue;
//import java.util.Scanner;
//
//public class no1 {
//    public static int message_time(int[] messages, int consumer_num){
//        PriorityQueue<Integer> consumer = new PriorityQueue<>();
//        int full_time = 0;
//        for(int i=0; i<messages.length; i++){
//            if(consumer.size() < consumer_num){
//                consumer.add(messages[i]);
//            }
//            else{
//                int update_consumer = messages[i] + consumer.poll();
//                consumer.add(update_consumer);
//            }
//        }
//        while(!consumer.isEmpty()){
//            full_time = consumer.poll();
//        }
//        return full_time;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//
//        int[] messages = new int[a];
//
//        for(int i=0; i< a; i++){
//            messages[i] = sc.nextInt();
//        }
//
//        System.out.println(message_time(messages, b));
//    }
//}
