package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {
    @Override
    public ModelView process(Map<String, String> paramMap) throws IOException, ServletException {
        ModelView mv = new ModelView();
        mv.setViewName("new-form");
        return mv;
    }
}
