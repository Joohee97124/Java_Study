import java.util.Scanner;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

// 로그인 및 회원가입 진행하는 Login클래스
public class Login
{
	static List<MemberInfo> list;			//-- MemberInfo 클래스 타입의 배열을 저장할 list 생성
	static Scanner sc;

	String name2, pw2;						//--로그인에 성공한 사용자의 id/pw 담아 메인메소드에서 연결시킬 변수
	
	static
	{
		list = new ArrayList<MemberInfo>(50);
		sc = new Scanner(System.in);
	}

	
	// 기본 회원값 저장 메소드
	public void defaultInfo()
	{
		list.add(new MemberInfo("관리자", "admin", "1234", "00000000000", "00000000",0));		
		list.add(new MemberInfo("김가영", "gayoung", "rlarkdud", "01050501932", "19940225",1000));
		list.add(new MemberInfo("박정준", "jungjun", "qkrwjdwns", "01040207429", "19961031",1000));
		list.add(new MemberInfo("안정미", "jungmi", "dkswjdal", "01026194925", "19960125",1000));
		list.add(new MemberInfo("전혜림", "hyerim", "wjsgPfla", "01080019506", "19950630",1000));
		list.add(new MemberInfo("정주희", "joohee", "wjdwngml", "01080192565", "19971224",1000));		
	}
	
	// 회원 확인 메소드
	public void start() throws IOException
	{
		char a;

		System.out.println("\n\t==============================================");
		System.out.println("\t■■■■■ ilzo 칵테일 자판기입니다 ■■■■■");

		do
		{
			System.out.print("\n\t회원이십니까? (Y/N) : ");
			a = (char)System.in.read();
			System.in.skip(100);
		}
		while (a!='y' && a!='Y' && a!='n' && a!='N');

		if (a == 'y' || a == 'Y')
			login();		// 로그인 메소드로 이동
		else
			register();		// 회원가입 메소드로 이동
	}

	// 회원인 경우 → 로그인 메소드
	public void login() throws IOException
	{
		String userId, userPw;					// 사용자 입력 Id/Pw 정보를 담을 변수
		MemberInfo member;						// findById 메소드 실행 후 반환된 MemberInfo 객체를 저장할 변수

		System.out.println("\n\t■■■■■■ 로그인 페이지 입니다 ■■■■■■");

		do
		{
			System.out.print("\n\tID를 입력해주세요: ");
			userId = sc.next();
			System.out.print("\tPW를 입력해주세요: ");
			userPw = sc.next();
			
			member = findById(userId);
			if(member == null)												
			// 1. 사용자 입력 Id가 list상에 존재하지 않는 경우
				System.out.println("\n\t** 등록되지 않은 ID입니다.");
			else if(member.getPw().equals(userPw))							
			// 2. 사용자 입력 Id가 list상에 존재하고, Pw값이 일치하는 경우
			{
				System.out.println("\n\t로그인에 성공했습니다~!!!");
				name2 = userId;
				pw2 = userPw;
			}
			else															
			// 3. 사용자 입력 Id가 list상에 존재하고, Pw값이 일치하지 않는 경우
				System.out.println("\n\t** 비밀번호가 틀렸습니다.");
		}
		while (member == null || member.getPw().equals(userPw)!=true);		
		// 1 & 3 번의 경우 do while 문 반복 진행.
    }

	// 비회원인 경우 → 회원가입 메소드
	public void register() throws IOException
	{
		String userName, userBirth, userId, userPw, userPhone;				// 사용자 입력 정보를 담을 변수
		Calendar rightNow = Calendar.getInstance();							// 오늘의 년도를 알기 위해 Calendar 인스턴스 생성

		System.out.println("\n\t■■■■■■ 회원가입을 시작합니다 ■■■■■■");
		do
		{
			System.out.print("\t이름 입력(최대 5자): ");							
			userName = sc.next();
		}
		while (userName.length() < 1 || userName.length() > 5 );			// 이름 1~5자 제한


		do
		{
			System.out.print("\t생년월일 입력(8자리): ");					// 생년월일 8자 제한
			userBirth = sc.next();

			if (rightNow.get(Calendar.YEAR) - Integer.parseInt(userBirth.substring(0,4))<19)	// 오늘의 년도 - 생년월일 앞4자리 < 19 인 경우
			{
				System.out.println("\n\t미성년자는 가입할 수 없습니다.\n");
			} 
		}
		while (userBirth.length() != 8 || rightNow.get(Calendar.YEAR) - Integer.parseInt(userBirth.substring(0,4))<19);

		do
		{
			System.out.print("\tID 입력(소문자, 최대 10자): ");
			userId = sc.next();
		}
		while (userId.length() < 1 || userId.length() > 10 || checkId(userId)==false); // id 1~10자 제한, 소문자만 입력

		do
		{
			System.out.print("\tPW 입력(최대 12자): ");
			userPw = sc.next();
		}
		while (userPw.length() < 1 || userPw.length() > 12 );				// pw 1~12자 제한

		do
		{
			System.out.print("\t전화번호 입력(11자리): ");							
			userPhone = sc.next();
		}
		while (userPhone.length() != 11 );									// 전화번호 11자 제한
		
		        
        if(idCheck(userId))								// idCheck(userId) true 일 경우 list에 사용자 입력 Id와 동일한 Id 값이 존재하므로 중복알림 메세지 출력
            System.out.println("\t중복된 ID입니다.");
        else											// idCheck(userId) false 일 경우 list 에 추가
		{
			if (list.size()>=50)
			{
				System.out.println("\n\t가입 가능한 인원수(50명)가 초과되었습니다.");		// 가입인원 수 제한
				this.start();
			}
            list.add(new MemberInfo(userName, userId, userPw, userPhone, userBirth, 100));
            System.out.println("\n\t가입이 완료되었습니다~!!!\n");
			System.out.println("\n\t기본 적립금 100원이 지급되었습니다.^^\n");
        }
        
		this.start();
		
	}
	
	// id 소문자 체크 메소드
	public boolean checkId(String textInput) 
	{
		char chrInput;

		for (int i = 0; i < textInput.length(); i++) 
		{
			chrInput = textInput.charAt(i); // 입력받은 String에서 문자 하나씩 가져와서 체크

			if (chrInput >= 97 && chrInput <= 122) 
			{
				// 그냥 넘어간다 → 영문(소문자) OK!
			} 
	 
			else
				return false;   // 영문(소문자)가 아닌 경우
		}
		return true;

	}

	// MemberInfo타입 객체를 반환하는 findById() 메소드 : 사용자가 입력한 userId를 인자로 받아 list에 같은 Id값이 존재하면 memberinfo를 반환. 
	// 존재하지 않으면 null 반환
	protected MemberInfo findById(String userId) 
	{
		for(MemberInfo memberinfo : list)
		{
			if(memberinfo.getId().equals(userId)) 
				return memberinfo;
		}
		return null;
	}

	 // boolean을 반환하는 idCheck() 메소드 : 사용자가 입력한 userId를 인자로 받아 findById(userId) 메소드 실행 값을 member에 저장
	 //                                       사용자 입력 Id와 동일한 id값이 list에 존재하면 true / 존재하지 않으면(null이면) false 반환
    protected boolean idCheck(String userId) 
	{
        boolean check = true;
        MemberInfo member = findById(userId);
        if(member == null)
            check = false;
        return check;
    }

	
}

