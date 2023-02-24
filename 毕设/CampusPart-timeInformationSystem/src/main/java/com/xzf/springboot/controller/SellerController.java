package com.xzf.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzf.springboot.pojo.Card;
import com.xzf.springboot.pojo.Result;
import com.xzf.springboot.pojo.Seller;
import com.xzf.springboot.pojo.SellerAndCard;
import com.xzf.springboot.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@Controller
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping("/sys/seller-list")
    public String SellerList(Model model, @RequestParam(defaultValue = "1",value = "pageNum")int pageNum){

        PageHelper.startPage(pageNum,5);

        List<SellerAndCard> seller=sellerService.querySellerList();

        if (!StringUtils.isEmpty(String.valueOf(seller))){
            PageInfo<SellerAndCard> page=new PageInfo<>(seller);
            model.addAttribute("sellers",page);
            System.out.println(page.getList().get(0));
            return "seller-list";

        }else {
            model.addAttribute("erro","载入错误");
            return "error";
        }

    }

    @GetMapping("/sys/sellerdelall")
    @ResponseBody
    public Result sellerDelall(String sids){
        Result result=null;
        int d=0;
        String [] sidslist=sids.split(",");
        for (int i=0;i<sidslist.length;i++){

            System.out.println("控制层进入");
            d=sellerService.deleteSeller(Integer.parseInt(sidslist[i]));
            d+=1;
        }
        if (d!=0){
            result=new Result(0001,"删除成功");
        }else{
            result=new Result(0002,"删除失败");
        }
        return result;
    }

    @GetMapping("/sys/sellerDelete")
    @ResponseBody
    public Result sellerDelete(int sid){
        int d=0;
        Result result=null;

        d=sellerService.deleteSeller(sid);

        if (d!=0){
            result=new Result(0001,"删除成功");
        }else{
            result=new Result(0002,"删除失败");
        }
        return result;
    }

    //修改，赋予转态
    @GetMapping("/sys/changeSellerStates")
    public String changeSellerStates(Integer state,int sid){
        Result result = null;
        String string=null;

        Integer s=sellerService.changeSellerStates(state,sid);
        if (s==1){
//            result=new Result(0001,"成功");
            string="redirect:seller-list";
        }else {
//            result=new Result(0002,"失败");
            string="/sys/error";
        }
        return string;

    }

    //增加
    @PostMapping("/sys/toaddSeller")
    @ResponseBody
    public Result addSeller(SellerAndCard SAC){
        Result result=null;
        Seller seller=new Seller();
        Card card=new Card();

        Integer i=sellerService.querySellertAndCardByphone(SAC.getSphone());

        if (i==0001){

            seller.setSellerid(SAC.getSellerid());
            seller.setSname(SAC.getSname());
            seller.setSaddress(SAC.getSaddress());
            seller.setBusinesslicense(SAC.getBusinesslicense());
            seller.setSphone(SAC.getSphone());
            seller.setSpasswoed(SAC.getSpasswoed());
            seller.setSsex(SAC.getSsex());
            seller.setSemail(SAC.getSemail());
            seller.setSstatus(1);
            card.setCphone(SAC.getSphone());
            card.setCarid(SAC.getCarid());
            card.setCname(SAC.getCname());
            card.setCage(SAC.getCage());
            sellerService.addSeller(seller,card);
            result=new Result(0001,"增加成功");

        }else if (i==0002){
            result=new Result(0002,"增加失败：该账号已经存在但未绑定身份证");
        }else if (i==0003){
            result=new Result(0002,"增加失败：账号已经存在");
        }else {
            result=new Result(0002,"增加失败：系统未知错误");
        }




        return result;
    }

    //到修改界面
    @GetMapping("/sys/seller-edit/{sid}")
    public String toUserEdit(@PathVariable("sid") Integer sid, Model model){

//        userService.querySellerListById(sid);
        SellerAndCard SAC=sellerService.querySellerListById(sid);

        if (!StringUtils.isEmpty(String.valueOf(SAC))){

            model.addAttribute("sellerC",SAC);
            return "seller-edit";
        }else {
            return "error";
        }

   }

   //修改

    @RequestMapping(value = "/sys/sellerUpdate",produces = "application/json;charset=utf-8",method = RequestMethod.POST)
    @ResponseBody
    public Result userUpdate(@RequestBody SellerAndCard SaC){
        Integer u=null;
        Result result=null;

        u=sellerService.updataSellerAC(SaC);

        if (u==1){
            result=new Result(0001,"修改成功");

        }else {
            result=new Result(0003,"修改失败,系统未知名错误");
        }

        return result;
    }


}
