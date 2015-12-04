package com.hp.fb.integration;
import java.util.Date;
import facebook4j.FacebookException;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;
//import com.restfb.Parameter;
//import com.restfb.types.Post;
public class Facebook1 extends DefaultFacebookClient
{
	public  AccessToken  getPageAccessToken(String accessToken)
	{
		FacebookClient facebookClient = new DefaultFacebookClient(accessToken);
		Facebook facebook = new FacebookFactory().getInstance();
		AccessToken accessToken1=facebookClient.obtainAppAccessToken("1539125776353973","00bceaf95e076501664e81aed9ab852f");//based on Page id,we can get AppId and App secrete
		//AccessToken accessToken1=((DefaultFacebookClient) facebook).obtainAppAccessToken("1539125776353973","00bceaf95e076501664e81aed9ab852f");//User login details
		//facebook.setOAuthAppId("1539125776353973", "00bceaf95e076501664e81aed9ab852f");
		//facebook.setOAuthPermissions(commaSeparetedPermissions);
		//facebook.getOAuthAccessToken(new AccessToken());
		String accessToken11 = accessToken1.getAccessToken();
		Date expires = accessToken1.getExpires();
		System.out.println("XXXXXXXXXX" + accessToken11 + expires );
		
		//AccessToken accessToken1=facebookClient.obtainAppAccessToken("387332658091233","29103f31ee3b525fc449b31d5f547eb2");//OAuth login details
		//System.out.println("\n accessToken1 -->"+accessToken1);
		
		
		System.out.println("Likes count: 1 " );
		System.out.println("Likes count (from Likes): ");
		System.out.println("Comments count: 234t" ); 
	    return accessToken1; // Here Get The page Access Token
		
			}

		}
