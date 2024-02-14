package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;
import bitcamp.util.TransactionManager;
import java.util.List;

public class BoardModifyHandler extends AbstractMenuHandler {

  private BoardDao boardDao;
  private AttachedFileDao attachedFileDao;
  private TransactionManager txManager;

  public BoardModifyHandler(TransactionManager txManager, BoardDao boardDao,
      AttachedFileDao attachedFileDao
  ) {
    this.boardDao = boardDao;
    this.attachedFileDao = attachedFileDao;
    this.txManager = txManager;
  }

  @Override
  protected void action(Prompt prompt) {
    try {
      int no = prompt.inputInt("번호? ");

      Board oldBoard = boardDao.findBy(no);
      if (oldBoard == null) {
        prompt.println("게시글 번호가 유효하지 않습니다.");
        return;
      }

      Board board = new Board();
      board.setNo(oldBoard.getNo()); // 기존 게시글의 번호를 그대로 설정한다.
      board.setTitle(prompt.input("제목(%s)? ", oldBoard.getTitle()));
      board.setContent(prompt.input("내용(%s)? ", oldBoard.getContent()));
      board.setWriter(prompt.input("작성자(%s)? ", oldBoard.getWriter()));
      board.setCreatedDate(oldBoard.getCreatedDate());

      List<AttachedFile> files = attachedFileDao.findAllByBoardNo(no);

      txManager.startTransaction();

      if (files.size() != 0) {
        for (AttachedFile file : files) {
          String filePath = prompt.input("파일경로(%s, 삭제는 엔터)? ", file.getFilePath());
          if (filePath.length() == 0) {
            attachedFileDao.delete(file.getNo());
          } else {
            file.setNo(file.getNo());
            file.setBoardNo(file.getBoardNo());
            file.setFilePath(filePath);
            attachedFileDao.update(file);
          }
        }
      }

      while (true) {
        String filePath = prompt.input("파일경로(종료는 엔터)? ");
        if (filePath.length() == 0) {
          break;
        }
        AttachedFile file = new AttachedFile();
        file.setBoardNo(no);
        file.setFilePath(filePath);
        attachedFileDao.add(file);
      }

      boardDao.update(board);

      txManager.commit();

      prompt.println("게시글을 변경했습니다.");
    } catch (Exception e) {
      try {
        txManager.rollback();
      } catch (Exception e2) {
      }
      prompt.println("목록 오류!");
    }
  }
}