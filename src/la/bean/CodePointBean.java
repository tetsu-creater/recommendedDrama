package la.bean;

import java.io.Serializable;

public class CodePointBean implements Serializable{
	private int code;
	private int point;

	public CodePointBean(int code,int point) {
		this.code = code;
		this.point = point;
	}

	public CodePointBean() {

	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
}
