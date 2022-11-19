package sendHTTPRequest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class SendHTTPRequest {

	public static void main(String[] args) {
		try {
		SendHTTPRequest.convertJsonToJava();
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public static void convertJsonToJava() throws Exception {		
		String url="https://api.coinpaprika.com/v1/coins/btc-bitcoin";
		
		URL obj=new URL(url);
		HttpURLConnection con=(HttpURLConnection) obj.openConnection();
		
		//optional default is GET
		con.setRequestMethod("GET");
		
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
		//System.out.println(response.toString());
		
		//Parent 
	    JSONObject jsonObject=new JSONObject(response.toString());       //Parent Object
	    System.out.println("Total JSON Object: "+ jsonObject.length());  //will count total number of Objects available in that object
	    //System.out.println("Total JSON Array: "+ jsonObject);
	    //System.out.println(jsonObject);
	    
		//System.out.println(jsonObject.get("id"));
		//System.out.println(jsonObject.get("name"));
	    
	    //Extracted from Parent
		JSONArray jsonArray1=jsonObject.getJSONArray("team");     //will get JSON Array from parent JSON Object based on name
		System.out.println(jsonArray1.length());                  
		//System.out.println(jsonArray1);
		
		//Extracted from child "team"
		 JSONObject jsonObject1=jsonArray1.getJSONObject(0);      //will get JSON object of team JSON Array based on index number
		 System.out.println(jsonObject1);
		 
		 //Extracted from Parent 
		 JSONObject jsonObject2=jsonObject.getJSONObject("links");      //will get specific JSON object from parent JSON Object
		 System.out.println(jsonObject2.length());
		 //System.out.println(jsonObject2.get("explorer"));
		 
		 JSONArray jsonArray2=jsonObject2.getJSONArray("explorer"); 
		 System.out.println(jsonArray2.length());
		 System.out.println(jsonArray2.getString(0));                 //It will fetch 0th index data 
	}

}
