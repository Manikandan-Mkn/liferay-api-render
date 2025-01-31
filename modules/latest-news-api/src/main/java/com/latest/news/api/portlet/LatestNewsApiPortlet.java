package com.latest.news.api.portlet;

import com.google.gson.JsonArray;
import com.latest.news.api.constants.LatestNewsApiPortletKeys;
import com.latest.news.service.NewsService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author USER
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=LatestNewsApi", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + LatestNewsApiPortletKeys.LATESTNEWSAPI,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class LatestNewsApiPortlet extends MVCPortlet {

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		// The AJAX request sends a cmd parameter, here we'll check for the "fetchNews"
		// command
		String cmd = ParamUtil.getString(resourceRequest, "cmd");
		System.out.println("print :::::" + cmd);
		if ("fetchNews".equalsIgnoreCase(cmd)) {
			NewsService newsService = new NewsService();
			String newsData = newsService.getTopNews(); // Fetch the news data
			JsonArray newsArray = newsService.parseNewsData(newsData); // Parse the data to extract articles

			// Set the response type to JSON
			resourceResponse.setContentType("application/json");
			PrintWriter writer = resourceResponse.getWriter();
			writer.write(newsArray.toString()); // Send the parsed JSON data
			writer.flush();
		} else {
			// Handle other commands (if any)
			super.serveResource(resourceRequest, resourceResponse);
		}
	}

	public String getTopNews() {
		final String API_KEY = "0ca85727c01e434f9d8cbb88e336254d"; // Replace with your API key
		final String API_URL = "\r\n" + 
				"https://newsapi.org/v2/everything?q=tesla&from=2025-01-31&sortBy=publishedAt&apiKey=0ca85727c01e434f9d8cbb88e336254d";
		StringBuilder response = new StringBuilder();
		try {
			//String urlString = API_URL + "?q=apple&from=2025-01-30&to=2025-01-30&sortBy=popularity&apiKey=" + API_KEY;
			URL url = new URL(API_URL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("GET");

			int responseCode = connection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // Success
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String inputLine;
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
			} else {
				System.out.println("GET request failed with response code: " + responseCode);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Response: " + response.toString()); // Log the response
		return response.toString();
	}

}