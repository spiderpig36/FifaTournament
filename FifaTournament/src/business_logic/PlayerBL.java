package business_logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import data_access.MatchDA;
import data_access.PlayerDA;
import model.Match;
import model.Player;
import model.PlayerStats;

public class PlayerBL {
	public static List<PlayerStats> getPlayerStats(Date dateFrom) {
		List<PlayerStats> playersStats = new ArrayList<>();
		List<Player> players = PlayerDA.getAllPlayers();
		for (int i = 0; i < players.size(); i++) {
			Player player = players.get(i);
			PlayerStats playerStats = new PlayerStats(player);
			List<Match> matches = MatchDA.getMatchesForPlayer(player.getId(), dateFrom);
			for (Match match : matches) {
				if (match.getAwayscore() > match.getHomescore()) {
					if (match.getAwayPlayer().getId() == player.getId()) {
						playerStats.addWin();
					} else {
						playerStats.addDefeat();
					}
				} else {
					if (match.getAwayscore() < match.getHomescore()) {
						if (match.getHomePlayer().getId() == player.getId()) {
							playerStats.addWin();
						} else {
							playerStats.addDefeat();
						}
					} else {
						playerStats.addTie();
					}
				}
			}
			playersStats.add(playerStats);
		}
		return playersStats;
	}
}
