package com.cjj.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;


public class StrUtils {
	
      /**
       * 使用md5的算法进行加密
       */
      public static String md5(String plainText) {
         byte[] secretBytes = null;
         try {
             secretBytes = MessageDigest.getInstance("md5").digest(
                    plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有md5这个算法！");
        }
         String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
         // 如果生成数字未满32位，需要前面补0
         for (int i = 0; i < 32 - md5code.length(); i++) {
             md5code = "0" + md5code;
         }
         return md5code;
     }
	 
	  
	
	
	public static boolean check(String str, String regex) {
		boolean flag = false;
		try {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(str);
			flag = matcher.matches();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	/**
	 * 在commonProperties中完成赋值
	 */
	public static String prefix = "";
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddhh");
	{
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0800"));
	}

	public static String arr2String(String[] ss,boolean fangKuoHao) {
		StringBuilder sb = new StringBuilder();
		if(fangKuoHao) {
			sb.append("[");
		}
		for(String s :ss) {
			if(!StringUtils.isEmpty(s)) {
				sb.append(s.trim()).append(",");
			}
		}
		String finalStr = sb.toString();
		finalStr = finalStr.substring(0,finalStr.length() -1) + (fangKuoHao?"]":"");
		return finalStr;
	}
	public static String list2String(List<String> ss,boolean fangKuoHao) {
		StringBuilder sb = new StringBuilder();
		if(fangKuoHao) {
			sb.append("[");
		}
		for(String s :ss) {
			if(!StringUtils.isEmpty(s)) {
				sb.append(s.trim()).append(",");
			}
		}
		String finalStr = sb.toString();
		finalStr = finalStr.substring(0,finalStr.length() -1) + (fangKuoHao?"]":"");
		return finalStr;
	}
	public static List<String> string2List(String s){
		List<String> returnList = new ArrayList<String>();
		s = s.replaceAll("[", "").replace("]", "");
		String[] ss = s.split(",");
		for(String tmpS:ss) {
			if(!StringUtils.isEmpty(tmpS) && !"null".equals(tmpS.trim())) {
				returnList.add(tmpS.trim());
			}
		}
		return returnList;
	}
	public static String[] string2Arr(String s) {
		return string2List(s).toArray(new String[] {});
	}
	

	
	/**去掉两边的[]
	 * @param s
	 * @return
	 */
	public static String removeOuters(String s) {
		if(s == null) {
			return "";
		}
		if(s.startsWith("[")) {
			s = s.substring(1);
		}
		if(s.endsWith("]")) {
			s = s.substring(0,s.length() -1);
		}
		return s;
	}



	/**
	 * 数组字符串用sep符号组合
	 * @param ss
	 * @param sep
	 * @return
	 */
	public static String joinArr(String[] ss,String sep) {
		if(ss == null || ss.length == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for(String s:ss) {
			sb.append(s).append(sep);
		}
		String returnS = sb.toString();
		return returnS.substring(0,returnS.length() - sep.length());
	}
	
	/**
	 * 数组字符串用sep符号组合
	 * @param ss
	 * @param sep
	 * @return
	 */
	public static String joinArr(List<String> ss,String sep) {
		if(ss == null || ss.size() == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for(String s:ss) {
			sb.append(s).append(sep);
		}
		String returnS = sb.toString();
		return returnS.substring(0,returnS.length() - sep.length());
	}

	/**
	 * 根据数据库里存放的图片路径，拼接绝对图片网络地址
	 * 
	 * @param prefix
	 * @param path
	 * @return
	 */
	public static String getAbsolutePicUrl(String path) {

		return prefix + path;// path.replaceAll("\\\\", "/");
	}

	/**
	 * 验证手机号码
	 * 
	 * 移动号码段:134、135、136、137、138、139、147、150、151、152、157、158、159、178、182、183、184、187、188
	 * 联通号码段:130、131、132、136、145、155、156、176、185、186
	 * 电信号码段:133、153、173、177、180、181、189
	 * 
	 * @param phone
	 * @return
	 */
	public static boolean PHONE(String phone) {
		if (!StringUtils.isEmpty(phone)) {
			String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[3,6-8])|(18[0-9]))\\d{8}$";
			return check(phone, regex);
		}
		return false;
	}

	/**
	 * 验证姓名格式
	 * 
	 * @param name
	 * @return
	 */
	public static boolean NAME(String name) {
		if (!StringUtils.isEmpty(name)) {
			return true;
		}
		return false;
	}

	/**
	 * 验证地址格式
	 * 
	 * @param address
	 * @return
	 */
	public static boolean ADDRESS(String address) {
		if (!StringUtils.isEmpty(address)) {
			return true;
		}
		return false;
	}

	/**
	 * 验证银行卡格式
	 * 
	 * @param bankCard
	 * @return
	 */
	public static boolean BANK_CARD(String bankCard) {
		if (!StringUtils.isEmpty(bankCard)) {
			return true;
		}
		return false;
	}

	/**
	 * 验证电子邮件格式
	 * 
	 * @param email
	 * @return
	 */
	public static boolean EMAIL(String email) {
		if (!StringUtils.isEmpty(email)) {
			String regex = "^[a-zA-Z0-9_\\.-]+@([a-zA-Z0-9-]+\\.)+[a-zA-Z0-9]{2,4}$";
			return check(email, regex);
		}
		return false;
	}

	public static boolean EMPTY(String s) {
		return StringUtils.isEmpty(s);
	}
	
	
}
