package assembler;

import spring01.ChangePasswordService;
import spring01.MemberDao;
import spring01.MemberRegisterService;

/*
 * 조립기는 객체를 생성하고 의존 객체를 주입해주는 기능을 제공
 * 또한 특정 객체를 필요로 하는 곳에 객체를 제공할 수 있다.
 */

public class Assembler {
	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	public Assembler() {
		memberDao = new MemberDao();
		regSvc = new MemberRegisterService(memberDao);
		pwdSvc = new ChangePasswordService(memberDao);
	}
	public MemberDao getMemberDao() {
		return memberDao;
	}
	public MemberRegisterService getMemberRegisterService() {
		return regSvc;
	}
	public ChangePasswordService getChangePasswordService() {
		return pwdSvc;
	}
}
