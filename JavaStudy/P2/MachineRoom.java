// 기계실로 접근해서 청소하는 메소드
// 노래 클래스 생성
// 게임 했을 때 포인트 적립이 10원 단위로는 안 나오게!

import java.util.Random;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;

// 고장관리
class MachineRoom
{	
	private int sel;							// 메뉴 선택 변수	
	private char select;						// YES 혹은 NO..
	private static final Date d = new Date();	// 날짜 담아낼 변수
	public static String offday;				// 종료 날짜 담아낼 변수

	public void setMachine() throws IOException
	{	
		Scanner sc = new Scanner(System.in);
		int sel;

		System.out.println("\t1. 노즐 청소\t2. 자판기 전원 OFF");
		do
		{
			System.out.print("\n\t선택 해 주세요 : ");
			sel = sc.nextInt();
		}
		while (sel < 1 || sel > 2);


		if (sel==1)
		{
			clear();
		}

		if (sel==2)
		{
			exit();
		}
	}
	

	// 자판기 전원 OFF 메소드
	public void exit()						
	{
		SimpleDateFormat dayset = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 HH시");
		MachineRoom.offday = dayset.format(d);

		System.out.println("\t자판기 판매가 종료 되었습니다.");
		System.out.printf("\t자판기 판매 종료 일자 : %s\n", MachineRoom.offday);	

		System.exit(-1);							
	}
	
	// 기계실로 와서 직접 노즐 청소
	public void clear()	throws IOException				
	{
		game gm = new game();

		System.out.println("\t칵테일 판매 횟수 : " + gm.getsellcount());

		System.out.print("\t노즐을 청소 하시겠습니까? (Y/N) : ");
		select = (char)System.in.read();

		if (select == 'Y' || select == 'y')
		{
			gm.setsellcount(0);

			try
			{	
				System.out.print("\n\t");
				String s = " 깨 끗 이 청 소 중 . . . 깨 끗 이 청 소 중 . . . 깨 끗 이 청 소 중 . . . ";
				for (int i = 0; i < s.length(); i++) 
				{ 
					Thread.sleep(150);							// s 문자열을 돌면서 sleep() 안의 단위 마다 한 문자씩 출력!
					System.out.print(s.charAt(i));
				}

				System.out.println("\n");
			}
			catch (InterruptedException e)
			{
				System.out.println();							// 쓰레드는 예외 처리를 해줘야 함..
			}
		}
		
		else if (select == 'Y' || select == 'y')
			setMachine();
		
		Login ln = new Login();
		ln.login();
		
	}
	

	// 횟수 감지 노즐청소기 메소드
	public void aiclear()				
	{	
		// 판매횟수 초기화
		int num = 0;

		game gm = new game();
		
		if (gm.getsellcount()>2)								// 판매 되고나서 증가하기 때문에 판매할 잔 수 - 1
		{	
			System.out.println("\t 노즐에 때가 많이 꼈습니다... ");
			
			try
			{	
				System.out.print("\n\t");
				String s = " 깨 끗 이 청 소 중 . . . 깨 끗 이 청 소 중 . . . 깨 끗 이 청 소 중 . . . ";
				for (int i = 0; i < s.length(); i++) 
				{ 
					Thread.sleep(150);							// s 문자열을 돌면서 sleep() 안의 단위 마다 한 문자씩 출력!
					System.out.print(s.charAt(i));
				}

				System.out.println("\n");
			}
			catch (InterruptedException e)
			{
				System.out.println();							// 쓰레드는 예외 처리를 해줘야 함..
			}

			gm.setsellcount(num);
		}
	}

	public void loading()
	{
		try
		{	
			System.out.print("\n\t");
			String s = "▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶";
			for (int i = 0; i < s.length(); i++) 
			{ 
			   // 로딩 효과 스레드
			   Thread.sleep(80);					// s 문자열을 돌면서 sleep() 안의 단위 마다 한 문자씩 출력!
			   System.out.print(s.charAt(i));
			}

			System.out.println("\n");
		}
		catch (InterruptedException e)
		{
			System.out.println();					// 쓰레드는 예외 처리를 해줘야 함..
		}
	}

	public void temploading()
	{
		try
		{	
			System.out.print("\n\t");
			String s = "▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶ 결제가 완료 되었습니다 ▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶";
			for (int i = 0; i < s.length(); i++) 
			{ 
			   // 로딩 효과 스레드
			   Thread.sleep(80);					// s 문자열을 돌면서 sleep() 안의 단위 마다 한 문자씩 출력!
			   System.out.print(s.charAt(i));
			}

			System.out.println("\n");
		}
		catch (InterruptedException e)
		{
			System.out.println();					// 쓰레드는 예외 처리를 해줘야 함..
		}
	}
}



// 미니게임
class game
{	
	private int sel;						// 게임 확률 선택
	private int user;						// 사용자
	private int com;						// 컴퓨터

	private int sellcount;			// 칵테일 판 횟수

	UserPayment up = new UserPayment();
	MemberInfo mi = new MemberInfo();

	int total = up.getTotal();		// 결제금액을 가져옴.
	int point = mi.getPoint();		// 누적할 포인트 변수

	public int getsellcount()
	{
		return sellcount;
	}	

	public void setsellcount(int sellcount)
	{	
		this.sellcount = sellcount;
	}
	

	public void rsp() throws InterruptedException
	{	
		MachineRoom mr = new MachineRoom();
		Imagefile jpg = new Imagefile();

		mr.temploading();
		
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		System.out.println("\t적립금 지급을 위한 미니 게임(참참참)을 하시겠습니까?\n");
		System.out.println("\t1. 이길 확률 80% 게임(적립금 5%) \t\t 2. 이길 확률 66.6%(적립금 10%) \t\t 3. 안 할래요.");

		do
		{
			System.out.print("\n\t 선택 해 주세요 : ");
			sel = sc.nextInt();
		}
		while (sel < 1 || sel > 3);

	
		if (sel==1)
		{
			com = rd.nextInt(4)+1; // → 1 2 3 4 5
			System.out.println("\n\t확률 80 % 게임을 선택하셨습니다.");
			game1();
		}
		
		else if(sel==2)
		{
			com = rd.nextInt(2)+1; // → 1 2 3
			System.out.println("\n\t확률 66.6 % 게임을 선택하셨습니다.");
			game2();
		}
		
		else if(sel==3)
		{
			System.out.println("\n\t이용 해 주셔서 감사합니다.");						
			mr.exit();// 처음 화면으로 돌아가는 클래스 메소드 호출.
		}
		
		sellcount +=1;															// 칵테일 판 횟수

	}
	

	private void game1()
	{	
		Scanner sc = new Scanner(System.in);

		do
		{
			System.out.print("\t1. 위 2. 아래 3. 중앙 4. 왼쪽 5. 오른쪽 : ");
			user = sc.nextInt();
		}
		while (user < 1 || user > 5);

		try
		{
			Thread.sleep(3000);			
		}
		catch (InterruptedException e)
		{
			System.out.println();
		}

		try
		{	
			System.out.print("\t");
			Thread.sleep(3);			
		}
		catch (InterruptedException e)
		{
			System.out.println();
		}
		
		String[] str = {"위", "아래", "중앙", "왼쪽", "오른쪽"};

		System.out.println("\n\t - 유저	  : " + str[user-1]);
		System.out.println("  \t - 컴퓨터 : " + str[com-1]);
		
		if (user==com)
			System.out.println("\n\t패배 하셨습니다~!!");
		else
		{
			System.out.println("\n\t승리 하셨습니다~!!");

			// 포인트 적립
			double temppoint = total*0.05;
			int temp = (int)temppoint;
			
			// 100원 단위로 나누어떨어지지 않으면 100 단위로 나누어떨어지게 만들어주기
			if (temp % 100 != 0)
				temp -= (temp%100);
			
			// MemberInfo 클래스의 point로 연동
			point += temp;												
			mi.setPoint(point);
		}

	}


	private void game2()
	{	
		Scanner sc = new Scanner(System.in);

		do
		{
			System.out.print("\t1. 왼쪽 2. 중앙 3. 오른쪽 : ");
			user = sc.nextInt();
		}
		while (user < 1 || user > 3);
		
		try
		{
			Thread.sleep(3000);			
		}
		catch (InterruptedException e)
		{
			System.out.println();
		}

		String[] str = {"왼쪽", "중앙", "오른쪽"};

		System.out.println("\n\t - 유저	  : " + str[user-1]);
		System.out.println("  \t - 컴퓨터 : " + str[com-1]);
		
		if (user==com)
			System.out.println("\n\t패배 하셨습니다~!!");
		else
		{
			System.out.println("\n\t승리 하셨습니다~!!");
			// 포인트 적립
			double temppoint = total*0.01;
			int temp = (int)temppoint;
			
			// 100원 단위로 나누어떨어지지 않으면 100 단위로 나누어떨어지게 만들어주기
			if (temp % 100 != 0)
				temp -= (temp%100);
			
			// MemberInfo 클래스의 point로 연동
			point += temp;												
			mi.setPoint(point);									
		}

	}
}