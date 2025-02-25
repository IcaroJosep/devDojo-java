package dominio;

public class Producer {
	private Integer id;
	private String name;
	
	
	
	private Producer(Builder a) {
		this.id=a.id;
		this.name=a.name;
	}


	public Integer getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public static class  Builder{
		private Integer id;
		private String name;	
		
		//fora de usso id atribuido pelo banco de dados
	/*	public Builder id(Integer id) {
			this.id=id;
			return this;	 
		}*/
		public Builder name(String name) {
			this.name=name;
			return this;	 
		}
		public Producer builder() {
			return new Producer(this);
		}
	}


	@Override
	public String toString() {
		return "Producer [id=" + id + ", name=" + name + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Producer other = (Producer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	
}
