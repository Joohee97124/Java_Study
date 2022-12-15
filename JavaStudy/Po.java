/* 
// 실행 예)
// 1 4 17 23 44
// 1 2 8 16 28 42
//	:
// 계속하려면 아무 키나....
*/

import java.util.Random;

class Lotto
{
	int[] lotto = new int[6];

	void cal()
	{
		Random rd = new Random();
		int i,j;

		for (i=0; i<lotto.length ; i++ )
		{
			lotto[i] = rd.nextInt(45)+1;
			
			for (j=0 ;j=i ; j++)
			{
				if (i==0)
					continue;

				if (lotto[j] = lotto[i])
				{
					i--;
					lotto[i] = rd.nextInt(45)+1;
				}
			}
		}
	}

	void seq()
	{
		for (int i=0; i<lotto.length ; i++ )
		{
			for (int j=1;j<lotto.length-1 ;j++ )
			{
				if (lotto[i]>lotto[j])
				{
					lotto[i] = lotto[i]^lotto[j];
					lotto[j] = lotto[j]^lotto[i];
					lotto[i] = lotto[i]^lotto[j];
				}
			}
		}
	}



}


public class Po
{
	public static void main(String[] args)
	{
		Lotto ob = new Lotto();
		Lotto.cal();
		Lotto.seq();

		

	}
}


