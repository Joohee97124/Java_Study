import java.io.IOException;

class Run
{
	// 실제 실행되는 메인메소드
	public static void main(String[] args) throws IOException
	{
		Imagefile i = new Imagefile();		//-- 초기화면 칵테일
		Login l = new Login();				//-- 로그인 클래스
		MenuUser mu = new MenuUser();		//-- 메뉴 클래스
		UserPayment up = new UserPayment();	//-- 결제 클래스
		MachineRoom mr = new MachineRoom();	//-- 기계관리 클래스
		game g = new game();				//-- 게임 클래스

		MenuAdmin ad = new MenuAdmin();	
		ad.setting();
		ad.settingSide();

		do
		{
			mr.loading();
			i.cocktail();
			l.defaultInfo();					//-- 로그인 클래스에 임의 정보 입력 메소드
			l.start();							//-- 로그인 시작 메소드

			mu.baseSel();
			
			up.discount();
			
			try
			{
				g.rsp();																
			}
			catch (InterruptedException e)
			{
				System.out.println();
			}

			mr.aiclear();							//-- 게임 진행 후 자동 노즐 청소 기능 메소드
		}
		while (true);
	


					
	}
}