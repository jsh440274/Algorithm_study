import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution2 {

    private static int[] finishedBlocks;

    private static void solution(int day, int width, int[][] blocks) {
        // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        finishedBlocks = new int[width];
        int answer = 0;

        for (int i = 0; i < day; i++) {
            pq = new PriorityQueue<>();
            map = new HashMap<>();
            for (int j = 0; j < width; i++) {
                finishedBlocks[j] += blocks[i][j];
                int blocksize = map.put(finishedBlocks[j], j);
                pq.add(blocksize);
            }
            int leftmax = pq.poll();
            int rightmax = leftmax;
            while (!pq.isEmpty()) {
                int polled = pq.poll();
                int rightindex = map.get(rightmax);
                int leftindex = map.get(leftmax);
                int polledindex = map.get(polled);
                //오른쪽영역에서 가장 큰 애 찾기
                if (polledindex > rightindex) {
                    for (int j = polledindex; j <= rightindex; j++) {
                        answer += polled - finishedBlocks[j];
                        finishedBlocks[j] = polled;
                    }
                }
                //왼쪽 영역에서 가장 큰 애 찾기
                else if (polledindex < leftindex) {
                    for (int j = leftindex; j <= polledindex; j++) {
                        answer += polled - finishedBlocks[j];
                        finishedBlocks[j] = polled;
                    }
                }
                //그 사이에 있는 애면 패쓰
            }

        }

    }

    private static int find_big(int a, int b, int width) {
        int mid = (a + b) / 2;
        int maxIndex = mid;
        int max = finishedBlocks[mid];

        if (a != 0) {
            max = Math.max(max, find_big(a, mid, width));
        }
        if (b != width - 1) {
            max = Math.max(max, find_big(mid + 1, b, width));
        }
        return max;
    }

    private static class InputData {
        int day;
        int width;
        int[][] blocks;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.day = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.width = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.blocks = new int[inputData.day][inputData.width];
            for (int i = 0; i < inputData.day; i++) {
                String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
                for (int j = 0; j < inputData.width; j++) {
                    inputData.blocks[i][j] = Integer.parseInt(buf[j]);
                }
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

//    public static void main(String[] args) throws Exception {
//        InputData inputData = processStdin();
//
//        solution(inputData.day, inputData.width, inputData.blocks);
//    }
}