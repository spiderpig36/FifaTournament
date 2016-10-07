package data_access;

import java.util.Date;
import java.util.List;

import model.Match;

public class MatchDA {

	public static List<Match> getMatchesForPlayer(int idPlayer, Date dateFrom) {
		if (dateFrom == null) {
			return (List<Match>) DataAccess.read("FROM Match M WHERE M.homePlayer = " + idPlayer + "OR M.awayPlayer = " + idPlayer);
		} else {
			return (List<Match>) DataAccess
					.read("FROM Match M WHERE (M.homePlayer = " + idPlayer + "OR M.awayPlayer = " + idPlayer + ") AND M.timestamp >= '" + DataAccess.hqlDateFormat.format(dateFrom) + "'");
		}
	}

	public static void insertMatch(Match match) {
		DataAccess.save(match);
	}
}
