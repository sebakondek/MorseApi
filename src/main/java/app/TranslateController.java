package app;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/translate")
public class TranslateController {
		
	@Autowired
	TranslateService translateService;

	@RequestMapping(value="2text", method=RequestMethod.POST)
	public String translate2Text (@RequestBody String text) throws IOException, JSONException{
		JSONObject json = new JSONObject(text.trim());
		
		json.put("code", HttpStatus.OK);
		json.put("response", translateService.translate2Human(json.getString("text")));
		json.remove("text");
		
		return json.toString();
	}
	
	@RequestMapping(value="2morse", method=RequestMethod.POST)
	public String translate2Morse (@RequestBody String text) throws IOException, JSONException{
		JSONObject json = new JSONObject(text.trim());
		
		json.put("code", HttpStatus.OK);
		json.put("response", translateService.translate2Morse(json.getString("text")));
		json.remove("text");
		
		return json.toString();
	}

}
