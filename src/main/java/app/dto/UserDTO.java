package app.dto;

import app.validation.PasswordMatches;
import app.validation.ValidEmail;
import app.validation.ValidName;
import app.validation.ValidPass;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by yurii on 14.07.17.
 */

@PasswordMatches
public class UserDTO {

    @NotNull
    @NotEmpty
    @ValidName
    private String firstName;

    @NotNull
    @NotEmpty
    @ValidName
    private String lastName;

   /* @NotNull
    @NotEmpty
    private String middleName;*/

    @NotNull
    @NotEmpty
    @ValidPass
    private String password;
    private String matchingPassword;

    @NotNull
    @NotEmpty
    @ValidEmail
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

   /* public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
*/
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getLogin() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
