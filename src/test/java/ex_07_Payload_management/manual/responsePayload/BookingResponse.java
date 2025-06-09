package ex_07_Payload_management.manual.responsePayload;

import ex_07_Payload_management.manual.requestPayload.BookingDates;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class BookingResponse {

    private Integer bookingId;
    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private String additionalneeds;
    private BookingDates bookingdates;
}
