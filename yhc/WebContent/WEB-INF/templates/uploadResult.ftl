<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<div class="content">
	<table>
		<tr>
			<th>업로드 태그명</th>
			<th>파일이름</th>
			<th>업로드명</th>
			<th>파일유형</th>
			<th>파일 크기</th>
			<th>저장된 파일명</th>
		</tr>
		<#list fileList as fileItem>
		<tr>
			<td>${fileItem.multipartFile.name}</td>
			<td>${fileItem.originalFilename}</td>
			<td>${fileItem.uploadedFilename}</td>
			<td>${fileItem.multipartFile.contentType}</td>
			<td>${fileItem.multipartFile.size}</td>
			<td>${fileItem.savedFilename}</td>
		</tr>
		</#list>
	</table>
</div>
</body>
</html>