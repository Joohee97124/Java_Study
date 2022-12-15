import java.util.Iterator;
import java.io.IOException;

class UserAdmin extends Management
{
	int i=0;

	// 회원 관리 페이지
	public void userAdminMenu() throws IOException
	{
		System.out.println("\n\n\t=================[ 회원 관리 페이지 ]==================\n");
		System.out.println("\t1. 회원 정보 출력  2. 회원 정보 검색  3. 회원 정보 삭제 4. 커스텀 레시피 관리(검색)  5. 돌아가기");

		do
		{
			System.out.print("\t확인하고자 하는 페이지 선택(1~5) : ");
			selection = sc.nextInt();
		}
		while (selection<1 || selection>5);

		switch (selection)
		{
			case 1 : showDB(); break;				// 회원 정보 출력 메소드와 연결
			case 2 : searchDB(); break;				// 회원 정보 검색 메소드와 연결
			case 3 : deleteDB(); break;				// 회원 정보 삭제 메소드와 연결
			case 4 : searchRecipe(); break;			// 커스텀 레시피 관리(검색) 메소드와 연결
			case 5 : managerMenu(); break;			// 돌아가기
		}
	}

	public void showDB()throws IOException
	{
		System.out.println("\n\t=================[회원 정보 리스트 전체 출력]==================\n");
		Iterator it = list.iterator();

		while (it.hasNext())
		{
			MemberInfo str = (MemberInfo)it.next();
			if (str.getId().equals(""))
				continue;

			System.out.println("\t" + str);
		}
		System.out.println("\n\t리스트 전체 출력 완.\n");	
		userAdminMenu();
	}

	public void searchDB()throws IOException
	{
		
		System.out.print("\n\t검색하고자 하는 회원 ID 입력 : ");
		String s = sc.next();
		System.out.println("\n\t=================[검색 결과 출력]==================");
		
		if (idCheck(s))
		{
			MemberInfo m = findById(s);
			System.out.printf("\n\t이름 : %s\n\tID : %s\n\tPW : %s\n\t전화번호 : %s\n\t생년월일 : %s\n\t적립금 : %d\n"
				,m.getName(),m.getId() ,m.getPw(),m.getPhone(),m.getBirth(),m.getPoint());
		}
		else
			System.out.println("\t입력하신 회원 ID가 존재하지 않아 검색할 수 없습니다.");

		userAdminMenu();
		
	}

	public void deleteDB()throws IOException
	{
		System.out.print("\n\t삭제할 회원 ID 입력 : ");
		String s = sc.next();

		if (idCheck(s))
		{
			list.remove(findById(s));
			System.out.printf("\n\t정상적으로 삭제가 완료되었습니다.");
		}
		else
			System.out.println("\t입력하신 회원 ID가 존재하지 않아 삭제할 수 없습니다.");

		userAdminMenu();
	}

	public void searchRecipe() throws IOException
	{
		System.out.print("\n\t검색하고자 하는 회원의 ID 입력: ");
		String s = sc.next();

		if (idCheck(s))
		{
			MemberInfo m = findById(s);
			System.out.printf("\n\t %s 님의 커스텀레시피 : 베이스 %s ml & 주스/큐라소 %s ml"
				,m.getName(),m.getCustomBase(),m.getCustomJuice());
		}
		else
			System.out.println("\t입력하신 회원 ID가 존재하지 않아 레시피를 출력할 수 없습니다.");

		userAdminMenu();
		
	}

}
