package service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import data_access.MatchDA;
import model.Match;

@Path("/match")
public class MatchService extends BaseService {
	@GET
	@Path("/{idPlayer}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Match> readMatchesForPlayer(@PathParam(value = "idPlayer") int idPlayer) {
		List<Match> match = MatchDA.getMatchesForPlayer(idPlayer, null);
		return match;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMatch(Match match) throws URISyntaxException {
		MatchDA.insertMatch(match);
		return Response.created(new URI("/match/" + match.getId())).build();
	}
}
