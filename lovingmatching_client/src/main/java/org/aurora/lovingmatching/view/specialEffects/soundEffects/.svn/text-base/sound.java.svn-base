package org.aurora.lovingmatching.view.specialEffects.soundEffects;

import java.io.File;

import saint.media.SimplePlayer;


public class sound {
	private static SimplePlayer bgmPlayer = null;
	private static SimplePlayer soundPlayer = null;
	private static String route="src/main/resources/sound/";
	
	public static void playBGM(String name) {
		if (bgmPlayer!=null){
			bgmPlayer.stop();
			bgmPlayer=new SimplePlayer();
		}
		else{
			bgmPlayer=new SimplePlayer();
		}
	
		try{
			bgmPlayer.open(new File(route+name+".wav"));
			bgmPlayer.setLoop(true);
			bgmPlayer.setLoopCount(1000);
		}catch (Exception e) {
			System.err.println("无文件");
			return;
		}

		try{
			bgmPlayer.play();	
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static void playSound(String name){
		soundPlayer=new SimplePlayer();
		
		try{
			soundPlayer.open(new File(route+name+".wav"));
			soundPlayer.setLoop(false);
		}catch (Exception e) {
			System.err.println("无文件");
			return;
		}

		try{
			soundPlayer.play();	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void stopBGM(){
		bgmPlayer.setVolume(0);
	}
	
	public static void stopSound(){
		soundPlayer.setVolume(0);
	}
}
