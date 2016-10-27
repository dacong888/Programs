<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>鲜花订购系统</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/common.css" />
<link rel="stylesheet" href="css/toastr.min.css" />
</head>
<body class="bk-sd-color">

	<nav class="navbar navbar-sd-color navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<!--导航-头-->
			<div class="navbar-header">
				<a class="navbar-brand title-brand-sd-color" href="main.jsp">鲜花订购系统</a>
			</div>
			<!--管理员操作选项，通过session进行判断是否显示多余操作细节-->
			<ul class="collapse navbar-collapse nav navbar-nav top-menu navbar-right">
                <li><a href="search.jsp"><i class="glyphicon glyphicon-search"></i>商品高级查询</a></li>
                <li><a href="goods!showGoodsDetails.action"><i class="glyphicon glyphicon-shopping-cart"></i> 我的购物车<i class="glyphicon glyphicon-chevron-right"></i></a></li>
				<li class="dropdown">
					<a class="dropdown-toggle" href="#" data-toggle="dropdown" aria-expanded="false">
						<i class="glyphicon glyphicon-user"></i>
						<s:property value="#session.UserLoginSession.userName"/>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href="login!Logout.action" class="text-center"> <i
								class="glyphicon glyphicon-home"></i> 
								退出
							</a>
						</li>
						<li class="divider"></li>
						<li>
							<a id="aboutmessage" class="text-center btn">
								<i class="glyphicon glyphicon-zoom-in"></i> 
								关于
							</a>
						</li>
					</ul>
				</li>
            </ul>  
		</div>
	</nav>

	<!--侧边导航-->
	<div class="container-fluid col-lg-10 col-lg-offset-1" style="margin-top: 80px;">
		<!--显示内容-->
		<div class="maincontent row">
			<!--我是主要内容 start-->
			<ul class="breadcrumb" style="background-color: burlywood;">
				<li class="active"><b>鲜花列表</b></li>
				<li class="pull-right"><a class="btn btn-xs btn-circle btn-danger" data-toggle="modal" data-target="#typeExplore">[类型]搜索</a></li>
				<li class="pull-right"><a class="btn btn-xs btn-circle btn-danger" data-toggle="modal" data-target="#priceExplore">[价格]搜索</a></li>
			</ul>
		<!-- 1 -->
		<div class="incredible-grids">
				<div id='line1' class="col-md-3 incredible-grid line1">
					<p class="p3" hidden="hidden">想着 我们曾一起跨过海边，想着 我们曾一起晒太阳。想着 我们曾一起坐着小火车,想着 我们曾手牵手走过曾经。此刻，我的心情，一如阳光般温暖！</p>
					<p class="p1" hidden="hidden">10枝多头黄百合,黄莺适量搭配。</p>
					<p class="p2" hidden="hidden">蓝色平面纸圆形包装，拉菲草束扎。</p>
					<img src="img/baihe/9010811.jpg_220x240-329yuan.jpg" class="img-responsive center-block">
					<h4 class="text-center">阳光心情 ￥329</h4>			
					<a type="button" class="btn btn-xs btn-success btn-circle" style="margin-left:10px;" href="goods!addUserCart.action?goodsDesc.name=阳光心情">
					<i class="glyphicon glyphicon-shopping-cart"></i> 选购</a>
					<a href="javascript:void(0)" type="button" class="btn btn-xs btn-info btn-circle" 
					onclick="descInfo1('line1');"><i class="glyphicon glyphicon-th-list"></i> 详细</a>
				</div>
				
				<div id="line2" class="col-md-3 incredible-grid line2">
					<p class="p3" hidden="hidden">康乃馨+百合， 温暖、纯洁，暖暖的心意，让花儿传送：爱是牵挂，爱是奉献，是思念的痛，是回忆的甜，是难舍难分!是晨昏心颤的期盼……</p>
					<p class="p1" hidden="hidden">2枝多头白香水百合,19枝粉康乃馨,黄莺适量搭配。</p>
					<p class="p2" hidden="hidden">内层白色乱网，外层粉色平面纸，香槟与粉色双层缎带花结。</p>
					<img src="img/baihe/9010840.jpg_220x240-198yuan.jpg" class="img-responsive center-block">
					<h4 class="text-center">爱的祝福 ￥198</h4>
					<a type="button" class="btn btn-xs btn-success btn-circle" style="margin-left:10px;" href="goods!addUserCart.action?goodsDesc.name=爱的祝福">
					<i class="glyphicon glyphicon-shopping-cart"></i> 选购</a>
					<a href="javascript:void(0)" type="button" class="btn btn-xs btn-info btn-circle" 
					onclick="descInfo1('line2');"><i class="glyphicon glyphicon-th-list"></i> 详细</a>
				</div>
				
				<div id='line3' class="col-md-3 incredible-grid">
					<p class="p3" hidden="hidden">“青青子衿，悠悠我心。”</p>
					<p class="p1" hidden="hidden">白色多头香水百合6枝，澳州腊梅做点缀。</p>
					<p class="p2" hidden="hidden">咖啡色条纹纸，牛皮纸，拉菲草。</p>
					<img src="img/baihe/9010904.jpg_220x240-270yuan.jpg" class="img-responsive center-block">
					<h4 class="text-center">青青子衿 ￥270</h4>
					<a type="button" class="btn btn-xs btn-success btn-circle" style="margin-left:10px;" href="goods!addUserCart.action?goodsDesc.name=青青子衿">
					<i class="glyphicon glyphicon-shopping-cart"></i> 选购</a>
					<a href="javascript:void(0)" type="button" class="btn btn-xs btn-info btn-circle" 
					onclick="descInfo1('line3');"><i class="glyphicon glyphicon-th-list"></i> 详细</a>
				</div>
				<div id='line4' class="col-md-3 incredible-grid">
					<p class="p3" hidden="hidden">您的付出是我爱的源泉，幻化成这世间最美丽的色彩，那么浓烈，又是那般温柔，它永驻我心不能忘怀~恩情永远，爱无止境！</p>
					<p class="p1" hidden="hidden">红色、粉色康乃馨共66枝（粉略多于红），搭配石竹梅、绿叶适量</p>
					<p class="p2" hidden="hidden">咖啡色条纹纸，牛皮纸，拉菲草。</p>
					<img src="img/kangnaixin/9012058.jpg_220x240-298yuan.jpg" class="img-responsive center-block">
					<h4 class="text-center">永驻我心 ￥298</h4>
					<a type="button" class="btn btn-xs btn-success btn-circle" style="margin-left:10px;" href="goods!addUserCart.action?goodsDesc.name=永驻我心">
					<i class="glyphicon glyphicon-shopping-cart"></i> 选购</a>
					<a href="javascript:void(0)" type="button" class="btn btn-xs btn-info btn-circle" 
					onclick="descInfo1('line4');"><i class="glyphicon glyphicon-th-list"></i> 详细</a>
				</div>
				<div class="clearfix"></div>
			</div>
			
			<!-- 2 -->
			<div class="incredible-grids top-sd-above">
				<div id='line5' class="col-md-3 incredible-grid">
					<p class="p3" hidden="hidden">母亲的爱是永恒的，她是一颗不落的星；母亲的爱是伟大的，她可以毫不保留的付出一切倾尽所有！</p>
					<p class="p1" hidden="hidden">粉色康乃馨33枝，石竹梅围绕</p>
					<p class="p2" hidden="hidden">内层紫红色不织布，外层淡紫色白牛皮纸，红色缎带花结。</p>
					<img src="img/kangnaixin/9012093.jpg_220x240-236yuan.jpg" class="img-responsive center-block">
					<h4 class="text-center">永恒的爱 ￥236</h4>
					<a type="button" class="btn btn-xs btn-success btn-circle" style="margin-left:10px;" href="goods!addUserCart.action?goodsDesc.name=永恒的爱">
					<i class="glyphicon glyphicon-shopping-cart"></i> 选购</a>
					<a href="javascript:void(0)" type="button" class="btn btn-xs btn-info btn-circle" 
					onclick="descInfo1('line5');"><i class="glyphicon glyphicon-th-list"></i> 详细</a>
				</div>
				<div id='line6' class="col-md-3 incredible-grid">
					<p class="p3" hidden="hidden">妈妈，您是我唯一的牵挂，将我心中的祝福化作阳光般的温暖，永恒地留在您心中！</p>
					<p class="p1" hidden="hidden">红色康乃馨33枝，石竹梅围绕</p>
					<p class="p2" hidden="hidden">内层黄色不织布，外层咖啡色英文报纸，深红色缎带花结。</p>
					<img src="img/kangnaixin/9012094.jpg_220x240-229yuan.jpg" class="img-responsive center-block">
					<h4 class="text-center">牵挂 ￥229</h4>
					<a type="button" class="btn btn-xs btn-success btn-circle" style="margin-left:10px;" href="goods!addUserCart.action?goodsDesc.name=牵挂">
					<i class="glyphicon glyphicon-shopping-cart"></i> 选购</a>
					<a href="javascript:void(0)" type="button" class="btn btn-xs btn-info btn-circle" 
					onclick="descInfo1('line6');"><i class="glyphicon glyphicon-th-list"></i> 详细</a>
				</div>
				<div id='line7' class="col-md-3 incredible-grid">
					<p class="p3" hidden="hidden">简单、时尚而典雅的包装，犹如赏心悦目的你一般。白色马蹄莲清雅美丽,它的花语是"忠贞不渝,永结同心";</p>
					<p class="p1" hidden="hidden">5枝白色马蹄莲,9枝香槟玫瑰,剑叶+绿叶适量。</p>
					<p class="p2" hidden="hidden">香槟色平面纸一张垫底,浅黄绿色平面纸+白色平面纸呈扇形包装,金黄色条纹丝带束扎。</p>
					<img src="img/matilian/9010791.jpg_220x240-189yuan.jpg" class="img-responsive center-block">
					<h4 class="text-center">赏心悦目 ￥189</h4>
					<a type="button" class="btn btn-xs btn-success btn-circle" style="margin-left:10px;" href="goods!addUserCart.action?goodsDesc.name=赏心悦目">
					<i class="glyphicon glyphicon-shopping-cart"></i> 选购</a>
					<a href="javascript:void(0)" type="button" class="btn btn-xs btn-info btn-circle" 
					onclick="descInfo1('line7');"><i class="glyphicon glyphicon-th-list"></i> 详细</a>
				</div>
				<div id='line8' class="col-md-3 incredible-grid">
					<p class="p3" hidden="hidden">春带来希望风 送来喜讯带着春天的柔和的旋律走在希望的田野上等待 收获 希望。</p>
					<p class="p1" hidden="hidden">7枝白色马蹄莲,2枝白香水百合，情人草适量搭配。</p>
					<p class="p2" hidden="hidden">透明玻璃纸一张垫底，白色平面纸+浅紫色平面纸扇形包装,蓝色平面纸+绿色平面纸托底,带条纹棕黄色宽丝带束扎。</p>
					<img id="id_mtl" src="img/matilian/9010795.jpg_220x240-188yuan.jpg" class="img-responsive center-block">
					<h4 class="text-center">春韵 ￥188</h4>
					<a type="button" class="btn btn-xs btn-success btn-circle" style="margin-left:10px;" href="goods!addUserCart.action?goodsDesc.name=春韵">
					<i class="glyphicon glyphicon-shopping-cart"></i> 选购</a>
					<a href="javascript:void(0)" type="button" class="btn btn-xs btn-info btn-circle" 
					onclick="descInfo1('line8');"><i class="glyphicon glyphicon-th-list"></i> 详细</a>
				</div>
				<div class="clearfix"></div>
			</div>
			
			<!-- 3 -->
			<div class="incredible-grids top-sd-above">
				<div id='line9' class="col-md-3 incredible-grid">
					<p class="p3" hidden="hidden">在一天的最美的时分对心爱的人说声爱你。</p>
					<p class="p1" hidden="hidden">马蹄莲10枝，白玫瑰5枝，绿色桔梗一枝，绿叶适量。</p>
					<p class="p2" hidden="hidden">深蓝色条纹纸，米白色缎带花结。</p>
					<img src="img/matilian/9012013.jpg_220x240-219yuan.jpg" class="img-responsive center-block">
					<h4 class="text-center">清晨的问候 ￥219</h4>
					<a type="button" class="btn btn-xs btn-success btn-circle" style="margin-left:10px;" href="goods!addUserCart.action?goodsDesc.name=清晨的问候">
					<i class="glyphicon glyphicon-shopping-cart"></i> 选购</a>
					<a href="javascript:void(0)" type="button" class="btn btn-xs btn-info btn-circle" 
					onclick="descInfo1('line9');"><i class="glyphicon glyphicon-th-list"></i> 详细</a>
				</div>
				<div id='line10' class="col-md-3 incredible-grid">
					<p class="p3" hidden="hidden">只想和你忘掉一切烦恼，尽情沉醉在最浪漫的气氛中。</p>
					<p class="p1" hidden="hidden">33枝红玫瑰，石竹梅围绕。</p>
					<p class="p2" hidden="hidden">黑色条纹纸，红色缎带花结。</p>
					<img src="img/meigui/9012009.jpg_220x240-280yuan.jpg" class="img-responsive center-block">
					<h4 class="text-center">忘情巴黎 ￥280</h4>
					<a type="button" class="btn btn-xs btn-success btn-circle" style="margin-left:10px;" href="goods!addUserCart.action?goodsDesc.name=忘情巴黎">
					<i class="glyphicon glyphicon-shopping-cart"></i> 选购</a>
					<a href="javascript:void(0)" type="button" class="btn btn-xs btn-info btn-circle" 
					onclick="descInfo1('line10');"><i class="glyphicon glyphicon-th-list"></i> 详细</a>
				</div>
				<div id='line11' class="col-md-3 incredible-grid">
					<p class="p3" hidden="hidden">那是谁的目光，凝望着云端你的方向，你问我世上哪朵花最美？我的心上人，所有的花朵都比不上你的发香；你问我世上哪杯酒最甜，哪颗星最亮？所有的风景都沉醉在你的身旁，你的模样深深刻在我心上。</p>
					<p class="p1" hidden="hidden">红玫瑰66枝，满天星围绕。</p>
					<p class="p2" hidden="hidden">牛皮纸，咖啡色英文报纸，玻璃纸，拉菲草。</p>
					<img src="img/meigui/9012062.jpg_220x240-338yuan.jpg" class="img-responsive center-block">
					<h4 class="text-center">心上人 ￥338</h4>
					<a type="button" class="btn btn-xs btn-success btn-circle" style="margin-left:10px;" href="goods!addUserCart.action?goodsDesc.name=心上人">
					<i class="glyphicon glyphicon-shopping-cart"></i> 选购</a>
					<a href="javascript:void(0)" type="button" class="btn btn-xs btn-info btn-circle" 
					onclick="descInfo1('line11');"><i class="glyphicon glyphicon-th-list"></i> 详细</a>
				</div>
				<div id='line12' class="col-md-3 incredible-grid">
					<p class="p3" hidden="hidden">我的热情，好像一把火。</p>
					<p class="p1" hidden="hidden">10枝向日葵,桔梗适量围边,绿叶。</p>
					<p class="p2" hidden="hidden">白色网纱围绕鲜花一圈,水蓝色卷边纸形圆形包装，白色丝带束扎。</p>
					<img id="id_mtl" src="img/xiangrikui/9010810.jpg_220x240-232yuan.jpg" class="img-responsive center-block">
					<h4 class="text-center">热情￥232</h4>
					<a type="button" class="btn btn-xs btn-success btn-circle" style="margin-left:10px;" href="goods!addUserCart.action?goodsDesc.name=热情">
					<i class="glyphicon glyphicon-shopping-cart"></i> 选购</a>
					<a href="javascript:void(0)" type="button" class="btn btn-xs btn-info btn-circle" 
					onclick="descInfo1('line12');"><i class="glyphicon glyphicon-th-list"></i> 详细</a>
				</div>
				<div class="clearfix"></div>
			</div>
			
			<!-- 4 -->
			<div class="incredible-grids top-sd-above">
				<div id='line13' class="col-md-3 incredible-grid">
					<p class="p3" hidden="hidden">你的微笑就是我的向日葵，像夏日碧空一尘不染，有你陪伴的日子是最幸福的时光，那一刻你就是我心中最爱！</p>
					<p class="p1" hidden="hidden">向日葵5枝，红色康乃馨11枝，蓝色绣球1枝，水竹叶半扎，填充适量石竹梅红豆绿叶。</p>
					<p class="p2" hidden="hidden">有柄花篮一个。</p>
					<img src="img/xiangrikui/9012051.jpg_220x240-228yuan.jpg" class="img-responsive center-block">
					<h4 class="text-center">夏日花园 ￥228</h4>
					<a type="button" class="btn btn-xs btn-success btn-circle" style="margin-left:10px;" href="goods!addUserCart.action?goodsDesc.name=夏日花园">
					<i class="glyphicon glyphicon-shopping-cart"></i> 选购</a>
					<a href="javascript:void(0)" type="button" class="btn btn-xs btn-info btn-circle" 
					onclick="descInfo1('line13');"><i class="glyphicon glyphicon-th-list"></i> 详细</a>
				</div>
				<div id='line14' class="col-md-3 incredible-grid">
					<p class="p3" hidden="hidden">采一束阳光，制成书签，每一天都有温暖入怀。</p>
					<p class="p1" hidden="hidden">向日葵6枝，搭配适量黄色勿忘我、黄莺。</p>
					<p class="p2" hidden="hidden">咖啡色英文报纸,拉菲草花结。</p>
					<img src="img/xiangrikui/9012072.jpg_220x240-179yuan.jpg" class="img-responsive center-block">
					<h4 class="text-center">向日葵之歌￥179</h4>
					<a type="button" class="btn btn-xs btn-success btn-circle" style="margin-left:10px;" href="goods!addUserCart.action?goodsDesc.name=向日葵之歌">
					<i class="glyphicon glyphicon-shopping-cart"></i> 选购</a>
					<a href="javascript:void(0)" type="button" class="btn btn-xs btn-info btn-circle" 
					onclick="descInfo1('line14');"><i class="glyphicon glyphicon-th-list"></i> 详细</a>
				</div>
				<div id='line15' class="col-md-3 incredible-grid">
					<p class="p3" hidden="hidden">还记得吗？我与你那些年少轻狂的日子，我与你共同编织。</p>
					<p class="p1" hidden="hidden">紫郁金香10朵，白郁金香10朵，配沙巴叶。</p>
					<p class="p2" hidden="hidden">浅蓝色绵纸包装，蓝色宽丝带束扎。</p>
					<img src="img/yujinxiang/9010056.jpg_220x240-336yuan.jpg" class="img-responsive center-block">
					<h4 class="text-center">意难忘 ￥336</h4>
					<a type="button" class="btn btn-xs btn-success btn-circle" style="margin-left:10px;" href="goods!addUserCart.action?goodsDesc.name=意难忘">
					<i class="glyphicon glyphicon-shopping-cart"></i> 选购</a>
					<a href="javascript:void(0)" type="button" class="btn btn-xs btn-info btn-circle" 
					onclick="descInfo1('line15');"><i class="glyphicon glyphicon-th-list"></i> 详细</a>
				</div>
				<div id='line16' class="col-md-3 incredible-grid">
					<p class="p3" hidden="hidden">郁（遇）见了你，让我生活变得更美丽。</p>
					<p class="p1" hidden="hidden">双色郁金香20枝。</p>
					<p class="p2" hidden="hidden">内层：浅黄色皱纹纸，外层：乳白色皱纹纸，红、金双色丝带束扎。</p>
					<img id="id_mtl" src="img/yujinxiang/9010200.jpg_220x240-332yuan.jpg" class="img-responsive center-block">
					<h4 class="text-center">郁来郁爱￥332</h4>
					<a type="button" class="btn btn-xs btn-success btn-circle" style="margin-left:10px;" href="goods!addUserCart.action?goodsDesc.name=郁来郁爱">
					<i class="glyphicon glyphicon-shopping-cart"></i> 选购</a>
					<a href="javascript:void(0)" type="button" class="btn btn-xs btn-info btn-circle" 
					onclick="descInfo1('line16');"><i class="glyphicon glyphicon-th-list"></i> 详细</a>
				</div>
				<div class="clearfix"></div>
			</div>
			
			<!-- 数据多的情况下，采用监听事件，对图片数据进行分页 -->
			<ul class="breadcrumb content-nav-sd-top body-sd-color"></ul>
		</div>
	</div>
	
	
	<!-- 搜索 -->
	<div class="modal fade " id="typeExplore" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h3 class="panel-title">类型搜索</h3>
					</div>
					<div class="panel-body">
						<form class="form-inline" action="goods!goodsTypeSearch.action" method="post">
			            	<div class="form-group">
			            		<select class="form-control input-default" name="goodsTypeRetrival.select" style="width: 150px;">
			            				<option value="goods_bh" id="sp_bh">百合</option>
			            				<option value="goods_knx" id="sp_knx">康乃馨</option>
			            				<option value="goods_mtl" id="sp_mtl">马蹄莲</option>
			            				<option value="goods_mg" id="sp_mg">玫瑰</option>
			            				<option value="goods_xrk" id="sp_xrk">向日葵</option>
			            				<option value="goods_yjx" id="sp_yjx">郁金香</option>
			            			</select>
			            		
			            			<div class="form-group input-group">
		                                <button class="btn btn-info" type="submit"><i class="glyphicon glyphicon-search"></i> 搜索</button>
			            			</div>
		            		</div>
		            	</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade " id="priceExplore" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h3 class="panel-title">价格搜索</h3>
					</div>
					<div class="panel-body">
						<form class="form-inline" action="goods!goodsPriceSearch.action" method="post">
			            	<div class="form-group">
			            		<select class="form-control input-default" name="goodsPriceRetrival.select" style="width: 150px;">
			            				<option value="goods_100" id="sp_100">100-200</option>
			            				<option value="goods_200" id="sp_200">200-300</option>
			            				<option value="goods_300" id="sp_300">300以上</option>
			            			</select>
			            		
			            			<div class="form-group input-group">
		                                <button class="btn btn-info" type="submit"><i class="glyphicon glyphicon-search"></i> 搜索</button>
			            			</div>
		            		</div>
		            	</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 商品详细信息 -->
	<div class="modal fade" id="goodsInfoModel" aria-hidden="true">
		<div class="modal-dialog dlg-sd-top">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title">详细信息</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-5">
							<div>
								<img id='urlLink'
									src="img/baihe/9010811.jpg_220x240-329yuan.jpg"
									class="img-responsive">
							</div>
						</div>

						<div class="col-md-5 col-md-offset-1">
							<div>
								<h5 style="color: red;">
									<i class="glyphicon glyphicon-tint"></i> <b>材 料</b>
								</h5>
								<p id="cldetailId" style="text-indent: 2em;"></p>
								<h5 style="color: red;">
									<i class="glyphicon glyphicon-leaf"></i> <b>包 装</b>
								</h5>
								<p id="bzdetailId" style="text-indent: 2em;"></p>
								<h5 style="color: red;">
									<i class="glyphicon glyphicon-heart"></i> <b>花语</b>
								</h5>
								<p id="hydetailId" style="text-indent: 2em;"></p>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-sm btn-primary" data-dismiss="modal">关闭</button>
					<!-- <button type="button" class="btn btn-primary">添加</button> -->
				</div>
			</div>
		</div>
		
	</div>
	
	

	<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/toastr.min.js"></script>
	<script src="js/common.js"></script>
</body>
</html>