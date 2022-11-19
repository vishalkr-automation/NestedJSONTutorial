package nestedJSON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ReadNestedJSON {

	public static void main(String[] args) {
		try {
		ReadNestedJSON.convertJsonToJava();
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public static void convertJsonToJava() throws Exception {
//		String ip="117.245.94.65";
//		String key="4E191A613023EA66D24E35E41C870D3B";
//		
//		String url="https://api.ip2location.io/?key="+key+"&ip="+ip+"&format=json";
		
		String url="http://httpbin.org/ip";
		
		URL obj=new URL(url);
		HttpURLConnection con=(HttpURLConnection) obj.openConnection();
		
		//optional default is GET
		con.setRequestMethod("GET");
		//add request header
		//con.setRequestProperty("user-Agent", "Mozilla/5.0");
		
		int responseCode=con.getResponseCode();
		System.out.println("Sending get request to URL: "+ url);
		System.out.println("Response code: "+ responseCode);
		BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response=new StringBuffer();
		while((inputLine=br.readLine())!=null) {
			response.append(inputLine);
		}
		br.close();
		System.out.println(response.toString());
		
	
		
	}

}
