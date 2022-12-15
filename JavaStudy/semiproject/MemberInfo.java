// 멤버 정보 저장 클래스

class MemberInfo
{
	private String name = "", id= "", pw= "", phone= "", birth= "";

	private int point=100;
	private String mainMenu="없음";		// 주문한 칵테일 이름 vCust1.get(vCust3.size()-1)
	private int mainCount=1;			// 주문한 칵테일 수
	private int mainTotal=0;			// 주문한 칵테일 가격 mainTot
	private String subMenu;				// 추가 메뉴 이름
	private int subMenuCount=0;			// 추가 메뉴 수량
	private int subTotal;				// 추가 메뉴 가격
	private int orderTotal;				// 총 주문 가격(칵테일+추가 메뉴, 할인 전) fianlTot
	private int payTotal;				// 할인 후 최종 결제 금액
	private int everyTotal=0;			// 회원 가입 후 계속 누적된 결제 금액
	private int customBase=-1;
	private int customJuice=-1;

	// 결제 시점: 연도, 월, 일
	private int y=0;
	private int m=0;
	private int d=0;

	private String strHow="없음";		// 결제 방식 (카드, 현금)


	// 기본 사용자 등록하기 위한 사용자 정의 생성자
	public MemberInfo(String name, String id, String pw, String phone, String birth, int point) 
	{
        this.name = name;
		this.id = id;
		this.pw = pw;
		this.phone = phone;
		this.birth = birth;
		this.point = point;
	}

	// 로그인한 사용자의 결제 정보를 저장해 정렬하기 위한 사용자 정의 생성자
	public MemberInfo(int y, int m, int d, String name, String mainMenu, int mainCount, int everyTotal, String strHow)
	{
		this.y=y;
		this.m=m;
		this.d=d;
		this.name=name;
		this.mainMenu=mainMenu;
		this.mainCount=mainCount;
		this.everyTotal=everyTotal;
		this.strHow=strHow;	
	}
	
	public MemberInfo()
	{
	}

	// getter
	public String getName(){ return name; }

	public String getId(){ return id; }

	public String getPw(){ return pw; }

	public String getPhone(){ return phone; }

	public String getBirth(){ return birth; }

	public int getPoint(){ return point; }

	public String getMainMenu(){ return mainMenu;}

	public int getMainCount(){ return mainCount; }

	public int getMainTotal(){ return mainTotal; }

	public String getSubMenu(){ return subMenu; }

	public int getSubMenuCount(){ return subMenuCount; }

	public int getSubTotal(){ return subTotal; }

	public int getOrderTotal(){ return orderTotal; }

	public int getPayTotal(){ return payTotal; }

	public int getEveryTotal(){ return everyTotal; }

	public int getCustomBase(){ return customBase; }

	public int getCustomJuice(){ return customJuice; }

	public int getY(){ return y; }

	public int getM(){ return m; }

	public int getD(){ return d; }

	public String getStrHow(){ return strHow; }

	// setter
	public void setName(String name){ this.name = name; }

	public void setId(String id){ this.id = id; }

	public void setPw(String pw){ this.pw = pw; }

	public void setPhone(String phone){ this.phone = phone; }

	public void setBirth(String birth){ this.birth = birth; }

	public void setPoint(int point){ this.point = point; }

	public void setMainMenu(String mainMenu){ this.mainMenu = mainMenu; }

	public void setMainCount(int MainCount){ this.mainCount = mainCount; }

	public void setMainTotal(int mainTotal){ this.mainTotal = mainTotal; }

	public void setSubMenu(String subMenu){ this.subMenu = subMenu; }

	public void setSubMenuCount(int subMenuCount){ this.subMenuCount = subMenuCount; }

	public void setSubTotal(int subTotal){ this.subTotal = subTotal; }

	public void setOrderTotal(int orderTotal){ this.orderTotal = orderTotal; }

	public void setPayTotal(int payTotal){ this.payTotal = payTotal; }

	public void setEveryTotal(int everyTotal){ this.everyTotal += everyTotal; }

	public void setCustomBase(int customBase){ this.customBase = customBase; }

	public void setCustomJuice(int customJuice){ this.customJuice = customJuice; }

	public void setY(int y){ this.y = y; }

	public void setM(int m){ this.m = m; }

	public void setD(int d){ this.d = d; }

	public void setStrHow(String strHow){ this.strHow = strHow; }

	@Override
    public String toString() 
	{ 
        return " 이름 : " + name + "   ID : " + id + "   PW : " + pw + "   전화번호 : " + phone + "   생년월일 : " + birth + "    적립금 : " + point;
    }


}