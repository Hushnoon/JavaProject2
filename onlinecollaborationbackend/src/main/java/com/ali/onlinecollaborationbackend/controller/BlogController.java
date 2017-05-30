package com.ali.onlinecollaborationbackend.controller;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ali.onlinecollaborationbackend.Dao.BlogDao;
import com.ali.onlinecollaborationbackend.model.Blog;

@RestController
public class BlogController {

	@Autowired
	BlogDao blogDao;

	@PostMapping("/addblog")
	public ResponseEntity<Blog> addBlog(@RequestBody Blog blog) {
		System.out.println(LocalDate.now());
		blog.setPostDate(LocalDate.now());
		blogDao.addBlog(blog);
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}

	@GetMapping("/getallblog")
	public ResponseEntity<List<Blog>> getAllBlog() {
		List<Blog> getallblogs = blogDao.getAllBlog();

		return new ResponseEntity<List<Blog>>(getallblogs, HttpStatus.OK);
	}

	@GetMapping("/getblogid/{blogId}")
	public ResponseEntity<Blog> getBlogById(@PathVariable("blogId") int blogId) {
		Blog blog = blogDao.getById(blogId);
		if (blog == null) {
			Blog blg = new Blog();

			return new ResponseEntity<Blog>(blg, HttpStatus.NOT_FOUND);
		} else {

			return new ResponseEntity<Blog>(blog, HttpStatus.OK);
		}
	}

	@DeleteMapping("/deleteblog/{blogId}")
	public ResponseEntity<Blog> deleteBlog(@PathVariable("blogId") int blogId) {
		Blog blog = blogDao.getById(blogId);
		blogDao.deleteBlog(blog);
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}

	@GetMapping("/getbloguserid/{userId}")
	public ResponseEntity<List<Blog>> getBlogByUserID(@PathVariable("userId") int userId) {
		List<Blog> blog = blogDao.getByUserId(userId);

		return new ResponseEntity<List<Blog>>(blog, HttpStatus.OK);

	}

	@PutMapping("/updateblog")
	public ResponseEntity<Blog> updateBlog(@RequestBody Blog blog) {
		blogDao.updateBlog(blog);
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}

}
