package bitcamp.myapp.controller;

import java.beans.PropertyEditorSupport;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Date;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalControllerAdvice {

  @InitBinder
  public void initBinder(WebDataBinder webDataBinder) {
    webDataBinder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
      public void setAsText(String text) throws IllegalArgumentException {
        this.setValue(Date.valueOf(text));
      }
    });
  }

  @ExceptionHandler
  public ModelAndView exceptionHandler(Exception e) {
    ModelAndView mv = new ModelAndView();
    mv.addObject("message", e);

    StringWriter stringwriter = new StringWriter();
    PrintWriter out = new PrintWriter(stringwriter);
    e.printStackTrace(out);

    mv.addObject("detail", stringwriter.toString());

    mv.setViewName("/error");
    return mv;
  }
}
