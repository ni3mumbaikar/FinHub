package herokuapp.com.finhublti.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "documents")
public class Document {
    long custid, vaadhar, vpan, vphoto, vbank_info;
    String aadhar, pan, photo, bank_info, comment;
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    public Document() {
    }

    public Document(long custid, long vaadhar, long vpan, long vphoto, long vbank_info, String aadhar, String pan, String photo, String bank_info, String comment, Long id) {
        this.custid = custid;
        this.vaadhar = vaadhar;
        this.vpan = vpan;
        this.vphoto = vphoto;
        this.vbank_info = vbank_info;
        this.aadhar = aadhar;
        this.pan = pan;
        this.photo = photo;
        this.bank_info = bank_info;
        this.comment = comment;
        this.id = id;
    }

    public long getCustid() {
        return custid;
    }

    public void setCustid(long custid) {
        this.custid = custid;
    }

    public long getVaadhar() {
        return vaadhar;
    }

    public void setVaadhar(long vaadhar) {
        this.vaadhar = vaadhar;
    }

    public long getVpan() {
        return vpan;
    }

    public void setVpan(long vpan) {
        this.vpan = vpan;
    }

    public long getVphoto() {
        return vphoto;
    }

    public void setVphoto(long vphoto) {
        this.vphoto = vphoto;
    }

    public long getVbank_info() {
        return vbank_info;
    }

    public void setVbank_info(long vbank_info) {
        this.vbank_info = vbank_info;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getBank_info() {
        return bank_info;
    }

    public void setBank_info(String bank_info) {
        this.bank_info = bank_info;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
