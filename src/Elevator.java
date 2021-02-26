import static java.lang.Thread.sleep;


public class Elevator {

  private final int floorMin;
  private final int floorMax;
  public int curFloor = 0;
  public boolean elevatorGoingUp = false;
  boolean emergency = false;
  boolean doorsOpen = false;
  public int temp = 0;
  public int calls = 0;
  public int[] floor = new int[12];


  public Elevator(int floorMin, int floorMax, int curFloor){
    this.curFloor = curFloor;
    this.floorMax = floorMax;
    this.floorMin = floorMin;
    for(int i=0; i<=floor.length;i++){
        floor[i]=-1;
      }
  }

  public void call(int num,boolean up) throws InterruptedException {
    if(num>=floorMin && num<=floorMax){
      calls++;
      if(up) {
        floor[num + 1] = 1;
      }
      else {
        floor[num + 1] = -1;
      }
      TurnOn();
    }
    else{
      System.out.println("andar nao disponivel");

    }
  }

  public void selectFloor(int goFloor){


  }

  public void TurnOn() throws InterruptedException {
    while(calls > 0) {
      nextFloor();
    }
  }

  public int nextFloor(){
    int nextFloor = 13;
    int comp=13;
    for(int i=0; i<floor.length;i++) {
      if(floor[i]!=0 && Math.abs(curFloor-i)<comp){
        comp = Math.abs(curFloor-i);
        nextFloor = i;
      }
    }
    return nextFloor;
  }







  public int mover(int num) throws InterruptedException {
    int mov = Math.abs(num - curFloor);
    boolean upElevator;
    temp = 0;

    upElevator = num >= curFloor;

    for(int i = 0; i<mov; i++){
      sleep1Sec();
      temp++;
      if (upElevator){
        curFloor ++;
      }
      else{
        curFloor --;
      }
      System.out.println("floor " + curFloor);
    }

    return temp;

  }

  public void sleep1Sec() throws InterruptedException {
    sleep(1000);
  }


  public static void main(String[] args) throws InterruptedException {
    Elevator E1 = new Elevator(-1,9,1);
    E1.call(2,true);
    //E1.callEmergency();
    //E1.selectFloor();


  }

}
