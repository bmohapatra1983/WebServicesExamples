package com.biswa.service;

import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.client.RestTemplate;

import com.biswa.entity.Employee;
import com.google.gson.Gson;
@Service
public class EmployeeConsumeServiceImpl implements EmployeeConsumeService {
	public static final String REST_URL = "http://localhost:8088/RESTApi/getAllEmployee";

	private static HttpHeaders getHeaders() {
		String plainCredentials = "admin:admin";
		String base64Credentials = new String(Base64Utils.encode(plainCredentials.getBytes()));
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Credentials);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return headers;
	}

	@Override
	public ResponseEntity<String> consumeJsonData() {
		System.out.println("-------------Biswa---------------------23------");
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> request = new HttpEntity<String>(getHeaders());
		ResponseEntity<String> userResponse = restTemplate.exchange(REST_URL, HttpMethod.GET, request, String.class);
		String body = userResponse.getBody();
		MediaType contentType = userResponse.getHeaders().getContentType();
		HttpStatus statusCode = userResponse.getStatusCode();
		System.out.println("body ::" + body);
		System.out.println("contentType ::" + contentType);
		System.out.println("statusCode ::" + statusCode);
		try {
			Gson gson = new Gson();
			JSONArray jsonArray = new JSONArray(body);
			int len = jsonArray.length();
			System.out.println(len);
			for (int i = 0; i < len; i++) {
				JSONObject dataObj = jsonArray.getJSONObject(i);
				Employee employeeEntity = gson.fromJson(dataObj.toString(), Employee.class);
				System.out.println(employeeEntity);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return userResponse;
	}
}
