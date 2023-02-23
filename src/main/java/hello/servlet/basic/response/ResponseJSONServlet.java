package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="responseJSONServlet",urlPatterns = "/response-json")
public class ResponseJSONServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Content-type : application/json
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        HelloData hellodata = new HelloData();
        hellodata.setName("Kim");
        hellodata.setAge(20);

        String s = objectMapper.writeValueAsString(hellodata);

        response.getWriter().write(s);

    }
}
