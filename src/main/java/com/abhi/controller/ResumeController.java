package com.abhi.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abhi.dao.Resume;

@Controller
public class ResumeController {
	
	@RequestMapping(value = "/resume", method = RequestMethod.GET)
	@ResponseBody
	public Resume resume(){	
		return new Resume();	
	}
	
	
	@RequestMapping(value="/resume/pdf", method=RequestMethod.GET)
	public ResponseEntity<byte[]> getPDF() {
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.parseMediaType("application/pdf"));
	    String filename = "resume.pdf";
	    headers.setContentDispositionFormData(filename, filename);
	    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
	    ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(Resume.resume_buffer, headers, HttpStatus.OK);
	    return response;
	    
	}
	
}
