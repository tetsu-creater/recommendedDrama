package la.bean;

import java.io.Serializable;

public class ShowDramaListBean implements Serializable{
	private int code;
	private int no;
	private String title;
	private String category;
	private int season;
	private String casts;
	private String services;

	public ShowDramaListBean() {

	}

	public ShowDramaListBean(int code,String title,String category,int season,String casts,String services) {
		this.code = code;
		this.title = title;
		this.category = category;
		this.season = season;
		this.casts = casts;
		this.services = services;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public String getCasts() {
		return casts;
	}

	public void setCasts(String casts) {
		this.casts = casts;
	}

	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}

}
