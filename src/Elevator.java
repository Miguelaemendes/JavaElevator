import static java.lang.Thread.sleep;

public class Elevator {

  private final int floorMin;
  private final int floorMax;
  public int curFloor = 0;
  boolean emergency = false;
  boolean pasWaiting = false;
  boolean doorsOpen = false;

  public Elevator(int floorMin, int floorMax, int curFloor){
    this.curFloor = curFloor;
    this.floorMax = floorMax;
    this.floorMin = floorMin;

  }

  public int call(int num) throws InterruptedException {
    if(num>=floorMin && num<=floorMax){
      int temp = mover(num);
      System.out.println("open doors");
      doorsOpen = true;
      return temp;

    }
    else{
      System.out.println("andar nao disponivel");
      return 0;
    }
  }

  public int travelTo(int num) throws InterruptedException{

    if(num>=floorMin && num<=floorMax){
      System.out.println("close doors");
      doorsOpen = false;
      int temp = mover(num);
      System.out.println("open doors");
      doorsOpen = true;
      return temp;

    }
    else{
      System.out.println("andar nao disponivel");
      return 0;
    }

  }

  public int mover(int num) throws InterruptedException {
    int mov = Math.abs(num - curFloor);
    boolean upElevator;
    int temp = 0;

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
    System.out.println(E1.call(9));


  }


}
