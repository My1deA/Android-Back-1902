package Model;

public class UploadItem {
	private String uid;
	private String url;
	private String time;
	private String loaction;
	private String type;
	private String text;
	
	
	
	public UploadItem(String uid, String text, String location, String time, String type,String url) {
		super();
		this.uid = uid;
		this.url = url;
		this.time = time;
		this.loaction = loaction;
		this.type = type;
		this.text=text;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getLoaction() {
		return loaction;
	}
	public void setLoaction(String loaction) {
		this.loaction = loaction;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
