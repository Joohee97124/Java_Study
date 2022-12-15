// ��� ���� ���� Ŭ����

class MemberInfo
{
	private String name = "", id= "", pw= "", phone= "", birth= "";

	private int point=100;
	private String mainMenu="����";		// �ֹ��� Ĭ���� �̸� vCust1.get(vCust3.size()-1)
	private int mainCount=1;			// �ֹ��� Ĭ���� ��
	private int mainTotal=0;			// �ֹ��� Ĭ���� ���� mainTot
	private String subMenu;				// �߰� �޴� �̸�
	private int subMenuCount=0;			// �߰� �޴� ����
	private int subTotal;				// �߰� �޴� ����
	private int orderTotal;				// �� �ֹ� ����(Ĭ����+�߰� �޴�, ���� ��) fianlTot
	private int payTotal;				// ���� �� ���� ���� �ݾ�
	private int everyTotal=0;			// ȸ�� ���� �� ��� ������ ���� �ݾ�
	private int customBase=-1;
	private int customJuice=-1;

	// ���� ����: ����, ��, ��
	private int y=0;
	private int m=0;
	private int d=0;

	private String strHow="����";		// ���� ��� (ī��, ����)


	// �⺻ ����� ����ϱ� ���� ����� ���� ������
	public MemberInfo(String name, String id, String pw, String phone, String birth, int point) 
	{
        this.name = name;
		this.id = id;
		this.pw = pw;
		this.phone = phone;
		this.birth = birth;
		this.point = point;
	}

	// �α����� ������� ���� ������ ������ �����ϱ� ���� ����� ���� ������
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
        return " �̸� : " + name + "   ID : " + id + "   PW : " + pw + "   ��ȭ��ȣ : " + phone + "   ������� : " + birth + "    ������ : " + point;
    }


}