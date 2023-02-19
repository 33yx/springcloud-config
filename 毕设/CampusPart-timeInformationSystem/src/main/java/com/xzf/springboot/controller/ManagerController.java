package com.xzf.springboot.controller;

import com.xzf.springboot.pojo.Manager;
import com.xzf.springboot.pojo.Result;
import com.xzf.springboot.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ManagerController {

    @Autowired
    private ManagerService managerService;





    @GetMapping("/sys/admin-list")
    public String queryManagerList(Model model){
        String string="";
        try {
            List<Manager> managers=managerService.queryManagerList();
            model.addAttribute("managers",managers);
            string="admin-list";
        }catch (Exception e){
            model.addAttribute("erro","载入错误");
            System.out.println(e);
            string="error";
        }

//        System.out.println(managers);

        return string;
     }

    public Manager queryManagerListById(@RequestParam("id") int id){
        Manager manager = null;
        try {
             manager=managerService.queryManagerListById(id);
        }catch (Exception e){
            System.out.println(e);
        }


        return manager;
    }


    //增加成员
    @RequestMapping("/sys/tolist")
    @ResponseBody
    public Result addManager(int mid,String musername, String phone, int power, String password) {//@RequestBody Manager manager
        Result result=null;
        Integer i = 110;
        Manager manager=new Manager();
        System.out.println("hhhah"+musername+","+phone+","+power+","+password);

        try {
            i=managerService.queryManagerListByMphone(phone);
        }catch (Exception e){
            System.out.println(e);
        }


        if (i==null){
            System.out.println("账好不存在");
            //创建账号
            manager.setManagerid(mid);
            manager.setMusername(musername);
            manager.setMphone(phone);
            manager.setPower(power);
            manager.setMpassword(password);
            Timestamp d = new Timestamp(System.currentTimeMillis());
            manager.setDatetime(d);
            switch (power){
                case 1: manager.setMrole("超级管理员");
                    break;
                case 2: manager.setMrole("商家管理员");
                    break;
                case 3: manager.setMrole("学生管理员");
                    break;
                case 4: manager.setMrole("兼职管理员");
                    break;
            }
            try {
                int a=managerService.addManager(manager);
                result=new Result(0001,"增加成功");

            }catch (Exception e){
                result=new Result(0003,"增加失败");
            }
        }else {
            result=new Result(0002,"增加失败："+i+"账号已经存在");
            System.out.println("账户已经存在"+i);
        }
        return result;
    }



    public int updateManager(Manager manager) {
        int u=0;
        try {
            u=managerService.updateManager(manager);
        }catch (Exception e){
            System.out.println(e);
        }

        return u;
    }


    @GetMapping("/sys/delete")
    @ResponseBody
    public Result deleteManager(int mid) {
        System.out.println("到达目的地");
        int d=0;
        Result result=null;
        if (mid==1){
            result=new Result(0004,"此为特殊超级管理员，不能删除");
        }else {
            try {
                d=managerService.deleteManager(mid);
            }catch (Exception e){
                System.out.println(e);
            }
            if (d!=0){
                result=new Result(0001,"删除成功");
            }else{
                result=new Result(0002,"删除失败");
            }
        }


        return result;
    }


    @GetMapping("/sys/delall")
    @ResponseBody
    public Result vdelBatch(String mids) {
        Result result=null;
        int d=0;
        String [] midlist=mids.split(",");
        try {
            for (int i=0;i<midlist.length;i++){
                if (midlist[i].equals("1")){
                    System.out.println("错误");
                    d=1314520;
                    break;

                }else {
                    d=managerService.deleteManager(Integer.parseInt(midlist[i]));
                    d+=1;
                }
            }
            if (d==1314520){
                result=new Result(0004,"包含特殊超级管理员，不能删除,请重选选择");
            }else if (d!=0){
                result=new Result(0001,"删除成功");
            }else{
                result=new Result(0002,"删除失败");
            }
        }catch (Exception e){
            System.out.println(e);
        }



        return result;

    }

//    //批量删除

}
