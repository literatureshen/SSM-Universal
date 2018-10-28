package com.literature.mapper;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;
import com.literature.po.Emp;

/**
 * Spring Controller测试
 * Spring4测试需要servlet3.0以上
 * @author Literature
 * @date 2018年10月27日
 *
 */
//@WebAppConfiguration:调用Java Web组件，如自动注入ServletContext Bean
//@RunWith:junit提供的测试环境扩展，使用SpringJUint测试来方便使用spring的依赖注入
//@ContextConfiguration:导入配置文件
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath*:applicationContext.xml","classpath*:applicationContext-dao.xml","classpath*:springmvc.xml"})
public class RequestMapperTest {

	@Autowired
	private WebApplicationContext context;   
	
	private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    
    @Test
    public void testRequest() throws Exception {
    	MvcResult mvcResult= mockMvc.perform(MockMvcRequestBuilders.get("/get").param("id", "1"))
    			.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println(result);
    }
    
    @Test
    public void testPageHelper() throws Exception {
    	MvcResult mvcResult= mockMvc.perform(MockMvcRequestBuilders.get("/getEmpByPage").param("pageNum", "1").param("pageSize", "2"))
    			.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println(result);
        PageInfo<Emp> pageInfo=(PageInfo<Emp>) mvcResult.getRequest().getAttribute("pageInfo");

        System.out.println("总记录数："+pageInfo.getTotal());  
        System.out.println("总页数："+pageInfo.getPages());  
        System.out.println("一页的大小："+pageInfo.getSize());
        List<Emp> emps=pageInfo.getList();
        for (int i = 0; i < emps.size(); i++) {
			System.out.println(emps.get(i).getName());
		}
    }    
    
    @Test
    public void testGetMsg() throws Exception {
    	MvcResult mvcResult= mockMvc.perform(MockMvcRequestBuilders.get("/getMsg").param("pageNum", "1").param("pageSize", "2"))
    			.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println(result);
    }
    
	@Test
	public void testManyTableSelect() throws Exception {
    	MvcResult mvcResult= mockMvc.perform(MockMvcRequestBuilders.get("/manyTableSelect"))
    			.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println(result);
	}
}
