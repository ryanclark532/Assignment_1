public class Main {
    public static void main(String[] args) {
        simBoard mainBoard=new simBoard();
        Road road=new Road(30,1,1);
        mainBoard.addRoad(road);
        Car car=new Car("Car",0,1,1);

    }
}
