package dominio;

public class LightNoval {

	private String title;
	private double price;
	
	public LightNoval(String title,double price) {
		this.title=title;
		this.price=price;
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
