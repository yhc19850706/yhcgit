<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
 <script type="text/javascript">
    wx.config(${wxJSConfig!''});
    wx.ready(function () {
        wx.checkJsApi({
            jsApiList: [
              'onMenuShareAppMessage',
              'onMenuShareTimeline'
            ],
            success: function (res) {
              //alert(JSON.stringify(res));
            }
          });
    	
    		    wx.onMenuShareAppMessage({
    		      title: '新窗帘已经到货，欢迎选购！',
    		      desc: '小蚂蚁窗帘是一家专门从事窗帘销售和安装的店面',
    		      link: '${shareUrl!''}',
    		      imgUrl: '${siteUrl!''}/images/banner.jpg',
    		      trigger: function (res) {
    		        //alert('用户点击发送给朋友');
    		      },
    		      success: function (res) {
    		       //alert('已分享');
    		      },
    		      cancel: function (res) {
    		        //alert('已取消');
    		      },
    		      fail: function (res) {
    		        //alert(JSON.stringify(res));
    		      }
    		    });


    		    wx.onMenuShareTimeline({
    		      title: '新窗帘已经到货，欢迎选购！',
    		      link: '${shareUrl!''}',
    		      imgUrl: '${siteUrl!''}/images/banner.jpg',
    		      trigger: function (res) {
    		        //alert('用户点击分享到朋友圈');
    		      },
    		      success: function (res) {
    		        //alert('已分享');
    		      },
    		      cancel: function (res) {
    		        //alert('已取消');
    		      },
    		      fail: function (res) {
    		        //alert(JSON.stringify(res));
    		      }
    		    });


    });
 </script>
</head>
<body>
		<!---->
		<div class="container">
			<div class="banner">
				<div class="banner-matter">
					<i class="line"> </i>
						<h1>where you choose the curtain</h1>
					<i class="line"> </i>
				</div>
		 <div class="banner-top">
			<div class="wmuSlider example1">
				   <div class="wmuSliderWrapper">
					   <article style="position: absolute; width: 100%; opacity: 0;">
							<div class="banner-bottom">
								<a href="single.html"><img class="img-responsive line-in" src="/images/banner.jpg" alt=""  /></a>
								<div class="dummy-text">
									<ul class="social-circle">			
										<li><a href="single.html"><i > </i></a></li>
										<li><a href="single.html"><i class="break"> </i></a></li>
									</ul>
									<div class="doe">
										<h6>the huntress</h6>
										<span>By <b>Jane Doe</b></span>
										<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed at auctor orci. Nullasc arcu lorem, consectetur eu tristique idnui hendrerit at massa. Vivamus velit ante, blandit eget suscipit ut, volutpat ac erasti augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere .</p>
									</div>
								</div>
								<div class="clearfix"> </div>
							</div>
					 	</article>
					 	 <article style="position: absolute; width: 100%; opacity: 0;">
							<div class="banner-bottom">
								<a href="single.html"><img class="img-responsive line-in" src="/images/banner1.jpg" alt=""  /></a>
								<div class="dummy-text">
									<ul class="social-circle">			
										<li><a href="single.html"><i > </i></a></li>
										<li><a href="single.html"><i class="break"> </i></a></li>
									</ul>
									<div class="doe">
										<h6>the huntress</h6>
										<span>By <b>Jane Doe</b></span>
										<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed at auctor orci. Nullasc arcu lorem, consectetur eu tristique idnui hendrerit at massa. Vivamus velit ante, blandit eget suscipit ut, volutpat ac erasti augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere .</p>
									</div>
								</div>
								<div class="clearfix"> </div>
							</div>
					 	</article>
					 	 <article style="position: absolute; width: 100%; opacity: 0;">
							<div class="banner-bottom">
								<a href="single.html"><img class="img-responsive line-in" src="/images/banner.jpg" alt=""  /></a>
								<div class="dummy-text">
									<ul class="social-circle">			
										<li><a href="single.html"><i > </i></a></li>
										<li><a href="single.html"><i class="break"> </i></a></li>
									</ul>
									<div class="doe">
										<h6>the huntress</h6>
										<span>By <b>Jane Doe</b></span>
										<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed at auctor orci. Nullasc arcu lorem, consectetur eu tristique idnui hendrerit at massa. Vivamus velit ante, blandit eget suscipit ut, volutpat ac erasti augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere .</p>
									</div>
								</div>
								<div class="clearfix"> </div>
							</div>
					 	</article>
					 </div>
	               
	            </div>
	            <script src="/js/jquery.wmuSlider.js"></script>
				<script>				
					 $('.example1').wmuSlider({
						 pagination:false,
					});         
				</script> 	
          	         
				</div>
			</div>
		</div>
		<!---->
			<div class="container">
			<div class="content">
				<div class="content-top">
					<h2>inSPIRED, inTELLIGENT, inCREDIBLE <span>(latest entries)</span></h2>
					<i class="line"> </i>
				</div>
				<p class="you">award the inspired brings together some of today's brightest artists, designers and photographers for your votes. Browse the profiles of the most recent contributors and cast your vote for the final 10 to reach our ceremony.</p>
				<div class="top-on">
				<div class="content-bottom">
					<div class="col-md-6 top-pic">
						<div class="col-md-6 bottom-pic">
						<a href="single.html"><img class="img-responsive " src="/images/pic.jpg" alt=""  /></a>
						</div>
						<div class="col-md-6 bottom-doe">
						<h6>Jane Doe</h6>
							<p>Donec tincidunt aliquam urna, in lobortis lorem eleifend eu. pellentesque id emet venenatis erat. Mauris nisl tellus, lorem rhoncus ut iaculis sit amet, imperdietium quis eros. Ut mattis, est sed mattis eras viverra, turpis nibh tempus tellus.</p>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="col-md-6 top-pic">
					<div class="col-md-6 bottom-pic">
						<a href="single.html"><img class="img-responsive " src="/images/pic1.jpg" alt=""  /></a>
						</div>
						<div class="col-md-6 bottom-doe">
						<h6>Anne Other</h6>
							<p>Donec tincidunt aliquam urna, in lobortis lorem eleifend eu. pellentesque id emet venenatis erat. Mauris nisl tellus, lorem rhoncus ut iaculis sit amet, imperdietium quis eros. Ut mattis, est sed mattis eras viverra, turpis nibh tempus tellus.</p>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="content-bottom">
					<div class="col-md-6 top-pic">
						<div class="col-md-6 bottom-pic">
						<a href="single.html"><img class="img-responsive " src="/images/pic2.jpg" alt=""  /></a>
						</div>
						<div class="col-md-6 bottom-doe">
						<h6>Joe Bloggs</h6>
							<p>Donec tincidunt aliquam urna, in lobortis lorem eleifend eu. pellentesque id emet venenatis erat. Mauris nisl tellus, lorem rhoncus ut iaculis sit amet, imperdietium quis eros. Ut mattis, est sed mattis eras viverra, turpis nibh tempus tellus.</p>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="col-md-6 top-pic">
					<div class="col-md-6 bottom-pic">
						<a href="single.html"><img class="img-responsive " src="/images/pic3.jpg" alt=""  /></a>
						</div>
						<div class="col-md-6 bottom-doe">
						<h6>John Somebody</h6>
							<p>Donec tincidunt aliquam urna, in lobortis lorem eleifend eu. pellentesque id emet venenatis erat. Mauris nisl tellus, lorem rhoncus ut iaculis sit amet, imperdietium quis eros. Ut mattis, est sed mattis eras viverra, turpis nibh tempus tellus.</p>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="content-bottom">
					<div class="col-md-6 top-pic">
						<div class="col-md-6 bottom-pic">
						<a href="single.html"><img class="img-responsive " src="/images/pic4.jpg" alt=""  /></a>
						</div>
						<div class="col-md-6 bottom-doe">
						<h6>Timothy Consecteur</h6>
							<p>Donec tincidunt aliquam urna, in lobortis lorem eleifend eu. pellentesque id emet venenatis erat. Mauris nisl tellus, lorem rhoncus ut iaculis sit amet, imperdietium quis eros. Ut mattis, est sed mattis eras viverra, turpis nibh tempus tellus.</p>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="col-md-6 top-pic">
					<div class="col-md-6 bottom-pic">
						<a href="single.html"><img class="img-responsive " src="/images/pic5.jpg" alt=""  /></a>
						</div>
						<div class="col-md-6 bottom-doe">
						<h6>Laura Ipsum</h6>
							<p>Donec tincidunt aliquam urna, in lobortis lorem eleifend eu. pellentesque id emet venenatis erat. Mauris nisl tellus, lorem rhoncus ut iaculis sit amet, imperdietium quis eros. Ut mattis, est sed mattis eras viverra, turpis nibh tempus tellus.</p>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="content-bottom">
					<div class="col-md-6 top-pic">
						<div class="col-md-6 bottom-pic">
						<a href="single.html"><img class="img-responsive " src="/images/pic6.jpg" alt=""  /></a>
						</div>
						<div class="col-md-6 bottom-doe">
						<h6>Pierre Lorem</h6>
							<p>Donec tincidunt aliquam urna, in lobortis lorem eleifend eu. pellentesque id emet venenatis erat. Mauris nisl tellus, lorem rhoncus ut iaculis sit amet, imperdietium quis eros. Ut mattis, est sed mattis eras viverra, turpis nibh tempus tellus.</p>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="col-md-6 top-pic">
					<div class="col-md-6 bottom-pic">
						<a href="single.html"><img class="img-responsive " src="/images/pic7.jpg" alt=""  /></a>
						</div>
						<div class="col-md-6 bottom-doe">
						<h6>Wan More</h6>
							<p>Donec tincidunt aliquam urna, in lobortis lorem eleifend eu. pellentesque id emet venenatis erat. Mauris nisl tellus, lorem rhoncus ut iaculis sit amet, imperdietium quis eros. Ut mattis, est sed mattis eras viverra, turpis nibh tempus tellus.</p>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="clearfix"> </div>
				</div>
				</div>
				<i class="line"> </i>
				<!---->
				<div class="bottom-content">
					<div class="col-md-6 award">
						<h3>awi awards ceremony</h3>						
						<p>The ‘Award The Inspired’ awards ceremony. The Fuji Film Gallery, Holland. </p>
						<div class="inverted">
							<p class="date">4th October to 12 October 2012 10am to 4pm.</p>                       
							<a href="single.html" class="only">Invitation Only</a>
							<div class="clearfix"> </div>
						</div>
						<a href="single.html"><img class="img-responsive " src="/images/po.jpg" alt=""  />
						<div class="share">
							<p>Share <i class="down"> </i></p>
							<ul class="social-in tin-in">
								<li><i> </i></li>						
								<li><i class="tin"> </i></li>
								<li><i class="message"> </i></li>
							</ul>
							</a>
							<div class="clearfix"> </div>
						</div>
					</div>
					<div class="col-md-6 award-bottom">
						<h3>Have You Been Invited?</h3>
						<p>If you have an awards ceremony invitation code, please enter it along with your e-mail address in the form below.</p>
						<form >					    	
						   <input type="text" value="Your E-mail..">
						   <input type="text" value="Invitation Code..">
						   <input type="submit" value="Submit RSVP">	
						   </form>
						   <p><a href="single.html">Don’t have an invitation?</a></p>
						   <a href="index.html" class="logo-bottom"><img src="/images/logo-1.png" alt="" ></a>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>
		</div>
		<!---->
</body>
</html>