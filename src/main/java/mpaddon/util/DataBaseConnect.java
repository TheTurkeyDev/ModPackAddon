package mpaddon.util;

import mpaddon.MPASettings;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

@SuppressWarnings("deprecation")
public class DataBaseConnect
{
	
	@SuppressWarnings("resource")
	public static void sendMessage(String json)
	{
		if(MPASettings.statopout)
			return;
		
		HttpClient httpClient = new DefaultHttpClient();

	    try {
	        HttpPost request = new HttpPost("http://theprogrammingturkey.com/API/CrashLanding2.php");
	        StringEntity params =new StringEntity("message=" + json);
	        request.addHeader("content-type", "application/x-www-form-urlencoded");
	        request.setEntity(params);
	        HttpResponse response = httpClient.execute(request);
	        org.apache.http.util.EntityUtils.consume(response.getEntity());
	    } catch (Exception ex) {
	        // handle exception here
	    } finally {
	        httpClient.getConnectionManager().shutdown();
	    }
	}
}
