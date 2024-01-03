package bitcamp.myapp;

import bitcamp.menu.MenuGroup;
import bitcamp.myapp.handler.HelpHandler;
import bitcamp.myapp.handler.assignment.AssignmentAddHandler;
import bitcamp.myapp.handler.assignment.AssignmentDeleteHandler;
import bitcamp.myapp.handler.assignment.AssignmentListHandler;
import bitcamp.myapp.handler.assignment.AssignmentModifyHandler;
import bitcamp.myapp.handler.assignment.AssignmentViewHandler;
import bitcamp.myapp.handler.board.BoardAddHandler;
import bitcamp.myapp.handler.board.BoardDeleteHandler;
import bitcamp.myapp.handler.board.BoardListHandler;
import bitcamp.myapp.handler.board.BoardModifyHandler;
import bitcamp.myapp.handler.board.BoardViewHandler;
import bitcamp.myapp.handler.member.MemberAddHandler;
import bitcamp.myapp.handler.member.MemberDeleteHandler;
import bitcamp.myapp.handler.member.MemberListHandler;
import bitcamp.myapp.handler.member.MemberModifyHandler;
import bitcamp.myapp.handler.member.MemberViewHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {

  Prompt prompt = new Prompt(System.in);

  List<Board> boardRepository = new LinkedList<>();
  List<Assignment> assignmentRepository = new LinkedList<>();
  List<Member> memberRepository = new ArrayList<>();
  List<Board> greetingRepository = new ArrayList<>();

  MenuGroup mainMenu;

  App() {
    prepareMenu();
    loadAssignment();
    loadBoard();
    loadMember();
  }

  public static void main(String[] args) throws Exception {
    new App().run();
  }

  void prepareMenu() {
    mainMenu = MenuGroup.getInstance("메인");

    MenuGroup assignmentMenu = mainMenu.addGroup("과제");
    assignmentMenu.addItem("등록", new AssignmentAddHandler(assignmentRepository, prompt));
    assignmentMenu.addItem("조회", new AssignmentViewHandler(assignmentRepository, prompt));
    assignmentMenu.addItem("변경", new AssignmentModifyHandler(assignmentRepository, prompt));
    assignmentMenu.addItem("삭제", new AssignmentDeleteHandler(assignmentRepository, prompt));
    assignmentMenu.addItem("목록", new AssignmentListHandler(assignmentRepository, prompt));

    MenuGroup boardMenu = mainMenu.addGroup("게시글");
    boardMenu.addItem("등록", new BoardAddHandler(boardRepository, prompt));
    boardMenu.addItem("조회", new BoardViewHandler(boardRepository, prompt));
    boardMenu.addItem("변경", new BoardModifyHandler(boardRepository, prompt));
    boardMenu.addItem("삭제", new BoardDeleteHandler(boardRepository, prompt));
    boardMenu.addItem("목록", new BoardListHandler(boardRepository, prompt));

    MenuGroup memberMenu = mainMenu.addGroup("회원");
    memberMenu.addItem("등록", new MemberAddHandler(memberRepository, prompt));
    memberMenu.addItem("조회", new MemberViewHandler(memberRepository, prompt));
    memberMenu.addItem("변경", new MemberModifyHandler(memberRepository, prompt));
    memberMenu.addItem("삭제", new MemberDeleteHandler(memberRepository, prompt));
    memberMenu.addItem("목록", new MemberListHandler(memberRepository, prompt));

    MenuGroup greetingMenu = mainMenu.addGroup("가입인사");
    greetingMenu.addItem("등록", new BoardAddHandler(greetingRepository, prompt));
    greetingMenu.addItem("조회", new BoardViewHandler(greetingRepository, prompt));
    greetingMenu.addItem("변경", new BoardModifyHandler(greetingRepository, prompt));
    greetingMenu.addItem("삭제", new BoardDeleteHandler(greetingRepository, prompt));
    greetingMenu.addItem("목록", new BoardListHandler(greetingRepository, prompt));

    mainMenu.addItem("도움말", new HelpHandler(prompt));
  }

  void run() {
    while (true) {
      try {
        mainMenu.execute(prompt);
        prompt.close();
        break;
      } catch (Exception e) {
        System.out.println("예외 발생!");
      }
    }
    saveAssignment();
    saveBoard();
    saveMember();
  }

  void saveAssignment() {
    try (FileOutputStream out = new FileOutputStream("assignment.data")) {

      out.write(assignmentRepository.size() >> 8);
      out.write(assignmentRepository.size());

      for (Assignment assignment : assignmentRepository) {

        String title = assignment.getTitle();
        byte[] bytes = title.getBytes(StandardCharsets.UTF_8);

        out.write(bytes.length >> 8);
        out.write(bytes.length);

        out.write(bytes);

        String content = assignment.getContent();
        bytes = content.getBytes(StandardCharsets.UTF_8);

        out.write(bytes.length >> 8);
        out.write(bytes.length);

        out.write(bytes);

        String date = assignment.getDeadline().toString();
        bytes = date.getBytes(StandardCharsets.UTF_8);

        out.write(bytes);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  void loadAssignment() {
    try (FileInputStream in = new FileInputStream("assignment.data")) {

      byte[] bytes = new byte[60000];
      int size = in.read() << 8 | in.read();

      for (int i = 0; i < size; i ++) {
        int len = in.read() << 8 | in.read();
        in.read(bytes, 0, len);
        String title = new String(bytes, 0, len ,StandardCharsets.UTF_8);

        len = in.read() << 8 | in.read();
        in.read(bytes, 0, len);
        String content = new String(bytes, 0, len, StandardCharsets.UTF_8);

        in.read(bytes, 0, 10);
        Date deadLine = Date.valueOf(new String(bytes, 0, 10, StandardCharsets.UTF_8));

        Assignment assignment = new Assignment();
        assignment.setTitle(title);
        assignment.setContent(content);
        assignment.setDeadline(deadLine);

        assignmentRepository.add(assignment);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  void saveBoard () {
    try (FileOutputStream out = new FileOutputStream("board.data")) {

      out.write(boardRepository.size() >> 8);
      out.write(boardRepository.size());

      for (Board board : boardRepository) {
        String title = board.getTitle();
        byte[] bytes = title.getBytes(StandardCharsets.UTF_8);

        out.write(bytes.length >> 8);
        out.write(bytes.length);

        out.write(bytes);

        String content = board.getContent();
        bytes = content.getBytes(StandardCharsets.UTF_8);

        out.write(bytes.length >> 8);
        out.write(bytes.length);

        out.write(bytes);

        String writer = board.getWriter();
        bytes = writer.getBytes(StandardCharsets.UTF_8);

        out.write(bytes.length >> 8);
        out.write(bytes.length);

        out.write(bytes);

        long date = board.getCreatedDate().getTime();
        out.write((int) (date >> 56));
        out.write((int) (date >> 48));
        out.write((int) (date >> 40));
        out.write((int) (date >> 32));
        out.write((int) (date >> 24));
        out.write((int) (date >> 16));
        out.write((int) (date >> 8));
        out.write((int) date);

      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  void loadBoard () {
    try (FileInputStream in = new FileInputStream("board.data")) {

      byte[] bytes = new byte[60000];
      int size = in.read() << 8 | in.read();

      for (int i = 0; i < size; i++) {

        int len = in.read() << 8 | in.read();
        in.read(bytes, 0, len);
        String title = new String(bytes, 0, len, StandardCharsets.UTF_8);

        len = in.read() << 8 | in.read();
        in.read(bytes, 0, len);
        String content = new String(bytes, 0, len, StandardCharsets.UTF_8);

        len = in.read() << 8 | in.read();
        in.read(bytes, 0, len);
        String writer = new String(bytes, 0, len, StandardCharsets.UTF_8);

        long date = ((long) in.read() << 56 ) |
            ((long) in.read() << 48 ) |
            ((long) in.read() << 40 ) |
            ((long) in.read() << 32 ) |
            ((long) in.read() << 24 ) |
            ((long) in.read() << 16 ) |
            ((long) in.read() << 8 ) |
            ((long) in.read());

        Board board = new Board();
        board.setTitle(title);
        board.setContent(content);
        board.setWriter(writer);
        board.setCreatedDate(new java.util.Date(date));

        boardRepository.add(board);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  void saveMember () {
    try (FileOutputStream out = new FileOutputStream("member.data")) {

      out.write(memberRepository.size() >> 8);
      out.write(memberRepository.size());

      for (Member member : memberRepository) {

        String email = member.getEmail();
        byte[] bytes = email.getBytes(StandardCharsets.UTF_8);

        out.write(bytes.length >> 8);
        out.write(bytes.length);

        out.write(bytes);

        String name = member.getName();
        bytes = name.getBytes(StandardCharsets.UTF_8);

        out.write(bytes.length >> 8);
        out.write(bytes.length);

        out.write(bytes);

        String password = member.getPassword();
        bytes = password.getBytes(StandardCharsets.UTF_8);

        out.write(bytes.length >> 8);
        out.write(bytes.length);

        out.write(bytes);

        long date = member.getCreatedDate().getTime();
        out.write((int) date >> 56);
        out.write((int) date >> 48);
        out.write((int) date >> 40);
        out.write((int) date >> 32);
        out.write((int) date >> 24);
        out.write((int) date >> 16);
        out.write((int) date >> 8);
        out.write((int) date);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  void loadMember() {
    try (FileInputStream in = new FileInputStream("member.data")) {

      byte[] bytes = new byte[60000];
      int size = in.read() << 8 | in.read();

      for (int i = 0; i < size; i++) {
        int len = in.read() << 8 | in.read();
        in.read(bytes, 0, len);
        String email = new String(bytes, 0, len, StandardCharsets.UTF_8);

        len = in.read() << 8 | in.read();
        in.read(bytes, 0, len);
        String name = new String(bytes, 0, len, StandardCharsets.UTF_8);

        len = in.read() << 8 | in.read();
        in.read(bytes, 0, len);
        String password = new String(bytes, 0, len, StandardCharsets.UTF_8);

        long date = ((long) in.read() << 56) |
            ((long) in.read() << 48) |
            ((long) in.read() << 40) |
            ((long) in.read() << 32) |
            ((long) in.read() << 24) |
            ((long) in.read() << 16) |
            ((long) in.read() << 8) |
            ((long) in.read());

        Member member = new Member();
        member.setEmail(email);
        member.setName(name);
        member.setPassword(password);
        member.setCreatedDate(new java.util.Date(date));

        memberRepository.add(member);

      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}