package admincontrols;

import dto.FlightDetails;

import java.util.ArrayList;

public interface AdminControllerToModel {
    void updationSuccess();
    void deletionSuccess(String flightNo);

    void deletetionFailed();
}
