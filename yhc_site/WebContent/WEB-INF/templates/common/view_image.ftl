<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="description" content="理财,科技">
<title>熊猫金融 :: 二维码</title>
<script src="/js/jquery-1.11.1.js"></script>
<script src="/js/jquery.rotate.js"></script>
<script type="text/javascript">
function rotate(angle){
	$("#img").rotate(angle);
	// AutoResizeImage(500,500,$("#img")[0])
}
</script>
<style type="text/css">
body{margin:0;padding:0}
.tx_change{display:inline-block;line-height:24px;height:24px;margin-right:10px;padding:0 15px;background-color:#fefefe;border:1px solid #a8adb6;font-family:'宋体',applegothic,sans-serif;font-size:12px;color:#666;text-decoration:none;z-index:1000}
.pst_lft{position:fixed;left:30px;top:20px}
</style>
</head>
<body>
<div class="pst_lft">
	<a href="javascript:void(0);" onClick="rotate(-90)" class="tx_change">左旋转</a>
	<a href="javascript:void(0);" onClick="rotate(90)" class="tx_change">右旋转</a>
</div>
<img id="img" src="/disp_verify_img_page.bl?fileId=${fileId!''}">
</body>
</html>