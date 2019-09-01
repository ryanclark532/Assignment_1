public class Road {
    public double length;
    public double xStart,yStart;
    public double xFinish,yFinish;
    public String orientation;

    public Road(int length, double xStart, double yStart, String orientation) {
        this.length = length;
        this.xStart = xStart;
        this.yStart = yStart;
        this.orientation=orientation;
        if (orientation.equals("vertical")) {
            setyFinish(this.yStart + this.length);
            setxFinish(this.xStart);
        }
        else {
            setxFinish(this.xStart + this.length);
            setyFinish(this.yStart);
        }

    }

    public void setxFinish(double xFinish) {
        this.xFinish = xFinish;
    }

    public void setyFinish(double yFinish) {
        this.yFinish = yFinish;
    }
}
