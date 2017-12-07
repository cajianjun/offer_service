package com.cjj.manage.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cjj.common.Constants;
@RestController
@RequestMapping(value = Constants.ROUTE_LOG)
public class AdminESController {
	@RequestMapping(value="log", method = RequestMethod.GET)  
    public String log() {  
		
		try {
//			String lineSeparator = System.getProperty("line.separator", "\n");  
			InputStream stream = getClass().getClassLoader().getResourceAsStream("apilog/log");
			InputStreamReader read = new InputStreamReader(stream
            /*new FileInputStream(file)*/,"utf-8");//考虑到编码格式
            BufferedReader bufferedReader = new BufferedReader(read);
            StringBuilder sb = new StringBuilder();
            String lineTxt = null;
            while((lineTxt = bufferedReader.readLine()) != null){
                sb.append(lineTxt).append("<br>");
            }
            read.close();
            return sb.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return null;  
    }  
}
