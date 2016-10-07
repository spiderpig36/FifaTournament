package service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import data_access.TeamDA;
import model.Team;

@Path("/team")
public class TeamService extends BaseService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Team> readTeams() {
		return TeamDA.getAllTeams();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addTeam(Team team) throws URISyntaxException {
		TeamDA.insertTeam(team);
		return Response.created(new URI("/team/" + team.getId())).build();
	}

	@DELETE
	@Path("/{idTeam}")
	public Response deletePlayer(@PathParam(value = "idTeam") int idTeam) {
		if (!TeamDA.deleteTeam(idTeam)) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.accepted().build();
	}
}
