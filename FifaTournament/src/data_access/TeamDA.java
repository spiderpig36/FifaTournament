package data_access;

import java.util.List;

import model.Team;

public class TeamDA {
	public static Team getTeam(int idTeam) {
		return (Team) DataAccess.read("FROM Team P WHERE P.id = " + idTeam).get(0);
	}

	public static List<Team> getAllTeams() {
		return (List<Team>) DataAccess.read("FROM Team");
	}

	public static void insertTeam(Team team) {
		DataAccess.save(team);
	}

	public static boolean deleteTeam(int idTeam) {
		return DataAccess.update("DELETE FROM Team T WHERE T.id = " + idTeam) != 0;
	}
}
