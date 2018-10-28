package com.literature.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.literature.common.mapper.BaseMapper;
import com.literature.po.Emp;

public interface EmpMapper extends BaseMapper<Emp> {

	Emp selectByPrimaryKeyWithDept(@Param(value="id")Long id);
	List<Emp> selectByDeptIdWithDept(@Param(value="deptId")Long deptId);
}