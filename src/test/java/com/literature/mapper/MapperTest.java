package com.literature.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.literature.po.Dept;
import com.literature.po.Emp;
import com.literature.service.DeptService;
import com.literature.service.EmpService;
/**
 * Spring 普通测试类
 * @author Literature
 * @date 2018年10月27日
 *
 */
//@RunWith:junit提供的测试环境扩展，使用SpringJUint测试来方便使用spring的依赖注入
//@ContextConfiguration:导入配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml","classpath:applicationContext-dao.xml"})
public class MapperTest {

	@Autowired
	private DeptService deptService;
	@Autowired
	private EmpService empService;
	
	@Test
	public void test() {
//		Dept dept=new Dept();
//		dept.setName("AC");
//		deptService.save(dept);
		Emp emp=new Emp();
		emp.setName("Henry");
		emp.setDeptId((long) 2);
		empService.insert(emp);
	}
}
