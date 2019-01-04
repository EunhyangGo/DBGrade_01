package com.biz.grade.dao;

import java.util.List;

import com.biz.grade.vo.StudentVO;

public interface StudentDao {

	// CRUD 선언
	public int insert(StudentVO vo);
	
	public List<StudentVO> selectAll(); //DB로부터 데이터를 읽어서list형태로 return
	public StudentVO findByNum(String st_num);
	public List<StudentVO> findByName(String st_name);
	
	public int update(StudentVO vo);
	public int delete(String st_num);

	public void insertBulk(List<StudentVO> stdList);
	
}
