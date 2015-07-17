<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
			form {
				margin: 0;
			}
			textarea {
				display: block;
			}
		</style>
<script type="text/javascript"  src="/js/kindeditor/kindeditor-min.js"></script>
<script type="text/javascript"  src="/js/kindeditor/zh_CN.js"></script>

<script type="text/javascript" src="/js/jquery-1.10.2.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="/js/plupload-2.1.1/plupload.full.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="/js/plupload-2.1.1/jquery.plupload.queue/jquery.plupload.queue.min.js" charset="UTF-8"></script>
<link type="text/css" rel="stylesheet" href="/js/plupload-2.1.1/jquery.plupload.queue/css/jquery.plupload.queue.css" media="screen" />


</head>
<body>
<@lib.test />
<p>--------------------------------     [${total!''}]         [${total1!''}]입니다       ---------------------------------</p>

<div >

       <script>
			var editor;
			KindEditor.ready(function(K) {
				editor = K.create('textarea[name="content"]', {
					resizeType : 1,
					allowPreviewEmoticons : false,
					allowImageUpload : false,
					items : [
						'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
						'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
						'insertunorderedlist', '|', 'emoticons', 'image', 'link']
				});
			});
		</script>

    
	 <form id="input_form" method="post" action="/list.md" method="post">
	 	<input type="hidden" name="isOpen" value="1" />
	 	<textarea name="content" style="width:700px;height:200px;visibility:hidden;">KindEditor</textarea>
	 	<div class="action">
			<input type="submit" />
		</div>
	 </form>
	 
	 
	<!--
	<form id="file_form" method="post" action="/fileUpload.md" enctype="multipart/form-data">
		<ol>
			<li>
				<input type="file" name="attach1" />
			</li><!--
			<li>
				<input type="file" name="attach2" />
			</li>
		</ol>
		
		<div class="action">
			<input type="submit" />
		</div>
	</form>
	-->
	
	<div id="uploader">
	    <p>Your browser doesn't have Flash, Silverlight or HTML5 support.</p>
	</div>
	
	<script type="text/javascript">
		// Initialize the widget when the DOM is ready
		$(function() {
		    // Setup html5 version
		    $("#uploader").pluploadQueue({
		        // General settings
		        runtimes : 'html5,flash,silverlight,html4',
		        url : "/fileUpload.md",
		         
		        chunk_size : '1mb',
		        rename : true,
		        dragdrop: true,
            	mutlipart: true,
	            unique_names : true,
	            file_data_name:"upload",
		         
		        filters : {
		            // Maximum file size
		            max_file_size : '10mb',
		            // Specify what files to browse for
		            mime_types: [
		                {title : "Image files", extensions : "jpg,gif,png,pdf"}
		            ]
		        },
		 
		        // Resize images on clientside if we can
		        resize: {
		            width : 200,
		            height : 200,
		            quality : 90,
		            crop: true // crop to exact dimensions
		        },
		 
		 
		        // Flash settings
		        flash_swf_url : '/js/plupload-2.1.1/Moxie.swf',
		     
		        // Silverlight settings
		        silverlight_xap_url : '/js/plupload-2.1.1/Moxie.xap',
		        
	            preinit: {
	                FilesAdded: function(up, files){
	                    if (up.files.length >= 5) {
	                        alert("最多只能上传5个文件");
	                        for (var i = 0; i < files.length; i++) {
	                            up.removeFile(files[i]);
	                        }
	                        return false;
	                    }
	
	                    if (files.length > 5) {
	                        alert("最多只能上传5个文件");
	                        return false;
	                    }
	
	                }
	            },
	            init: {
	            	FileUploaded: function(up,files){
	                	console.log(files.name);
	                    alert("FileUploaded");
	                },
	                UploadComplete: function(up,files){
	                    alert("complete");
	                },
	                Error: function(up,files){
	                //	console.log(files);
		                for(var i in files){
		                	if(files[i].name){
	                			console.log("<<<  error   ["+files[i].name+"]     >>>");
		                	}
	                	}
	                    alert("error");
	                }
	            }
		    });
		});
	</script>
</div>
</body>
</html>