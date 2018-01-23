package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.demo.dao.StudentRepository;
import com.example.demo.model.StudentDetailsRequest;
import com.example.demo.model.StudentDetailsResponse;

@Endpoint
public class StudentEndpoint {
	
		private static final String NAMESPACE_URI = "http://service.demo.example.com";

		private StudentRepository studentRepository;

		@Autowired
		public StudentEndpoint(StudentRepository stuRepository) {
			this.studentRepository = stuRepository;
		}

		@PayloadRoot(namespace = NAMESPACE_URI, localPart = "StudentDetailsRequest")
		@ResponsePayload
		public StudentDetailsResponse getStudent(@RequestPayload StudentDetailsRequest request) {
			StudentDetailsResponse response = new StudentDetailsResponse();
			response.setStudent(studentRepository.findStudent(request.getName()));

			return response;
		}
	}