package demoreact.demo.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * LoginDto
 * <p>
 * Version 1.0
 * <p>
 * Date: 06-07-2021
 * <p>
 * Copyright
 * <p>
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * 06-07-2021          Anhtp8           Request into login
 */
@Data
public class LoginDto {
    @NotBlank
    private String username;

    @NotBlank
    private String password;


    public LoginDto() {
    }

    /**
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
