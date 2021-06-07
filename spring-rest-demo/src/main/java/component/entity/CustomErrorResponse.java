package component.entity;


public class CustomErrorResponse 
{
	private String message;
	private int status;
	private long time;
	
	public CustomErrorResponse() {}

	public CustomErrorResponse(String message, int status, long time) {
		this.message = message;
		this.status = status;
		this.time = time;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

}
