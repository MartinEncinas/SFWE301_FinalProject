public class NewAccount {
    private String name;
    private String academicHistory;
    private String contactDetails;
    private String contactEmails;
    private String contactPassword;
    private String permissionValue;
    
    public NewAccount(String name, String academicHistory, String contactDetails, String contactEmails, String contactPassword, String permissionValue) {
        this.name = name;
        this.academicHistory = academicHistory;
        this.contactDetails = contactDetails;
        this.contactEmails = contactEmails; // Fixed the parameter name here
        this.contactPassword = contactPassword;
        this.permissionValue = permissionValue;
    }
    public NewAccount() {
        this.name = "";
        this.academicHistory = "";
        this.contactDetails = "";
        this.contactEmails = ""; // Fixed the parameter name here
        this.contactPassword = "";
        this.permissionValue = "";
    }

    // Getters
    public String getName() {
        return name;
    }
    public String getPermissions() {
        return permissionValue;
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
    public void setPermissions(String permissionValue) {
        this.permissionValue = permissionValue;
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
    
    public void test() {
        System.out.println(name + " " + permissionValue + " " + academicHistory + " " + contactDetails + " " + contactEmails + " " + contactPassword);
    }
}
