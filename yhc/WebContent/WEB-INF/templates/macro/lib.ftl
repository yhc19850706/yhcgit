<#setting number_format="###############">
<#setting url_escaping_charset="UTF-8">
<#macro snb idx>
	<div class="snb" style="left:-152px;">
		<a href="#" class="sld_btn"></a>
		<ul class="snb_ul"><#if (parentMenuList?? && parentMenuList?size > 0)><#if (xmphMenuList?? && xmphMenuList?size > 0)><#list parentMenuList as parentMenu>
		<li name="pr_snb" <#if (idx?? && idx?length > 0)><#assign tab=idx?substring(0, idx?index_of('_'))> class="<#if tab==parentMenu.tag>on</#if>"</#if>>
			<a href="#">${parentMenu.name!''} <span class="open"></span></a>
			<ul><#list xmphMenuList as xmphMenu>
			<#if xmphMenu.parentMenuNm = parentMenu.name>
			<li class="<#if idx==xmphMenu.menuTagNm>on</#if>"><a href="${xmphMenu.menuUri}">${xmphMenu.menuNm!''}</a></li></#if></#list>
			</ul>
		</li></#list></#if></#if>
		</ul>
	</div>
	<script type="text/javascript">
		$(function(){
			$('li[name="pr_snb"]').click(function(e){
                var tar = e.currentTarget;
                if ($(tar).attr("class") == 'on') {
                	$(tar).removeClass("on");
                } else {
                	var prSnb = $('li[name="pr_snb"]');
					prSnb.removeClass("on");
                	$(tar).addClass("on");
                }
            }); /*
           
			$(".snb").hover(function(){
					$(".sld_btn").toggleClass("sld_btn2");
					$(this).stop().animate({left:"0px"},800);
				},function(){
					$(".sld_btn").toggleClass("sld_btn2");
					$(this).stop().animate({left:"-152px"});
				}
			);  */
			
			$(".sld_btn").click(function(){
				if($(".sld_btn").hasClass("sld_btn2")){
					$(".sld_btn").toggleClass("sld_btn2");
					$(".snb").stop().animate({left:"-152px"});
				} else {
					$(".sld_btn").toggleClass("sld_btn2");
					$(".snb").stop().animate({left:"0px"},800);
				}
			});
		});
	</script>
</#macro>
<#macro num_paging page form>
	<#if (page.totalPageNumber>=1)>
		<script type="text/javascript">
			function go_page(pn){
	        	$("#pageNo").val(pn);
	        	$('#${form}').submit();
	        }
		</script>
		<input type="hidden" name="pageNo" id="pageNo">
		<#if (page.pageNo>1)><a href="javascript:void(0)" onClick="go_page(${page.pageNo-1})" class="pg_num">&lt;</a></#if><#if (page.startPageNo == 2)><a href="javascript:void(0)" onClick="go_page(1)" class="pg_num">1</a><#elseif (page.startPageNo>2)><a href="javascript:void(0)" onClick="go_page(1)" class="pg_num">1</a><a href="javascript:void(0)" onClick="go_page(2)" class="pg_num">2</a><#if (page.startPageNo==4)><a href="javascript:void(0)" onClick="go_page(3)" class="pg_num">3</a><#elseif (page.startPageNo>4)><strong class="pg_num pg_bu">...</strong></#if></#if><#list page.pageNoList as pn><#if page.pageNo==pn><strong class="pg_num pg_num_on">${pn}</strong><#else><a href="javascript:void(0)" onClick="go_page(${pn})" class="pg_num">${pn}</a></#if></#list><#if (page.totalPageNumber-page.lastPageNo>=2)><#if (page.totalPageNumber-page.lastPageNo==3)><a href="javascript:void(0)" onClick="go_page(${page.totalPageNumber-2})" class="pg_num">${page.totalPageNumber-2}</a><#elseif (page.totalPageNumber-page.lastPageNo>3)><strong class="pg_num pg_bu">...</strong></#if><a href="javascript:void(0)" onClick="go_page(${page.totalPageNumber-1})" class="pg_num">${page.totalPageNumber-1}</a><a href="javascript:void(0)" onClick="go_page(${page.totalPageNumber})" class="pg_num">${page.totalPageNumber}</a></#if><#if page.lastPageNo!=page.pageNo><a href="javascript:void(0)" onClick="go_page(${page.pageNo+1})" class="pg_num">&gt;</a></#if>
	</#if>
</#macro>
<#macro number_paging page url tar_obj>
			<script type="text/javascript">
		        function go_page_ajax(pn){
		        	$("#pageNo").val(pn);
		        	var tarForm = $("#pgForm");
		        	$.ajax({
				         type: "post",
				         url: tarForm.attr("action"),
				         data: tarForm.serialize(),
				         success: function(data){
							$("#${tar_obj}").html(data);
				         }  
				    }); 
		        }
			</script>
			<form name="pgForm" id="pgForm" action="${url}" method="post">
			   <input type="hidden" name="pageNo" id="pageNo"> 
			</form>
			<#if (page.totalPageNumber>1 && page.pageNoList?size>0)>
					<div class="paging paging_v1">
					 <#if (page.pageNo>1)><a href="javascript:void(0)" onClick="go_page_ajax(${page.pageNo-1})" class="pg_num">&lt;</a></#if><#if (page.startPageNo == 2)><a href="javascript:void(0)" onClick="go_page_ajax(1)" class="pg_num">1</a><#elseif (page.startPageNo>2)><a href="javascript:void(0)" onClick="go_page_ajax(1)" class="pg_num">1</a><a href="javascript:void(0)" onClick="go_page_ajax(2)" class="pg_num">2</a><#if (page.startPageNo==4)><a href="javascript:void(0)" onClick="go_page_ajax(3)" class="pg_num">3</a><#elseif (page.startPageNo>4)><strong class="pg_num pg_bu">...</strong></#if></#if><#list page.pageNoList as pn><#if page.pageNo==pn><strong class="pg_num pg_num_on">${pn}</strong><#else><a href="javascript:void(0)" onClick="go_page_ajax(${pn})" class="pg_num">${pn}</a></#if></#list><#if (page.totalPageNumber-page.lastPageNo>=2)><#if (page.totalPageNumber-page.lastPageNo==3)><a href="javascript:void(0)" onClick="go_page_ajax(${page.totalPageNumber-2})" class="pg_num">${page.totalPageNumber-2}</a><#elseif (page.totalPageNumber-page.lastPageNo>3)><strong class="pg_num pg_bu">...</strong></#if><a href="javascript:void(0)" onClick="go_page_ajax(${page.totalPageNumber-1})" class="pg_num">${page.totalPageNumber-1}</a><a href="javascript:void(0)" onClick="go_page_ajax(${page.totalPageNumber})" class="pg_num">${page.totalPageNumber}</a></#if><#if page.lastPageNo!=page.pageNo><a href="javascript:void(0)" onClick="go_page_ajax(${page.pageNo+1})" class="pg_num">&gt;</a></#if>
					</div>
		     </#if>

</#macro>