package dtos.requests;

import java.time.LocalDateTime;

public class CreateMail {
    private String subject;
    private String message;
    private LocalDateTime time = LocalDateTime.now();
    private int mailId;
    private String emailAddress;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getMailId() {
        return mailId;
    }

    public void setMailId(int mailId) {
        this.mailId = mailId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "CreateMail{" +
                "subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", time=" + time +
                ", mailId=" + mailId +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
