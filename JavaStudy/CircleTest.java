
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CircleTest	
{
	// ���� �� Ǯ��
	/*

	// ������,���� ���� ����
	int r;
	double pi = 3.141592;

	// ���� �������� �Է¹޴� �޼ҵ�
	void input()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Է� : ");
		r = sc.nextInt();
	}
	
	// ���� ���� ���� �޼ҵ�
	double calArea()
	{
		// ������*������*3.141592
		double area;
		area = r*r*pi;
		return area;

		// return r*r*pi;

	}
	
	// ���� �ѷ� ���� �޼ҵ�
	double calLen()
	{
		// ������*2*3.141592
		
		//double length;
		//length = r * 2 * pi;
		//return length;
		

		return r*2*pi;
	}

	// ��� �޼ҵ�
	void print(double a, double l)
	{
		System.out.printf(">> �������� %d�� ����\n",r);
		System.out.printf(">> ���� : %.2f\n",a);
		System.out.printf(">> �ѷ� : %.2f\n",l);
	}
	*/

	
	// �Բ� �� Ǯ��

	int r;					//-- ������
	// double pi = 3.141592;
	final double PI = 3.141592;	//-- ������
	// ��final�� : ������ ���ȭ

	void input()	throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("������ �Է� : ");
		r = Integer.parseInt(br.readLine());
	}

	double calArea()
	{
		// ���� ���� = ������ * ������ * 3.141592

		double result;

		//result = ������ * ������ * 3.141592
		result = r*r*PI;

		return result;	// ���� ���� �����
	}

	double calLength()
	{
		// ���� �ѷ� = ������ * 2 * 3.141592
		double result;

		// result = ������ * 2 * 3.141592
		result = r*2*PI;

		return result;
	}

	void print(double a, double l)
	{
		System.out.printf("\n>> �������� %d�� ���� \n",r);
		System.out.printf(">> ���� : %.2f\n", a);
		System.out.printf(">> �ѷ� : %.2f\n", l);
	}

}
