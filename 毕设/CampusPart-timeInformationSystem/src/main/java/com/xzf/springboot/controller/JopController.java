package com.xzf.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzf.springboot.mongodb.JobDescription;
import com.xzf.springboot.pojo.JaU;
import com.xzf.springboot.pojo.Jop;
import com.xzf.springboot.pojo.tool.Result;
import com.xzf.springboot.pojo.tool.ResultJaU;
import com.xzf.springboot.pojo.tool.ResultJop;
import com.xzf.springboot.pojo.tool.ResultJopOne;
import com.xzf.springboot.service.JaUService;
import com.xzf.springboot.service.JopService;
import com.xzf.springboot.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@Controller
public class JopController {
    @Autowired
    private JopService jopService;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private JaUService jaUService;

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
//        System.out.println("?????????????????????"+mongoTemplate.findById(1,JobDescription.class).getDescription());
//        JobDescription user=new JobDescription(1,"?????????");
//        mongoTemplate.save(user,"JopDescriprions");//save ?????????_id ????????????????????? ?????????


        return "order-list";
    }

    //???????????????
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


    //????????????
    @PostMapping("/sys/pass")
    @ResponseBody
    public Result jopPassExamine(int jid){
        Integer j=null;
        Result result=null;
        int examine=1;

        j=jopService.updateJopExamine(jid,examine);
        if (j==1){
            result=new Result(0001,"??????");
        }else {
            result=new Result(0003,"?????????????????????????????????");
        }

        return result;
    }
    //???????????????
    @PostMapping("/sys/notpass")
    @ResponseBody
    public Result jopNotPassExamine(int jid,String errorreason){
        Integer j=null;
        Result result=null;
        int examine=2;

        j=jopService.updateJopNot(jid,examine,errorreason);
        if (j==1){
            result=new Result(0001,"?????????");
        }else {
            result=new Result(0003,"????????????????????????????????????");
        }



        return result;

    }

    //??????
    @GetMapping("/sys/jopDelete")
    @ResponseBody
    public Result jopDelete(int jid){
        Integer d=0;
        Result result=null;

        d=jopService.deleteJop(jid);

        if (d!=0 && d!=null){
            result=new Result(0001,"????????????");
        }else{
            result=new Result(0002,"????????????");
        }
        return result;
    }

    //????????????

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
            result=new Result(0001,"????????????,?????????"+s+"???");
        }else{
            result=new Result(0002,"????????????");
        }
        return result;



    }
//??????????????????
    @GetMapping("/fore/jop-list")
    @ResponseBody
    public ResultJop orderList(String username, HttpSession session){
        List<Jop> jopsD=new ArrayList<>();
        JobDescription jobDescription;
        List<Jop> jopenddates=null;
        List<Jop> jops=null;

        Timestamp date = new Timestamp(System.currentTimeMillis());

        session.setAttribute("loginUser", username);

        jopenddates=jopService.queryqJopList();
        System.out.println(jopenddates);


        for (Jop jop:jopenddates){
            if (jop.getEnddate().before(date)){//??????????????????
                System.out.println("????????????"+jop);
                jop.setValid(0);
               Integer c= jopService.changleVaild(jop);
                System.out.println(c);
            }
        }
        jops=jopService.queryqJopList();





        ResultJop resultJop= new ResultJop(0001,jops);

        return resultJop;

    }

//??????????????????
    @PostMapping("/fore/searchjop")
    @ResponseBody
    public ResultJopOne jopOne(Integer jid){
        ResultJopOne resultJopOne=null;
        Jop jop=null;
        Integer id=null;
        String jobdescription=null;
        String context=null;

        jop=jopService.queryjopListById(jid);

        jobdescription = jop.getJobdescription();
        id= Integer.valueOf(jobdescription);
        context=mongoTemplate.findById(id,JobDescription.class).getDescription();
        jop.setJobdescription(context);




        System.out.println(jop);
        if (jop !=null){
            resultJopOne=new ResultJopOne(0001,jop,"??????");
        }else {
            resultJopOne=new ResultJopOne(0002,null,"??????");
        }


        return resultJopOne;

    }

//????????????
    @PostMapping("/fore/addjop")
    @ResponseBody
    public Result addjop( String joptype,String sellerid, String enddate,String jobdescription,String number,String salary,String address){
        Result result=null;
        Jop jop=null;

        Integer sid=sellerService.querySellertByphone(sellerid);

        if (sid !=null){//????????????
            jop=new Jop();
            jop.setJoptype(joptype);
            jop.setSellerid(sellerid);
            Timestamp d = new Timestamp(System.currentTimeMillis());
            jop.setPubdate(d);

            jop.setEnddate(Timestamp.valueOf(enddate));

            Integer uuid=-1;
            while (uuid<0) {
                uuid=UUID.randomUUID().toString().replaceAll("-","").hashCode();
            }
            JobDescription jobDescription=new JobDescription(uuid,jobdescription);
            mongoTemplate.save(jobDescription, "JopDescriprions");
            jop.setJobdescription(String.valueOf(uuid));

            jop.setNumber(Integer.valueOf(number));
            jop.setSalary(salary);
            jop.setAddress(address);
            jop.setValid(1);
            jop.setExamine(0);
            Integer i=jopService.addjop(jop);

            if (i==1){
                result=new Result(0001,"????????????");
            }else {
                result=new Result(0002,"????????????");
            }
        }else {
            result=new Result(0003,"???????????????");
        }
        return result;
    }

// ?????????
    @PostMapping("/fore/Receivjop")
    @ResponseBody
    public Result recevijop(Integer jid,String uphone,String enddate){
        Result result=null;
        Jop jop=null;
        Integer n;
        Integer a;
        JaU jaU=new JaU();

        JaU jaU1 = jaUService.queryList(uphone, jid);

        if (jaU1==null){
            jop=jopService.queryjopListById(jid);
            if (jop !=null){
                //1.???????????????????????????
                if (jop.getNumber()-1 >= 0){
                    jop.setNumber(jop.getNumber()-1);
                    n = jopService.updataNumber(jop);

                    if (n==1){
                        //?????????????????????
                        jaU.setJid(jid);
                        jaU.setUphone(uphone);
                        Timestamp date = new Timestamp(System.currentTimeMillis());
                        jaU.setCdate(date);
                        jaU.setStatu(1);

                        jaU.setEnddate(Timestamp.valueOf(enddate));
                        a=jaUService.addJaU(jaU);
                        if (a==1){
                            result=new Result(0001,"??????????????????");
                        }else {
                            result=new Result(0004,"??????????????????");
                        }

                    }else {

                        result=new Result(0004,"??????????????????");
                    }

                }else {
                    jop.setValid(0);
                    Integer c= jopService.changleVaild(jop);
                    result=new Result(0003,"???????????????????????????????????????????????????");
                }

            }else {
                result=new Result(0001,"???????????????");
            }
        }else {
            result=new Result(0006,"????????????????????????????????????????????????????????????");
        }





        return result;
    }


    //???????????????????????????
    @PostMapping("/fore/torecivejop")
    @ResponseBody
    public ResultJaU seearchOrder(String uphone){
        ResultJaU resultJaU=null;
        List<JaU> jaus=null;
        List<JaU> jaub=null;
        Timestamp date = new Timestamp(System.currentTimeMillis());
        jaub=jaUService.queryByPhone(uphone);

        for (JaU jaU:jaub){
           if (jaU.getEnddate().before(date)){
               jaU.setStatu(0);
               jaUService.updateJaustatu(jaU);
           }
        }


        jaus=jaUService.queryByPhone(uphone);

        if (jaus !=null){
            resultJaU=new ResultJaU(0001,jaus,"??????????????????");
        }else {
            resultJaU=new ResultJaU(0002,null,"????????????????????????");
        }

        return resultJaU;
    }

    //?????????????????????????????????
    @PostMapping("/fore/toOldjop")
    @ResponseBody
    public ResultJop OldJop(String uphone){
        ResultJop resultJop=null;
        List<Jop> jops=null;

        jops=jopService.queryjopbyphone(uphone);

        if (jops!=null){
            resultJop=new ResultJop(0001,jops);
        }else {
            resultJop=new ResultJop(0002,null);
        }



        return resultJop;

    }

}
