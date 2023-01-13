package com.cognixia.jump.DAO;

public class Show {
	private int showId;
	private String title;
	private int episodes;

	/**
	 * @param showId
	 * @param title
	 * @param episodes
	 */
	public Show(int showId, String title, int episodes) {
		super();
		this.showId = showId;
		this.title = title;
		this.episodes = episodes;
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
		return "Show [showId=" + showId + ", title=" + title + ", episodes=" + episodes + "]";
	}
	
	
}
