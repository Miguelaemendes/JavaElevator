public class testes {

  public static void main(String[] args) {
    int curFloor = 5;
    int[] floor = new int[11];

    floor[3]=1;
    floor[10]=1;
    floor[5]=1;


    int nextFloor = 11;
    int comp=11;
    for(int i=0; i<floor.length;i++) {
      if(floor[i]!=0 && Math.abs(curFloor-i)<comp){
        comp = Math.abs(curFloor-i);
        nextFloor = i;
      }
    }

    System.out.println(nextFloor);

  }


}
