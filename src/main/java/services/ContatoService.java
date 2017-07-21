package services;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.hibernate.HibernateException;
import org.springframework.ui.Model;

import model.BancoContatos;
import model.ContatoModelo;


@Path("/contatos")
//@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ContatoService {
	
	private static BancoContatos bancoContatos;
	
	public ContatoService(){
		bancoContatos = new BancoContatos();
	}
	
	@GET
	public static List<ContatoModelo> listaTodos() throws HibernateException, Exception {
		List<ContatoModelo> contato = BancoContatos.listarContato();
		return contato;
	}
	
	
	@GET
	@Path("{id}")
	public ContatoModelo encontrarContato(@PathParam("id") Integer id) throws HibernateException, Exception {
		ContatoModelo contato = BancoContatos.buscarContato(id);
		if (contato != null)
			return contato;
			throw new WebApplicationException(404);
	}
	
	@POST
	 public Response criarContato(ContatoModelo contato) {
		try {
			bancoContatos.addContato(contato);
		}
			catch (Exception e) {
				throw new WebApplicationException(Status.CONFLICT);
			}
		
		return Response.status(201).build();
	}
	
	@DELETE
	@Path("{id}")
	public static List<ContatoModelo> apagarContato(@PathParam("id") Integer id) throws HibernateException, Exception {
		ContatoModelo c = BancoContatos.buscarContato(id);
		return BancoContatos.deletarContato(id);
	}
	
	@PUT
	@Path("{id}")                                   
	public static ContatoModelo editarContato(ContatoModelo contato) throws HibernateException, Exception{
		return bancoContatos.addContato(contato);
	}
	
}