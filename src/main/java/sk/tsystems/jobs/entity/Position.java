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
