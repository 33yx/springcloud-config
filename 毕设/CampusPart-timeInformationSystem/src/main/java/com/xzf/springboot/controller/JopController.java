package com.xzf.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzf.springboot.mongodb.JobDescription;
import com.xzf.springboot.pojo.Jop;
import com.xzf.springboot.pojo.Result;
import com.xzf.springboot.pojo.tool.ResultJop;
import com.xzf.springboot.service.JopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
public class JopController {
    @Autowired
    private JopService jopService;

    private final MongoTemplate mongoTemplate;

    @Autowired
    public JopController(MongoTemplate mongoTemplate){

        this.mongoTemplate = mongoTemplate;
    }



    @GetMapping("/sys/order-list")
    public String orderList(Model model, @RequestParam(defaultValue = "1",value = "pageNum")int pageNum){
        List<Jop> jopsD=new ArrayList<>();


        JobDescription jobDescription;


        PageHelper.startPage(pageNum,5);
        List<Jop> jops=jopService.queryJopList();

        System.out.println(jops);

//        for (Jop jop:jops){
//             jobdescription = jop.getJobdescription();
//            id= Integer.valueOf(jobdescription);
//            context=mongoTemplate.findById(id,JobDescription.class).getDescription();
////            jop.setJobdescription(context);
//        }
        if (!StringUtils.isEmpty(String.valueOf(jops))){
            PageInfo<Jop> page=new PageInfo<>(jops);

            model.addAttribute("jops",page);
        }

//        Update update=new Update();
//        update.set("description","jj");

//        mongoTemplate.updateFirst(Query.query(Criteria.where("id").is(1)),update, JobDescription.class);
//
//        System.out.println("修改后的值为："+mongoTemplate.findById(1,JobDescription.class).getDescription());
//        JobDescription user=new JobDescription(1,"九州鼎");
//        mongoTemplate.save(user,"JopDescriprions");//save 方法在_id 存在时更新数据 遍历慢


        return "order-list";
    }

    //到审核页面
    @GetMapping("/sys/order-examine/{jid}")
    public String toUserEdit(@PathVariable("jid") Integer jid, Model model){
        Integer id=null;
        String jobdescription=null;
        String context=null;
        Jop jop=jopService.queryjopListById(jid);

        if (!StringUtils.isEmpty(String.valueOf(jop))){


            jobdescription = jop.getJobdescription();
            id= Integer.valueOf(jobdescription);
            context=mongoTemplate.findById(id,JobDescription.class).getDescription();
            jop.setJobdescription(context);

            model.addAttribute("jopd",jop);
            return "order-examine";
        }else {
            return "error";
        }




    }


    //审核通过
    @PostMapping("/sys/pass")
    @ResponseBody
    public Result jopPassExamine(int jid){
        Integer j=null;
        Result result=null;
        int examine=1;

        j=jopService.updateJopExamine(jid,examine);
        if (j==1){
            result=new Result(0001,"通过");
        }else {
            result=new Result(0003,"通过失败，未知系统错误");
        }

        return result;
    }
    //审核不通过
    @PostMapping("/sys/notpass")
    @ResponseBody
    public Result jopNotPassExamine(int jid,String errorreason){
        Integer j=null;
        Result result=null;
        int examine=2;

        j=jopService.updateJopNot(jid,examine,errorreason);
        if (j==1){
            result=new Result(0001,"不通过");
        }else {
            result=new Result(0003,"不通过失败，未知系统错误");
        }



        return result;

    }

    //删除
    @GetMapping("/sys/jopDelete")
    @ResponseBody
    public Result jopDelete(int jid){
        Integer d=0;
        Result result=null;

        d=jopService.deleteJop(jid);

        if (d!=0 && d!=null){
            result=new Result(0001,"删除成功");
        }else{
            result=new Result(0002,"删除失败");
        }
        return result;
    }

    //删除所有

    @GetMapping("/sys/deljopall")
    @ResponseBody
    public Result userDelallall(String jids) {
        Result result = null;
        int d = 0;
        Integer s=0;
        String[] jidlist = jids.split(",");
        for (int i=0;i<jidlist.length;i++){
            d=jopService.deleteJop(Integer.parseInt(jidlist[i]));
            s+=d;
        }
        if (s!=0 && s!=null){
            result=new Result(0001,"删除成功,共删除"+s+"条");
        }else{
            result=new Result(0002,"删除失败");
        }
        return result;



    }

    @GetMapping("/fore/order-list")
    @ResponseBody
    public ResultJop orderList(String username, HttpSession session){
        List<Jop> jopsD=new ArrayList<>();
        JobDescription jobDescription;
        List<Jop> jops=null;
        session.setAttribute("loginUser", username);

        jops=jopService.queryJopList();

        ResultJop resultJop= new ResultJop(0001,jops);

        System.out.println("进入查找"+jops);

        return resultJop;

    }


}
