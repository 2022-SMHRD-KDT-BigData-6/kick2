package kr.smhrd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.smhrd.model.DrivingVO;
import kr.smhrd.model.MemberVO;

@Mapper
public interface MainMapper {
	
	public int register(MemberVO mvo);
	
	public MemberVO login(MemberVO mvo);

	public int check(MemberVO mvo);
	
	public int insertDriving(DrivingVO dvo);

	public int drivingSelect(String ftime);

	public int checkParking(int drinum); 
	
	public int cntDrinum(int drinum);
	
	public int cntDrinumHelmet(int drinum);
	
	public int cntDrinumHead(int drinum);
	
	public int cntDrinumTwo(int drinum);

	public DrivingVO checkDriving(int drinum);

	public void point3(String id);

	public void point6(String id);

	public void point9(String id);

	public MemberVO sessionUpdate(String id);

	public List<DrivingVO> checkRecord(String id);


}