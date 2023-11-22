package com.wyden.banco.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wyden.banco.dao.ClienteDao;
import com.wyden.banco.entity.Cliente;
import com.wyden.banco.restapi.ClienteRestApi;

import jakarta.ws.rs.core.Response;

@Service
public class ClienteServices implements ClienteRestApi {

	public ClienteServices() {

	}

	@Override
	public List<Cliente> getClientes() {
		ClienteDao clienteDAO = new ClienteDao();
		return clienteDAO.getAll();
	}

	@Override
	public Cliente getCliente(String cpf) {
		ClienteDao clienteDAO = new ClienteDao();
		return clienteDAO.read(cpf);
	}

	@Override
	public Response createCliente(Cliente cliente) {
		ClienteDao clienteDAO = new ClienteDao();
		clienteDAO.create(cliente);
		return Response.ok(cliente).build();
	}

	@Override
	public Response updateCliente(Cliente cliente) {
		ClienteDao clienteDAO = new ClienteDao();
		clienteDAO.update(cliente);
		return Response.ok(cliente).build();
	}

	@Override
	public Response deleteCliente(String cpf) {
		ClienteDao clienteDAO = new ClienteDao();
		clienteDAO.delete(cpf);
		return Response.ok(cpf + " deletado com sucesso!").build();
	}

}
