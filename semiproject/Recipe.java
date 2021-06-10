// ○ 메뉴관리 속성 클래스

class Recipe
{
	// 메뉴를 구성하는 모든 변수를 필드 변수로 선언
	private String menuName, sideName, ing;				// 메뉴 이름, 사이드 메뉴 이름, 재료 이름
	private int base;									// 베이스 이름
	private int baseQ, ingQ;							// 베이스량, 재료량										
 
	
	// getter setter 구성

	//-- menuName
	public String getMenuName()
	{
		return menuName;
	}

	public void setMenuName(String menuName)
	{
		this.menuName = menuName;
	}
	
	//-- base
	public int getBase()
	{
		return base;
	}

	public void setBase(int base)
	{
		this.base = base;
	}
	
	//-- ing
	public String getIng()
	{
		return ing;
	}

	public void setIng(String ing)
	{
		this.ing = ing;
	}
	
	//-- baseQ
	public int getBaseQ()
	{
		return baseQ;
	}

	public void setBaseQ(int baseQ)
	{
		this.baseQ = baseQ;
	}

	//-- ingQ
	public int getIngQ()
	{
		return ingQ;
	}
	
	public void setIngQ(int ingQ)
	{
		this.ingQ = ingQ;
	}
	
	//-- sideName
	public String getSideName()
	{
		return sideName;
	}

	public void setSideName(String sideName)
	{
		this.sideName = sideName;
	}

	// 매개변수가 없는 생성자 → 인스턴스 생성 위해 정의
	public Recipe()
	{
	}
	
	// int(베이스량), String(재료 이름), int(재료량)를 매개변수로 넘겨받는 생성자
	public Recipe(int baseQ, String ing, int ingQ)
	{
		this.baseQ = baseQ;
		this.ing = ing;
		this.ingQ = ingQ;
	}
}