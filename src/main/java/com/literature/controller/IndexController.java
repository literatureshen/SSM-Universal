package com.literature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.literature.common.bean.Msg;
import com.literature.po.Dept;
import com.literature.po.Emp;
import com.literature.service.DeptService;
import com.literature.service.EmpService;

@Controller
@RequestMapping(value="/")
public class IndexController {

	@Autowired
	private EmpService empService;
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public @ResponseBody Emp get(Long id) {
		Emp emp=empService.selectByPrimaryKey(id);
		return emp;
	}
	
	@RequestMapping(value="/getEmpByPage",method=RequestMethod.GET)
	public String getEmpByPage(@RequestParam(value="pageNum",defaultValue="1")int pageNum,@RequestParam(value="pageSize",defaultValue="1")int pageSize,Model model){
		//传入页码和页面大小
		PageHelper.startPage(pageNum, pageSize);
		List<Emp> emps=empService.selectAll();
		//传入要显示的页面数据，连续要显示的页数（可操作）
		PageInfo<Emp> pageInfo=new PageInfo<>(emps, 5);
		model.addAttribute("pageInfo",pageInfo);
		return "listEmp";
	}
	
	@RequestMapping(value="/getMsg",method=RequestMethod.GET)
	public @ResponseBody Msg getMsg(@RequestParam(value="pageNum",defaultValue="1")int pageNum,@RequestParam(value="pageSize",defaultValue="1")int pageSize) {
		//传入页码和页面大小
		PageHelper.startPage(pageNum, pageSize);
		List<Emp> emps=empService.selectAll();
		//传入要显示的页面数据，连续要显示的页数（可操作）
		PageInfo<Emp> pageInfo=new PageInfo<>(emps, 5);
		return Msg.success().add("pageInfo",pageInfo);
	}
	
	@RequestMapping(value="/manyTableSelect",method=RequestMethod.GET)
	public @ResponseBody Msg manyTableSelect() {
		Emp emp=empService.getWithDept((long)2);
		List<Emp> emps=empService.getByDeptIdWithDept((long)3);
		return Msg.success().add("emp",emp).add("emps",emps);
	}
}
