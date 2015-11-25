<#setting number_format="###############">
<#setting url_escaping_charset="UTF-8">
<#macro snb idx>
	<div id="sidebar-left" class="span2">
	<div class="nav-collapse sidebar-nav">
		<ul class="nav nav-tabs nav-stacked main-menu">
		<#if (pareMenuList?? && pareMenuList?size > 0)>
		<#if (menulist?? && menulist?size > 0)>
		<#list pareMenuList as parentMenu>
		<li> 
		    <a class="dropmenu" href="#"><i class="icon-folder-close-alt"></i><span class="hidden-tablet"> ${parentMenu.name!''}</span></a>
			<ul>
			<#list menulist as menu>
			<#if menu.parentId = parentMenu.id>
			<li><a class="submenu" href="${menu.href}"><i class="icon-file-alt"></i><span class="hidden-tablet"> ${menu.name!''}</span></a></li>
			</#if>
			</#list>
			</ul>
		</li>
		</#list>
		</#if>
		</#if>
		</ul>
	</div>
	</div>
</#macro>
<#macro snb2 idx>
	<div id="sidebar-left" class="span2">
	<div class="nav-collapse sidebar-nav">
		<ul class="nav nav-tabs nav-stacked main-menu">
		<#if (parentMenuList?? && parentMenuList?size > 0)>
		<#if (MenuList?? && MenuList?size > 0)>
		<#list parentMenuList as parentMenu>
		<li name="pr_snb" 
		
		    <#if (idx?? && idx?length > 0)><#assign tab=idx?substring(0, idx?index_of('_'))> class="<#if tab==parentMenu.tag>on</#if>"</#if>>
			<a class="dropmenu" href="#"><i class="icon-folder-close-alt"></i><span class="hidden-tablet"> ${parentMenu.name!''}</span><span class="label label-important"> 3 </span></a>
			<ul>
			<#list MenuList as Menu>
			<#if Menu.parentMenuNm = parentMenu.name>
			<li><a class="submenu" href="${Menu.menuUri}"><i class="icon-file-alt"></i><span class="hidden-tablet"> ${Menu.menuNm!''}</span></a></li>
			</#if>
			</#list>
			</ul>
		</li>
		</#list>
		</#if>
		</#if>
		</ul>
	</div>
	</div>
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