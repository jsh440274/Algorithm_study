import java.util.HashMap;
import java.util.Scanner;

public class Solution1 {
    private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers,
                                 int numOfGames, int[] numOfMovesPerGame) {
        // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.


        HashMap<Character, Integer> countingmap = new HashMap<>();
        char[] players = new char[numOfAllPlayers - 1];
        boolean[] fastplayers = new boolean[numOfAllPlayers];
        int nowseat = 0;
        char solle = 'A';

        countingmap.put('A', 1);
        for (int i = 0; i < players.length; i++) {
            players[i] = (char) ('B' + i);
            countingmap.put(players[i], 0);
        }

        for (int i = 0; i < numOfQuickPlayers; i++) {
            fastplayers[namesOfQuickPlayers[i] - 'A'] = true;
        }

        for (int i = 0; i < numOfGames; i++) {
            int move = numOfMovesPerGame[i];
            if (move < 0) {
                move += players.length;
            }
            nowseat += move;
            nowseat %= players.length;
            if (!fastplayers[players[nowseat] - 'A']) {
                char temp = solle;
                solle = players[nowseat];
                players[nowseat] = temp;
            }
            countingmap.put(solle, countingmap.get(solle) + 1);
        }


        for (int i = 0; i < players.length; i++) {
            System.out.println(players[i] + " " + countingmap.get(players[i]));
        }

        System.out.println(solle + " " + countingmap.get(solle));
    }

    private static class InputData {
        int numOfAllPlayers;
        int numOfQuickPlayers;
        char[] namesOfQuickPlayers;
        int numOfGames;
        int[] numOfMovesPerGame;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
            System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0, inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);

            inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.numOfMovesPerGame = new int[inputData.numOfGames];
            String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
            for(int i = 0; i < inputData.numOfGames ; i++){
                inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

//    public static void main(String[] args) throws Exception {
//        InputData inputData = processStdin();
//
//        solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers, inputData.numOfGames, inputData.numOfMovesPerGame);
//    }
}
