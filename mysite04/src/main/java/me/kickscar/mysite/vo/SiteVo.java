package me.kickscar.mysite.vo;

public class SiteVo {
	private String title;
	private String welcome;
	private String profile;
	private String description;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWelcome() {
		return welcome;
	}
	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		SiteVo clone = new SiteVo();
		clone.setTitle(title);
		clone.setDescription(description);
		clone.setWelcome(welcome);
		clone.setProfile(profile);

		return clone;
	}

	@Override
	public String toString() {
		return "SiteVo [title=" + title + ", welcome=" + welcome + ", profile=" + profile + ", description="
				+ description + "]";
	}
}
