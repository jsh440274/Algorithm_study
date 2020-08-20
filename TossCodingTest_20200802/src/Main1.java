import java.io.*;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String line = br.readLine();
        String[] lines = line.split(",");
        int alpha = Integer.parseInt(lines[1]);
        String[] hexa = lines[0].split("#");

        int tohex = (alpha * 255) / 100;
        String alphaTohex = Integer.toHexString(tohex);

        sb.append("#");
        if (alphaTohex.length() == 1) {
            sb.append("0");
        }
        sb.append(alphaTohex.toUpperCase());
        sb.append(hexa[1]);
        System.out.println(sb.toString());

    }
}
