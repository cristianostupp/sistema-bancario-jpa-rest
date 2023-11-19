package com.stupp.restws;

import java.util.List;

import com.stupp.restws.model.Patient;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/patientservice")
public interface PatientService {
	
	@Path("/patients")
	@GET
	List<Patient> getPatients();
	
	@Path("/patients/{id}")
	@GET
	Patient getPatient(@PathParam("id") Long id);
	
	@Path("/patients")
	@POST
	Response createPatient(Patient patient);
	
	@Path("/patients")
	@PUT
	Response updatePatient(Patient patient);
	
	@Path("/patients/{id}")
	@DELETE
	Response deletePatient(@PathParam("id") Long id);
	
}
