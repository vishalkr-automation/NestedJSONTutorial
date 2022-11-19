package sendHTTPRequest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONObject;

public class SendHTTPPostRequest {

	public static void main(String[] args) throws Exception{
		
		URL url=new URL("http://httpbin.org/post");
		Map<String,Object> parms=new LinkedHashMap<>();
		parms.put("Name", "Amit");
		parms.put("Email", "Amit@gmail.com");
		parms.put("Mob", "9999999999");
		parms.put("code", "111");
		parms.put("message", "Heloo Amit");
		
		StringBuilder postData=new StringBuilder();
		for(Map.Entry<String, Object> param:parms.entrySet())
		{
			if((postData.length() !=0))	
			postData.append('&');
			postData.append(URLEncoder.encode(param.getKey(),"UTF-8"));
			postData.append('=');
			postData.append(URLEncoder.encode(String.valueOf(param.getValue()),"UTF-8"));
			
		}
		
		byte[] postDataBytes=postData.toString().getBytes("UTF-8");
		HttpURLConnection con=(HttpURLConnection)url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		con.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
		con.setDoOutput(true);
		con.getOutputStream().write(postDataBytes);
		
		Reader in=new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
		
		StringBuilder sb=new StringBuilder();
		for(int c;(c=in.read())>=0;) {
			sb.append((char)c);
			
		}
		String response=sb.toString();
		//System.out.println(response);
		
		JSONObject myResponse=new JSONObject(response.toLowerCase());
		System.out.println(myResponse);
		
		System.out.println("Origin: "+myResponse.getString("origin"));
		//System.out.println("Host: "+myResponse.getString("content-type"));
		System.out.println("URL: "+myResponse.getString("url"));
		
		//Read Nested JSON Value
		JSONObject myResponse2=myResponse.getJSONObject("form");
		System.out.println("Name: "+myResponse2.getString("name"));
		System.out.println("Email: "+myResponse2.getString("email"));
		System.out.println("Mob: "+myResponse2.getString("mob"));
		System.out.println("Code: "+myResponse2.getString("code"));
		System.out.println("message: "+myResponse2.getString("message"));

	}

}
