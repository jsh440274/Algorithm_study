//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//
//public class Main {
//    //먼저 나무들의 길이를 내림차순으로 sort한 다음 가장 큰값과 0을 기준으로 이분탐색하여 푼다.
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String[] inputArray = br.readLine().split(" ");
//
//        int treeCount = Integer.parseInt(inputArray[0]); // 나무의 수
//        int minLengthTree = Integer.parseInt(inputArray[1]); // 적어도 가져가야할 나무의 길이
//
//
//        String[] preTreeArray = br.readLine().split(" ");
//        int[] treeArray = new int[treeCount]; // 나무 높이들의 배열
//        for(int i=0; i<preTreeArray.length; i++){
//            treeArray[i] = Integer.parseInt(preTreeArray[i]);
//        }
//        Arrays.sort(treeArray); // 오름차순으로 정렬
//        int lastInt = treeArray[treeCount-1];
//
//        int maxHeight = lastInt; // 톱날의 최대 높이
//        int minHeight = 0; // 톱날의 최소 높이
//        int middle = 0;
//
//        while(maxHeight >= minHeight){
//            middle = (minHeight+maxHeight)/2;
//
//            int cutTree = 0; // 톱날로 나무를 잘랐을 때 남은 나무 길이
//            long sumCutTree = 0; // 잘라낸 나무 길이들의 합, long을 선언한 이유는 합이 int 범위를 넘어갈 수도 있다.
//
//            for(int j=0; j<treeArray.length; j++){
//
//                cutTree = treeArray[j] - middle; // 이분탐색으로 적절한 톱날의 높이를 찾아간다. 중간 값으로 나무들을 잘라보고
//                // 범위를 좁혀나간다.
//
//                if(cutTree <0){
//                    cutTree = 0; // 잘린게 없으면 0이기 때문에 마이너스 값은 존재할 수 없다.
//                }
//                sumCutTree += cutTree;
//            }
//
//            if(sumCutTree >= minLengthTree){ // 톱으로 잘라낸 나무 길이들의 합이 최소한으로 가져가야되는 나무 길이보다 클 때
//
//                minHeight = middle + 1; // 환경을 생각해서 딱 맞춰 잘라가려면 톱날의 높이를 높여서 나무를 조금만 잘라가야 한다.
//
//            }else if(sumCutTree < minLengthTree){ // 톱으로 잘라낸 나무 길이들의 합이 최소한으로 가져가야 되는 나무 길이보다 작을 때
//
//                maxHeight = middle - 1; // 필요한 나무길이보다 잘라낸 나무 길이들의 합이 작기 때문에 톱날의 높이를 낮춰서 더 길게 베어야 한다.
//
//            }
//
//        }
//
//        System.out.println(maxHeight);    // 톱날의 높이를 설정할 수 있는 높이에서 최대값
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    //먼저 나무들의 길이를 내림차순으로 sort한 다음 dp를 사용해서 푼다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //n과 m의 값을 입력받음
        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        long m = Integer.parseInt(line[1]);
        //나무들의 값들을 입력받음. (n개)
        line = br.readLine().split(" ");

        long[] trees = new long[n];
        //가장 큰 나무의 바로 위쪽을 잘랐을 때 나오는 나무들을 저장.
        long[] dp = new long[n];
        //가장 큰 나무의 위쪽을 잘랐을 때는 아무것도 안나옴.
        dp[n - 1] = 0;

        for (int i = 0; i < trees.length; i++) {
            trees[i] = Long.parseLong(line[i]);
        }

        Arrays.sort(trees);

        //나무 하나밖에 없을때
        if (n == 1) {
            System.out.println(trees[0] - m);
        } else {
            //어디까지 잘랐는지
            int index = 0;
            //index부터 n까지 남은 나무들
            long count = 0;
            //실제 잘라야 하는 길이;
            long res = 0;
            for (int i = n - 1; i > 0; i--) {
                count++;
                long diff = trees[i] - trees[i - 1];
                dp[i - 1] += dp[i] + diff * count;
                if (dp[i - 1] >= m) {
                    index = i;
                    res = trees[i];
                    break;
                }
            }
            while (dp[index] < m) {
                res--;
                dp[index] += n - index;
            }
            System.out.println(res);
        }
    }
}

//import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.util.Arrays;
//
//public class Main {
//    //먼저 나무들의 길이를 내림차순으로 sort한 다음 dp를 사용해서 푼다.
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        //n과 m의 값을 입력받음
//        String[] line = br.readLine().split(" ");
//
//        int n = Integer.parseInt(line[0]);
//        long m = Integer.parseInt(line[1]);
//        //나무들의 값들을 입력받음. (n개)
//        line = br.readLine().split(" ");
//
//        long[] trees = new long[n];
//        //가장 큰 나무의 바로 위쪽을 잘랐을 때 나오는 나무들을 저장.
//        long[] dp = new long[n];
//        //가장 큰 나무의 위쪽을 잘랐을 때는 아무것도 안나옴.
//        dp[n - 1] = 0;
//
//        for (int i = 0; i < trees.length; i++) {
//            trees[i] = Long.parseLong(line[i]);
//        }
//
//        Arrays.sort(trees);
//
//        //나무 하나밖에 없을때
//        if (n == 1) {
//            System.out.println(trees[0] - m);
//        } else {
//            boolean flag = true;
//            for (int i = n - 2; i >= 0; i--) {
//                dp[i] = (n - 1 - i) * (trees[i + 1] - trees[i]) + dp[i + 1];
//                if (dp[i] >= m) {
//                    flag = false;
//                    //여기에서 잘못이야.
//                    //여기에서 trees[i]에 m보다 작아지지 않는 선에서 n-1-i의 값만큼 더해줘야함.
//                    int plus = 0;
//                    while (dp[i] - (n - 1 - i) > m) {
//                        plus++;
//                        dp[i] -= n - 1 - i;
//                    }
//                    System.out.println(trees[i] + plus);
//                    break;
//                }
//            }
//            if (flag) {
//                int i = 0;
//                while (dp[0] < m) {
//                    dp[0] += n;
//                    i++;
//                }
//                System.out.println(trees[0] - i);
//
////                long temp = (m - dp[0]) / n;
////                if ((m - dp[0]) % n != 0) {
////                    temp++;
////                }
////                temp = trees[0] - temp;
////                System.out.println(temp);
//            }
//        }
//    }
//}