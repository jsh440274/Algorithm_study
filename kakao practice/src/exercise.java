import java.util.ArrayList;

public class exercise {
    public static void main(String[] args) {
        String normal1 = "abcde";
        String abnormal1 = "ab++--";

        normal1 = normal1.toUpperCase();
        abnormal1 = abnormal1.toUpperCase();

        ArrayList original = new ArrayList();
        ArrayList<String> tokenized = new ArrayList<>();

        char[] abn = abnormal1.toCharArray();

        for (int i = 0; i < abn.length - 1; i++) {
            if (65 > abn[i] || abn[i] > 90 || 65 > abn[i + 1] || abn[i + 1] > 90) {
                continue;
            }
            char[] temp = {abn[i], abn[i + 1]};
            String input = String.valueOf(temp);
            tokenized.add(input);
        }

        System.out.println(tokenized);
    }
}
