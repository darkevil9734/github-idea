package EntityBeans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the monhoc database table.
 * 
 */
@Entity
@NamedQuery(name="Monhoc.findAll", query="SELECT m FROM Monhoc m")
public class Monhoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idMonHoc;

	private String tenMonHoc;

	//bi-directional many-to-many association to Loai
	@ManyToMany
	@JoinTable(
		name="loai_has_monhoc"
		, joinColumns={
			@JoinColumn(name="MonHoc_idMonHoc")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Loai_idLoai")
			}
		)
	private List<Loai> loais;

	//bi-directional many-to-many association to Tailieu
	@ManyToMany(mappedBy="monhocs")
	private List<Tailieu> tailieus;

	public Monhoc() {
	}

	public int getIdMonHoc() {
		return this.idMonHoc;
	}

	public void setIdMonHoc(int idMonHoc) {
		this.idMonHoc = idMonHoc;
	}

	public String getTenMonHoc() {
		return this.tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	public List<Loai> getLoais() {
		return this.loais;
	}

	public void setLoais(List<Loai> loais) {
		this.loais = loais;
	}

	public List<Tailieu> getTailieus() {
		return this.tailieus;
	}

	public void setTailieus(List<Tailieu> tailieus) {
		this.tailieus = tailieus;
	}

}