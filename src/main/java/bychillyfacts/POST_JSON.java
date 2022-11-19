package bychillyfacts;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.io.IOUtils;

public class POST_JSON {

	public static void main(String[] args) throws Exception {
		String query_URL="https://jsonplaceholder.typicode.com/posts";
		String json="{\r\n"
				+ "  \"userId\": 1,\r\n"
				+ "  \"id\": 1,\r\n"
				+ "  \"title\": \"Test Title\",\r\n"
				+ "  \"body\": \"Test Body\"\r\n"
				+ "}";
		try {
			URL url=new URL(query_URL);
			HttpsURLConnection con=(HttpsURLConnection) url.openConnection();
			con.setConnectTimeout(5000);
			con.setRequestProperty("Content-Type", "application/json; charset=UTF=8");
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setRequestMethod("POST");
			
			OutputStream os=con.getOutputStream();
			os.write(json.getBytes("UTF-8"));
			os.close();
			
			//read the response
			InputStream in=new BufferedInputStream(con.getInputStream());
			String result=IOUtils.toString(in,"UTF-8");
			
			System.out.println(result);
			in.close();
			con.disconnect();			
		}
		catch(Exception e) {
			
			System.out.println(e);	
		}

	}

}
