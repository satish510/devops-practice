package com.hp.fb.integration;
import java.util.List;
public class PostVO
    {
	private String userMailId;
	private String first_name;
	private String postURL;
	private String totalLikes;
	private String gender;
	private List<String> likeNames;
	private String fbGraph;
		PostVO(String fbGraph)
	{		
this.fbGraph=fbGraph;
	}	
	
public String getUserMailId() 
  {
		return userMailId;
	}
	public void setUserMailId(String userMailId) 
	{
		this.userMailId = userMailId;
	}
	public String getFirst_name() 
	{
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getPostURL() {
		return postURL;
	}
	public void setPostURL(String postURL) {
		this.postURL = postURL;
	}
	public String getTotalLikes() {
		return totalLikes;
	}
	public void setTotalLikes(String totalLikes) {
		this.totalLikes = totalLikes;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<String> getLikeNames() {
		return likeNames;
	}
	public void setLikeNames(List<String> likeNames) {
		this.likeNames = likeNames;
	}
	public String getFbGraph() {
		return fbGraph;
	}
	public void setFbGraph(String fbGraph) {
		this.fbGraph = fbGraph;
	}
	@Override
	public String toString() 
	{
		return first_name + " | " + userMailId +" | "+ postURL + " | "+ likeNames + " | "+ totalLikes;
	}

	public Object getInterests() {
		// TODO Auto-generated method stub
		return null;
	}
}

