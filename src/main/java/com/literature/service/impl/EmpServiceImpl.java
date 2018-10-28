package com.literature.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.literature.common.mapper.BaseMapper;
import com.literature.common.service.impl.BaseServiceImpl;
import com.literature.mapper.EmpMapper;
import com.literature.po.Emp;
import com.literature.service.EmpService;

@Service
@Transactional
public class EmpServiceImpl extends BaseServiceImpl<Emp> implements EmpService {

	@Autowired
	private EmpMapper empMapper;

	@Override
	protected BaseMapper<Emp> getBaseMapper() {
		return empMapper;
	}


	@Override
	public Emp getWithDept(Long id) {
		return empMapper.selectByPrimaryKeyWithDept(id);
	}

	@Override
	public List<Emp> getByDeptIdWithDept(Long deptId) {
		return empMapper.selectByDeptIdWithDept(deptId);
	}
}
