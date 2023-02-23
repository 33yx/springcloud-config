package com.xzf.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzf.springboot.pojo.Result;
import com.xzf.springboot.pojo.SellerAndCard;
import com.xzf.springboot.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
    @PostMapping("/sys/toUserList")
    @ResponseBody
    public Result addSeller(){
        Result result=null;

        return result;
    }


}
