package org.aurora.lovingmatching.txtUtility;

/**
 * @author ljing12[AT]software.nju.edu.cn
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileHelper {
	String pathName;
	String fileName;

	public FileHelper() {

	}

	/**
	 * fileName需要使用全名，即包括路径名
	 * @param fileName
	 */
	public FileHelper(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * 得到reader
	 * 
	 * @return
	 */
	private BufferedReader createReader() {
		FileInputStream fs = null;
		BufferedReader bf = null;
		try {
			//System.out.println(fileName);
			fs = new FileInputStream(this.fileName);
			InputStreamReader fr = new InputStreamReader(fs, "UTF-8");
			bf = new BufferedReader(fr);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(FileHelper.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (UnsupportedEncodingException ex) {
			Logger.getLogger(FileHelper.class.getName()).log(Level.SEVERE,
					null, ex);
		}

		return bf;
	}

	/**
	 * 得到writer
	 * 
	 * @return
	 * @throws FileNotFoundException
	 */
	private PrintWriter createPrintWriter() throws FileNotFoundException {
		FileOutputStream fout = new FileOutputStream(fileName);
		Writer writer = null;
		try {
			writer = new OutputStreamWriter(fout, "UTF-8");
		} catch (UnsupportedEncodingException ex) {
			Logger.getLogger(FileHelper.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		PrintWriter pr = new PrintWriter(writer);
		// PrintWriter writer = new PrintWriter(fileName);
		return pr;
	}

	/**
	 * 创建文件
	 * 
	 * @param pathName
	 * @param fileName
	 * @return
	 */
	public boolean createFile(String pathName, String fileName) {
		File pathFile = new File(pathName);
		File file = new File(pathFile, fileName);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	/**
	 * 删除文件
	 * 
	 * @param pathName
	 * @param fileName
	 * @return
	 */
	public boolean deleteFile(String pathName, String fileName) {
		boolean flag = false;
		File file = new File(pathName + fileName);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
			flag = true;
		}
		return flag;
	}

	/**
	 * 向文件中添加一行数据
	 * 
	 * @param oneline
	 * @return
	 */
	public boolean append(String oneline) {
		try {
			BufferedReader bf = createReader();
			StringBuffer sbf = new StringBuffer();
			String s = null;
			while ((s = bf.readLine()) != null) {
				sbf.append(s);
				sbf.append("\r\n");
			}
			sbf.append(oneline);
			PrintWriter pw = createPrintWriter();
			pw.write(sbf.toString());
			pw.close();
			bf.close();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(FileHelper.class.getName()).log(Level.SEVERE,
					null, ex);
			return false;
		} catch (IOException ex) {
			Logger.getLogger(FileHelper.class.getName()).log(Level.SEVERE,
					null, ex);
			return false;
		}
		return true;
	}

	/**
	 * 向文件中添加一组数据
	 * 
	 * @param lines
	 * @return
	 */
	public boolean append(ArrayList<String> lines) {
		try {
			BufferedReader bf = createReader();
			StringBuffer sbf = new StringBuffer();
			String s = null;
			while ((s = bf.readLine()) != null) {
				sbf.append(s);
				sbf.append("\r\n");
			}
			for (String online : lines) {
				sbf.append(online);
				sbf.append("\r\n");
			}
			PrintWriter pw = createPrintWriter();
			pw.write(sbf.toString());
			pw.close();
			bf.close();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(FileHelper.class.getName()).log(Level.SEVERE,
					null, ex);
			return false;
		} catch (IOException ex) {
			Logger.getLogger(FileHelper.class.getName()).log(Level.SEVERE,
					null, ex);
			return false;
		}
		return true;
	}

	/**
	 * 得到文件中所有的数据
	 * 
	 * @return
	 */
	public ArrayList<String> find() {
		ArrayList<String> result = new ArrayList<String>();
		try {
			BufferedReader fr = createReader();
			String s = null;
			while ((s = fr.readLine()) != null) {
				result.add(s);
			}
		} catch (FileNotFoundException ex) {
			Logger.getLogger(FileHelper.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (IOException ex) {
			Logger.getLogger(FileHelper.class.getName()).log(Level.SEVERE,
					null, ex);
		}

		return result;
	}

	/**
	 * 得到文件中某一行的数据
	 * 
	 * @param lineNum
	 *            行号
	 * @return
	 */
	public String find(int lineNum) {
		String result = null;
		try {
			BufferedReader bf = createReader();
			int i = 1;
			while ((result = bf.readLine()) != null && i < lineNum) {
				i++;
			}
			bf.close();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(FileHelper.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (IOException ex) {
			Logger.getLogger(FileHelper.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return result;
	}
	
	/**
	 * 根据field位置的值得到一行记录
	 * @param field
	 * @param key
	 * @param separater
	 * @return
	 */
	public String find(int field,String key,String separater){
		String result = "";
		try {
			BufferedReader bf = createReader();
			StringBuffer sbf = new StringBuffer();
			String s = null;
			while ((s = bf.readLine()) != null) {
				String[] strs = s.split(separater);
				String fieldValue = strs[field];
				sbf.append(s);
				sbf.append("\r\n");
				if (fieldValue.equals(key)) {
					result=s;
				}
			}
			PrintWriter pw = createPrintWriter();
			pw.write(sbf.toString());
			pw.close();
			bf.close();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(FileHelper.class.getName()).log(Level.SEVERE,
					null, ex);
			return null;
		} catch (IOException ex) {
			Logger.getLogger(FileHelper.class.getName()).log(Level.SEVERE,
					null, ex);
			return null;
		}
		return result;
	}
	
	/**
	 * 根据第field个位置的值删除一行记录
	 * @param field
	 * @param key
	 * @param separater
	 * @return
	 */
	public String deleteOneline(int field, String key, String separater) {
		String result = "";
		try {
			BufferedReader bf = createReader();
			StringBuffer sbf = new StringBuffer();
			String s = null;
			while ((s = bf.readLine()) != null) {
				String[] strs = s.split(separater);
				String fieldValue = strs[field];
				if (!fieldValue.equals(key)) {
					sbf.append(s);
					sbf.append("\r\n");
				}else{
					result=fieldValue;
				}
			}
			PrintWriter pw = createPrintWriter();
			pw.write(sbf.toString());
			pw.close();
			bf.close();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(FileHelper.class.getName()).log(Level.SEVERE,
					null, ex);
			return null;
		} catch (IOException ex) {
			Logger.getLogger(FileHelper.class.getName()).log(Level.SEVERE,
					null, ex);
			return null;
		}
		return result;
	}

	/**
	 * 清空文件
	 * 
	 * @return
	 */
	public boolean clear() {
		try {
			PrintWriter pr = createPrintWriter();
			pr.write("");
			pr.close();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(FileHelper.class.getName()).log(Level.SEVERE,
					null, ex);
			return false;
		}
		return true;
	}

}
