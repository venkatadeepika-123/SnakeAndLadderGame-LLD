import java.util.*;

import Models.Player;
import Models.Snake;
import Services.SnakeLadderService;
import Models.Ladder;
public class Runner {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int noOfPlayers = in.nextInt();
        List<Player> players = new ArrayList<>();
        for(int i=0; i<noOfPlayers; i++){
            players.add(new Player(in.next()));
        }

        int noOfSnakes = in.nextInt();
        List<Snake> snakes = new ArrayList<>();
        for(int i=0; i<noOfSnakes; i++){
            snakes.add(new Snake(in.nextInt(), in.nextInt()));
        }

        int noOfLadders = in.nextInt();
        List<Ladder> ladders = new ArrayList<>();
        for(int i=0; i<noOfLadders; i++){
            ladders.add(new Ladder(in.nextInt(), in.nextInt()));
        }

        SnakeLadderService s = new SnakeLadderService();
        s.setLadder(ladders);
        s.setSnake(snakes);
        s.setPlayers(players);
        s.startGame();
    }
}
