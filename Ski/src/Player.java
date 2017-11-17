/**
 * Created by E6410 on 13.11.2017.
 */
public class Player implements Comparable<Player>{
    private String playerName;
    private long time;

    public Player(String playerName, long time) {
        this.playerName = playerName;
        this.time = time;
    }

    public Player() {
    }
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", time=" + time +
                '}';
    }

	@Override
	public int compareTo(Player arg0) {
		return arg0.getTime()< time ? 0 : -1;
	}
}
