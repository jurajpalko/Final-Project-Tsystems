package sk.tsystems.jobs.entity;

import java.util.Date;

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
	private String jobDescription;
	private String requirementDescription;
//  zatial bez typu DATE. 	
//	private Date publicationStartDay;
//	private Date applicationDeadline;
	//PositionSchedule
	private String employmentType;
	private String positionURI;
	
	
	
	public Position(String jobId, String positionTitle, String jobDescription, String requirementDescription,
			// Date publicationStartDay, Date applicationDeadline,
			String employmentType, String positionURI) {
		
		
// ident sa tu nepise lebo je @GeneratedValue		this.ident = ident;
		this.jobId = jobId;
		this.positionTitle = positionTitle;
		this.jobDescription = jobDescription;
		this.requirementDescription = requirementDescription;
//		this.publicationStartDay = publicationStartDay;
//		this.applicationDeadline = applicationDeadline;
		this.employmentType = employmentType;
		this.positionURI = positionURI;
	}



	public Position() {
		
	}
	
	


	
	
	
}
