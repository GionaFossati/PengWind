package application;


import java.io.*;
import javax.sound.sampled.*;
 
public class soundCheck {
 
    public static void main(String[] args) {
 
        ByteArrayOutputStream byteArrayOutputStream;
        TargetDataLine targetDataLine;
        int count;
        boolean stopCapture = false;
        byte tempBuffer[] = new byte[8000];
        int countzero, timeInSeconds;    
        short convert[] = new short[tempBuffer.length];
        boolean blowDetected;
 
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            stopCapture = false;
            timeInSeconds = 0;
            
            System.out.println("Starting microphone detection test...");
            
            while (!stopCapture) {
                AudioFormat audioFormat = new AudioFormat(8000.0F, 16, 1, true, false);
                DataLine.Info dataLineInfo = new DataLine.Info(TargetDataLine.class, audioFormat);
                targetDataLine = (TargetDataLine) AudioSystem.getLine(dataLineInfo);
                targetDataLine.open(audioFormat);
                targetDataLine.start();
                count = targetDataLine.read(tempBuffer, 0, tempBuffer.length);
                byteArrayOutputStream.write(tempBuffer, 0, count); 
                try {
                	
                	// Byte Size
                    countzero = 0;
                    
                    for (int i = 0; i < tempBuffer.length; i++) {                                     
                        convert[i] = tempBuffer[i];
                        if (convert[i] == 0) {
                            countzero++;
                        }
                    }
                     
                    timeInSeconds++;
                    
                    // If 
                    if (countzero < 800) {
                    	System.out.println(countzero + " bytes detected at " + timeInSeconds + " seconds");
                    	
                    	blowDetected = true;
                    	System.out.println(blowDetected + ": Blow detected at " + timeInSeconds + " seconds!");
                    } 
 
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                }
                Thread.sleep(0);
                targetDataLine.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}