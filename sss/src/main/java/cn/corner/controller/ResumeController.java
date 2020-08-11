package cn.corner.controller;

import cn.corner.pojo.Resume;
import cn.corner.service.ResumeService;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @company: yzw
 * @author: connor.h.liu
 * @version: V1.0
 * date: 2020-08-11 10:11
 */
@RequestMapping("/resume")
@Controller
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @RequestMapping(value="/list",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView list(ModelAndView modelAndView){
        List<Resume> list = resumeService.list();
        modelAndView.setViewName("list");
        modelAndView.addObject("list",list);
        return modelAndView;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public String save(@RequestBody Resume resume){
        resumeService.save(resume);
        return "success";
    }

    @RequestMapping(value="/delete",method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@RequestParam Long id){
        resumeService.delete(id);
        return "success";
    }
}
