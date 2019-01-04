package com.biz.grade.serivce;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.grade.dao.StudentDao;
import com.biz.grade.dao.StudentDaoImp;
import com.biz.grade.vo.StudentVO;

public class StudentService {
	List<StudentVO> stdList;
	String fileName = "";
	Scanner scan ;
	StudentDao stdDao;
	
	public StudentService(String fileName) {
		stdList = new ArrayList();
		this.fileName = fileName;
		scan = new Scanner(System.in);
		stdDao = new StudentDaoImp();
		
		
	}
	public void readStdInfo() {
		FileReader fr;
		BufferedReader buffer;
		
		try {
			fr = new FileReader(fileName);
			buffer = new BufferedReader(fr);
			
			// while(true)
			// String reader = buffer.readLine()
			// if(reader == null) break; 
			// 아래 코드와 같음 
			
			String reader = new String(); // String을 객체로 선언해야 reader값이 null값이 되지 않는다.
			while((reader = buffer.readLine()) != null) {
				// reader = buffer.readLine();
				// break가 생략 된 것과 같다.
				
				String[] st = reader.split(":");
				
				// 001 >> 0001
				String st_num = st[0];
				st_num = "00000" + st_num ;// 0000001
				int sEnd = st_num.length();
				int sStart = st_num.length() -5;
				st_num = st_num.substring(sStart, sEnd);
				
				String st_name = st[1];
				String st_tel = st[2];
				String st_adder = st[3];
				// 데이터 분리하기
				
				StudentVO vo = new StudentVO(
						st_num,
						st_name,
						st_tel,
						st_adder);
				stdList.add(vo);
				
			}
			fr.close();
			buffer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void stdMenu() {
		while(true) {
		System.out.println("=======================================");
		System.out.println("학생정보 관리");
		System.out.println("---------------------------------------");
		System.out.println("1.추가 2.수정 3.삭제 4.리스트보기 0.종료");
		System.out.println("5. 파일로부터 읽기 6. BulkDB Update");
		System.out.println("---------------------------------------");
		System.out.print("선택 >> ");
		
		String strM = scan.nextLine();
		int intM = Integer.valueOf(strM);
		if(intM == 0 ) return;
		
		if(intM == 1 ) this.insertStudent();
		if(intM == 2 ) this.updateStuent();
		if(intM == 3 ) this.deleteStudent();
		// 파일에서 읽어 stdList 만들기
		if(intM == 5 ) this.readStdInfo();
		if(intM == 6 ) this.insertBulkData();
		
	}
}
	private void insertBulkData() {
		// TODO stdList에 담겨있는 많은(bulk)데이터를 DB에 Insert하기
		/*
		 * Dao 인터페이스에 정의하지 않은 메서드를 사용해서
		 * Dao의 어떤 기능을 수행하려고 한다.
		 * 이 메서드는 표준 method(CRUD)에 해당하는 메서드가 아니어서
		 * 굳이 인터페이스에 정의하지 않아도 된다.
		 * 이럴때는 아래와 같은 cast 코드로 작성을 한다.
		 */
		// 1번 사용법
		//StudentDaoImp impDao = (StudentDaoImp) stdDao;
		//impDao.insertBulk(stdList);
		
		// 2번 사용법
		((StudentDaoImp)stdDao).insertBulk(stdList);
		
	}
	private void deleteStudent() {
		// TODO Auto-generated method stub
		
	}
	private void updateStuent() {
		// TODO Auto-generated method stub
		
	}
	private void insertStudent() {
		// TODO Auto-generated method stub
		
	}
}