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
	public void exit() throws IOException						
	{
		SimpleDateFormat dayset = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 HH시");
		MachineRoom.offday = dayset.format(d);
		//UserPayment up = new UserPayment(d);

		System.out.println("\t자판기 판매가 종료 되었습니다.");
		System.out.printf("\t자판기 판매 종료 일자 : %s\n", MachineRoom.offday);	
		
		try
		{	
			System.out.print("\n\t");
			String s = "▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶자 판 기 끄 는 중▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶";
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
		System.exit(-1);							
	}
	
	// 기계실로 와서 직접 노즐 청소
	public void clear()	throws IOException				
	{	
		Management mg = new Management();
		UserPayment up = new UserPayment();

		System.out.println("\t칵테일 판매 횟수 : " + up.getsellcount());

		System.out.print("\t노즐을 청소 하시겠습니까? (Y/N) : ");
		select = (char)System.in.read();

		if (select == 'Y' || select == 'y')
		{
			up.setsellcount(0);

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

			mg.managerMenu();
		}
		
		else if (select == 'N' || select == 'n')
			mg.managerMenu();

		
	}
	

	// 횟수 감지 노즐청소기 메소드
	public void aiclear() throws IOException				
	{	
		// 판매횟수 초기화
		int num = 0;

		UserPayment up = new UserPayment();
		
		if (up.getsellcount()>1)								// 판매 되고나서 증가하기 때문에 판매할 잔 수 - 1
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

			up.setsellcount(num);
		}
	}

	public void loading()
	{
		try
		{	
			System.out.print("\n\t");
			String s = "▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶자 판 기 켜 는 중▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶";
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
