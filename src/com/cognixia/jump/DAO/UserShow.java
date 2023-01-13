package com.cognixia.jump.DAO;

public class UserShow {
	private int userId;
	private int showId;
	private String title;
	private int episodes;
	private int lastWatched;
	/**
	 * @param userId
	 * @param showId
	 * @param lastWatched
	 */
	public UserShow(int userId, String title, int episodes, int lastWatched) {
		super();
		this.userId = userId;
		this.lastWatched = lastWatched;
		this.title = title;
		this.episodes = episodes;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the showId
	 */
	public int getShowId() {
		return showId;
	}
	/**
	 * @param showId the showId to set
	 */
	public void setShowId(int showId) {
		this.showId = showId;
	}
	/**
	 * @return the lastWatched
	 */
	public int getLastWatched() {
		return lastWatched;
	}
	/**
	 * @param lastWatched the lastWatched to set
	 */
	public void setLastWatched(int lastWatched) {
		this.lastWatched = lastWatched;
	}
	
	/**
	 * @return the episodes
	 */
	public int getEpisodes() {
		return episodes;
	}
	/**
	 * @param episodes the episodes to set
	 */
	public void setEpisodes(int episodes) {
		this.episodes = episodes;
	}
	@Override
	public String toString() {
		return "UserShow [userId=" + userId + ", title=" + title + ", episodes=" + episodes
				+ ", lastWatched=" + lastWatched + "]";
	}
	

	
}
