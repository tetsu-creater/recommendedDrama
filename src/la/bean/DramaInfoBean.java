package la.bean;

import java.io.Serializable;

public class DramaInfoBean implements Serializable{
	private int rank;
	private int code;
	private String title;
	private String category;
	private int season;
	private String photo;
	private String casts;
	private String content;
	private String services;

	public DramaInfoBean() {

	}

	public DramaInfoBean(String title,String category,int season,String photo,String casts,String content,String services) {
		this.title = title;
		this.category = category;
		this.season = season;
		this.photo = photo;
		this.casts = casts;
		this.content = content;
		this.services = services;
	}

	public DramaInfoBean(int code,String title) {
		this.code = code;
		this.title = title;
	}

	public DramaInfoBean(int code,String title,String category,int season,String casts,String services) {
		this.code = code;
		this.title = title;
		this.category = category;
		this.season = season;
		this.casts = casts;
		this.services = services;
	}

	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getSeason() {
		return season;
	}
	public void setSeason(int season) {
		this.season = season;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getCasts() {
		return casts;
	}
	public void setCasts(String casts) {
		this.casts = casts;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}


}
