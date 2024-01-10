package bitcamp.myapp.dao;

import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;

public class DaoTest extends AbstractDao<Member> {

  public static void main(String[] args) {
    DaoTest obj = new DaoTest();
    obj.loadData("app/member.json");

    for (Member member : obj.list) {
      System.out.println(member);
    }
  }

}
