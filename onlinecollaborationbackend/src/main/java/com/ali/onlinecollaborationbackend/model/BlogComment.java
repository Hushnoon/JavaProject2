package com.ali.onlinecollaborationbackend.model;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class BlogComment {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int BlogCommentId;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Blog blog;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private User user;
	private String comment;
	public int getBlogCommentId() {
		return BlogCommentId;
	}
	public void setBlogCommentId(int blogCommentId) {
		BlogCommentId = blogCommentId;
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
