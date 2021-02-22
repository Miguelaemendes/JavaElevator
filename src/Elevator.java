public class Elevator {

  private final int floorMin;
  private final int floorMax;
  public int curFloor = 0;

  public Elevator(int floorMin, int floorMax, int curFloor){
    this.curFloor = curFloor;
    this.floorMax = floorMax;
    this.floorMin = floorMin;

  }
//falta fazer a contagem dos segundos
  public int call(int num){
    int count=0;
    if(num>floorMin || num>floorMax){
      mover(num);
      return count;
    }
    else{
      System.out.println("andar nao disponivel");
      return count;
    }
  }

  public int mover(int num){

  }

}
