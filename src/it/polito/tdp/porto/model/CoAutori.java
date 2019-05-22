package it.polito.tdp.porto.model;

public class CoAutori {
	
	private Author primo;
	private Author secondo;
	public CoAutori(Author primo, Author secondo) {
		super();
		this.primo = primo;
		this.secondo = secondo;
	}
	public Author getPrimo() {
		return primo;
	}
	public void setPrimo(Author primo) {
		this.primo = primo;
	}
	public Author getSecondo() {
		return secondo;
	}
	public void setSecondo(Author secondo) {
		this.secondo = secondo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((primo == null) ? 0 : primo.hashCode());
		result = prime * result + ((secondo == null) ? 0 : secondo.hashCode());
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
		CoAutori other = (CoAutori) obj;
		if (primo == null) {
			if (other.primo != null)
				return false;
		} else if (!primo.equals(other.primo))
			return false;
		if (secondo == null) {
			if (other.secondo != null)
				return false;
		} else if (!secondo.equals(other.secondo))
			return false;
		return true;
	}
	
	
}
