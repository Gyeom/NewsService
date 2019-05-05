package com.example.spring02.controller.papago;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("papago/*")
public class PapagoAPI {
	@PostMapping("PapagoAPI")
	public String papagoNMT(@RequestParam("data") String data, HttpServletResponse response) throws IOException {
		    response.setContentType("text/html;charset=utf-8");
		 
		    //����� ������ ���Ѱ� 
		    PrintWriter out = response.getWriter();
		    out.print((String)nmtReturnResult(data));
		
		return null;
	}
	// nmtReturnResult�� �Լ��� ���ؼ� �ѱ� - > ����� ����
	public String nmtReturnResult(String data){
	    
	    //���ø����̼� Ŭ���̾�Ʈ ���̵�";
	    String clientId = "6jxVIB0bYIj1h1NJleqK";
	    //���ø����̼� Ŭ���̾�Ʈ ��ũ����";
	    String clientSecret = "VAF76f9X5C";
	    String resultString ="";
		 try {
			String text = URLEncoder.encode(data, "UTF-8");
			
			String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
	        URL url = new URL(apiURL);
	        HttpURLConnection con = (HttpURLConnection)url.openConnection();
	        con.setRequestMethod("POST");
	        con.setRequestProperty("X-Naver-Client-Id", clientId);
	        con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
	        // post request
	        String postParams = "source=en&target=ko&text=" + text;
	        con.setDoOutput(true);
	        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	        wr.writeBytes(postParams);
	        wr.flush();
	        wr.close();
	        int responseCode = con.getResponseCode();
	        BufferedReader br;
	        if(responseCode==200) { // ���� ȣ��
	            br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
	        } else {  // ���� �߻�
	            br = new BufferedReader(new InputStreamReader(con.getErrorStream(),"UTF-8"));
	        }
	        String inputLine;
	        StringBuffer response = new StringBuffer();
	        while ((inputLine = br.readLine()) != null) {
	            response.append(inputLine);
	        }
	        br.close();
	        System.out.println(response.toString());
	        
	        resultString = response.toString();
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    
	    return resultString;
	}

}