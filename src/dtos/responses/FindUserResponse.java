package dtos.responses;

public class FindUserResponse {
    private String emailAddress;
    private String fullName;
    private  String dateRegistered;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(String dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    @Override
    public String toString() {
        return "FindUserResponse{" +
                "emailAddress ='" + emailAddress + '\'' +
                ", fullName='" + fullName + '\'' +
                ", dateRegistered='" + dateRegistered + '\'' +
                '}';
    }
}
