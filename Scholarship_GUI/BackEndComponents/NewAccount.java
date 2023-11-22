public class NewAccount {
    private String name;
    private String academicHistory;
    private String contactDetails;
    private String contactEmails;
    private String contactPassword;

    public NewAccount(String name, String academicHistory, String contactDetails, String contactEmails, String contactPassword) {
        this.name = name;
        this.academicHistory = academicHistory;
        this.contactDetails = contactDetails;
        this.contactEmails = contactEmails; // Fixed the parameter name here
        this.contactPassword = contactPassword;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getAcademicHistory() {
        return academicHistory;
    }

    public String getContactDetails() {
        return contactDetails;
    }
    public String getContactEmails() {
        return contactEmails;
    }
     public String getContactPassword() {
        return contactPassword;
    }



    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAcademicHistory(String academicHistory) {
        this.academicHistory = academicHistory;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }
    public void setContactEmails(String contactEmails) {
        this.contactEmails = contactEmails;
    }
    public void setContactPassword(String contactPassword) {
        this.contactPassword = contactPassword;
    }
}
