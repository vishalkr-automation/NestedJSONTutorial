package bychillyfacts;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.codehaus.jackson.map.ObjectMapper;

public class JSON_TO_JAVA {

	public static void main(String[] args) {
		try {
		JSON_TO_JAVA.convertJsonToJava();
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public static void convertJsonToJava() throws Exception {
		String ip="117.245.94.65";
		String key="4E191A613023EA66D24E35E41C870D3B";
		
		String url="https://api.ip2location.io/?key="+key+"&ip="+ip+"&format=json";
		URL obj=new URL(url);
		HttpsURLConnection con=(HttpsURLConnection) obj.openConnection();
		
		//optional default is GET
		con.setRequestMethod("GET");
		//add request header
		//con.setRequestProperty("user-Agent", "Mozilla/5.0");
		
		//int responseCode=con.getResponseCode();
		//System.out.println("Sending get request to URL: "+ url);
		//System.out.println("Response code: "+ responseCode);
		BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response=new StringBuffer();
		while((inputLine=br.readLine())!=null) {
			response.append(inputLine);
		}
		br.close();
		System.out.println(response.toString());
		
		ObjectMapper objectMapper=new ObjectMapper();
		Country_Bean objCountryBean=new Country_Bean();
		
		objCountryBean=objectMapper.readValue(response.toString(), objCountryBean.getClass());
		
		System.out.println(objCountryBean.getIp());
		System.out.println(objCountryBean.getCountry_code());
		System.out.println(objCountryBean.getCity_name());
		System.out.println(objCountryBean.getRegion_name());
		System.out.println(objCountryBean.getCity_name());	
		System.out.println(objCountryBean.getLatitude());
		System.out.println(objCountryBean.getLongitude());
		System.out.println(objCountryBean.getZip_code());
		System.out.println(objCountryBean.getTime_zone());
		System.out.println(objCountryBean.getAsn());
		System.out.println(objCountryBean.getAs());
		System.out.println(objCountryBean.getIs_proxy());
		
	}

}
