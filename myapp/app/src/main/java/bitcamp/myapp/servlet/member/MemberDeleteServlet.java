package bitcamp.myapp.servlet.member;

import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.dao.mysql.MemberDaoImpl;
import bitcamp.myapp.vo.Member;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.TransactionManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {

  private MemberDao memberDao;
  private TransactionManager txManager;

  public MemberDeleteServlet() {
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

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (loginUser == null) {
      out.println("<p>로그인하시기 바랍니다.</p>");
      out.println("</body>");
      out.println("</html>");
      return;
    }

    try {
      txManager.startTransaction();

      int no = Integer.parseInt(request.getParameter("no"));

      Member member = memberDao.findBy(no);
      if (member.getNo() != loginUser.getNo()) {
        out.println("<p>권한이 없습니다.</p>");
        return;
      }

      if (memberDao.delete(no) == -1) {
        out.println("<p>회원 번호가 유효하지 않습니다!</p>");
      } else {
        out.println("<p>회원을 삭제했습니다.</p>");
      }

      txManager.commit();

    } catch (Exception e) {
      try {
        txManager.rollback();
      } catch (Exception e2) {
      }
      out.println("<p>삭제 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }

    out.println("  </tbody>");
    out.println("</table>");
  }
}
