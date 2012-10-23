package hello.app;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
@SuppressWarnings("serial")
public class HelloWorldServlet extends HttpServlet {  
  
    protected void doGet(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException, IOException {  
        this.process(request, response);  
    }  
  
    protected void doPost(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException, IOException {  
        this.process(request, response);  
    }  
  
    private void process(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException, IOException {  
	ServletContext context = getServletContext();
	final int mainVer = context.getMajorVersion();
	final int minVer = context.getMinorVersion();
	String version = Integer.toString(mainVer) + "." + Integer.toString(minVer);
        response.setContentType("text/html;charset=utf-8");  
        response.setCharacterEncoding("utf-8");  
        PrintWriter out = response.getWriter();  
        String title="Webapp Demo";  
        out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");  
        out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");  
        out.println("<head>");  
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\" />");  
        out.println("<title>" + title + "</title>");  
        out.println("<body>");  
        out.println("<h1>Hello, Servlet " + version + " World!</h1>");  
        out.println("</body>");  
        out.println("</html>");  
    }  
}
