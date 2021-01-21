package Get;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetExample {
	public void getmethod() throws IOException {
		URL url=new URL("http://dummy.restapiexample.com/api/v1/employee/1");
		HttpURLConnection connection=(HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		System.out.println("status code :"+connection.getResponseCode());
		String statusmess=connection.getResponseMessage();
		System.out.println("status message"+statusmess);

		InputStream inputstream=connection.getInputStream();
		InputStreamReader inputstreamreader=new InputStreamReader(inputstream);
		BufferedReader buffer=new BufferedReader(inputstreamreader);
		String line;
		StringBuffer bufferi=new StringBuffer();
		while((line=buffer.readLine())!=null){

			bufferi.append(line);
		}
		System.out.println(bufferi);

	}
	public void postmethod() throws IOException {
		URL url=new URL("http://dummy.restapiexample.com/api/v1/create");
		HttpURLConnection connection=(HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setDoOutput(true);	
		String Jsonbody="{\\\"name\\\":\\\"test\\\",\\\"salary\\\":\\\"123\\\",\\\"age\\\":\\\"23\\\"}";
		byte[]inputjson=Jsonbody.getBytes();
		OutputStream outputstream=connection.getOutputStream();
		outputstream.write(inputjson);
		System.out.println(connection.getResponseCode());
		System.out.println(connection.getResponseMessage());
		InputStream inputstream=connection.getInputStream();
		InputStreamReader input= new InputStreamReader(inputstream);
		BufferedReader buffer=new BufferedReader(input);
		String line;
		StringBuffer bufferinput=new StringBuffer();
		while((line=buffer.readLine())!=null) {
			bufferinput.append(line);
		}
		System.out.println(bufferinput);
	}
	public void deletemethod() throws IOException {
		URL url=new URL("http://dummy.restapiexample.com/api/v1/delete/6363");
		HttpURLConnection connection=(HttpURLConnection) url.openConnection();
		connection.setRequestMethod("DELETE");
		System.out.println(connection.getResponseCode());
		System.out.println(connection.getResponseMessage());
		InputStream inputstream=connection.getInputStream();
		InputStreamReader input= new InputStreamReader(inputstream);
		BufferedReader buffer=new BufferedReader(input);
		String line;
		StringBuffer bufferinput=new StringBuffer();
		while((line=buffer.readLine())!=null) {
			bufferinput.append(line);
		}
		System.out.println(bufferinput);
		
	}
			

	public static void main(String[] args) throws IOException {
		GetExample example=new GetExample();
		example.getmethod();
		//example.postmethod();
		//example.deletemethod();
	}

}
