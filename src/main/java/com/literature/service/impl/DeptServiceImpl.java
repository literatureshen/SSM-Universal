package com.literature.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.literature.common.mapper.BaseMapper;
import com.literature.common.service.impl.BaseServiceImpl;
import com.literature.mapper.DeptMapper;
import com.literature.po.Dept;
import com.literature.service.DeptService;

@Service
@Transactional
public class DeptServiceImpl extends BaseServiceImpl<Dept> implements DeptService {

	@Autowired
	private DeptMapper deptMapper;
	@Override
	protected BaseMapper<Dept> getBaseMapper() {
		return deptMapper;
	}

}
