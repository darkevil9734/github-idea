package EntityBeans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the binhluan database table.
 * 
 */
@Entity
@NamedQuery(name="Binhluan.findAll", query="SELECT b FROM Binhluan b")
public class Binhluan implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BinhluanPK id;

	@Column(name="noi_dung")
	private String noiDung;

	//bi-directional many-to-one association to Tailieu
	@ManyToOne
	private Tailieu tailieu;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="User_idLoai", referencedColumnName="idLoai"),
		@JoinColumn(name="User_idUser", referencedColumnName="idUser")
		})
	private User user;

	public Binhluan() {
	}

	public BinhluanPK getId() {
		return this.id;
	}

	public void setId(BinhluanPK id) {
		this.id = id;
	}

	public String getNoiDung() {
		return this.noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public Tailieu getTailieu() {
		return this.tailieu;
	}

	public void setTailieu(Tailieu tailieu) {
		this.tailieu = tailieu;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}