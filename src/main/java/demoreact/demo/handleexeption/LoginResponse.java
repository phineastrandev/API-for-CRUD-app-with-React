package demoreact.demo.handleexeption;

import lombok.Data;

/**
 * LoginResponse
 *
 * Version 1.0
 *
 * Date: 06-07-2021
 *
 * Copyright
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * 06-07-2021          Anhtp8
 */
@Data
public class LoginResponse {
    private String accessToken;
    private String tokenType = "Bearer";


    /**
     *
     * @param accessToken
     */

    public LoginResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}