package kr.smhrd.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.smhrd.mapper.MainMapper;
import kr.smhrd.model.DrivingVO;
import kr.smhrd.model.MemberVO;

@Service
public class MainService {

	@Autowired
	private MainMapper mapper;

	public void registerAjax(MemberVO mvo) {

		int cnt = mapper.register(mvo);

		if (cnt > 0) {

			System.out.println("회원가입성공");

		} else {

			System.out.println("회원가입실패");
		}

	}

	public void loginAjax(MemberVO mvo, HttpSession session) {
		System.out.println(mvo+"?");
		MemberVO mvo2 = mapper.login(mvo);
		System.out.println(mvo2);
		if (mvo2 != null) {
			session.setAttribute("mvo", mvo2);
			System.out.println("로그인성공");
			System.out.println(mvo2);
			
		} else {
			System.out.println("로그인 실패");
			
		}

	}
	
	@ResponseBody
	public int checkAjax(MemberVO mvo) {
	
		 int cnt = mapper.check(mvo);
		
	
		
		
		
		System.out.println(cnt);
		
		
		
		return cnt;
	}

	public int driveInset(DrivingVO dvo) {
		 mapper.drivingInsert(dvo);
		 int drinum =  mapper.drivingSelect(dvo.getFtime());
		 return drinum;
	
	}

	public int checkParking(int dnum) {
		
		int cnt = mapper.checkParking(dnum);
		
		return cnt;
		
	}

	public ArrayList<String> illegalCheck(int dnum) {
		
		String total = Integer.toString(mapper.cntDrinum(dnum));
		String helmet = Integer.toString(mapper.cntDrinumHelmet(dnum));
		String head = Integer.toString(mapper.cntDrinumHead(dnum));
		String two = Integer.toString(mapper.cntDrinumTwo(dnum));
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add(total);
		list.add(helmet);
		list.add(head);
		list.add(two);
		
		return list;
		
	}

	public DrivingVO searchDrinum(int dnum) {
		
		DrivingVO dvo = mapper.searchDrinum(dnum);
		
		return dvo;
	}

	public void updatePoint(String id,int point) {

		if(point == 3) {
			
			mapper.point3(id);
			
		}else if(point == 6) {
			mapper.point6(id);
			
		}else if(point ==9) {
			
			mapper.point9(id);
			
		}
		
	}

	
	
	public void updateSession(String id,HttpSession session) {
		
		MemberVO mvo2 = mapper.sessionUpdate(id);
		
		
		session.setAttribute("mvo", mvo2);
		
	}
		
		


	
	
	
}
