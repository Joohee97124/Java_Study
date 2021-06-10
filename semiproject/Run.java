import java.io.IOException;

class Run
{
	// 실제 실행되는 메인메소드
	public static void main(String[] args) throws IOException
	{	
		Music music = new Music();
		Imagefile i = new Imagefile();				//-- 초기화면 칵테일
		Login l = new Login();						//-- 로그인 클래스
		Management mm = new Management();			//-- 관리자 모드 클래스
		MenuUser mu = new MenuUser();				//-- 메뉴 클래스
		UserPayment up = new UserPayment();			//-- 결제 클래스
		SalesManagement sm = new SalesManagement();	//-- 결제 관리 클래스
		MachineRoom mr = new MachineRoom();			//-- 기계관리 클래스
		game g = new game();						//-- 게임 클래스
		//Cash ch = new Cash();

		MenuAdmin ma = new MenuAdmin();				//-- 메뉴관리 클래스
		
		music.music();
		l.defaultInfo();							//-- 로그인 클래스에 임의 정보 입력 메소드
		sm.defaultData();							//-- 정렬 시 확인할 데이터 업로드
		mr.loading();
		i.cocktail();

		ma.setting();								//-- 칵테일 메뉴 세팅
		ma.settingSide();							//-- 사이드 메뉴 세팅

		do
		{
			l.start();								//-- 로그인 시작 메소드
			g.id = sm.buyer = up.name = mu.userId = l.name2;

			if (l.name2.equals("admin") && l.pw2.equals("1234")) // -- 관리자 모드
			{
				mm.managerMenu();		
				continue;				//-- 관리자 모드에서 첫화면 선택하면 continue로 반복문 처음부터 시작.
			}
			
			mu.baseSel();							//-- 메뉴 선택 메소드
			up.discount();							//-- 결제 진행 메소드
					
			try
			{	
				up.rsp();							//-- 게임 진행 메소드 
			}
			catch (InterruptedException e)
			{
				System.out.println();
			}

			mr.aiclear();						//-- 게임 진행 후 자동 노즐 청소 기능 메소드
		}
		while (true);
	 
	}
}