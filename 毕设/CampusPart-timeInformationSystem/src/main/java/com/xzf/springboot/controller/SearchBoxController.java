package com.xzf.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzf.springboot.pojo.Jop;
import com.xzf.springboot.pojo.Manager;
import com.xzf.springboot.pojo.SellerAndCard;
import com.xzf.springboot.service.JopService;
import com.xzf.springboot.service.ManagerService;
import com.xzf.springboot.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.crypto.Data;
import java.util.List;

@Controller
public class SearchBoxController {
    @Autowired
    private ManagerService managerService;

    @Autowired
    private JopService jopService;

    @Autowired
    private SellerService sellerService;

   //管理员搜索
    @RequestMapping("/sys/search")
    public String queryManagerList(@RequestParam("start") String start,
                                   @RequestParam("end") String end,
                                   @RequestParam("username") String username,
                                    Model model,@RequestParam(defaultValue = "1",value = "pageNum")int pageNum
                                   ){
        PageHelper.startPage(pageNum,5);


        List<Manager> managers = managerService.search(start, end,username);

        PageInfo<Manager> page=new PageInfo<>(managers);

        model.addAttribute("managers",page);
        return "admin-list";
    }

    @RequestMapping("/sys/jopsearchtime")
    public String queryJopList(@RequestParam("start") String start,
                                   @RequestParam("end") String end,
                                   @RequestParam(required=false,name ="jopid") Integer jopid,
                                   @RequestParam(required=false,name ="contrller") Integer examine,
                                   @RequestParam(required=false,name ="contrller1") Integer valid,
                                   @RequestParam(required=false,name ="sellerid") Integer  sellerid,
                                   Model model,@RequestParam(defaultValue = "1",value = "pageNum")int pageNum){
        PageHelper.startPage(pageNum,5);

        List<Jop> jops = jopService.searchJop(start, end, jopid, examine, valid, sellerid);

        PageInfo<Jop> page=new PageInfo<>(jops);

        model.addAttribute("jops",page);
        return "order-list";

    }

    @RequestMapping("/sys/sellersearch")
    public String querysellerList(@RequestParam(required=false,name ="username") String sname,
                                  @RequestParam(required=false,name ="sphone") String sphone,
                                  Model model,@RequestParam(defaultValue = "1",value = "pageNum")int pageNum){
        PageHelper.startPage(pageNum,5);
        List<SellerAndCard> sellerAndCards = sellerService.searchSeller(sname, sphone);
        PageInfo<SellerAndCard> page=new PageInfo<>(sellerAndCards);

        model.addAttribute("sellers",page);

        return "seller-list";
    }



}
