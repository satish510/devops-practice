package com.hp.fb.integration;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
//import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
//import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
//import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class FBGraph 
{
	private String accessToken;
	public FBGraph(String accessToken)//Parameterized constructor 
	{
		this.accessToken = accessToken;
	}
	public String getFBGraph()
	{
		String graph = null;
		try {
			String g = "https://graph.facebook.com/me?" + accessToken;
			URL u = new URL(g);
			System.out.println("AAAAAAA1111222Deepak" + accessToken);
			System.out.println("AAAAAAA1111222Deepakxxxxxxxxxxmmm" + g);
			//If you are no want append appsecret_proof parameter then you can change set to no use appsecret_proof paameter on your app management site. The management site menu is setting>advanced>Require AppSecret Proof for Server API calls -> set to disabled.
			URLConnection c = u.openConnection();//open the connection
			BufferedReader in = new BufferedReader(new java.io.InputStreamReader(c.getInputStream()));
			String inputLine;
			StringBuffer b = new StringBuffer();
			System.out.println("AAAAAAA1111222Deepakxxxxxxxxxxhhh" + b);
			while ((inputLine = in.readLine()) != null)
				b.append(inputLine + "\n");
			System.out.println("AAAAAAA1111222Deepakxxxxxxxxxx" + inputLine);
			in.close();
			graph = b.toString();
			System.out.println("Deepakkkkkkkkkkk"+graph);
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("ERROR in getting FB graph data. " + e);
		}
		return graph;
	}
	
	public String getUserInfo(String access_token) throws MalformedURLException, ProtocolException, IOException {
	    try {
	        String connection = connectionGet("https://graph.facebook.com/me?access_token=" + access_token, "");
	        return connection;
	    } catch (Exception e) {
	        return null;
	    }
	}


	public String connectionGet(String url, String parameter) throws MalformedURLException, ProtocolException, IOException {

	    URL url1 = new URL(url);
	    HttpURLConnection request1 = (HttpURLConnection) url1.openConnection();
	    request1.setRequestMethod("GET");
	    request1.connect();
	    String responseBody = convertStreamToString(request1.getInputStream());
	    return responseBody;
	}

	  private String convertStreamToString(InputStream is) {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	    StringBuilder sb = new StringBuilder();
	    String line = null;
	    try {
	        while ((line = reader.readLine()) != null) {
	            sb.append(line).append("\n");
	        }
	    } catch (IOException e) {
	    } finally {
	        try {
	            is.close();
	        } catch (IOException e) {
	        }
	    }

	    return sb.toString();
	}
	public Map<String, String> getGraphData(String fbGraph)
	{
		Map<String, String> fbProfile = new HashMap<String, String>();
		try
		{
		JSONObject json = new JSONObject(fbGraph);
			fbProfile.put("id", json.getString("id"));
			
			fbProfile.put("first_name", json.getString("first_name"));
					if (json.has("email"))
				fbProfile.put("email", json.getString("email"));
			if (json.has("gender"))
				fbProfile.put("gender", json.getString("gender"));
			fbProfile.put("last_name", json.getString("last_name"));
			fbProfile.put("locale", json.getString("locale"));
			fbProfile.put("name", json.getString("name"));
		}
		catch (JSONException e)
		{
			e.printStackTrace();
			throw new RuntimeException("ERROR in parsing FB graph data. " + e);
		}
		return fbProfile;
	}
}
