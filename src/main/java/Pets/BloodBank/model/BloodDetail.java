package Pets.BloodBank.model;

import javax.persistence.*;

/**
 * Created by Student on 2017/6/1.
 */
@Entity
public class BloodDetail {
    private int bType;
    private String typeDetail;

    @Id
    @Column(name = "bType", nullable = false)
    @SequenceGenerator(name="yyy", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="yyy")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】
    public int getbType() {
        return bType;
    }

    public void setbType(int bType) {
        this.bType = bType;
    }

    @Basic
    @Column(name = "typeDetail", nullable = true, length = 2000)
    public String getTypeDetail() {
        return typeDetail;
    }

    public void setTypeDetail(String typeDetail) {
        this.typeDetail = typeDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BloodDetail that = (BloodDetail) o;

        if (bType != that.bType) return false;
        return typeDetail != null ? typeDetail.equals(that.typeDetail) : that.typeDetail == null;
    }

    @Override
    public int hashCode() {
        int result = bType;
        result = 31 * result + (typeDetail != null ? typeDetail.hashCode() : 0);
        return result;
    }
}
