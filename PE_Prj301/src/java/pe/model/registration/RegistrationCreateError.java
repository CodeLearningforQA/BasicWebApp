/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.model.registration;

import java.io.Serializable;

/**
 *
 * @author Be Keo
 */
public class RegistrationCreateError implements Serializable{
    private String usernameLengthError;
    private String passwordLengthError;
    private String fullNameLengthError;
    
    private String confirmMatched;
    
    private String usernameIsExister;

    public RegistrationCreateError() {
    }

    public String getUsernameLengthError() {
        return usernameLengthError;
    }

    public void setUsernameLengthError(String usernameLengthError) {
        this.usernameLengthError = usernameLengthError;
    }

    public String getPasswordLengthError() {
        return passwordLengthError;
    }

    public void setPasswordLengthError(String passwordLengthError) {
        this.passwordLengthError = passwordLengthError;
    }

    public String getFullNameLengthError() {
        return fullNameLengthError;
    }

    public void setFullNameLengthError(String fullNameLengthError) {
        this.fullNameLengthError = fullNameLengthError;
    }

    public String getConfirmMatched() {
        return confirmMatched;
    }

    public void setConfirmMatched(String confirmMatched) {
        this.confirmMatched = confirmMatched;
    }

    public String getUsernameIsExister() {
        return usernameIsExister;
    }

    public void setUsernameIsExister(String usernameIsExister) {
        this.usernameIsExister = usernameIsExister;
    }
    
    
}
