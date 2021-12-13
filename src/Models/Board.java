package Models;

import java.util.*;
public class Board {

    private int size;
    private List<Snake> snakes;
    private List<Ladder> ladders;
    private List<Player> players;
    private HashMap<String, Integer> location;

    public Board(int size){
        this.size = size;
        this.snakes = new ArrayList<Snake>();
        this.ladders = new ArrayList<Ladder>();
        this.players = new ArrayList<Player>();
        this.location = new HashMap<>();
    }

    public HashMap<String, Integer> getLocation() {
        return location;
    }

    public void setLocation(HashMap<String, Integer> location) {
        this.location = location;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }
}
