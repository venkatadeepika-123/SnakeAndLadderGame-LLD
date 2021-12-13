package Services;

import Models.Ladder;
import Models.Snake;
import Models.Player;
import Models.Board;
import java.util.*;
public class SnakeLadderService {
    private Board board;
    private Queue<Player> players;
    private int noOfPlayers;
    private static int DEFAULTVALUE = 100;
    private int size;

    public SnakeLadderService(int size){
        this.size = size;
        this.board = new Board(size);
        this.players = new LinkedList<Player>();
    }

    public SnakeLadderService(){
        this(DEFAULTVALUE);
    }

    public void setPlayers(List<Player> players){
        this.noOfPlayers = players.size();
        HashMap<String, Integer> playerPiece = new HashMap<String, Integer>();
        for (Player p : players) {
            this.players.offer(p);
            playerPiece.put(p.getPlayerName(), 0);
        }
        this.board.setLocation(playerPiece);
    }

    public void setSnake(List<Snake> snakes){
        this.board.setSnakes(snakes);
    }

    public void setLadder(List<Ladder> ladders){
        this.board.setLadders(ladders);
    }

    public void startGame() {

        while (!isGameEnded()) {
            int diceValue = getCurrentRollValue();
            int count = 0;
            Player curPlayer = this.players.poll();
            movePosition(curPlayer, diceValue);
            if (isPlayerWon(curPlayer)) {
                System.out.println("Hurry! Player " + curPlayer.getPlayerName() + " won the game!!\n");
                this.board.getLocation().remove(curPlayer.getPlayerName());
            } else {
                this.players.offer(curPlayer);
            }
        }
    }

    public boolean isGameEnded() {
        return this.players.size() == 1;
    }

    public int getCurrentRollValue() {
        return DiscService.rollingOfDisc();
    }

    public void movePosition(Player player, int diceValue) {

        int currPosition = this.board.getLocation().get(player.getPlayerName());

        int nextPosition = currPosition + diceValue;

        if (nextPosition > this.size) {
            nextPosition = currPosition;
        } else {
            nextPosition = getNewPositionWithSnakesLadders(nextPosition);
        }

        this.board.getLocation().put(player.getPlayerName(), nextPosition);

        System.out.println(
                "Player " + player.getPlayerName() + " moved from position " + currPosition + " to " + nextPosition);
    }

    public int getNewPositionWithSnakesLadders(int nextPosition) {
        int nextnewPositon;
        do {
            nextnewPositon = nextPosition;
            for (Snake nextSnake : this.board.getSnakes()) {
                if (nextSnake.getStartPoint() == nextPosition)
                    nextPosition = nextSnake.getEndPoint();
            }

            for (Ladder nextLadder : this.board.getLadders()) {
                if (nextLadder.getStartPoint() == nextPosition)
                    nextPosition = nextLadder.getEndPoint();
            }
        } while (nextnewPositon != nextPosition);
        return nextPosition;

    }

    public boolean isPlayerWon(Player player) {
        return this.board.getLocation().get(player.getPlayerName()) == size;
    }
}
