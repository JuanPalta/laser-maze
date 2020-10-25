package model;

public class User {
	
	private String nickname;
	private int score;
	
	public User(String nickname) {
		this.setNickname(nickname);
		score = 0;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
