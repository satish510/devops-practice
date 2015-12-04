package com.hp.fb.integration;
import java.io.IOException;
import facebook4j.FacebookException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

//import javax.ws.rs.*;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





//import com.face4j.facebook.Facebook;
//import com.face4j.facebook.Facebook;
//import com.face4j.facebook.fql.FqlUser;
//import com.face4j.facebook.util.FacebookUtil;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.json.JsonObject;
import com.restfb.types.Post;

import facebook4j.conf.Configuration;
import facebook4j.internal.org.json.JSONArray;
import facebook4j.internal.org.json.JSONObject;
//import com.face4j.facebook.fql.FqlUser;
@WebService

public class MainMenu extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;
	//private static final int likesCount = 0;
	//private static final String accessToken2 = null;
	private String code=" ";
	private	String  accessToken1=" ";
	
	FacebookClient client1=new DefaultFacebookClient();
		@WebMethod
		 
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException 
			{		
		          code = req.getParameter("code");  
		if (code == null || code.equals(""))
		{
			throw new RuntimeException("ERROR: Didn't get code parameter in callback.");
		}
		//res.setContentType("application/json");

		System.getProperties().put("http.proxyHost", "proxy.sgp.hp.com");
		System.getProperties().put("http.proxyPort", "8080");
		
		System.out.println("inside try111111"+code);
		String post_id="804373672976973_804777062936634";
		FBConnection fbConnection = new FBConnection();
		String accessToken = fbConnection.getAccessToken(code);
		System.out.println("accessToken"+accessToken);
		FBGraph fbGraph = new FBGraph(accessToken);// get the user accessToken
		String graph = fbGraph.getFBGraph();
		//String graph = fbGraph.getUserInfo(accessToken);
		System.out.println("accessTokensss"+graph);
		Map<String, String> fbProfileData = fbGraph.getGraphData(graph);
		ServletOutputStream out = res.getOutputStream();
		out.println("<h1>Facebook Login using Java</h1>");
		out.println("<h2>Application Main Menu</h2>");
		out.println("<div>Id:"+fbProfileData.get("id"));
		out.println("<div>First Name:"+fbProfileData.get("first_name"));
		out.println("<div>Your Email: "+fbProfileData.get("email"));
		out.println("<div>Gender:"+fbProfileData.get("gender"));	
		out.println("<div> Last Name:"+fbProfileData.get("last_name"));
	    out.println("<div>Locale:"+fbProfileData.get("locale"));
	    out.println("<div>Name:"+fbProfileData.get("name"));
	    
	    /*Post post1 = client1.fetchObject("804373672976973_810242229056784", Post.class, Parameter.with("fields", "from,to,likes.summary(true),comments.summary(true)")); 


		System.out.println("Number of likes count on this comment: " + post1.getLikesCount());
		System.out.println("Likes count (from Likes): " + post1.getLikes().getCount());
		System.out.println("Comments count: " + post1.getComments().getCount());
		System.out.println("User who posted the comment:"+post1.getFrom());*/
		//System.out.println("client1-->"+client1);
	   
		Facebook1 Client=new Facebook1(); 
   		AccessToken pageToken=Client.getPageAccessToken(accessToken1);
   		System.out.println("\n pageToken--->"+pageToken);
   		
   		String pageTokenModified = pageToken.toString();
   		System.out.println("\n pageTokenModified -- >"+pageTokenModified);
   		
   		String pageAccessToken=pageTokenModified.substring(24, 68) ;
   		System.out.println("\n Getting the pageAccessToken From FaceBook Page------>"+pageAccessToken);
   		
   		FBAccessToken ac = new FBAccessToken();
   		//String acc=ac.callURL("https://graph.facebook.com/oauth/access_token?client_id=864605343587486&client_secret=8d28de00b1c0e283036cb751fae99417&grant_type=client_credentials");
   		String acc="https://graph.facebook.com/v2.2/oauth/access_token?grant_type=fb_exchange_token&client_id=864605343587486&client_secret=8d28de00b1c0e283036cb751fae99417&fb_exchange_token="+code;
   		System.out.println(" XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" +acc);
   		
   		AccessToken accessToken4 =
   			  new DefaultFacebookClient().obtainAppAccessToken("864605343587486",
   			    "8d28de00b1c0e283036cb751fae99417");
   		System.out.println(" XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX444" +accessToken4);
   		
   		
   		
   		//String tst="https://graph.facebook.com/oauth/access_token?client_id=864605343587486&client_secret=8d28de00b1c0e283036cb751fae99417&grant_type=client_credentials";
   		
   		//System.out.println("xccccccccc" + tst);
   		//AccessToken accessToken3=client1.obtainExtendedAccessToken("864605343587486","8d28de00b1c0e283036cb751fae99417",pageTokenModified);
   		//System.out.println("accessToken2------>"+accessToken3);
   		//Page1 page=new Page1();
	    //String accessToken2 = page.getConnection(pageAccessToken);
        //System.out.println("accessToken2------>"+accessToken2);
        
        /*ConvertJsonToJava convertjsonToJava=new ConvertJsonToJava();
        convertjsonToJava.JsonToJava();*/
   		//String query = "SELECT like_info.like_count, comment_info.comment_count, share_count FROM stream WHERE post_id = 804777062936634";
        //List<FqlUser> users = client1.executeFqlQuery(query, FqlUser.class,);
        //String query = "SELECT uid, name FROM user WHERE uid=220439 or uid=7901103";
        //List<FqlUser> users1 = client1.executeQuery(query1, FqlUser.class);
        //List<JsonObject> queryResults =  client1.executeQuery(query, JsonObject.class);
       //out.println(queryResults.get(0).getString("share_count"));
       // System.out.println(queryResults.get(1));
        //System.out.println(jsonObject.get("uid2"));
        //String query = "SELECT uid2 FROM friend WHERE uid1=me()";
        //JSONArray jsonArray = client1.executeFqlQuery(query);
       // for (int i = 0; i < jsonArray.length(); i++) {
            //JSONObject jsonObject = jsonArray.getJSONObject(i);
            //System.out.println(jsonObject.get("uid2"));
        //}




        //out.println("Users: " + users1);


        //out.println("Users: " + users);
        //Post1 post=new Post1(); 
		//int likescount= post.getLikes(likesCount);

        
        //String post_id="730714793682130_763286747091601";
		//ArrayList<?> likescount1= post.getCommentFromPost(client1,post_id,accessToken);
		
		//out.println("\n Likes Count--->"+likescount1);

		/*out.println("Likes count: " + post.getLikesCount());
    	out.println("Likes count (from Likes): " + post.getLikes().getCount());
	    out.println("Comments count: " + post.getComments().getCount());*/
		}
}
