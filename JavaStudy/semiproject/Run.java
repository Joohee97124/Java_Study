import java.io.IOException;

class Run
{
	// ���� ����Ǵ� ���θ޼ҵ�
	public static void main(String[] args) throws IOException
	{	
		Music music = new Music();
		Imagefile i = new Imagefile();				//-- �ʱ�ȭ�� Ĭ����
		Login l = new Login();						//-- �α��� Ŭ����
		Management mm = new Management();			//-- ������ ��� Ŭ����
		MenuUser mu = new MenuUser();				//-- �޴� Ŭ����
		UserPayment up = new UserPayment();			//-- ���� Ŭ����
		SalesManagement sm = new SalesManagement();	//-- ���� ���� Ŭ����
		MachineRoom mr = new MachineRoom();			//-- ������ Ŭ����
		game g = new game();						//-- ���� Ŭ����
		//Cash ch = new Cash();

		MenuAdmin ma = new MenuAdmin();				//-- �޴����� Ŭ����
		
		music.music();
		l.defaultInfo();							//-- �α��� Ŭ������ ���� ���� �Է� �޼ҵ�
		sm.defaultData();							//-- ���� �� Ȯ���� ������ ���ε�
		mr.loading();
		i.cocktail();

		ma.setting();								//-- Ĭ���� �޴� ����
		ma.settingSide();							//-- ���̵� �޴� ����

		do
		{
			l.start();								//-- �α��� ���� �޼ҵ�
			g.id = sm.buyer = up.name = mu.userId = l.name2;

			if (l.name2.equals("admin") && l.pw2.equals("1234")) // -- ������ ���
			{
				mm.managerMenu();		
				continue;				//-- ������ ��忡�� ùȭ�� �����ϸ� continue�� �ݺ��� ó������ ����.
			}
			
			mu.baseSel();							//-- �޴� ���� �޼ҵ�
			up.discount();							//-- ���� ���� �޼ҵ�
					
			try
			{	
				up.rsp();							//-- ���� ���� �޼ҵ� 
			}
			catch (InterruptedException e)
			{
				System.out.println();
			}

			mr.aiclear();						//-- ���� ���� �� �ڵ� ���� û�� ��� �޼ҵ�
		}
		while (true);
	 
	}
}