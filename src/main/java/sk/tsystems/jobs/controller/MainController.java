package sk.tsystems.jobs.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import sk.tsystems.jobs.entity.Position;
import sk.tsystems.jobs.service.PositionService;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
public class MainController {

	@RequestMapping("/")
	public String index() {

		return "index";
	}

	@Autowired
	private PositionService positionService;

	@RequestMapping("/update")
	public String update(Position position) throws IOException, ParseException {

		JSONObject jsonObject = null;

		String jsonString = jsonPostRequest();
		JSONParser parser = new JSONParser();
		jsonObject = (JSONObject) parser.parse(jsonString);
		JSONObject searchResult = (JSONObject) jsonObject.get("SearchResult");
		Long numberOfJobs = (Long) searchResult.get("SearchResultCount");
		JSONArray allJobs = (JSONArray) searchResult.get("SearchResultItems");

		if (jsonObject != null) {

			int numberOfDeletedRows = positionService.deleteAllFromTable();

			for (int i = 0; i < numberOfJobs; i++) {
				String jobId = null;
				String positionTitle = null;
				String jobDescription = null;
				String requirementDescription = null;
				String employmentType = null;
				String positionURI = null;
				String applicationDeadline = null;
				String publicationStartDate = null;

				JSONObject job = (JSONObject) allJobs.get(i);
				JSONObject matchedObjectDescriptor = (JSONObject) job.get("MatchedObjectDescriptor");
				jobId = (String) matchedObjectDescriptor.get("ID");
				positionTitle = (String) matchedObjectDescriptor.get("PositionTitle");
				JSONObject userArea = (JSONObject) matchedObjectDescriptor.get("UserArea");
				jobDescription = (String) userArea.get("TextJobDescription");
				requirementDescription = (String) userArea.get("TextRequirementDescription");
				publicationStartDate = (String) matchedObjectDescriptor.get("PublicationStartDate");
				JSONArray positionSchedule = (JSONArray) matchedObjectDescriptor.get("PositionSchedule");
				if (positionSchedule.size() > 0) {
					JSONObject positionScheduleFirstObject = (JSONObject) positionSchedule.get(0);
					employmentType = (String) positionScheduleFirstObject.get("Name");
				}
				positionURI = (String) matchedObjectDescriptor.get("PositionURI");
				applicationDeadline = (String) matchedObjectDescriptor.get("ApplicationDeadline");

				Position p = new Position(jobId, positionTitle, jobDescription, requirementDescription, employmentType,
						positionURI, applicationDeadline, publicationStartDate);
				positionService.addPosition(p);

			}

		}

		return "index";
	}

	public String jsonPostRequest() throws IOException {

		URL url = new URL("https://t-systems.jobs/globaljobboard_api/v3/search/");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json; utf-8");
		con.setRequestProperty("Accept", "application/json");
		con.setDoOutput(true);

		String jsonInputString = "{\"JobadID\":\"\",\"LanguageCode\":\"2\",\"SearchParameters\":{\"FirstItem\":1,\"CountItem\":250,\"Sort\":[{\"Criterion\":\"FavoriteJobIndicator\",\"Direction\":\"DESC\"}],\"MatchedObjectDescriptor\":[\"ID\",\"RelevanceRank\",\"PositionID\",\"PositionTitle\",\"ParentOrganization\",\"ParentOrganizationName\",\"PositionURI\",\"PositionLocation.CountryName\",\"PositionLocation.CountrySubDivisionName\",\"PositionLocation.CityName\",\"PositionLocation.Longitude\",\"PositionLocation.Latitude\",\"PositionIndustry.Name\",\"JobCategory.Name\",\"CareerLevel.Name\",\"PositionSchedule.Name\",\"PublicationStartDate\",\"UserArea.TextWorkingHoursPerWeek\",\"PublicationEndDate\",\"ApplicationDeadline\",\"UserArea.TextRequiredWorkExperience\",\"UserArea.TextTravel\",\"UserArea.TextRequiredLanguageSkills\",\"UserArea.TextJobDescription\",\"UserArea.TextRequirementDescription\",\"PositionBenefit.Code\",\"PositionBenefit.Name\",\"FavoriteJobIndicator\",\"FavoriteJobIndicatorName\",\"PositionStartDate\",\"Partnerhochschule\"]},\"SearchCriteria\":[{\"CriterionName\":\"PositionLocation.Latitude\",\"CriterionValue\":[\"48.7163857\"]},{\"CriterionName\":\"PositionLocation.Longitude\",\"CriterionValue\":[\"21.26107460000003\"]},{\"CriterionName\":\"PositionLocation.Distance\",\"CriterionValue\":[\"13.975119302957149\"]},{\"CriterionName\":\"PositionLocation.CountryCode\",\"CriterionValue\":[\"SK\"]},{\"CriterionName\":\"PositionLocation.AreaCode\",\"CriterionValue\":[\"SK\"]},{\"CriterionName\":\"ParentOrganization\",\"CriterionValue\":[\"1070\",\"1099\",\"1104\",\"1158\",\"2922\",\"1165\",\"1175\",\"1176\",\"1207\",\"1234\",\"1235\",\"1236\",\"1237\",\"1238\",\"1239\",\"1240\",\"1241\",\"1242\",\"1243\",\"1244\",\"1245\",\"1246\",\"1247\",\"1248\",\"1249\",\"7834\",\"7814\",\"1250\",\"1251\",\"1252\",\"1253\",\"1254\",\"1255\",\"1256\",\"1257\",\"1258\",\"1259\",\"2923\",\"1260\",\"1261\",\"1262\",\"1263\",\"1264\",\"1265\",\"2924\",\"1268\",\"1269\",\"2925\",\"2926\",\"1273\",\"1274\",\"1275\",\"1276\",\"2927\",\"5460\",\"1278\",\"1279\",\"1280\",\"1281\",\"1282\",\"1283\"]}]}";

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

}
