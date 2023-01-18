package com.example.demo.controller;

import com.example.demo.dao.DepartmentDao;
import com.example.demo.dao.EmyployeeDao;
import com.example.demo.pojo.Department;
import com.example.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class EmpioyeeController {
    @Autowired
    EmyployeeDao emyployeeDao;
    @Autowired
    DepartmentDao departmentDao;
@RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees=emyployeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }
    @GetMapping("/emp")
    public String toaddpage(Model model){
    //查出所有部门的信息
        Collection<Department> departments=departmentDao.getDepartments();
        model.addAttribute("departments",departments);
    return "emp/add";
    }
    @PostMapping("/emp")
    public String addemp(Employee employee){
           //添加的操作  forward
        emyployeeDao.save(employee);//调用抵触员工方法保存员工信息
        return "redirect:/emps";
    }

    //去员工的修改页面
    @GetMapping("/emp/{id}")
    public String toUpadateEmp(@PathVariable("id")Integer id,Model model){
    //查出原来的数据
        Employee employee=emyployeeDao.getEmployeeById(id);
        model.addAttribute("emp",employee);
        //查出所有部门的信息
        Collection<Department> departments=departmentDao.getDepartments();
        model.addAttribute("departments",departments);
    return "emp/upadate";
    }
    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
    emyployeeDao.save(employee);
    return "redirect:/emps";
    }
    //删除员工
    @GetMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id")int id){
    emyployeeDao.delete(id);
        return "redirect:/emps";
    }

}
