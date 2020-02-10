package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import assembler.Assembler;
import spring01.AlreadyExistingMemberException;
import spring01.ChangePasswordService;
import spring01.IdPasswordNotMatchingException;
import spring01.MemberNotFoundException;
import spring01.MemberRegisterService;
import spring01.RegisterRequest;

public class MainForAssembler {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("명령어 입력");
			String command = reader.readLine();
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("종료.");
				break;
			}
			if(command.startsWith("new")) {
				processNewCommand(command.split(" "));
				continue;
			}else if(command.startsWith("change")) {
				processChangeCommand(command.split(" "));
				continue;
			}
			printHelp();
		}
	}
	
	private static Assembler assembler = new Assembler();
	
	private static void processNewCommand(String[] arg) {
		if(arg.length != 5) {
			printHelp();
			return;
		}
		MemberRegisterService regSvc = assembler.getMemberRegisterService();
		RegisterRequest req = new RegisterRequest();
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPw(arg[3]);
		req.setConfirmpw(arg[4]);
		
		if(!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호확인이 일치하지 않습니다.");
			return;
		}
		try {
			regSvc.regist(req);
			System.out.println("동록완료.\n");
		}catch (AlreadyExistingMemberException e) {
			System.out.println("이미 존재하는 이메일 입니다.\n");
		}
	}
	
	private static void processChangeCommand(String[] arg) {
		if(arg.length != 4) {
			printHelp();
		}
		ChangePasswordService changerPwSvc = assembler.getChangePasswordService();
		try {
			changerPwSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("암호 변경 완료\n");
		}catch(MemberNotFoundException e) {
			System.out.println("존재하지 않음\n");
		}catch(IdPasswordNotMatchingException e) {
			System.out.println("이메일과 비밀번호가 일치하지않습니다n");
		}
	}
	private static void printHelp() {
		System.out.println();
		System.out.println("명령어 사용법을 확인하시오");
		System.out.println("usage : ");
		System.out.println("new [이메일] [이름] [임호] [임호확인]");
		System.out.println("change [이메일] [현재비밀번호] [변경할 비밀번호]");
		System.out.println();
	}
}


















