package com.literature.service;

import java.util.List;

import com.literature.common.service.BaseService;
import com.literature.po.Emp;
public interface EmpService extends BaseService<Emp>{

	Emp getWithDept(Long id);

	List<Emp> getByDeptIdWithDept(Long deptId);
}