//{
//            job: {
//                id: 15,
//                companyId: 78,
//                jobName: "电话销售",
//                jobType: "OTHER",
//                salaryF: 3000,
//                salaryT: 5000,
//                keywords: "[\"1\",\"qq\",\"2\",\"3\",\"4\",\"5\",\"6\"]",
//                school: "高中以上",
//                datetimeCreate: 1512616900000,
//                isDeleted: 0
//            },
//            company: {
//                id: 78,
//                name: "湖州渡口信息技术有限公司",
//                address: "联系地址：湖州二环西路1388号赛格数码城2号楼裙楼4层A区4A09号办公区",
//                contractor: "联 系 人：朱经理",
//                phone: "联系电话：15067292599",
//                email: "联系邮箱：345913@qq.com",
//                website: "公司网址：www.zjduko.com",
//                fax: "传    真：",
//                introduce: "渡口网络是一家集策略咨询、创意创新、视觉设计、技术研发、内容制造、营销推广为一体的综合型数字化创新服务企业，其利用公司持续积累的核心技术和互联网思维，提供以互联网、移动互联网为核心的网络技术服务和互动整合营销服务，为传统企业实现“互联网+”升级提供整套解决方案。公司定位于中大型企业为核心客户群，可充分满足这一群体相比中小企业更为丰富、高端、多元的互联网数字综合需求。公司作为一家互联网数字服务综合商，其主营业务包括移动互联网应用开发服务、数字互动整合营销服务、互联网网站建设综合服务和电子商务综合服务。",
//                jsonArr: null,
//                platformId: 1,
//                thirdpartId: "28105",
//                datetimeCreate: 1512635042000,
//                isDeleted: 0
//            }
//        }

var mansorySetting = {
	childrenClass: 'item', // default is a div
	columnClasses: 'padding', //add classes to items
	breakpoints:{
		lg: 3, 
		md: 4, 
		sm: 6,
		xs: 12
	},
	distributeBy: { order: false, height: false, attr: 'data-order', attrOrder: 'asc' }, //default distribute by order, options => order: true/false, height: true/false, attr => 'data-order', attrOrder=> 'asc'/'desc'
	onload: function (items) {
		//make somthing with items
	} 
}

var vm = new Vue({
  el: '#vct',
  data: {
    title: '菜鸟教程官网',
    items: [
    ]
  },
  mounted:function(){
	 // reLayout();
  }
})

$.ajax({
	type: "POST",
    url: "offer/listj",
    contentType: "application/json",
    data: JSON.stringify({page:1,pageSize:10}),
    success: function(r){
    	if(r.errCode == 0){
    		vm.items = r.data;
    		for(var i = 0 ;i < vm.items.length;i++){
    			var keywordsStr = vm.items[i].job.keywords;
    			if(keywordsStr){
    				vm.items[i].job.keywords = JSON.parse(keywordsStr);
    				vm.items[i].job.contact_html = "<h5>" + vm.items[i].company.contractor + "</h5>"
    				+"<h5>" + vm.items[i].company.phone + "</h5>"
    				+"<h5>" + vm.items[i].company.email + "</h5>";
    			}
    		}
    		vm.$nextTick(reLayout);
    	}
	}
});
function reLayout(){
	jQuery(document).ready(function ( $ ) {
		$("#my-gallery-container").mpmansory(
				mansorySetting
		);
	});
	$("[data-toggle='popover']").popover({html:true});
}

