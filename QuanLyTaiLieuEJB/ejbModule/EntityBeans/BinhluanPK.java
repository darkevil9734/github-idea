package EntityBeans;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the binhluan database table.
 * 
 */
@Embeddable
public class BinhluanPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idBinhLuan;

	@Column(insertable=false, updatable=false)
	private int taiLieu_idTaiLieu;

	@Column(insertable=false, updatable=false)
	private int user_idUser;

	@Column(insertable=false, updatable=false)
	private int user_idLoai;

	public BinhluanPK() {
	}
	public int getIdBinhLuan() {
		return this.idBinhLuan;
	}
	public void setIdBinhLuan(int idBinhLuan) {
		this.idBinhLuan = idBinhLuan;
	}
	public int getTaiLieu_idTaiLieu() {
		return this.taiLieu_idTaiLieu;
	}
	public void setTaiLieu_idTaiLieu(int taiLieu_idTaiLieu) {
		this.taiLieu_idTaiLieu = taiLieu_idTaiLieu;
	}
	public int getUser_idUser() {
		return this.user_idUser;
	}
	public void setUser_idUser(int user_idUser) {
		this.user_idUser = user_idUser;
	}
	public int getUser_idLoai() {
		return this.user_idLoai;
	}
	public void setUser_idLoai(int user_idLoai) {
		this.user_idLoai = user_idLoai;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BinhluanPK)) {
			return false;
		}
		BinhluanPK castOther = (BinhluanPK)other;
		return 
			(this.idBinhLuan == castOther.idBinhLuan)
			&& (this.taiLieu_idTaiLieu == castOther.taiLieu_idTaiLieu)
			&& (this.user_idUser == castOther.user_idUser)
			&& (this.user_idLoai == castOther.user_idLoai);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idBinhLuan;
		hash = hash * prime + this.taiLieu_idTaiLieu;
		hash = hash * prime + this.user_idUser;
		hash = hash * prime + this.user_idLoai;
		
		return hash;
	}
}