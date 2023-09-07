package withus.ex.config;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseMessage {

    private StatusEnum status;
    private String message;
    private Object data;
    
    public ResponseMessage() {
    	this.status = StatusEnum.BAD_REQUEST;
    	this.message = null;
    	this.data = null;
    }

	public ResponseMessage(StatusEnum status, String message, Object data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

}