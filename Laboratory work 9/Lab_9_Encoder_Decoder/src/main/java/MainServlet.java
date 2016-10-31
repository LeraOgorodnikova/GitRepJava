
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
          String string;
          String answer="";
        String enc=req.getParameter("stringEncoder");
        String dec=req.getParameter("stringDecoder");
          if ((req.getParameter("stringEncoder")!=null)||(req.getParameter("stringDecoder")!=null)) {
             if (req.getParameter("stringEncoder") == null) {
                 // string = (String) req.getParameter("stringDecoder");
                  answer = Decoder.decode(dec);
                  req.setAttribute("answer1", answer);
              } else {
                  //string = (String) req.getParameter("stringEncoder");
                  answer = Encoder.encode(enc);
                  req.setAttribute("answer2", answer);
              }
          }
//        req.getRequestDispatcher("index.html").forward(req, resp);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println("<!DOCTYPE HTML>");
        resp.getWriter().println("<html><body><p><form action=\"\" method=\"GET\">\n" +
                "    <p>Введите строку (Encoder): <input type=\"text\" name=\"stringEncoder\"></p>\n" +
                "    <input type=\"submit\" value=\"Отправить\" />\n" +
                "</form>\n" +
                "<form action=\"\" method=\"GET\">\n" +
                "    <p>Введите строку (Decoder): <input type=\"text\" name=\"stringDecoder\"></p>\n" +
                "    <input type=\"submit\" value=\"Отправить\" />\n" +
                "</form>\n" +
                "<p>Ответ:" +answer+"</p></body></html>");

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        //super.doPost(req, resp);
    }
}
