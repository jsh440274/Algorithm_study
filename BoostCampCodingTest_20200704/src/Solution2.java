import java.util.ArrayList;

public class Solution2 {
    public static int[] solution(int[] A, int[]B){
        int[] answer = new int[5];
        ArrayList<Integer> setA = new ArrayList<>();
        ArrayList<Integer> setB = new ArrayList<>();
        ArrayList<Integer> sumAB = new ArrayList<>();

        for(int i=0; i< A.length; i++){
            if(!setA.contains(A[i])){
                setA.add(A[i]);
            }
        }
        for(int i=0; i< B.length; i++){
            if(!setB.contains(B[i])){
                setB.add(B[i]);
            }
        }
        sumAB.addAll(setA);
        for(int i=0; i< B.length; i++){
            if(!sumAB.contains(B[i])){
                sumAB.add(B[i]);
            }
        }

        return answer;
    }
}
