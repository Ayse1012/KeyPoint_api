package pojoPage;

public class ModeratorBody {

    private String firstName;
    private String lastName;
    private String password;
    private String mobile;
    private String email;

  /* public ModeratorBody(String firstName, String lastName, String password, String mobile,String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.password = password;
      this.mobile = mobile;
      this.email = email;
  } */

    public ModeratorBody(){
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
