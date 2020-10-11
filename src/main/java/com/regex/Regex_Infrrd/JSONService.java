package com.regex.Regex_Infrrd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.simple.JSONObject;

@Path("/regex")
public class JSONService implements Runnable {

	@POST // http annotations
	@Path("/post")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response checkRegex(Regex_POJO rg) {
		JSONService serviceObject = new JSONService();
		Thread thread = new Thread(serviceObject); // create new thread
		thread.start(); // Starting the thread

		String textbody = rg.getText(); // getting the regex & text variables via POJO
		String regex = rg.getRegex();
		String error = "False";
		String match = null;
		JSONObject obj = new JSONObject(); // Creating JSONObject
		int startIndex = 0;

		try {
			Pattern pattern = Pattern.compile(regex); // compiling Regular Expression
			Matcher matcher = pattern.matcher(textbody); // matching the regex with input text
			int count = 0;

			while (matcher.find()) { // will run till text input has matching pattern as per regex
				count++;
				startIndex = matcher.start(); // get the index of the first occurrence

			}
			if (count > 0) {
				obj.put("match", startIndex); // Creating output JSON in case of match found
				obj.put("error", error);

			} else {
				obj.put("match", match); // creating output JSON in case of no match found
				obj.put("error", error); 

			}

		} catch (Exception e) {
			obj.put("match", match); // creating output JSON in case of bad regex/compilation error
			obj.put("error", "True");
			System.out.print("exception occured" + e);
		}

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			obj.put("match", match); // creating output JSON in case of interrupted exception or evil regex
			obj.put("error", "True");
			System.out.print("Interrupted thread exception occured" + e);

		}
		thread.interrupt(); // Interrupting the thread

		return Response.status(201).entity(obj).build(); // returning output as JSON Object

	}

	@Override
	public void run() { // executing the thread via Run method
		System.out.print("Run method Called");

	}

}