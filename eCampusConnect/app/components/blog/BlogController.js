BlogModule.controller('BlogController', ['BlogService','$http','$scope','$rootScope', function(BlogService,$scope,$rootScope){
	var me=this;
	me.newBlog=false;
	me.allBlogs=true;
	me.myBlogs=false;
	me.add=function()
	{
		me.allBlogs=false;
		me.newBlog=true;
		me.myBlogs=false;
		console.log('Add new Blogs');
		/*console.log($rootScope.currentUser);
		me.blog.user=$rootScope.currentUser;	
		BlogService.add(me.blog)
		.then(function(data){
			console.log("added in BlogController");
		},function(error){
			console.log(error);
		});*/
	}
	me.viewAllBlogs=function()
	{
		me.allBlogs=true;
		me.newBlog=false;
		me.myBlogs=false;
		console.log('View All Blogs');
		BlogService.viewAll()
		.then(function(data){
			console.log(data);
			me.blogList=data;
		},function(error){
			console.log(error);
		});
	}
	me.viewMyBlogs=function()
	{
		me.allBlogs=false;
		me.newBlog=false;
		me.myBlogs=true;
		console.log('View My Blogs');
	}
	me.viewAllBlogs();
}])