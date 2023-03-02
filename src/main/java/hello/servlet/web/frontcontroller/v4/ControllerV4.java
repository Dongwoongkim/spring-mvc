package hello.servlet.web.frontcontroller.v4;

import hello.servlet.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public interface ControllerV4 {
    public String process(Map<String, String> paramMap, Map<String, Object> model) throws IOException, ServletException;
}

