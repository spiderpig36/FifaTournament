package data_access;

import java.util.List;

import model.Player;

public class PlayerDA {

	public static Player getPlayer(int idPlayer) {
		return (Player) DataAccess.read("FROM Player P WHERE P.id = " + idPlayer).get(0);
	}

	public static List<Player> getAllPlayers() {
		return (List<Player>) DataAccess.read("FROM Player");
	}

	public static void insertPlayer(Player player) {
		DataAccess.save(player);
	}

	public static boolean deletePlayer(int idPlayer) {
		return DataAccess.update("DELETE FROM Player P WHERE P.id = " + idPlayer) != 0;
	}
}
