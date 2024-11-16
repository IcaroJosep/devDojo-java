package dominio;

public class LightNoval {

	private String title;
	private double price;
	
	public LightNoval(String title,double price) {
		this.title=title;
		this.price=price;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LightNoval other = (LightNoval) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title)) {
			return false;
			}
		return true;
	}

	@Override
	public String toString() {
		return "LightNova{"+"title="+title+", price="+price+'}';
	}

	public String getTitle() {
		return title;
	}

	public double getPrice() {
		return price;
	}
	
	
	
}
