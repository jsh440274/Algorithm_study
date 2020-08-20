public class Main {
    public static void main(String[] args) {

        no1 no1 = new no1();
        int result1 = no1.solution(8,4,7);
        System.out.println(result1);

        no2 no2 = new no2();
        String[] a = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        String[] b = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};

        int result2 = no2.solution(3,a);
        int result3 = no2.solution(3,b);


        System.out.println(result2);
        System.out.println(result3);
    }
}
