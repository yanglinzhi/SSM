package com.ylz.controller;

import com.ylz.dao.EmployeeDao;
import com.ylz.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author 杨霖志
 * @date 2022/9/15
 * 查询所有员工信息-->/employee-->get
 * 跳转到添加页面/to/add-->get
 * 跳转到修改页面-->/employee/{id}-->get
 * 添加员工信息-->/employee-->post
 * 修改员工信息-->/employee-->put
 * 删除员工信息-->/employee/{id}-->delete
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @GetMapping("/employee")
    public String getAllEmployees(Model model) {
        Collection<Employee> allEmployees = employeeDao.getAll();
        //将所有员工信息在请求域中共享
        model.addAttribute("allEmployee",allEmployees);
        //跳转到列表页面
        return "employeeList";
    }
    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable() Integer id){
        employeeDao.delete(id);
        return "redirect:/employee";
    }
    @GetMapping("/employee/{id}")
    public String updateEmployee(@PathVariable() Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee",employee);
        return "add";
    }
    @PostMapping("/employee")
    public String saveEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }
    @GetMapping("/to/add")
    public String toAdd(){
        return "add";
    }
}
