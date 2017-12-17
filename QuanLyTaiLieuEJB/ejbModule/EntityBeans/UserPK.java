package EntityBeans;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the user database table.
 * 
 */
@Embeddable
public class UserPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idUser;

	@Column(insertable=false, updatable=false)
	private int idLoai;

	public UserPK() {
	}
	public int getIdUser() {
		return this.idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdLoai() {
		return this.idLoai;
	}
	public void setIdLoai(int idLoai) {
		this.idLoai = idLoai;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserPK)) {
			return false;
		}
		UserPK castOther = (UserPK)other;
		return 
			(this.idUser == castOther.idUser)
			&& (this.idLoai == castOther.idLoai);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idUser;
		hash = hash * prime + this.idLoai;
		
		return hash;
	}
}