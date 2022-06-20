package com.mentorproject.Controller;

import com.mentorproject.Dao.ApplicationRecordRep;
import com.mentorproject.Entity.ApplicationRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/application")
public class ApplicationRecordController {

    @Autowired
    private ApplicationRecordRep appRecRep;

    /**
     * 查询所有志愿提交记录信息
     * @return
     **/
    @RequestMapping(value = "/getall", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView getAppRecList(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("appRecList", appRecRep.findAll());
        mav.setViewName("applicationshow");
        return mav;
    }

    /**
     * 添加一条志愿提交记录
     * @param studentId
     * @param firstApp
     * @param secondApp
     * @param thirdApp
     * @param isSelected
     **/
    @RequestMapping(value = "/add",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView addAppRec(@RequestParam("studentId") String studentId,
                                  @RequestParam("firstApp") String firstApp,
                                  @RequestParam("secondApp") String secondApp,
                                  @RequestParam("thirdApp") String thirdApp,
                                  @RequestParam("isSelected") Integer isSelected){
        ApplicationRecord appRec = new ApplicationRecord();
        appRec.setStudentId(studentId);
        appRec.setFirst_app(firstApp);
        appRec.setSecond_app(secondApp);
        appRec.setThird_app(thirdApp);
        appRec.setIs_selected(isSelected);
        appRecRep.save(appRec);
        ModelAndView mav = new ModelAndView("redirect:/application/getall");
        return mav;
    }

    /**
     * 查询自己填写的志愿信息
     * @param student_id
     **/
    @RequestMapping(value = "/getStudent",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView getAppRecByStudentId(@RequestParam("student_id") String student_id){
        List<ApplicationRecord> appRecList = appRecRep.getApplicationRecordByStudentId(student_id);
        ModelAndView mav = new ModelAndView();
        if (appRecList.isEmpty()){
            mav.setViewName("errorpage");
        }else {
            mav.addObject("appRecList", appRecList);
            mav.setViewName("applicationshow");
        }
        return mav;
    }
}
