import static java.lang.Thread.sleep;

import java.util.Scanner;


public class Elevator {

  private final int floorMin;
  private final int floorMax;
  public int curFloor = 0;
  public boolean elevatorGoingUp = false;
  boolean emergency = false;
  boolean doorsOpen = false;
  boolean elevatorOn = false;
  
  public int temp = 0;
  public int calls = 0;
  public int[] floor = new int[12];
  Scanner sFloor = new Scanner(System.in);


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
      elevatorOn = true;
      checkOn();
    }
    else{
      System.out.println("andar nao disponivel");

    }
  }


  public void checkOn() throws InterruptedException {
    if (elevatorOn = false){
      turnOn();
    };

  }
  public void turnOn() throws InterruptedException {
    while(calls>0){
      mover(nextFloor());
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


  public void mover(int num) throws InterruptedException {
    int mov = Math.abs(num - curFloor);
    boolean upElevator;
    temp = 0;

    upElevator = num >= curFloor;

    for(int i = 0; i<mov; i++){
      int floorSelected = 0;
      sleep1Sec();
      temp++;
      if (upElevator){
        curFloor ++;
        if (floor[curFloor-1] == 1){
          doorsOpen = true;
          System.out.println("select floor");
          floorSelected = sFloor.nextInt();
          if(floorSelected == curFloor){
            System.out.println("you select the current floor");
          }
          if(floorSelected>curFloor){

          }

        }
      }
      else{
        curFloor --;
      }
      System.out.println("floor " + curFloor);
    }

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
