package com.hp.fb.integration;
import java.util.ArrayList;
import java.util.List;

//import com.face4j.facebook.Facebook;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
//import com.restfb.FacebookClient.AccessToken;
import com.restfb.json.JsonObject;
//import com.restfb.types.Comment;
import com.restfb.types.Page;
//import com.restfb.types.Post;
import com.restfb.types.FacebookType.Metadata;
//import com.restfb.types.*;

import facebook4j.FacebookFactory;
import facebook4j.PagableList;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.FacebookException;
import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
//import facebook4j.FacebookFactory;
import facebook4j.PagableList;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;

public class Post1
{

	FacebookClient client1=new DefaultFacebookClient();
	DefaultFacebookClient client2 = new DefaultFacebookClient();
	 
	//Post post = ((FacebookClient) client1).fetchObject("1539125776353973", Post.class, Parameter.with("fields", "from,to,likes.summary(true),comments.summary(true)"));
	
		/*public int getLikes(int likesCount)
		{
			// TODO Auto-generated method stub	
	    Post post = ((FacebookClient) client1).fetchObject("804373672976973_804777062936634", Post.class, Parameter.with("fields", "from,to,likes.summary(true),comments.summary(true)"));   
	    System.out.println("Likes count: " + post.getLikesCount());//100005397976161_324845577705372"
		System.out.println("Likes count (from Likes): " + post.getLikes().getCount());
		System.out.println("Comments count: " + post.getComments().getCount());
		return likesCount;
	}	
		Connection<Post> myPost = client1.fetchConnection("100005397976161_324845577705372", Post.class,Parameter.with("fields", "from,to,likes.summary(true),comments.summary(true)"));
	      for (List<Post> myPostConnectionPage : myPost)
		  for (Post post1 : myPostConnectionPage)
		  System. out.println("Post: " + post1);
	      System.out.println("First item in my feed: " + myPost.getData().get(0));// receive message not other  information
*/		
		@SuppressWarnings("unchecked")
		public <FBComment> ArrayList<FBComment> getCommentFromPost(FacebookClient client, String post_id,String accessToken) 
		{
			FacebookClient facebookClient = new DefaultFacebookClient(accessToken);
			com.restfb.FacebookClient.AccessToken accessToken1=facebookClient.obtainAppAccessToken("1539125776353973","00bceaf95e076501664e81aed9ab852f");
			ArrayList<FBComment> comments = new ArrayList<FBComment>();
		    ArrayList<FBComment> comments1 = new ArrayList<FBComment>();
		   System.out.println("Comments---->"+comments);
		    //String accessToken31[]=accessToken3.split("&");
		    //String a=accessToken31[0];
		    //String b=a.replace("access_token=","");
		   // System.out.println("Commentsss---->"+comments + a );
		    //System.out.println("Commentsss11---->"+comments + b );
		   /*Facebook facebook = new FacebookFactory().getInstance();
		    // Use default values for oauth app id.
		    facebook.setOAuthAppId("864605343587486", "8d28de00b1c0e283036cb751fae99417");
		    // Get an access token from: 
		    // https://developers.facebook.com/tools/explorer
		    // Copy and paste it below.
		    String accessTokenString = "864605343587486|SL11XmDcVytyX5IJWTC3ANQ-A6c";
		    AccessToken at = new AccessToken(accessTokenString);
		    // Set access token.
		    facebook.setOAuthAccessToken(at);
		    System.out.println("Commentsssaa---->"+at);*/
		   
		    FBConnection fbConnection = new FBConnection();
		    //String accessToken = fbConnection.getAccessToken(code);
		    
		    //FacebookClient client1=new DefaultFacebookClient();
		    //Connection<Post> post = facebookClient.fetchConnection(post_id, Post.class);
		    
		    System.out.println("Commentsssxxxxxxxxx---->"+comments );
		    Connection<Comment> allComments = facebookClient.fetchConnection(post_id+"/comments", Comment.class);
		    System.out.println("Commentsss---->"+comments );
		    JsonObject jsonObject = client.fetchObject(post_id + "/comments",JsonObject.class, Parameter.with("summary", true),Parameter.with("limit", 10));
			@SuppressWarnings("unused")
			long commentsTotalCount = jsonObject.getJsonObject("summary").getLong("total_count");
			System.out.print("\nComments: ");
		    System.out.println("All Comments----->"+allComments);
		    JsonObject jsonObject1 = client.fetchObject(post_id + "/comments",JsonObject.class, Parameter.with("summary", true),Parameter.with("limit", 10));
			System.out.println("JsonObject---->"+jsonObject);
			long commentsTotalCount1 = jsonObject1.getJsonObject("summary").getLong("total_count");
			//JsonObject jsonObject2 = client.fetchObject(post_id + "/comments",JsonObject.class, Parameter.with("summary", true),Parameter.with("limit", 10));
			//long commentsTotalCount2 = jsonObject1.getJsonObject("summary").getLong("user_likes");
			//System.out.println("\nCommentsTotalCount2: "+commentsTotalCount2);
			System.out.println("\nCommentsTotalCount: "+commentsTotalCount1);
		    for(List<Comment> postcomments : allComments)
		    {
		        for (Comment comment : postcomments)
		        {
		        @SuppressWarnings("deprecation")
				long likes     = comment.getLikeCount()==0?(((Page) comment).getLikes()==null?0:((Page) comment).getLikes()):comment.getLikeCount();
				//long likes     = comment.getLikeCount()==null?(comment.getLikes()==null?0:comment.getLikes()):comment.getLikeCount();
		      comments.add((FBComment) (comment.getMessage()+" - "+likes));
		      String name = comment.getFrom().getName();
		      //String name1 = comment.getLikes();
		      comments1.add((FBComment) (comment.getFrom().getName()));
		      //String name1 = comment.getLikes();
		      System.out.println("aaaaa"+ name + comments1);
		     
		      
		        System.out.println("\n Getting a likes count and comment from that particular page-->"+comments + likes);
		        }
		    }
		    return comments;
		}
		

}

