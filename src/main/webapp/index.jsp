<%@page import="com.hp.fb.integration.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	FBConnection fbConnection = new FBConnection();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Java Facebook Login</title>
</head>
<body style="text-align: center; margin: 0 auto;">
	<div
		style="margin: 0 auto; background-image: url(./img/fbloginbckgrnd.jpg); height: 360px; width: 610px;">
		<a href="<%=fbConnection.getFBAuthUrl()%>">     <!-- here redirect the FBConnection class -->
		<img
			style="margin-top: 138px;" src="./img/facebookloginbutton.png" />
		</a>
	</div>
	
	<div class="section-header">
<h3>Comments</h3>
</div>
<div id="commentItems" class="comment-items has-comments">
<a href="#" name="lastComment"></a>

<div class="like-and-count has-likes">
<p class="likers">
<a class="first liker" href="/groups/1559166527653468/type=1&comment_id=469650199850660&offset=0&total_comments=143">Sunitha</a> 
<span class='verbiage'>likes this</span>
</p>
<p class="commenters-count active">
<span class="count">149 comments</span>

<div class="like-count"></div>
<p class="like">
<a href="https://developers.facebook.com/tools/explorer/145634995501895/?method=GET&path=me/feed?fields=likes,shares">Total count</a>

	<li class="like-comment ">
<a href="/groupItem?setUnlike=&gid=2258445&type=member&item=5967319612965076992&commentID=5967935262796374016&ajax=true&csrfToken=ajax%3A6634283887615713985" class="unlike-comment" title="Unlike this comment">Unlike</a>

<a href="/groupItem?setLike=&gid=2258445&type=member&item=5967319612965076992&commentID=5967935262796374016&ajax=true&csrfToken=ajax%3A6634283887615713985" class="like-comment" title="Like this comment">Like (1)</a>

</li>
<!-- 	
	function fb_comment_count($url)
{
  $json = json_decode(file_get_contents('https://graph.facebook.com/?ids=' . $url));
  return isset($json->$url->comments) ? $json->$url->comments : 0;
} -->

</body>
</html>