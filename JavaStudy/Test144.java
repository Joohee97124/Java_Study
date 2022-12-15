/*======================================
■■■ 예외(Exception) 처리 ■■■
======================================*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Test144
{
	private String[] data = new String[3];

	public void proc() // throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str;
		int n=0;

		try
		{
			System.out.print("이름 입력[종료: Ctrl+z] : ");

			while ((str=br.readLine()) != null)
			{
				data[n++] = str;
				System.out.print("이름 입력[종료: Ctrl+z] : ");
			}

			System.out.println("입력된 내용...");
			for (String s : data)
			{
				if (s != null)
					System.out.println(s);
			}
		}
		catch (IOException e1)
		{
			System.out.println(e1.toString());
		}
		catch (ArrayIndexOutOfBoundsException e2)
		{
			System.out.println("예외 발생~!!!");
			System.out.println("getMessage : " + e2.getMessage());
			System.out.println("toString : : " + e2.toString());
			System.out.println("printStackTrace...");
			e2.printStackTrace();
		}

	}


	public static void main(String[] args)  // throws IOException
	{
		Test144 ob = new Test144();
		ob.proc();
	}
}