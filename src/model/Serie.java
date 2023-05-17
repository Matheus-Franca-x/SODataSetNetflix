package model;

import java.util.Objects;

public class Serie 
{
	private String major_genre;
	private String title;
	private String subgente;
	private int premiere_year;
	private String episodes;
	private String status;
	private int imdb_rating;
	
	public Serie(String major, String title, String subgente, int year, String ep, String status, int imdb)
	{
		this.major_genre = major;
		this.title = title;
		this.subgente = subgente;
		this.premiere_year = year;
		this.episodes = ep;
		this.status = status;
		this.imdb_rating = imdb;
	}

	public String getMajor_genre() {
		return major_genre;
	}

	public String getTitle() {
		return title;
	}

	public String getSubgente() {
		return subgente;
	}

	public int getPremiere_year() {
		return premiere_year;
	}

	public String getEpisodes() {
		return episodes;
	}

	public String getStatus() {
		return status;
	}

	public int getImdb_rating() {
		return imdb_rating;
	}

	@Override
	public String toString() {
		return "Serie [major_genre=" + major_genre + ", title=" + title + ", subgente=" + subgente + ", premiere_year="
				+ premiere_year + ", episodes=" + episodes + ", status=" + status + ", imdb_rating=" + imdb_rating
				+ "]";
	}

	@Override
	public int hashCode() 
	{
		int rate = this.imdb_rating / 15;
		if (this.imdb_rating % 15 == 0 && this.imdb_rating != 0)
		{
			rate -= 1;
		}
		return rate;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Serie other = (Serie) obj;
		return Objects.equals(episodes, other.episodes) && imdb_rating == other.imdb_rating
				&& Objects.equals(major_genre, other.major_genre) && premiere_year == other.premiere_year
				&& Objects.equals(status, other.status) && Objects.equals(subgente, other.subgente)
				&& Objects.equals(title, other.title);
	}
	
	
	

}
