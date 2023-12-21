package algorithm.test.baekjoon.level02.exam06;

public class Main {
  public static void main(String[] args) {

    java.util.Scanner input = new java.util.Scanner(System.in);

    int h = input.nextInt();
    int m = input.nextInt();
    int time = input.nextInt();

    int timeH = time / 60;
    int timeM = time % 60;

    int endM = m + timeM;
    int endH = h + timeH;

    if (endM >= 60) {
      endM -= 60;
      endH++;
    }
    if (endH >= 24) {
      endH -= 24;
    }

    System.out.println(endH + " " + endM);

    input.close();
  }
}
