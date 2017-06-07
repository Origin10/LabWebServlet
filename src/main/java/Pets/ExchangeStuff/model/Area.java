package Pets.ExchangeStuff.model;

import javax.persistence.*;

/**
 * Created by Student on 2017/6/1.
 */
@Entity
public class Area {
    private Integer id;
    private String name;
    private Integer parentId;
    private int common;
    private String type;

//    @Column(name = "id", nullable = false, unique = true)
//    @GenericGenerator(name = "generator", strategy = "uuid")
//    @GeneratedValue(generator = "generator")


    @Id
    @Column(name = "id", nullable = false, unique = true)
    @SequenceGenerator(name="yyy", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="yyy")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "parent_id", nullable = false)
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "common", nullable = false)
    public int getCommon() {
        return common;
    }

    public void setCommon(int common) {
        this.common = common;
    }

    @Basic
    @Column(name = "type", nullable = false, length = 16)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Area area = (Area) o;

        if (id != area.id) return false;
        if (parentId != area.parentId) return false;
        if (common != area.common) return false;
        if (name != null ? !name.equals(area.name) : area.name != null) return false;
        if (type != null ? !type.equals(area.type) : area.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) (parentId ^ (parentId >>> 32));
        result = 31 * result + common;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
