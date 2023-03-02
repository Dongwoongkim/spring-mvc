package hello.servlet.web.frontcontroller.v4;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import hello.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV4" , urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {
    private Map<String, ControllerV4> controllerMap = new HashMap<>();

    public FrontControllerServletV4()
    {
        controllerMap.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        controllerMap.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
        controllerMap.put("/front-controller/v4/members", new MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        ControllerV4 controllerV4 = controllerMap.get(requestURI);

        Map<String,String> paramMap = createParamMap(request);
        Map<String,Object> model = new HashMap<>();

                                               //파라미터정보, JSP instance 설정 -> return ViewName;
        String viewName = controllerV4.process(paramMap, model);

        ModelView mv = new ModelView(viewName);
        mv.setModel(model);

        MyView view = new MyView(viewResolver(viewName));

        view.render(mv.getModel(),request,response);
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {

        Map<String, String> pm = new HashMap<>();

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName-> pm.put(paramName,request.getParameter(paramName)));

        return pm;
    }

    private String viewResolver(String viewName) {
        return "/WEB-INF/views/" + viewName + ".jsp";
    }
}
