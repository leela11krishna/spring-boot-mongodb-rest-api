package in.revathi.restapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "catalog")
public class CatalogModel {

	public static final String SEQUENCE_NAME = "catalog_sequence";

	@Id
	private Long id;

	private String packaging;

	private String superproduct_id;

	private String brand;

	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPackaging() {
		return packaging;
	}

	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}

	public String getSuperproduct_id() {
		return superproduct_id;
	}

	public void setSuperproduct_id(String superproduct_id) {
		this.superproduct_id = superproduct_id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CatalogModel [id=" + id + ", packaging=" + packaging + ", superproduct_id=" + superproduct_id
				+ ", brand=" + brand + ", name=" + name + "]";
	}
}
