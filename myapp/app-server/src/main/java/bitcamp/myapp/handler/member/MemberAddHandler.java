package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.Prompt;
import java.sql.Connection;
import java.util.Date;

public class MemberAddHandler extends AbstractMenuHandler {

  private MemberDao memberDao;
  private DBConnectionPool connectionPool;


  public MemberAddHandler(DBConnectionPool connectionPool, MemberDao memberDao) {
    this.connectionPool = connectionPool;
    this.memberDao = memberDao;
  }

  @Override
  protected void action(Prompt prompt) {
    Connection con = null;
    try {
      con = connectionPool.getConnection();
      con.setAutoCommit(false);
      Member member = new Member();
      member.setEmail(prompt.input("이메일? "));
      member.setName(prompt.input("이름? "));
      member.setPassword(prompt.input("암호? "));
      member.setCreatedDate(new Date());

      con.commit();

      memberDao.add(member);
    } catch (Exception e) {
      try {
        con.rollback();
      } catch (Exception e2) {
      }
      prompt.println("회원 입력 중 오류 발생!");
      prompt.println("다시 시도하시기 바랍니다.");
    } finally {
      try {
        con.setAutoCommit(true);
      } catch (Exception e) {
      }

      connectionPool.returnConnection(con);
    }
  }
}
