package com.FirstSpringProject.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sicluceatlux on 2017-04-24.
 * Represents the Article/News entity
 */
@Entity
public class Article implements Serializable {
	
	/**
	 *	GUID
	 */
	private static final long serialVersionUID = 5664724314066801408L;
	/**
	 * article ID
	 */
	@Id
	@GeneratedValue
	private int articleId;
	
	
	/**
	 * title of the article
	 */
	@NotEmpty(message = "The article articleTitle must not be null.")
	private String articleTitle;
	/**
	 * content of the article
	 */
	@NotEmpty(message = "The article articleContent must not be null.")
	private String articleContent;
	/**
	 * Image for the article
	 */
	@Transient
	private MultipartFile articleImage;
	/**
	 * Date of create
	 */
	private String articleDate;
	
	/**
	 * getter of article ID
	 * @return ID of the article
	 */
	public int getArticleId() {
		return articleId;
	}
	
	/**
	 * setter for the article ID
	 * @param articleId ID of the article
	 */
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	
	/**
	 * gettter for article Title
	 * @return
	 */
	public String getArticleTitle() {
		return articleTitle;
	}
	
	/**
	 * setter of the article Title
	 * @param articleTitle title of the article
	 */
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	
	/**
	 * getter for the article Content
	 * @return article Content
	 */
	public String getArticleContent() {
		return articleContent;
	}
	
	/**
	 * setter of the article Content
	 * @param articleContent
	 */
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	
	/**
	 * getter for the article Image
	 * @return
	 */
	public MultipartFile getArticleImage() {
		return articleImage;
	}
	
	/**
	 * setter for the article Image
	 * @param articleImage image for the article
	 */
	public void setArticleImage(MultipartFile articleImage) {
		this.articleImage = articleImage;
	}
	
	/**
	 * getter for article Create Date
	 * @return String create date
	 */
	public String getArticleDate() {
		return articleDate;
	}
	
	/**
	 * setter for article create date
	 * @param articleDate article create date
	 */
	public void setArticleDate(String articleDate) {
		this.articleDate = articleDate;
	}
	
	/**
	 * default Article constructor
	 */
	public Article(){}
	
	/**
	 * parametrized article constructor
	 * @param articleDate article create date
	 */
	public Article(String articleDate){
		this.articleDate = articleDate;
	}
	
	
	/**
	 * overridden toString() method
	 * @return string representation of Article
	 */
	@Override
	public String toString(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd:MM:yyyy hh:mm");
		return "Article{" +
				"articleTitle='" + articleTitle + '\'' +
				", articleDate='" + articleDate + '\'' +
				", articleContent='" + articleContent +
				'}';
	}
}
