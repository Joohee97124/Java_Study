// �� �޴����� �Ӽ� Ŭ����

class Recipe
{
	// �޴��� �����ϴ� ��� ������ �ʵ� ������ ����
	private String menuName, sideName, ing;				//-- �޴� �̸�, ���̵� �޴� �̸�, ��� �̸�
	private int base;									//-- ���̽� �̸� �� ���̽� �̸��� int Ÿ������ ������ ������ ���ؼ��� �Ʒ����� ����
	private int baseQ, ingQ;							
	//-- ���̽���, ��ᷮ										
 
	
	// getter setter ����

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

	// �Ű������� ���� ������ �� �ν��Ͻ� ���� ���� ����
	public Recipe()
	{
	}
	
	// String(�޴� �̸�)�� �Ű������� �Ѱܹ޴� ������
	public Recipe(String menuName)
	{	
		this.menuName = menuName;
	}

	// int(���̽� �̸�)�� �Ű������� �Ѱܹ޴� ������ �� base ����, �� ���̽� �̸��� String Ÿ������ ������ ���
	//													�����ڸ� �����ε��ϴ� ���� �Ұ����ϹǷ�
	//													int Ÿ������ ������ �� ���̽� �̸��� ��ҷ� ������ �迭�� �ε��� ���� �����Ͽ� ��Ʈ����
	public Recipe(int base)
	{
		this.base = base;
	}
	
	// int(���̽���), String(��� �̸�), int(��ᷮ)�� �Ű������� �Ѱܹ޴� ������
	public Recipe(int baseQ, String ing, int ingQ)
	{
		this.baseQ = baseQ;
		this.ing = ing;
		this.ingQ = ingQ;
	}
}