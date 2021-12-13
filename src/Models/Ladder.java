package Models;

public class Ladder extends SnakeLadderImplementation{
    public Ladder(int startPoint, int endPoint){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    @Override
    public int getStartPoint(){
        return startPoint;
    }

    @Override
    public void setStartPoint(int startPoint){
        this.startPoint = startPoint;
    }

    @Override
    public int getEndPoint(){
        return endPoint;
    }
    @Override
    public void setEndPoint(int endPoint){
        this.endPoint = endPoint;
    }
}
