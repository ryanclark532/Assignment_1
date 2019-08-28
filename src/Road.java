public class Road {
    public int length;
    public int xStart,yStart;
    public int xFinish,yFinish;
    public String orientation;

    public Road(int length, int x, int y, String orientation) {
        this.length = length;
        this.xStart = x;
        this.yStart = y;
        this.orientation=orientation;
        if(orientation.equals("horizontal")){
            xFinish=xStart+length;
            yFinish=yStart;
        }
        else {
            xFinish=xStart;
            yFinish=yStart+length;
        }
    }


}
