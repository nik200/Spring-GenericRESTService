package util.generic.service;

import generic.spring.implementations.GenericSpringService;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/RestWebService")
public class GenericServiceController {

	private static final Logger logger = LoggerFactory.getLogger(GenericServiceController.class);


	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		return "Hello World!!!";
	}

	@RequestMapping(value="{serviceName}/{operationName}", method = RequestMethod.POST, consumes = "application/xml", produces = "application/xml")
	@ResponseBody
	public String method(@PathVariable Map<String,String> pathVars, @RequestBody String postPayload, @RequestHeader(value="SoapAction", defaultValue="na") String soapAction){
		
		return GenericSpringService.baseMethod(pathVars.get("serviceName"), 
				pathVars.get("operationName"), soapAction,postPayload);

	}




}