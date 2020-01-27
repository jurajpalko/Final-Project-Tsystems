package sk.tsystems.jobs.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import sk.tsystems.jobs.entity.Position;
import sk.tsystems.jobs.service.PositionService;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
public class MainController {

	@Autowired
	private ServletContext servletContext;

	@RequestMapping("/")
	public String index() {

		return "index";
	}

	@RequestMapping("/update")
	public String updateWeb() throws Exception {
		update();
		return "index";
	}

	@Autowired
	private PositionService positionService;

	private static final String QR_FOLDER = System.getProperty("java.io.tmpdir");

	@Scheduled(fixedRate = 10000000)
	public void update() throws IOException, ParseException {

		JSONObject jsonObject = null;

		String jsonString = jsonPostRequest();
		JSONParser parser = new JSONParser();
		jsonObject = (JSONObject) parser.parse(jsonString);

		if (jsonObject != null) {

			JSONObject searchResult = (JSONObject) jsonObject.get("SearchResult");

			Long numberOfJobs = (Long) searchResult.get("SearchResultCount");

			JSONArray allJobs = (JSONArray) searchResult.get("SearchResultItems");

			// DELETING CONTENT OF IMG/QRs FOLDER
			// Arrays.stream(new
			// File("src/main/resources/static/img/QRs/").listFiles()).forEach(File::delete);
			// System.out.println("Images Deleted");
			//

			int numberOfDeletedRows = positionService.deleteAllFromTable();
			clearSavedData(numberOfDeletedRows);
			int ident = 1;

			for (int i = 0; i < numberOfJobs; i++) {
				String jobId = null;
				String positionTitle = null;
				String jobDescription = null;
				String requirementDescription = null;
				String employmentType = null;
				String positionURI = null;
				String applicationDeadline = null;
				String publicationStartDate = null;
				String positionBenefitname = null;
				String salary = null;
				String qrCodeImage = null;

				JSONObject job = (JSONObject) allJobs.get(i);
				JSONObject matchedObjectDescriptor = (JSONObject) job.get("MatchedObjectDescriptor");
				jobId = (String) matchedObjectDescriptor.get("PositionID");
				positionTitle = (String) matchedObjectDescriptor.get("PositionTitle");
				JSONObject userArea = (JSONObject) matchedObjectDescriptor.get("UserArea");
				jobDescription = (String) userArea.get("TextJobDescription");

				if (jobDescription != null) {

					requirementDescription = (String) userArea.get("TextRequirementDescription");
					salary = findSalary(requirementDescription, jobDescription);

					jobDescription = jobDescription.replaceAll("<p>&nbsp;</p>", "");
					jobDescription = jobDescription.replaceAll("<p> </p>", "");
					Document docJobDescription = Jsoup.parse(jobDescription);

					requirementDescription = (String) userArea.get("TextRequirementDescription");
					requirementDescription = requirementDescription.replaceAll("<p>&nbsp;</p>", "");
					requirementDescription = requirementDescription.replaceAll("<p> </p>", "");
					Document docRequirementDescription = Jsoup.parse(requirementDescription);

					

					jobDescription = jobDescriptionFinal(jobDescription);

					publicationStartDate = (String) matchedObjectDescriptor.get("PublicationStartDate");
					JSONArray positionSchedule = (JSONArray) matchedObjectDescriptor.get("PositionSchedule");
					if (positionSchedule.size() > 0) {
						JSONObject positionScheduleFirstObject = (JSONObject) positionSchedule.get(0);
						employmentType = (String) positionScheduleFirstObject.get("Name");
					}
					JSONArray positionBenefit = (JSONArray) matchedObjectDescriptor.get("PositionBenefit");
					if (positionBenefit.size() > 0) {
						JSONObject positionBenefitFirstObject = (JSONObject) positionBenefit.get(0);
						positionBenefitname = (String) positionBenefitFirstObject.get("Name");
					}

					positionURI = "https://t-systems.jobs/global-careers-en/"
							+ (String) matchedObjectDescriptor.get("PositionURI");
					applicationDeadline = (String) matchedObjectDescriptor.get("ApplicationDeadline");

					try {
						generateQRCodeImage(positionURI, 350, 350, QR_FOLDER + ident + ".png");
						System.err.println(QR_FOLDER + ident + ".png" + " saved ");

						qrCodeImage = "<img class='qr-code-img bg-light' src='" + servletContext.getContextPath()
								+ "/qrcode?number=" + ident + "' alt='Qr code image.'/>";
					} catch (WriterException e) {
						System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
					} catch (IOException e) {
						System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
					}

					Position p = new Position(ident, jobId, positionTitle, jobDescription, requirementDescription,
							employmentType, positionURI, applicationDeadline, publicationStartDate, positionBenefitname,
							salary, qrCodeImage);
					positionService.addPosition(p);

					// IDENT OF LAST ADDED POSITION
					// int ident = p.getIdent();
					//

					// SAVING QR CODE OF THE POSITION

					ident++;

				}
			}

		}

	}

	private String jobDescriptionFinal(String jobDescription) {
		jobDescription = Jsoup.parse(jobDescription).text();
		jobDescription = jobDescription.replaceAll("General description/ Purpose", "");
		jobDescription = jobDescription.replaceAll("General description/", "");
		jobDescription = jobDescription.replaceAll("General description", "");
		jobDescription = jobDescription.replaceAll("General Description/ Purpose", "");
		jobDescription = jobDescription.replaceAll("General Description/", "");
		jobDescription = jobDescription.replaceAll("General Description", "");
		jobDescription = jobDescription.replaceAll("Purpose", "");
		jobDescription = jobDescription.replaceAll("•", "");
		jobDescription = jobDescription.substring(0, 150);
		for (int i = jobDescription.length() - 1; i > 0; i--) {
			if ((jobDescription.charAt(i)) == ' ') {
				return (jobDescription.substring(0, i).trim() + "...");
			}
		}
		return jobDescription;
	}

	private void findElementWhenTextIsInStrong(Document doc, String text) {
		if (doc.select("p>strong:contains(" + text + ")").text().length() > (text.length() + 10)) {

			System.out.println("-------------------------------------------");
			System.out.println(doc.select("p>strong:contains(" + text + ")").toString());
			System.out.println("-------------------------------------------");

		}
		// return "nejaky string";
	}

	private String findElement(Document doc, String text) {
		if (doc.select("p:matchesOwn((?i)" + text + ")").text().length() > (text.length() + 10)) {
			return (doc.select("p:matchesOwn((?i)" + text + ")").text().toString());
		} else {
			return (doc.select("p:matchesOwn((?i)" + text + ")").next().text().toString());
		}
	}

	private String findSalary(String str1, String str2) {
		String salary;
		salary = selectAllFrom(str1, "Salary");
		salary = salaryRegExp(salary);
		if (salary == null) {
			salary = selectAllFrom(str2, "Salary");
			salary = salaryRegExp(salary);
		}
		return salary;
	}

	private String salaryRegExp(String salary) {
		if (salary != null) {
			Pattern pattern = Pattern.compile("(\\D)+([0-9]){3,4}(.*)");
			Matcher matcher = pattern.matcher(salary);
			if (matcher.matches()) {
				int beggining = matcher.end(1);
				salary = salary.substring(beggining, beggining + 4);
				if (!Character.isDigit(salary.charAt(3)))
					salary = salary.substring(0, 3);
				return salary;
			}
		}
		return null;
	}

	private static String deleteAllFrom(String mainString, String subString) {
		String subStringUpperCase = subString.toUpperCase();
		if (mainString != null) {
			String mainStringUpperCase = mainString.toUpperCase();
			int positionOfSubstring = mainStringUpperCase.indexOf(subStringUpperCase);
			if (positionOfSubstring != -1) {
				mainString = mainString.substring(0, positionOfSubstring);
				int positionOfpstrong = mainString.lastIndexOf("<p><strong>");
				if (positionOfpstrong != -1) {
					mainString = mainString.substring(0, positionOfpstrong);
				}
			}
		}
		return mainString;
	}

	private static String selectAllFrom(String mainString, String subString) {

		String subStringUpperCase = subString.toUpperCase();
		if (mainString != null) {
			String mainStringUpperCase = mainString.toUpperCase();
			int positionOfSubstring = mainStringUpperCase.indexOf(subStringUpperCase);
			if (positionOfSubstring != -1) {
				subString = mainString.substring(positionOfSubstring);
				subString = "<p><strong>" + subString;
				return subString;
			}
		}

		return null;
	}

	private void clearSavedData(int deleted) {
		Path path = FileSystems.getDefault().getPath(QR_FOLDER + "1" + ".png");
		if (Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
			try {
				for (int index = 1; index <= deleted; index++) {
					Path file = FileSystems.getDefault().getPath(QR_FOLDER + index + ".png");
					Files.delete(file);
					System.err.println(QR_FOLDER + index + ".png" + " DELETED");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	// METHOD FOR GENERATING QR CODES
	private static void generateQRCodeImage(String text, int width, int height, String filePath)
			throws WriterException, IOException {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

		Path path = FileSystems.getDefault().getPath(filePath);
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

	}

	public String jsonPostRequest() throws IOException {

		URL url = new URL("https://t-systems.jobs/globaljobboard_api/v3/search/");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json; utf-8");
		con.setRequestProperty("Accept", "application/json");
		con.setDoOutput(true);

		String jsonInputString = "{\"JobadID\":\"\",\"LanguageCode\":\"2\",\"SearchParameters\":{\"FirstItem\":1,\"CountItem\":250,\"Sort\":[{\"Criterion\":\"FavoriteJobIndicator\",\"Direction\":\"DESC\"}],\"MatchedObjectDescriptor\":[\"ID\",\"RelevanceRank\",\"PositionID\",\"PositionTitle\",\"ParentOrganization\",\"ParentOrganizationName\",\"PositionURI\",\"PositionLocation.CountryName\",\"PositionLocation.CountrySubDivisionName\",\"PositionLocation.CityName\",\"PositionLocation.Longitude\",\"PositionLocation.Latitude\",\"PositionIndustry.Name\",\"JobCategory.Name\",\"CareerLevel.Name\",\"PositionSchedule.Name\",\"PublicationStartDate\",\"UserArea.TextWorkingHoursPerWeek\",\"PublicationEndDate\",\"ApplicationDeadline\",\"UserArea.TextRequiredWorkExperience\",\"UserArea.TextTravel\",\"UserArea.TextRequiredLanguageSkills\",\"UserArea.TextJobDescription\",\"UserArea.TextRequirementDescription\",\"PositionBenefit.Code\",\"PositionBenefit.Name\",\"FavoriteJobIndicator\",\"FavoriteJobIndicatorName\",\"PositionStartDate\",\"Partnerhochschule\"]},\"SearchCriteria\":[{\"CriterionName\":\"PositionLocation.Latitude\",\"CriterionValue\":[\"48.7163857\"]},{\"CriterionName\":\"PositionLocation.Longitude\",\"CriterionValue\":[\"21.2610746\"]},{\"CriterionName\":\"PositionLocation.Distance\",\"CriterionValue\":[\"13.975119302957982\"]},{\"CriterionName\":\"PositionLocation.CountryCode\",\"CriterionValue\":[\"SK\"]},{\"CriterionName\":\"PositionLocation.AreaCode\",\"CriterionValue\":[\"SK\"]},{\"CriterionName\":\"ParentOrganization\",\"CriterionValue\":[\"1070\",\"1099\",\"1104\",\"1158\",\"2922\",\"1165\",\"1175\",\"1176\",\"1207\",\"1234\",\"1235\",\"1236\",\"1237\",\"1238\",\"1239\",\"1240\",\"1241\",\"1242\",\"1243\",\"1244\",\"1245\",\"1246\",\"1247\",\"1248\",\"1249\",\"7834\",\"7814\",\"1250\",\"1251\",\"1252\",\"1253\",\"1254\",\"1255\",\"1256\",\"1257\",\"1258\",\"1259\",\"2923\",\"1260\",\"1261\",\"1262\",\"1263\",\"1264\",\"1265\",\"2924\",\"1268\",\"1269\",\"2925\",\"2926\",\"1273\",\"1274\",\"1275\",\"1276\",\"2927\",\"5460\",\"1278\",\"1279\",\"1280\",\"1281\",\"1282\",\"1283\"]},{\"CriterionName\":\"PositionLocation.City\",\"CriterionValue\":[\"Košice, Slovakia\"]},{\"CriterionName\":\"PositionLocation.Country\",\"CriterionValue\":[\"29\"]},{\"CriterionName\":\"CareerLevel.Code\",\"CriterionValue\":[\"2\",\"5\",\"7\"]},{\"CriterionName\":\"PublicationLanguage.Code\",\"CriterionValue\":[\"2\",\"19\"]}]}";

		try (OutputStream os = con.getOutputStream()) {
			byte[] input = jsonInputString.getBytes("utf-8");
			os.write(input, 0, input.length);
		}

		try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
			return response.toString();
		}
	}

	public List<Position> getAll() {
		return positionService.getAllPositions();
	}

	public List<Position> getPositionList() {

		return positionService.getPositionList();
	}

	public Position getPosition() {
		return positionService.getPosition(1);
	}

	public long getCountOffers() {
		return positionService.getAllCountOffers();
	}

	@RequestMapping(value = "/qrcode", method = RequestMethod.GET)
	public void getQrCode(HttpServletResponse response, int number) throws IOException {
		if (number > 0 && number <= getAll().size()) {
			InputStream in = new FileInputStream(QR_FOLDER + number + ".png");
			response.setContentType(MediaType.IMAGE_PNG_VALUE);
			OutputStream os = response.getOutputStream();
			IOUtils.copy(in, os);
		}
	}
	
}

//  selected data by jsoup
//	from strong element
//	String languages = docRequirementDescription.select("p>strong:contains(Languages)").parents().next().toString();
//	String education = docRequirementDescription.select("p>strong:contains(Education)").parents().next().toString();
//	String experience = docRequirementDescription.select("p>strong:contains(experience)").parents().next().toString();
//	String others = docRequirementDescription.select("p>strong:contains(others)").parents().next().toString();
//	String accountabilities = docJobDescription.select("p>strong:contains(accountabilities)").parents().next()
//			.toString();
//	String generalDescription = docJobDescription.select("p>strong:contains(general description)").parents().next()
//			.toString();
//	String softSkills = docRequirementDescription.select("p>strong:contains(soft Skills)").parents().next().toString();
//	String iTTechnicalSkills = docRequirementDescription.select("p>strong:contains(IT Technical Skills)").parents().next()
//			.toString();
//	String technicalSkills = docRequirementDescription.select("p>strong:contains(Technical Skills)").parents().next()
//			.toString();
//	String language = docRequirementDescription.select("p>strong:contains(language)").parents().next().toString();
//	String experiences = docRequirementDescription.select("p>strong:contains(experiences)").parents().next().toString();
//	String yourSkills = docRequirementDescription.select("p>strong:contains(Your skills)").parents().next().toString();
//	String otherCriteriaOrRequirements = docRequirementDescription
//			.select("p>strong:contains(Other criteria or requirements)").parents().next().toString();
//	String purpose = docJobDescription.select("p>strong:contains(purpose)").parents().next().toString();
//  
//  selected data by regular expression if description is inside p element
	
//	String education1 = docRequirementDescription.select("p:matchesOwn((?i)education)").next().toString();
//	String languages1 = docRequirementDescription.select("p:matchesOwn((?i)languages)").next().toString(); 
//	String experience1 = docRequirementDescription.select("p:matchesOwn((?i)experience)").next().toString();
//	String others1 = docRequirementDescription.select("p:matchesOwn((?i)others)").next().toString();
//	String accountabilities1 = docJobDescription.select("p:matchesOwn((?i)accountabilities)").next().toString();
//	String language1 = docRequirementDescription.select("p:matchesOwn((?i)language)").next().toString();
//	String experiences1 = docRequirementDescription.select("p:matchesOwn((?i)experiences)").next().toString(); 
//	String generalDescription1 = docJobDescription.select("p:matchesOwn((?i)general description)").next().toString();
//	String softSkills1 = docRequirementDescription.select("p:matchesOwn((?i)soft Skills)").next().toString();
//	String iTTechnicalSkills1 = docRequirementDescription.select("p:matchesOwn((?i)IT Technical Skills)").next().toString();																					
//	String technicalSkills1 = docRequirementDescription.select("p:matchesOwn((?i)Technical Skills)").next().toString();
//	String yourSkills1 = docRequirementDescription.select("p:matchesOwn((?i)Your skills)").next().toString();
//	String otherCriteriaOrRequirements1 = docRequirementDescription.select("p:matchesOwn((?i)Other criteria or requirements)").next().toString();
//	String purpose1 = docJobDescription.select("p:matchesOwn((?i)Purpose)").next().toString();
//
//	selected data by findElement method
	
//	String language1 = findElement(docRequirementDescription, "language");
//	String education1 = findElement(docRequirementDescription, "education");
//	String experience1 = findElement(docRequirementDescription, "experience");
//	String others1 = findElement(docRequirementDescription, "others");
//	String accountabilities1 = findElement(docJobDescription, "accountabilities");
//	String generalDescription1 = findElement(docJobDescription, "general description");
//	String softSkills1 = findElement(docRequirementDescription, "Soft Skills");
//	String technicalSkills1 = findElement(docRequirementDescription, "Technical Skills");
//	String yourSkills1 = findElement(docRequirementDescription, "Your Skills");
//	String otherCriteriaOrRequirements1 = findElement(docRequirementDescription, "Other criteria or requirements");
//	String purpose1 = findElement(docRequirementDescription, "Purpose");

