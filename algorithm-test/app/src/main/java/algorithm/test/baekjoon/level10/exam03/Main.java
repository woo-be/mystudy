package algorithm.test.baekjoon.level10.exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    Dot first = new Dot();
    Dot second = new Dot();
    Dot third = new Dot();

    StringTokenizer st = new StringTokenizer(br.readLine());
    first.setX(Integer.valueOf(st.nextToken()));
    first.setY(Integer.valueOf(st.nextToken()));

    st = new StringTokenizer(br.readLine());
    second.setX(Integer.valueOf(st.nextToken()));
    second.setY(Integer.valueOf(st.nextToken()));

    st = new StringTokenizer(br.readLine());
    third.setX(Integer.valueOf(st.nextToken()));
    third.setY(Integer.valueOf(st.nextToken()));

    Square square = new Square(first, second, third);
    Dot forth = square.getForth();

    System.out.printf("%d %d", forth.x, forth.y);

    br.close();
    // bw.flush();
    // bw.close();
  }
}


class Dot {
  int x;
  int y;

  void setX(int i) { x = i; }

  void setY(int i) { y = i; }

}


class Square {
  Dot first, second, third;
  Dot forth = new Dot();

  Square(Dot first, Dot second, Dot third) {
    this.first = first;
    this.second = second;
    this.third = third;
    this.forthSetX(first, second, third);
    this.forthSetY(first, second, third);
  }

  void forthSetX(Dot first, Dot second, Dot third) {
    if (first.x == second.x) {
      forth.x = third.x;
      return;
    }
    if (first.x == third.x) {
      forth.x = second.x;
      return;
    }
    if (second.x == third.x) {
      forth.x = first.x;
      return;
    }
  }

  void forthSetY(Dot first, Dot second, Dot third) {
    if (first.y == second.y) {
      forth.y = third.y;
      return;
    }
    if (first.y == third.y) {
      forth.y = second.y;
      return;
    }
    if (second.y == third.y) {
      forth.y = first.y;
      return;
    }
  }

  Dot getForth() {
    return forth;
  }

}
