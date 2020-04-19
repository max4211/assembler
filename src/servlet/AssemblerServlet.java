package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AssemblerServlet extends HttpServlet {

    private static final String FILETYPE = "output-type";
    private static final String BASE = "output-base";

    /**
     * Life-cycle method invoked on servlet first access by client
     * @param config
     */
    public void init(ServletConfig config) {
        System.out.println("Servlet is being initialized :)");
    }

    /**
     * Handles HTTP GET request
     * @param request is the client request
     * @param response is the response to the client
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<html>Hello, I am a Java servlet!</html>");
        writer.flush();
    }

    /**
     * Handles HTTP POST request
     * @param request is the client request
     * @param response is the response to the client
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String outputType = request.getParameter(FILETYPE);
        String outputBase = request.getParameter(BASE);
        PrintWriter writer = response.getWriter();
        writer.println(String.format("<html>Servlet received type: %s and base: %s</html>", outputType, outputBase));
        writer.flush();
    }

    /**
     * Life-cyle method invoked when application is shutting down
     */
    public void destroy() {
        System.out.println("Servlet is being destroyed :(");
    }

}
