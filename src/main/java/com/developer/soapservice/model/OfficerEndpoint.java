package com.developer.soapservice.model;

import com.developer.soapservice.repository.OfficerRepository;
import com.developer.xml.generated.OfficerDetailsRequest;
import com.developer.xml.generated.OfficerDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class OfficerEndpoint {
	private static final String NAMESPACE_URI = "http://www.developer.com/xml/generated";

	@Autowired
	private OfficerRepository OfficerRepository;

	@Autowired
	public OfficerEndpoint(OfficerRepository OfficerRepository) {
		this.OfficerRepository = OfficerRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "OfficerDetailsRequest")
	@ResponsePayload
	public OfficerDetailsResponse getOfficer(@RequestPayload OfficerDetailsRequest request) {
		OfficerDetailsResponse response = new OfficerDetailsResponse();
		response.setOfficer(OfficerRepository.findOfficer(request.getName()));

		return response;
	}

}