import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main3 {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat df = new SimpleDateFormat();
        String num = br.readLine();
        int n = Integer.parseInt(num);
        String line_standard = br.readLine();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date standard = sf.parse(line_standard);

        for (int m = 0; m < n; m++) {
            String line = br.readLine();
            String[] temp1 = line.split(" ");
            String[] temp2 = temp1[0].split("-");//년 월 일
            String[] temp3 = temp1[1].split(":");//시 분 초
            if (temp2.length != 3 || temp3.length != 3) {
                System.out.println("error");
                continue;
            }
            boolean flag = false;
            for (int i = 0; i < 3; i++) {
                if (temp2[i].equals("") || temp3[i].equals("")) {
                    System.out.println("error");
                    flag = true;
                    break;
                }
            }
            if (flag) {
                continue;
            }
            //심플 데이트 포멧으로 애들을 전부 엮어
            //위에서는 알맞은 표현인지 알아보고 아니면 바로 넘어갈 부분이니깐 무적권 맞는 포멧이라고 생각하고 코딩.
            //년, 월, 일 입력 받은 다음에 1년 이상인지 먼저 확인해서 그대로 적을건지 차이로 적을건지 판별해서 프린트
            Date current = sf.parse(line);
            long difference = (standard.getTime() - current.getTime()) / 1000;
            if (difference < 0) {
                System.out.println("error");
                continue;
            }
            if (difference / (60 * 60 * 24 * 30 * 12) > 1) {
                System.out.println(temp2[0] + "년" + temp2[1] + "월" + temp2[2] + "일");
            } else {
                //얼마전 프린트
            }
        }
    }
}
