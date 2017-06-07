package Pets.BloodBank.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Student on 2017/6/1.
 */
@Entity
public class BloodBank {
    private int id;
    private int pId;
    private Integer bType;
    private String bInfo;
    private Date bDate;

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name="yyy", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="yyy")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "pID", nullable = false)
    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    @Basic
    @Column(name = "bType", nullable = true)
    public Integer getbType() {
        return bType;
    }

    public void setbType(Integer bType) {
        this.bType = bType;
    }

    @Basic
    @Column(name = "bInfo", nullable = true, length = 2000)
    public String getbInfo() {
        return bInfo;
    }

    public void setbInfo(String bInfo) {
        this.bInfo = bInfo;
    }

    @Basic
    @Column(name = "bDate", nullable = true)
    public Date getbDate() {
        return bDate;
    }

    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BloodBank bloodBank = (BloodBank) o;

        if (id != bloodBank.id) return false;
        if (pId != bloodBank.pId) return false;
        if (bType != null ? !bType.equals(bloodBank.bType) : bloodBank.bType != null) return false;
        if (bInfo != null ? !bInfo.equals(bloodBank.bInfo) : bloodBank.bInfo != null) return false;
        if (bDate != null ? !bDate.equals(bloodBank.bDate) : bloodBank.bDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + pId;
        result = 31 * result + (bType != null ? bType.hashCode() : 0);
        result = 31 * result + (bInfo != null ? bInfo.hashCode() : 0);
        result = 31 * result + (bDate != null ? bDate.hashCode() : 0);
        return result;
    }
}
