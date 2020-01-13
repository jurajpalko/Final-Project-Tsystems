package sk.tsystems.jobs.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Position {

	@Id
	@GeneratedValue
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


	
	
	public Position(String jobId, String positionTitle, String jobDescription, String requirementDescription,
			String employmentType, String positionURI, String applicationDeadline, String publicationStartDate, String positionBenefitname ) {
		

		this.jobId = jobId;
		this.positionTitle = positionTitle;
		this.jobDescription = jobDescription;
		this.requirementDescription = requirementDescription;
		this.employmentType = employmentType;
		this.positionURI = positionURI;
		this.applicationDeadline = applicationDeadline;
		this.publicationStartDate = publicationStartDate;
		this.positionBenefitname = positionBenefitname;
		
	}



	public Position() {
		
	}
	
	


	
	
	
}
