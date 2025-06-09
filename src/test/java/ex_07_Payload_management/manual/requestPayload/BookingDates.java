package ex_07_Payload_management.manual.requestPayload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class BookingDates {

    private String checkin;

    private String checkout;

}
