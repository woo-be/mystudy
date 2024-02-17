package bitcamp.myapp.servlet.assignment;

import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.dao.mysql.AssignmentDaoImpl;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.DBConnectionPool;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/assignment/view")
public class AssignmentViewServlet extends HttpServlet {

  private AssignmentDao assignmentDao;

  public AssignmentViewServlet() {
    DBConnectionPool connectionPool = new DBConnectionPool(
        "jdbc:mysql://localhost/studydb", "study", "Bitcamp!@#123");
    this.assignmentDao = new AssignmentDaoImpl(connectionPool);
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
    out.println("<h1>과제</h1>");

    try {
      int no = Integer.valueOf(request.getParameter("no"));
      Assignment assignment = assignmentDao.findBy(no);
      if (assignment == null) {
        out.println("<p>과제 번호가 유효하지 않습니다!</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }

      out.println("<form action='assignment/add'>");
      out.println("  <div>");
      out.printf("    번호: <input name='no' readonly type='text' value='%s'>\n", assignment.getNo());
      out.println("  </div>");
      out.println("  <div>");
      out.printf("    제목: <input name='title' type='text' value='%s'>\n", assignment.getTitle());
      out.println("  </div>");
      out.println("  <div>");
      out.printf("    내용: <textarea name='content'>%s</textarea>\n", assignment.getContent());
      out.println("  </div>");
      out.println("  <div>");
      out.printf("    기한: <input name='deadline' type='text' value='%s'>\n",
          assignment.getDeadline());
      out.println("  </div>");
      out.println("</form>");


    } catch (Exception e) {
      out.println("<p>조회 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }

    out.println("  </tbody>");
    out.println("</table>");
  }

}