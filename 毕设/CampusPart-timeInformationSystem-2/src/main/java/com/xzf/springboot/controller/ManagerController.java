package com.xzf.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzf.springboot.pojo.Manager;
import com.xzf.springboot.pojo.tool.Result;
import com.xzf.springboot.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@Controller
@CrossOrigin
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @GetMapping("/sys/admin-list")
//    @RequestMapping("/sys/admin-list")
    public String queryManagerList(Model model,@RequestParam(defaultValue = "1",value = "pageNum")int pageNum){
        String string="";
        List<Manager> managers=null;
        PageHelper.startPage(pageNum,5);
//        System.out.println(starttime+endtiem+username);
        try {
            managers=managerService.queryManagerList();
//            System.out.println("xzf查全部"+managers);
            PageInfo<Manager> page=new PageInfo<>(managers);
//            System.out.println("xzf查部分"+page);
            model.addAttribute("managers",page);

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
        Integer i = -66;
        Manager manager=new Manager();
        System.out.println("hhhah"+musername+","+phone+","+power+","+password);

        try {
            i=managerService.queryManagerListByMphone(phone);
        }catch (Exception e){
            System.out.println(e);
        }


        if (i==null){
            System.out.println("账号不存在");
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
                result=new Result(0003,"增加失败(可能编号已经存在)");
            }
        }else {
            result=new Result(0002,"增加失败："+i+"账号已经存在");
            System.out.println("账户已经存在"+i);
        }
        return result;
    }

    @GetMapping("/sys/admin-edit/{mid}")
    public String toEdit( @PathVariable("mid") Integer mid,Model model){
        Manager manager = managerService.queryManagerListById(mid);

        model.addAttribute("manager",manager);
        return "admin-edit";
    }


    //修改
    @RequestMapping(value = "/sys/update",produces = "application/json;charset=utf-8",method = RequestMethod.POST)
    @ResponseBody
    public Result updateManager(@RequestBody Manager manager) {
        Integer u=null;
        Result result=null;

        switch (manager.getPower()){
            case 1: manager.setMrole("超级管理员");
                break;
            case 2: manager.setMrole("商家管理员");
                break;
            case 3: manager.setMrole("学生管理员");
                break;
            case 4: manager.setMrole("兼职管理员");
                break;
        }
        u=managerService.updateManager(manager);


        if (u==1){
            result=new Result(0001,"修改成功");
        }else {
            result=new Result(0003,"修改失败");
        }

        return result;
    }

    //删除
    @GetMapping("/sys/delete")
    @ResponseBody
    public Result deleteManager(int mid) {
        System.out.println("开始删除");
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

    //    //批量删除
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

    //修改，赋予转态
    @PostMapping("/sys/changeState")
    public String changeState(Integer state,int mid){
        Result result = null;
        String string=null;
        System.out.println(state);
        Integer i = managerService.changeState(state, mid);
        if (i==1){
//            result=new Result(0001,"成功");
            string="redirect:/sys/admin-list";
        }else {
//            result=new Result(0002,"失败");
            string="/sys/error";
        }


        return string;

    }
}
