package bitcamp.myapp.servlet.member;

import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.dao.mysql.MemberDaoImpl;
import bitcamp.myapp.vo.Member;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.TransactionManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/add")
public class MemberAddServlet extends HttpServlet {

  private MemberDao memberDao;
  private TransactionManager txManager;

  public MemberAddServlet() {
    DBConnectionPool connectionPool = new DBConnectionPool(
        "jdbc:mysql://localhost/studydb", "study", "Bitcamp!@#123");
    this.memberDao = new MemberDaoImpl(connectionPool);
    this.txManager = new TransactionManager(connectionPool);
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");

    out.println("  <title>비트캠프 데브옵스 5기</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원</h1>");

    try {
      txManager.startTransaction();

      Member member = new Member();
      member.setEmail(request.getParameter("email"));
      member.setName(request.getParameter("name"));
      member.setPassword(request.getParameter("password"));
      member.setCreatedDate(new Date());

      memberDao.add(member);

      txManager.commit();

      out.println("<p>회원을 등록했습니다.</p>");

    } catch (Exception e) {
      try {
        txManager.rollback();
      } catch (Exception e2) {
      }
      out.println("<p>추가 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }

    out.println("  </tbody>");
    out.println("</table>");
  }
}
