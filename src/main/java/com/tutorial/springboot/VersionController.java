package com.tutorial.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("version")
public class VersionController {
	private static final Logger LOG = LoggerFactory.getLogger(VersionController.class);

	@GetMapping("latest")
	public ResponseEntity<Resource> retrieveLatestVersion() throws Exception {

		Resource stateFile = new ClassPathResource("version.txt");
		LOG.info("Read File:{}", stateFile.contentLength());

		return ResponseEntity.ok().contentLength(stateFile.contentLength())
				.contentType(MediaType.parseMediaType("application/octet-stream")).body(stateFile);

	}

}
