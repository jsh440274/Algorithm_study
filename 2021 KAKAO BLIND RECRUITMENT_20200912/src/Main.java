public class Main {
    public static void main(String[] args) {
//        //no1
//        Solution1 no1 = new Solution1();
//        String new_id1 = "...!@BaT#*..y.abcdefghijklm"	;
//        String res1 = no1.solution(new_id1);
//        System.out.println(res1);
//        String new_id2 = "z-+.^.";
//        String res2 = no1.solution(new_id2);
//        System.out.println(res2);
//        String new_id3 = "=.=";
//        String res3 = no1.solution(new_id3);
//        System.out.println(res3);
//        String new_id4 = "123_.def";
//        String res4 = no1.solution(new_id4);
//        System.out.println(res4);
//        String new_id5 = "abcdefghijklmn.p";
//        String res5 = no1.solution(new_id5);
//        System.out.println(res5);
//        String new_id6 = "";
//        String res6 = no1.solution(new_id6);
//        System.out.println(res6);
//
//
//
//
//
//        //no2
//        Solution2 no2 = new Solution2();
//        String[] orders1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//        int[] course1 = {2, 3, 4};
//        String[] res1 = no2.solution(orders1, course1);
//        print(res1);
//        String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
//        int[] course2 = {2, 3, 5};
//        String[] res2 = no2.solution(orders2, course2);
//        print(res2);
//        String[] orders3 = {"XYZ", "XWY", "WXA"};
//        int[] course3 = {2, 3, 4};
//        String[] res3 = no2.solution(orders3, course3);
//        print(res3);


//        //no3
//        Solution3 no3 = new Solution3();
//        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
//        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
//        int[] res = no3.solution(info, query);
//        print(res);
//

//        //no4
//        Solution4 no4 = new Solution4();
//
//
//
//
//
//
        //no5
        Solution5 no5 = new Solution5();

        String pt1 = "02:03:55";
        String at1 = "00:14:15";
        String[] logs1 = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
        String res1 = no5.solution(pt1, at1, logs1);
        System.out.println(res1);
        String pt2 = "99:59:59";
        String at2 = "25:00:00";
        String[] logs2 = {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"};
        String res2 = no5.solution(pt2, at2, logs2);
        System.out.println(res2);
        String pt3 = "50:00:00";
        String at3 = "50:00:00";
        String[] logs3 = {"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"};
        String res3 = no5.solution(pt3, at3, logs3);
        System.out.println(res3);

//        //no6
//        Solution6 no6 = new Solution6();

    }

    public static void print(int[] res) {
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void print(String[] res) {
        for (String i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void print(int[][] res) {
        StringBuilder sb = new StringBuilder();
        for (int[] i : res) {
            sb.append("{");
            for (int j : i) {
                sb.append(j + ",");
            }
            sb.append("},");
        }
        sb.substring(0, sb.length() - 1);
        System.out.println(sb.toString());
    }
}
