<!doctype html>
<html>
<head>
<script type="text/javascript" >
	<#if altMsg?exists>
		alert('${altMsg}');
		<#if redirectUrl?exists>
			location.href = '${redirectUrl}';
		<#elseif targetBlank?exists>
			window.close();
		<#else>
			history.back();
		</#if>
	</#if>
</script>
</head>
<body>
</body>
</html>