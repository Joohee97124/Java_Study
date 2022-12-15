// 멤버 정보 저장 클래스

public class MemberInfo
{


	private String name, id, pw, phone, birth;

	private int orderDate;
	private String orderMenu;
	private int orderTotal;
	private int point;
	private int customBase;
	private int customJuice;

	public MemberInfo(String name, String id, String pw, String phone, String birth, int point) 
	{
        this.name = name;
		this.id = id;
		this.pw = pw;
		this.phone = phone;
		this.birth = birth;
		this.point = point;
	}

	
	public MemberInfo()
	{
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getPw()
	{
		return pw;
	}

	public void setPw(String pw)
	{
		this.pw = pw;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getBirth()
	{
		return birth;
	}

	public void setBirth(String birth)
	{
		this.birth = birth;
	}

	public int getPoint()
	{
		return point;
	}

	public void setPoint(int point)
	{
		this.point = point;
	}

	public void setOrderTotal(int orderTotal)
	{
		this.orderTotal = orderTotal;
	}

	public int getOrderTotal()
	{
		return orderTotal;
	}

	public void setCustomBase(int customBase)
	{
		this.customBase = customBase;
	}

	public int getCustomBase()
	{
		return customBase;
	}

	public void setCustomJuice(int customJuice)
	{
		this.customJuice = customJuice;
	}

	public int getCustomJuice()
	{
		return customJuice;
	}

	@Override
    public String toString() 
	{ 
        return " 이름 : " + name + "   ID : " + id + "   PW : " + pw + "   전화번호 : " + phone + "   생년월일 : " + birth + "    적립금 : " + point;
    }

   // 포인트 적립 메소드
   /*public int pointC()
   {
      game gm = new game();
      int point1 = this.point;

      
      UserPayment up = new UserPayment();
      int point2 = up.pointStack();
      
      this.point = point1 + point2;

      return point;
   }*/

}