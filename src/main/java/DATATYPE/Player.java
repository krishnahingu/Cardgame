package DATATYPE;

public class Player implements Comparable<Player> {
	
	private int playerId;
	private String playerName;
	private int points;
	private String result;

	
	public Player(int id) {
		this.playerId = id;
	}
	
	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int compareTo(Player o) {
		if (this.getPoints() == o.getPoints()) {
			return 0;
		} else if (this.getPoints() > o.getPoints()) {
			return 1;
		} else
			return -1;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", playerName=" + playerName
				+  ", result=" + result + "]";
	}
	
	
}
