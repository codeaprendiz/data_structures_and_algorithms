public class CoinChange {

  public static void main(String[] args) {
    System.out.println(change(12,new int[]{1,2,5}));
  }

  public static int change(int amount, int[] coins) {
    int[] combinations = new int[amount+1];

    combinations[0]=1;

    for(int coin : coins) {
      for(int i=0; i<combinations.length; i++) {
        if( i>=coin ) {
          combinations[i]+=combinations[i-coin];
        }
      }
    }

    return combinations[amount];
  }
}
