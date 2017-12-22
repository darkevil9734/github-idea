package EntityBeans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tailieu database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Tailieu.findAll", query="SELECT t FROM Tailieu t"),
	@NamedQuery(name="Tailieu.DocTheoId", query="SELECT t FROM Tailieu t WHERE t.idTaiLieu=:id")
})
	
public class Tailieu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idTaiLieu;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ngay_upload")
	private Date ngayUpload;

	@Column(name="ten_tai_lieu")
	private String tenTaiLieu;

	//bi-directional many-to-one association to Binhluan
	@OneToMany(mappedBy="tailieu")
	private List<Binhluan> binhluans;

	//bi-directional many-to-many association to Monhoc
	@ManyToMany
	@JoinTable(
		name="monhoc_has_tailieu"
		, joinColumns={
			@JoinColumn(name="TaiLieu_idTaiLieu")
			}
		, inverseJoinColumns={
			@JoinColumn(name="MonHoc_idMonHoc")
			}
		)
	private List<Monhoc> monhocs;

	public Tailieu() {
	}

	public int getIdTaiLieu() {
		return this.idTaiLieu;
	}

	public void setIdTaiLieu(int idTaiLieu) {
		this.idTaiLieu = idTaiLieu;
	}

	public Date getNgayUpload() {
		return this.ngayUpload;
	}

	public void setNgayUpload(Date ngayUpload) {
		this.ngayUpload = ngayUpload;
	}

	public String getTenTaiLieu() {
		return this.tenTaiLieu;
	}

	public void setTenTaiLieu(String tenTaiLieu) {
		this.tenTaiLieu = tenTaiLieu;
	}

	public List<Binhluan> getBinhluans() {
		return this.binhluans;
	}

	public void setBinhluans(List<Binhluan> binhluans) {
		this.binhluans = binhluans;
	}

	public Binhluan addBinhluan(Binhluan binhluan) {
		getBinhluans().add(binhluan);
		binhluan.setTailieu(this);

		return binhluan;
	}

	public Binhluan removeBinhluan(Binhluan binhluan) {
		getBinhluans().remove(binhluan);
		binhluan.setTailieu(null);

		return binhluan;
	}

	public List<Monhoc> getMonhocs() {
		return this.monhocs;
	}

	public void setMonhocs(List<Monhoc> monhocs) {
		this.monhocs = monhocs;
	}

}