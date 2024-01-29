package algorithm.test;

public class Main {
  public static void main(String[] args) throws Exception {

    int[] a = new int[3];
    for (int i = 0; i < a.length; i++) {
      a[i] = i;
      System.out.println(a[i]);
    }

    System.out.println("------------------------");

    int[][] aa = new int[3][3];
    for (int i = 0; i < aa.length; i++) {
      aa[0][i] = a[i];
    }

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.println(aa[i][j]);
      }
    }

  }
}

