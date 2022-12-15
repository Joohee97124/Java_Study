import java.util.Scanner;

public class Sungjuk
{
	// ���� �� Ǯ��
	/*
	int n;
	Record[] objArr;								// Record ������ �迭 ���� (�迭 �̸� : objArr)


	void input()									// �ο��� �Է¹޴� �޼ҵ�
	{
		Scanner sc = new Scanner(System.in);
		
		do
		{
			System.out.print("�ο� �� �Է� (1~100) :");
			n = sc.nextInt();
		}
		while (n<1 || n>100);
	}


	void student()									// �̸�, ������ ���� �Է¹޴� �޼ҵ�
	{
		Scanner sc = new Scanner(System.in);
		

		objArr = new Record[n];						// �迭 �ʱ�ȭ ���ֱ� (n��)

		for (int i=0; i<n ;i++ )
		{
			objArr[i] = new Record();				// �迭 �ν��Ͻ� �������ֱ�-> �迭 �ʱ�ȭ �ϱ� ����!

			System.out.printf("%d��° �л��� �̸� �Է� :",(i+1));
			objArr[i].name = sc.next();
	
			System.out.print("�������� : ");
			objArr[i].kor = sc.nextInt();

			System.out.print("�������� : ");
			objArr[i].eng = sc.nextInt();
			
			System.out.print("�������� : ");
			objArr[i].mat = sc.nextInt();

			objArr[i].tot = objArr[i].kor + objArr[i].eng + objArr[i].mat ;	// ����
			int total = objArr[i].tot;

			objArr[i].avg = (double) total/n;								// ���
			double avger = objArr[i].avg;	
		}
	}


	void print()									// ����ϴ� �޼ҵ�
	{
		for (int i=0;i<n ;i++ )
		{
			System.out.printf("%s %d %d %d %d %.2f\n", objArr[i].name, objArr[i].kor, objArr[i].eng , objArr[i].mat , objArr[i].tot, objArr[i].avg);
		}
	}	
	*/



	// �Բ� �� Ǯ��
	//	- �Ӽ� : �ο���, Record ������ �迭 
	// �ֿ� �Ӽ� ����
	private int inwon;				//-- �ο� ��
	private Record [] recArr;		//-- Record ������ �迭
									//	 (�л� 1�� �� Record �迭�� 1�� Ȱ��)

	//	- ��� : �ο��� �Է�, �� ������ �Է�, ����/��� ����, ��� ���
	// �޼ҵ� ����
	// �� �ο� �� �Է�
	public void set()
	{
		Scanner sc = new Scanner(System.in);

		do
		{
			System.out.print("�ο� �� �Է� (1~100) :");
			inwon = sc.nextInt();
		}
		while (inwon<1 || inwon>100);
		
		// check~!!
		// Record Ŭ������ ������� ������ ��ü(�ν��Ͻ�)�� ���� �� �ִ�
		// �迭���� inwon ��ŭ ������ ������,
		// Record Ŭ������ �ν��Ͻ��� ������ ���� �ƴϴ�. (�ν��Ͻ���������X �迭O)
		recArr = new Record[inwon];		//-- �ο���ŭ "�迭" ����
	}
	
	//	- ��� : �� ������ �Է�, ����/��� ����, ��� ���
	// �޼ҵ� ����
	// �� �� ������ �Է� + �� ����/��� ����
	public void input()
	{
		Scanner sc = new Scanner(System.in);

		String[] subTitle = {"���� ���� : ", "���� ���� ", "���� ���� :"};

		for (int i=0; i<inwon ; i++ )	// �ο� �� ��ŭ �ݺ�~!! (inwon == recArr.length)
		{
			// ������ �Է°����� recArr �迭�� i��° �迭�濡 ��Ƴ���
			// �� Record Ŭ���� ����� �ν��Ͻ� ����
			recArr[i] = new Record();

			System.out.printf("%d��° �л��� �̸� �Է� : ", (i+1));
			recArr[i].name = sc.next();
			
			/*
			System.out.print("���� ���� : ");
			recArr[i].score[0] = sc.nextInt();
			recArr[i].tot += rec.Arr[i].score[0];

			System.out.print("���� ���� : ");
			recArr[i].score[1] = sc.nextInt();
			recArr[i].tot += recArr[i].score[1];

			System.out.print("���� ���� : ");
			recArr[i].score[2] = sc.nextInt();
			recArr[i].tot += recArr[i].score[2];
			*/

			for (int j=0;j<subTitle.length ;j++ )	// 0 1 2
			{
				// �ȳ� �޼��� ���
				System.out.print(subTitle[j]);
				
				// ����ڰ� �Է��� �����͸� ���ھ�(score) �迭�� ��Ƴ���
				recArr[i].score[j] = sc.nextInt();

				// ����, ����, ���� ���� �����͸� �ݺ������� �Է¹޴� ����
				// �� �������� ���� �����ϱ�
				recArr[i].tot += recArr[i].score[j];
			}


			// ��� �����ϱ�
			recArr[i].avg = recArr[i].tot / 3.0;
		}

	}//end input()


	//	- ��� : ��� ���
	// �޼ҵ� ����
	// �� ��� ���
	public void print()
	{
		// ���� ���� �޼ҵ� ȣ�� ���� �߰�~!!!
		ranking();

		// ����
		System.out.println();

		// �л� 1�� �� �ݺ� ��� ����
		for (int i=0; i<inwon ; i++ )		//-- �л� �ο� �� ��ŭ �ݺ�~!!
		{
			// �̸� ���
			System.out.printf("%5s", recArr[i].name);

			// ����(����, ����, ����) �ݺ� ���
			for (int j=0; j<3 ; j++ )	// 0 1 2 �� ���� ���� ����
				System.out.printf("%4d", recArr[i].score[j]);
			
			// ���� ��� ���
			System.out.printf("%5d", recArr[i].tot);
			System.out.printf("%8.2f", recArr[i].avg);

			// ���� ��� ���� �߰�~!!!
			System.out.printf("%5d",recArr[i].rank);

			// ����
			System.out.println();
		}

	}//end print()

	// �޼ҵ� �߰� ����
	// �� ���� ����
    private void ranking()
	{
		// ���� ����
		int i,j;
		// ��� �л����� ���(����)�� 1�� �ʱ�ȭ
		for (i=0; i<inwon ; i++ )

			recArr[i].rank = 1;
		
		// ��� (����) ����
		for (i=0; i<inwon-1 ; i++ )		//-- i �� �񱳱����� �����ϴ� �ε��� (�������� °���� �� �ʿ�X)
		{
			for (j=i+1;j<inwon ;j++ )	//-- j �� �񱳴���� �����ϴ� �ε��� (������ �� �񱳴���� �Ǿ���� + �񱳱��غ��� +1 Ŀ���ϰ� ,)
			{
				if (recArr[i].avg > recArr[j].avg)	// ���ص����Ͱ� �� �����ͺ��� ũ�ٸ�...
				{
					// �񱳵������� rank�� 1��ŭ ����
					recArr[j].rank ++;
				}
				else if (recArr[j].avg > recArr[i].avg)	// �񱳵����Ͱ� ���ص����ͺ��� ũ�ٸ�...
				{
					// ���ص������� rank�� 1��ŭ ����
					recArr[i].rank ++;
				}
			}
		}
	}



}