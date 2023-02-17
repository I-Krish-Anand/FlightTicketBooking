package admincontrols;

import dto.FlightDetails;

import java.util.ArrayList;

public interface AdminViewToController {

    void updationSuccess();

    void deletionSuccess(String flightNo);

    void deletetionFailed();
}
