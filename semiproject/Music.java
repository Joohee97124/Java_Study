import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import java.io.File;

class Music
{     
    public void music()
	{   
		// 스윙이란 GUI를 만들어주는 툴!
		// GUI란? 그래픽 유저 인터페이스!

		// 프레임이 있어야 GUI 화면 출력이 가능하며 프레임 내에 부착된 모든 컴포넌트들이 화면에 출력돼요. 
		// 스윙에서 프레임의 역할을 수행하는 클래스가 JFrame클래스에요.		
        JFrame f = new JFrame("1조하는1조");       

		// JFrame 을 사용할 때 따라 붙는 메소드
		// JFrame 창(음악이 재생하는 창)을 끄면 메모리(프로세스 상에서)가 남아있는데 이를 막아주는 메소드이다.
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// JFrame 창을 가운데로 정렬되게끔 도와주는 메소드
        f.setLocationRelativeTo(null);

		// JFrame 창의 크기를 조절 해 주는 메소드
        f.setSize(200,200);

		// JFrame 창이 보여지게끔 해 주는 메소드
        f.setVisible(true);

        File file = new File("C:/JavaStudy/semiproject/music.wav");

		// 파일의 존재 여부를 확인.
        //System.out.println(file.exists());	//true
        
        try 
		{	
			AudioInputStream stream = AudioSystem.getAudioInputStream(file);

			Clip clip = AudioSystem.getClip();
			clip.open(stream);

			// 해당 파일의 반복 횟수
			clip.loop(10);

			// 파일이 반복하는 시점
			clip.start();
            
        } catch(Exception e) {
            
            e.printStackTrace();
        }
        
    }      
}