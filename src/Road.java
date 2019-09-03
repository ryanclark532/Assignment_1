public class Road {
    private double length;
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

    private void setxFinish(double xFinish) {
        this.xFinish = xFinish;
    }

    private void setyFinish(double yFinish) {
        this.yFinish = yFinish;
    }
}
