package com.wyden.banco.restapi;

import java.util.List;

import com.wyden.banco.entity.Cliente;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Consumes("application/json")
@Produces("application/json")
@Path("/cliente-api")
public interface ClienteRestApi {
	
	@Path("/clientes")
	@GET
	List<Cliente> getClientes();
	
	@Path("/clientes/{cpf}")
	@GET
	Cliente getCliente(@PathParam("cpf") String cpf);
	
	@Path("/clientes")
	@POST
	Response createCliente(Cliente cliente);
	
	@Path("/clientes")
	@PUT
	Response updateCliente(Cliente cliente);
	
	@Path("/clientes/{cpf}")
	@DELETE
	Response deleteCliente(@PathParam("cpf") String cpf);
	
}
