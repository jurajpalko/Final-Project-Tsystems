package sk.tsystems.jobs.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Position {

	@Id
//	@GeneratedValue
	private int ident;

	private String jobId;
	private String positionTitle;
	@Column(length = 10000)
	private String jobDescription;
	@Column(length = 10000)
	private String requirementDescription;
	private String employmentType;
	private String positionURI;
	private String applicationDeadline;
	private String publicationStartDate;
	private String positionBenefitname;
	@Column(length = 10000)
	private String salary;
	private String qrCodeImage;
	private String education;
	@Column(length = 10000)
	private String languages;
	@Column(length = 10000)
	private String experience;
	@Column(length = 10000)
	private String others;
	@Column(length = 10000)
	private String accountabilities;
	@Column(length = 10000)
	private String generalDescription;
	@Column(length = 10000)
	private String softSkills;
	private String iTTechnicalSkills;
	private String technicalSkills;
	@Column(length = 10000)
	private String language;
	@Column(length = 10000)
	private String experiences;
	@Column(length = 10000)
	private String yourSkills;
	@Column(length = 10000)
	private String otherCriteriaOrRequirements;
	@Column(length = 10000)
	private String purpose;
	@Column(length = 10000)
	private String education1;
	@Column(length = 10000)
	private String languages1;
	@Column(length = 10000)
	private String experience1;
	@Column(length = 10000)
	private String others1;
	@Column(length = 10000)
	private String accountabilities1;
	@Column(length = 10000)
	private String language1;
	@Column(length = 10000)
	private String experiences1;
	@Column(length = 10000)
	private String generalDescription1;
	@Column(length = 10000)
	private String softSkills1;
	@Column(length = 10000)
	private String iTTechnicalSkills1;
	@Column(length = 10000)
	private String technicalSkills1;
	@Column(length = 10000)
	private String yourSkills1;
	@Column(length = 10000)
	private String otherCriteriaOrRequirements1;
	@Column(length = 10000)
	private String purpose1;

	public String getSalary() {
		return salary;
	}

	public Position(int ident, String jobId, String positionTitle, String jobDescription, String requirementDescription,
			String employmentType, String positionURI, String applicationDeadline, String publicationStartDate,
			String positionBenefitname, String salary, String qrCodeImage, String education, String languages, String experience, String others, String accountabilities, 
			String generalDescription, String softSkills, String iTTechnicalSkills, String technicalSkills, String language, String experiences, 
			String yourSkills, String otherCriteriaOrRequirements, String purpose, String education1, String languages1, String experience1,
			String others1, String accountabilities1, String language1, String experiences1, String generalDescription1, String softSkills1,
			String iTTechnicalSkills1, String technicalSkills1, String yourSkills1, String otherCriteriaOrRequirements1, String purpose1) {

		this.ident = ident;
		this.jobId = jobId;
		this.positionTitle = positionTitle;
		this.jobDescription = jobDescription;
		this.requirementDescription = requirementDescription;
		this.employmentType = employmentType;
		this.positionURI = positionURI;
		this.applicationDeadline = applicationDeadline;
		this.publicationStartDate = publicationStartDate;
		this.positionBenefitname = positionBenefitname;
		this.salary = salary;
		this.qrCodeImage = qrCodeImage;
		this.education=education;
		this.languages=languages;
		this.experience=experience;
		this.others=others;
		this.accountabilities=accountabilities;
		this.generalDescription=generalDescription;
		this.softSkills=softSkills;
		this.iTTechnicalSkills=iTTechnicalSkills;
		this.technicalSkills=technicalSkills;
		this.language=language;
		this.experiences=experiences;
		this.yourSkills=yourSkills;
		this.otherCriteriaOrRequirements=otherCriteriaOrRequirements;
		this.purpose=purpose;
		this.education1=education1;
		this.languages1=languages1;
		this.experience1=experience1;
		this.others1=others1;
		this.accountabilities1=accountabilities1;
		this.language1=language1;
		this.experiences1=experiences1;
		this.generalDescription1=generalDescription1;
		this.softSkills1=softSkills1;
		this.iTTechnicalSkills1=iTTechnicalSkills1;
		this.technicalSkills1=technicalSkills1;
		this.yourSkills1=yourSkills1;
		this.otherCriteriaOrRequirements1=otherCriteriaOrRequirements1;
		this.purpose1=purpose1;

	}

	public Position() {

	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public int getIdent() {
		return ident;
	}

	public void setIdent(int ident) {
		this.ident = ident;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getPositionTitle() {
		return positionTitle;
	}

	public void setPositionTitle(String positionTitle) {
		this.positionTitle = positionTitle;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getRequirementDescription() {
		return requirementDescription;
	}

	public void setRequirementDescription(String requirementDescription) {
		this.requirementDescription = requirementDescription;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public String getPositionURI() {
		return positionURI;
	}

	public void setPositionURI(String positionURI) {
		this.positionURI = positionURI;
	}

	public String getApplicationDeadline() {
		return applicationDeadline;
	}

	public void setApplicationDeadline(String applicationDeadline) {
		this.applicationDeadline = applicationDeadline;
	}

	public String getPublicationStartDate() {
		return publicationStartDate;
	}

	public void setPublicationStartDate(String publicationStartDate) {
		this.publicationStartDate = publicationStartDate;
	}

	public String getQrCodeImage() {
		return qrCodeImage;
	}

	public void setQrCodeImage(String qrCodeImage) {
		this.qrCodeImage = qrCodeImage;
	}
	
	public String getPurpose1() {
		return purpose1;
	}

	public void setPurpose1(String purpose1) {
		this.purpose1 = purpose1;
	}

	public String getOtherCriteriaOrRequirements1() {
		return otherCriteriaOrRequirements1;
	}

	public void setOtherCriteriaOrRequirements1(String otherCriteriaOrRequirements1) {
		this.otherCriteriaOrRequirements1 = otherCriteriaOrRequirements1;
	}

	public String getYourSkills1() {
		return yourSkills1;
	}

	public void setYourSkills1(String yourSkills1) {
		this.yourSkills1 = yourSkills1;
	}

	public String getTechnicalSkills1() {
		return technicalSkills1;
	}

	public void setTechnicalSkills1(String technicalSkills1) {
		this.technicalSkills1 = technicalSkills1;
	}

	public String getiTTechnicalSkills1() {
		return iTTechnicalSkills1;
	}

	public void setiTTechnicalSkills1(String iTTechnicalSkills1) {
		this.iTTechnicalSkills1 = iTTechnicalSkills1;
	}

	public String getSoftSkills1() {
		return softSkills1;
	}

	public void setSoftSkills1(String softSkills1) {
		this.softSkills1 = softSkills1;
	}

	public String getGeneralDescription1() {
		return generalDescription1;
	}

	public void setGeneralDescription1(String generalDescription1) {
		this.generalDescription1 = generalDescription1;
	}

	public String getExperiences1() {
		return experiences1;
	}

	public void setExperiences1(String experiences1) {
		this.experiences1 = experiences1;
	}

	public String getOthers1() {
		return others1;
	}

	public String getLanguage1() {
		return language1;
	}

	public void setLanguage1(String language1) {
		this.language1 = language1;
	}

	public void setOthers1(String others1) {
		this.others1 = others1;
	}

	public String getExperience1() {
		return experience1;
	}

	public String getAccountabilities1() {
		return accountabilities1;
	}

	public void setAccountabilities1(String accountabilities1) {
		this.accountabilities1 = accountabilities1;
	}

	public void setExperience1(String experience1) {
		this.experience1 = experience1;
	}
	
	public String getLanguages1() {
		return languages1;
	}

	public void setLanguages1(String languages1) {
		this.languages1 = languages1;
	}
	
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getLanguage() {
	return language;
	}
	public void setLanguage(String language) {
	this.language = language;
	}

	public String getSoftSkills() {
	return softSkills;
	}

	public void setSoftSkills(String softSkills) {
	this.softSkills = softSkills;
	}
	
	public String getEducation() {
		return education;
	}



	public void setEducation(String education) {
		this.education = education;
	}



	public String getLanguages() {
		return languages;
	}



	public void setLanguages(String languages) {
		this.languages = languages;
	}



	public String getExperience() {
		return experience;
	}



	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getOthers() {
		return others;
	}



	public void setOthers(String others) {
		this.others = others;
	}


	public String getAccountabilities() {
		return accountabilities;
	}


	public void setAccountabilities(String accountabilities) {
		this.accountabilities = accountabilities;
	}

	public String getGeneralDescription() {
		return generalDescription;
	}


	public void setGeneralDescription(String generalDescription) {
		this.generalDescription = generalDescription;
	}
	public String getiTTechnicalSkills() {
		return iTTechnicalSkills;
	}
	public void setiTTechnicalSkills(String iTTechnicalSkills) {
		this.iTTechnicalSkills = iTTechnicalSkills;
	}
	public String getTechnicalSkills() {
		return technicalSkills;
	}
	public void setTechnicalSkills(String technicalSkills) {
		this.technicalSkills = technicalSkills;
	}
	public String getExperiences() {
		return experiences;
	}
	public void setExperiences(String experiences) {
		this.experiences = experiences;
	}
	public String getYourSkills() {
		return yourSkills;
	}
	public void setYourSkills(String yourSkills) {
		this.yourSkills = yourSkills;
	}
	public String getOtherCriteriaOrRequirements() {
		return otherCriteriaOrRequirements;
	}
	public void setOtherCriteriaOrRequirements(String otherCriteriaOrRequirements) {
		this.otherCriteriaOrRequirements = otherCriteriaOrRequirements;
	}
	public String getEducation1() {
		return education1;
	}
	public void setEducation1(String education1) {
		this.education1 = education1;
	}
}
