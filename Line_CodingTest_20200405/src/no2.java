public class no2 {
    public int solution(String answer_sheet, String[] sheets) {
        if (sheets.length <= 1) return 0;
        int answer = -1;
        int[][] map = new int[sheets.length][answer_sheet.length()];
        for (int i = 0; i < sheets.length; i++) {
            for (int j = i + 1; j < sheets.length; j++) {
                answer = Math.max(answer, suspicious(answer_sheet, sheets[i], sheets[j]));
            }
        }
        return answer;
    }

    public static int suspicious(String answer, String src, String dst) {
        int suspicious_count = 0;
        int longest = 0;
        int long_start = -1, long_end = -1;
        for (int i = 0; i < src.length(); i++) {
            char original = answer.charAt(i);
            char a = src.charAt(i);
            char b = dst.charAt(i);
            if (original != a || original != b) {
                if (a == b) {
                    suspicious_count++;
                    long_end = i;
                    longest = Math.max(long_end - long_start, longest);
                } else {
                    longest = Math.max(long_end - long_start, longest);
                    long_start = i;
                    long_end = i;
                }
            } else {
                longest = Math.max(long_end - long_start, longest);
                long_start = i;
                long_end = i;
            }
        }
        int ret = suspicious_count + (longest * longest);
        return ret;
    }
}
/*문제 설명
객관식 5지선다로 치러진 시험의 답안지가 있습니다. 이때, 어떤 두 응시자가 제출한 답안지에 대해서, 부정행위 가능성 지수는 아래와 같은 방식으로 계산할 수 있습니다.

의심 문항 = 같은 선택지를 골랐으나 오답인 문항
부정행위 가능성 지수 = 총 의심 문항의 수 + (가장 긴 연속된 의심 문항의 수)2
응시자들이 제출한 답안지들 사이에서 가장 높은 부정행위 가능성 지수를 찾아주세요.

제한 사항
answer_sheet는 정답지를 나타냅니다.
answer_sheet는 길이가 1 이상 100 이하인 문자열입니다.
1번 문항의 정답부터 차례대로 저장하고 있습니다.
answer_sheets는 1,2,3,4,5로만 이루어진 문자열입니다.
sheets는 응시자들이 제출한 답안지입니다.
sheets는 원소의 개수가 2 이상 200 이하인 문자열 배열입니다.
sheets의 각 원소는 한 응시자가 제출한 답안을 저장하고 있는 문자열입니다.
sheets의 모든 원소의 길이는 answer_sheet의 길이와 같습니다.
즉, 응시자 수(=sheets의 원소 개수)는 2명 이상 200명 이하이고, 문항의 수(=sheets의 각 원소의 길이=answer_sheet의 길이)는 1개 이상 100개 이하입니다.
sheets의 모든 원소는 1,2,3,4,5로만 이루어진 문자열입니다.
모든 답안지들 사이에서 가장 높은 부정행위 가능성 지수를 찾아서 return 해주세요.
입출력 예

answer_sheet	sheets	result
"4132315142"	["3241523133","4121314445","3243523133","4433325251","2412313253"]	17
"53241"	["53241", "42133", "53241", "14354"]	0
"24551"	["24553", "24553", "24553", "24553"]	2
입출력 예 설명

입출력 예 #1

정답	4	1	3	2	3	1	5	1	4	2
답안 1	3	2	4	1	5	2	3	1	3	3
답안 2	4	1	2	1	3	1	4	4	4	5
답안 3	3	2	4	3	5	2	3	1	3	3
답안 4	4	4	3	3	3	2	5	2	5	1
답안 5	2	4	1	2	3	1	3	2	5	3
위의 예시는 10개의 객관식 문항에 대해서, 5명의 응시자가 제출한 답안들입니다.
답안 1, 3 사이에서는 의심 문항이 8개 발견되었고, 가장 긴 연속된 의심 문항의 수는 3입니다. 따라서 답안 1, 3 사이의 부정행위 가능성 지수는 8 + 32 = 17입니다. 길이가 3인 연속된 의심 문항 구간이 두 곳 있지만(1~3번 문항, 5~7번 문항) 한 번만 더해주는 것에 유의해야 합니다.
답안 4, 5 사이에서는 의심 문항이 3개 발견되었고, 가장 긴 연속된 의심 문항의 수는 2입니다. 따라서 답안 4, 5 사이의 부정행위 가능성 지수는 3+22 = 7입니다.

입출력 예 #2

정답	5	3	2	4	1
답안 1	5	3	2	4	1
답안 2	4	2	1	3	3
답안 3	5	3	2	4	1
답안 4	1	4	3	5	4
어느 답안들 사이에도 의심 문항이 존재하지 않습니다.
답안 1, 3이 모두 같지만 정답과 일치하므로, 의심 문항으로 볼 수는 없습니다.
따라서, 0( = 0+02 )을 return 해주어야 합니다.

입출력 예 #3

정답	2	4	5	5	1
답안 1	2	4	5	5	3
답안 2	2	4	5	5	3
답안 3	2	4	5	5	3
답안 4	2	4	5	5	3
어느 두 개의 답안을 골라서 비교하더라도, 5번 문항이 유일한 의심 문항입니다.
따라서, 2( = 1+12 )을 return 해주어야 합니다.*/