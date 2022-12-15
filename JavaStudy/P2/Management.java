import java.io.IOException;

class Management extends Login
{
	int selection; // 사용자 입력값

	// 관리자 화면 메뉴 출력 메소드
	public void managerMenu() throws IOException
	{
		UserAdmin ua = new UserAdmin();			// 회원 관리 클래스 인스턴스 생성
		InvPage ip = new InvPage();				// 재고 관리 클래스 인스턴스 생성
		MenuAdmin ma = new MenuAdmin();			// 메뉴 관리 클래스 인스턴스 생성
		SalesManagement sm = new SalesManagement(); // 매출 관리 클래스 인스턴스 생성
		MachineRoom mr = new MachineRoom();		// 기계 관리 클래스 인스턴스 생성

		System.out.println("\n\n\t\t\t\t\t[ 관리자 모드 ]\n");
		System.out.println("\t1. 회원 관리  2. 메뉴 관리  3. 재고 관리  4. 매출 관리  5. 기계 관리  6. 첫화면");

		do
		{
			System.out.print("\t확인하고자 하는 페이지 선택(1~6) : ");
			selection = sc.nextInt();
		}
		while (selection<1 || selection>6);

		switch (selection)
		{
			case 1 : ua.userAdminMenu(); break;		// 회원 관리 메소드와 연결
			case 2 : ma.home(); break;// 메뉴 관리 메소드와 연결				//ma.setting();
			case 3 : ip.stockManage(); break;		// 재고 관리 메소드와 연결
			case 4 : sm.showChoice(); break;		// 매출 관리 메소드와 연결
			case 5 : mr.setMachine(); break;		// 기계 관리 메소드와 연결
			case 6 : start(); break;				// 첫 화면과 연결
		}
	}
}
