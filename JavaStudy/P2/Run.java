import java.io.IOException;

class Run
{
	// ���� ����Ǵ� ���θ޼ҵ�
	public static void main(String[] args) throws IOException
	{
		Imagefile i = new Imagefile();		//-- �ʱ�ȭ�� Ĭ����
		Login l = new Login();				//-- �α��� Ŭ����
		MenuUser mu = new MenuUser();		//-- �޴� Ŭ����
		UserPayment up = new UserPayment();	//-- ���� Ŭ����
		MachineRoom mr = new MachineRoom();	//-- ������ Ŭ����
		game g = new game();				//-- ���� Ŭ����

		MenuAdmin ad = new MenuAdmin();	
		ad.setting();
		ad.settingSide();

		do
		{
			mr.loading();
			i.cocktail();
			l.defaultInfo();					//-- �α��� Ŭ������ ���� ���� �Է� �޼ҵ�
			l.start();							//-- �α��� ���� �޼ҵ�

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

			mr.aiclear();							//-- ���� ���� �� �ڵ� ���� û�� ��� �޼ҵ�
		}
		while (true);
	


					
	}
}