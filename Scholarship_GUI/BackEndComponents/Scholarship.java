public class Scholarship {
private String name;
private String description;
private String eligibility;
private String requirements;
private String amount;
private String deadlines;

public Scholarship(String name, String description, String eligibility, String requirements, String amount, String deadlines) {
    this.name = name;
    this.description = description;
    this.eligibility = eligibility;
    this.requirements = requirements; // Fixed the parameter name here
    this.amount = amount;
    this.deadlines = deadlines;
}

// Getters
public String getName() {
    return name;
}

public String getDescription() {
    return description;
}

public String getEligibility() {
    return eligibility;
}
public String getRequirements() {
    return requirements;
}
public String getAmount() {
    return amount;
}
public String getDeadlines() {
    return deadlines;
}



// Setters
public void setName(String name) {
    this.name = name;
}

public void setDescription(String description) {
    this.description = description;
}

public void setEligibility (String eligibility) {
    this.eligibility = eligibility;
}
public void setRequirements(String requirements) {
    this.requirements = requirements;
}
public void setAmount(String amount) {
    this.amount = amount;
}
public void setDeadlines (String deadlines) {
    this.deadlines = deadlines;
}

}






