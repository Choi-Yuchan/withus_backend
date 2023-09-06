package withus.ex.config;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseMessage {

    private StatusEnum status;
    private String message;

}