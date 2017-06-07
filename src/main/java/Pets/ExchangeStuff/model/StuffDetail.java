package Pets.ExchangeStuff.model;

import javax.persistence.*;

/**
 * Created by Student on 2017/6/1.
 */
@Entity
@Table(name = "ExchangDetail", schema = "dbo", catalog = "EEIT94")
public class StuffDetail {
    private long id;
    private long eId;
    private String eInfo;

//    @Column(name = "id", nullable = false, unique = true)
//    @GenericGenerator(name = "generator", strategy = "uuid")
//    @GeneratedValue(generator = "generator")

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @SequenceGenerator(name="yyy", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="yyy")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "eID", nullable = false)
    public long geteId() {
        return eId;
    }

    public void seteId(long eId) {
        this.eId = eId;
    }

    @Basic
    @Column(name = "eInfo", nullable = true, length = 8000)
    public String geteInfo() {
        return eInfo;
    }

    public void seteInfo(String eInfo) {
        this.eInfo = eInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StuffDetail that = (StuffDetail) o;

        if (id != that.id) return false;
        if (eId != that.eId) return false;
        if (eInfo != null ? !eInfo.equals(that.eInfo) : that.eInfo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (eId ^ (eId >>> 32));
        result = 31 * result + (eInfo != null ? eInfo.hashCode() : 0);
        return result;
    }
}
