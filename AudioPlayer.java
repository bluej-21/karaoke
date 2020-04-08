import java.io.*;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class AudioPlayer
{
    // to store current position 
    Long currentFrame; 
    Clip clip; 
      
    // current status of clip 
    String status; 
      
    AudioInputStream audioInputStream; 

    // constructor to initialize streams and clip 
    public AudioPlayer(String filePath) 
        throws UnsupportedAudioFileException, 
        IOException, LineUnavailableException  
    { 
        // create AudioInputStream object 
        audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile()); 
          
        // create clip reference
        clip = AudioSystem.getClip(); 
          
        // open audioInputStream to the clip 
        clip.open(audioInputStream); 
          
        clip.loop(Clip.LOOP_CONTINUOUSLY); 
    } 
  
    public static void main(String[] args)  
    { 
        try
        { 
            AudioPlayer audioPlayer = new AudioPlayer("C:\\Users\\jaso\\source\\repos\\karaoke\\songs\\Joji_Demons_Lunice_Remix.wav");

            audioPlayer.play(); 
            Scanner sc = new Scanner(System.in); 
              
            while (true) 
            {
                String op = sc.next();
                if (op.equals("start"))
                {
                    audioPlayer.play();
                }
                else if (op.equals("pause"))
                {
                    audioPlayer.pause();
                }
                else if (op.equals("off"))
                {
                    break;
                }
            }
            sc.close(); 
        }  
        catch (Exception ex)  
        { 
            System.out.println("Error with playing sound."); 
            ex.printStackTrace(); 
        } 
    }

    private void handleOperation(String op)
    {
        switch (op)
        {
            case "start":
                this.play();
                break;
            case "pause":
                this.pause();
                break;
            case "restart":
                
        }
    }
      
    // Method to play the audio 
    public void play()  
    { 
        //start the clip 
        clip.start(); 
        status = "play"; 
    } 
      
    // Method to pause the audio 
    public void pause()  
    {
        clip.stop();
        status = "paused";
    } 
}