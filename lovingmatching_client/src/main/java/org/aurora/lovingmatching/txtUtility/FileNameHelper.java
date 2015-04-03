package org.aurora.lovingmatching.txtUtility;
/**
 * @author ljing12[AT]software.nju.edu.cn
 */
public class FileNameHelper {
	private static String defaultRootPath = "src//main//resources//history//";
	private static String txtPostFix=".txt";
	private static String userFileNameString="user.txt";
	private static String initFileNameString="init.txt";
	public static String getDefaultPath(){
		return defaultRootPath;
	}
	public static String getTxtPostFix(){
		return txtPostFix;
	}
	
	public static String getUserHistoryFileName(String uid){
		return uid+"History.txt";
	}
	
	public static String getUserFileName(){
		return userFileNameString;
	}
	public static String getInitFileName(){
		return initFileNameString;
	}
}
