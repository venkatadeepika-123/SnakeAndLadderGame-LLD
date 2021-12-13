package Models;

public class Snake extends SnakeLadderImplementation{
    public Snake(int startPoint, int endPoint){
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
