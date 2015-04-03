package org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply;

public class HistoryReply extends Reply {
	private String game_type;
	private int total_game;			//总局数
	private int total_score;		//协作-总分
	private int total_win;			//对战-总胜局数
	private int avg_score;			//协作-每局均分
	private int avg_score_diff;		//对战-每局均净胜分
	
	public HistoryReply(String game, int n1, int n2, int n3)
	{
		type = "history";
		game_type = game;
		total_game = n1;
		if(game.equals("coop"))
		{
			total_score = n2;
			avg_score = n3;
		}
		if(game.equals("vs"))
		{
			total_win = n2;
			avg_score_diff = n3;
		}
	}
	
	public String toString()
	{
		String str = type + ":" + game_type + ";" + total_game + ";";
		if(game_type.equals("coop"))
			return str += total_score + ";" + avg_score;
		else if(game_type.equals("vs"))
			return str += total_win + ";" + avg_score_diff;
		else
			return type;
	}
	

}
