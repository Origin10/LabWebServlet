package Pets.ExchangeStuff.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Student on 2017/6/1.
 */
@Entity
public class Cart {
    private Integer id;
    private Integer userId;
    private Integer dealId;
    private Integer dealSkuId;
    private int count;
    private Date createTime;
    private Date updateTime;

//    @Column(name = "id", nullable = false, unique = true)
//    @GenericGenerator(name = "generator", strategy = "uuid")
//    @GeneratedValue(generator = "generator")

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @SequenceGenerator(name = "yyy", allocationSize = 1) //1.先用@SequenceGenerator建立一個generator
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "yyy")
    //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "deal_id", nullable = false)
    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    @Basic
    @Column(name = "deal_sku_id", nullable = false)
    public Integer getDealSkuId() {
        return dealSkuId;
    }

    public void setDealSkuId(Integer dealSkuId) {
        this.dealSkuId = dealSkuId;
    }

    @Basic
    @Column(name = "count", nullable = false)
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Basic
    @Column(name = "create_time", nullable = false)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time", nullable = false)
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        if (id != cart.id) return false;
        if (userId != cart.userId) return false;
        if (dealId != cart.dealId) return false;
        if (dealSkuId != cart.dealSkuId) return false;
        if (count != cart.count) return false;
        if (createTime != null ? !createTime.equals(cart.createTime) : cart.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(cart.updateTime) : cart.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (int) (dealId ^ (dealId >>> 32));
        result = 31 * result + (int) (dealSkuId ^ (dealSkuId >>> 32));
        result = 31 * result + count;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
