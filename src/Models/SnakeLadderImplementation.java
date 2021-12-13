package Models;

abstract class SnakeLadderImplementation {
    protected int startPoint;
    protected int endPoint;
    abstract public int getEndPoint();
    abstract public int getStartPoint();
    abstract public void setStartPoint(int startPoint);
    abstract public void setEndPoint(int endPoint);
}
