var BlogModule=angular.module('BlogModule', []);

BlogModule.service('BlogService', ['$http','$q','RESTURI',function($http,$q,RESTURI){
	
	this.add=function(blog){
		console.log("Add blog service");
		console.log(blog);
		var deferred=$q.defer();
		$http.post(RESTURI+'/addblog',blog)
		.then(
			function(response){
				console.log('success');
				console.log(response.data);
				deferred.resolve(response.data);

			},function(error){
				console.log('reject');
				deferred.reject(error);
			});
		return deferred.promise
	}
	this.viewAll=function(){
		console.log('View All Blogs service');
		var deferred=$q.defer();
		$http.get(RESTURI+'/getallblog')
		.then(
			function(response){
				console.log('success');
				deferred.resolve(response.data);
			},
			function(error)
			{
				console.log('Error');
				deferred.reject(error);
			});
		return deferred.promise;
	}
}])