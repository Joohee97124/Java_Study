/* ==========================
���� �迭(array) ����
- �迭�� ����� �ʱ�ȭ
- �迭�� �⺻���� Ȱ��
=============================*/

// �� �ǽ� ����
// ��char���ڷ����� �迭�� ����� ���ĺ� �빮�ڸ� ä���
// ä���� �迭�� ��ü ��Ҹ� ����ϴ� ���α׷��� �����Ѵ�.

// ���� ��)
// A B C D ... W X Y Z
// ����Ϸ��� �ƹ�Ű��...

public class Test082
{
	public static void main(String[] args)
	{

		// ���� �� Ǯ��
		/*
		// char [] arr = new char [26];
		 char [] arr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q','R','S','T','U','V','W','X','Y','Z'};
		// char [] arr = {A,B, C, D, E, F};
		
		//System.out.println(arr.length);

		for (int i=0;i<arr.length ;i++ )
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		*/

		
		// �Բ� �� Ǯ��
		
		// ��� ��
		char[] arr1;
		arr1 = new char[26];

		arr1[0] = 'A';
		// :


		// ��� ��
		char [] arr2 = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q','R','S','T','U','V','W','X','Y','Z'};


		// ��� ��
		char [] arr3 = new char[26];
		for (int i=0,ch=65; i<arr3.length; i++,ch++ )	// 26ȸ��
		{	
			arr3[i] = (char)ch;
			// arr3[0] = (char)65;
			// arr3[1] = (char)66;
			//  : 
			// arr3[25] = (char)90;
		}

		// �迭 ��� ��ü ���
		for (int i=0; i<arr3.length ; i++)
			System.out.print(arr3[i]+ " ");
		System.out.println();
	
	}
}

/*
[���� ���]
A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/