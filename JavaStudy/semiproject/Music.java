import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import java.io.File;

class Music
{     
    public void music()
	{   
		// �����̶� GUI�� ������ִ� ��!
		// GUI��? �׷��� ���� �������̽�!

		// �������� �־�� GUI ȭ�� ����� �����ϸ� ������ ���� ������ ��� ������Ʈ���� ȭ�鿡 ��µſ�. 
		// �������� �������� ������ �����ϴ� Ŭ������ JFrameŬ��������.		
        JFrame f = new JFrame("1���ϴ�1��");       

		// JFrame �� ����� �� ���� �ٴ� �޼ҵ�
		// JFrame â(������ ����ϴ� â)�� ���� �޸�(���μ��� �󿡼�)�� �����ִµ� �̸� �����ִ� �޼ҵ��̴�.
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// JFrame â�� ����� ���ĵǰԲ� �����ִ� �޼ҵ�
        f.setLocationRelativeTo(null);

		// JFrame â�� ũ�⸦ ���� �� �ִ� �޼ҵ�
        f.setSize(200,200);

		// JFrame â�� �������Բ� �� �ִ� �޼ҵ�
        f.setVisible(true);

        File file = new File("C:/JavaStudy/semiproject/music.wav");

		// ������ ���� ���θ� Ȯ��.
        //System.out.println(file.exists());	//true
        
        try 
		{	
			AudioInputStream stream = AudioSystem.getAudioInputStream(file);

			Clip clip = AudioSystem.getClip();
			clip.open(stream);

			// �ش� ������ �ݺ� Ƚ��
			clip.loop(10);

			// ������ �ݺ��ϴ� ����
			clip.start();
            
        } catch(Exception e) {
            
            e.printStackTrace();
        }
        
    }      
}