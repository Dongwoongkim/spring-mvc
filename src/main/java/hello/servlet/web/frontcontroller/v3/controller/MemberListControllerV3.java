package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.basic.domain.member.Member;
import hello.servlet.basic.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) throws IOException, ServletException {

        List<Member> members = memberRepository.findAll();
        ModelView mv = setModelView(members);
        return mv;
    }

    private ModelView setModelView(List<Member> members) {
        ModelView mv = new ModelView();
        mv.setViewName("members");
        Map<String, Object> model = mv.getModel();
        model.put("members", members);
        mv.setModel(model);
        return mv;
    }
}
