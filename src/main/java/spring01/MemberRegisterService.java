package spring01;

import java.util.Date;

public class MemberRegisterService {
	private MemberDao memberDao;

	public MemberRegisterService(MemberDao memberDao) {
		super();
		this.memberDao = memberDao;
	}
	
	public void regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null) {
			throw new AlreadyExistingMemberException("dup email " + req.getEmail());
		}
		Member newMember = new Member(req.getEmail(), req.getPw(), req.getName(), new Date());
		memberDao.insert(newMember);
	}
}
