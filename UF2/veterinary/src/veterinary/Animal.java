package veterinary;

public abstract class Animal {
	/** The animal identifier */
	private int id;
	/** The animal name */
	private String name;
	/** The animal species */
	private String species;

	/**
	 * Creates a Animal.
	 * 
	 * @param id      the animal's identifier.
	 * @param name    the animal's name.
	 * @param species the animal's species.
	 */
	public Animal(int id, String name, String species) {
		this.id = id;
		this.name = name;
		this.species = species;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the species.
	 * 
	 * @return the species
	 */
	public String getSpecies() {
		return this.species;
	}

	/**
	 * Calculates the hash code.
	 * 
	 * @return the hash code.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.id;
		return result;
	}

	/**
	 * Determines if an object is equal to the animal. Two animals are equal if they
	 * have the same id.
	 * 
	 * @param obj an object
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (this.id != other.id)
			return false;
		return true;
	}

}
