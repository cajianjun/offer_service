package com.cjj.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperator {
	static String basePath = "C:\\Users\\10308\\Desktop\\docs\\ipc分类文档\\txt";
	public static void main(String[] args) {
		format2Json("b.txt","B");
		format2Json("c.txt","C");
		format2Json("d.txt","D");
		format2Json("e.txt","E");
		format2Json("f.txt","F");
		format2Json("g.txt","G");
		format2Json("h.txt","H");
	}
	
	public static  void format2Json(String path,String code){
		
        try{
            BufferedReader br = new BufferedReader(new FileReader(basePath + "\\" +path));//构造一个BufferedReader类来读取文件
            String s = null;
            writeFile(basePath,code + "JSON.txt","",false);
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
            	if(!s.trim().equals("")) {
            		String lineWords = s.trim();
            		if(lineWords.indexOf(code) == 0) {
            			String[] kv = judgeHeader(lineWords);
            			if(kv.length ==2 && kv[0] != null) {
            				String content = kv[0] + "-----" + kv[1] + "\r\n";
            				writeFile(basePath,code + "JSON.txt",content,true);
            			}
            		}
            	}
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
	}
	
	public static String[] judgeHeader(String line) {
		String[] idValue = new String[2];
		int endIndex = -1;
		for(int i = 0;i < line.length();i++) {
			String tmpStr = line.substring(i,i + 1);
			if(tmpStr.getBytes().length != 1) {//中文
				endIndex = i;
				break;
			}
			if(judgeChar(line.charAt(i)) == -1) {//其他字符
				endIndex = i;
				break;
			}
			
		}
		
		if(endIndex >= 0) {
			String id = line.substring(0, endIndex);
			String value = line.substring(endIndex, line.length());
			value = value.trim().replaceAll("·", "");
			idValue[0] = id.trim();
			idValue[1] = value;
		}
		return idValue;
	}
	
	public static int judgeChar(char c) {
		byte bt = (byte)c;
		if(bt >= 65 && bt <= 90) {
			//字母
			return 0;
		}
		if(bt >= 48 && bt <= 57) {
			//数字
			return 1;
		}
		if(bt == 47) {
			return 2;
		}
		if(bt == 32) {
			return 3;
		}
		return -1;
	}
	
	public static void writeFile(String pathWithoutName,String fileName,String data,boolean append) {
		 FileWriter fileWritter;
			try {
				File f1 = new File(pathWithoutName);
				if(!f1.exists()) {
					f1.mkdirs();
				}
				File f2 = new File(pathWithoutName + "\\" + fileName);
				if(!f2.exists()) {
					f2.createNewFile();
				}
				fileWritter = new FileWriter(pathWithoutName + "\\" + fileName,append);
				BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
				bufferWritter.write(data);
				bufferWritter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
}

