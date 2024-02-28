package bitcamp.myapp.servlet.board;

import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/view")
public class BoardViewServlet extends HttpServlet {

  private BoardDao boardDao;
  private AttachedFileDao attachedFileDao;

  @Override
  public void init() {
    this.boardDao = (BoardDao) this.getServletContext().getAttribute("boardDao");
    this.attachedFileDao = (AttachedFileDao) this.getServletContext()
        .getAttribute("attachedFileDao");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String title = "";

    try {
      int category = Integer.valueOf(request.getParameter("category"));
      title = category == 1 ? "게시글" : "가입인사";

      int no = Integer.parseInt(request.getParameter("no"));
      Board board = boardDao.findBy(no);
      if (board == null) {
        throw new Exception("번호가 유효하지 않습니다.");
      }
      List<AttachedFile> files = attachedFileDao.findAllByBoardNo(no);

      request.setAttribute("files", files);
      request.setAttribute("title", title);
      request.setAttribute("category", category);
      request.setAttribute("board", board);

      request.getRequestDispatcher("/board/view.jsp").forward(request, response);

    } catch (Exception e) {
      request.setAttribute("message", String.format("%s 조회 오류!", title));
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}
