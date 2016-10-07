package service;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business_logic.PlayerBL;
import data_access.PlayerDA;
import model.Player;
import model.PlayerStats;

@Path("/player")
public class PlayerService extends BaseService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Player> readPlayers() {
		return PlayerDA.getAllPlayers();
	}

	@GET
	@Path("/stats")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PlayerStats> readPlayersStats() {
		return PlayerBL.getPlayerStats(null);
	}

	@GET
	@Path("/stats/dateFrom")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PlayerStats> readPlayersStatsFromDate(@QueryParam("dateFrom") String dateFrom) throws ParseException {
		return PlayerBL.getPlayerStats(PlayerService.dateFormat.parse(dateFrom));
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPlayer(Player player) throws URISyntaxException {
		PlayerDA.insertPlayer(player);
		return Response.created(new URI("/player/" + player.getId())).build();
	}

	@DELETE
	@Path("/{idPlayer}")
	public Response deletePlayer(@PathParam(value = "idPlayer") int idPlayer) {
		if (!PlayerDA.deletePlayer(idPlayer)) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.accepted().build();
	}
}
