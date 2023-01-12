package com.cognixia.jump.DAO;

public class UserShow {
	private int userId;
	private int showId;
	private int lastWatched;
	/**
	 * @param userId
	 * @param showId
	 * @param lastWatched
	 */
	public UserShow(int userId, int showId, int lastWatched) {
		super();
		this.userId = userId;
		this.showId = showId;
		this.lastWatched = lastWatched;
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
	@Override
	public String toString() {
		return "UserShow [userId=" + userId + ", showId=" + showId + ", lastWatched=" + lastWatched + "]";
	}
	
	
}
