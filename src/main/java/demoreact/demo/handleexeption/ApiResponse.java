package demoreact.demo.handleexeption;


/**
 * ApiResponse
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
public class ApiResponse {

    private int status;
    private String message;
    private Object result;


    /**
     * @param status
     * @param message
     * @param result
     */

    public ApiResponse(int status, String message, Object result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    /**
     *
     * @return status
     */
    public int getStatus() {
        return status;
    }

}