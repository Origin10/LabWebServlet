package Pets.ExchangeStuff.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Student on 2017/6/1.
 */
@Entity
@Table(name = "ExchangStuff", schema = "dbo", catalog = "EEIT94")
public class Stuff implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer areaId;
    private String areaName;
    private Integer providerId;
    private String title;
    private Integer imageId;
    private int dealLevel;
    private Integer maxExchangeCount;
    private int publishStatus;
    private int inventoryAmount;
    private Date startTime;
    private Date endTime;
    private Date exchangeMoment;
    private String merchantCode;
    private Date createTime;
    private Date updateTime;
    private Integer categoryId;

    private Set<StuffDetail> stuffDetails = new HashSet<StuffDetail>();


//    @Column(name = "id", nullable = false, unique = true)
//    @GenericGenerator(name = "generator", strategy = "uuid")
//    @GeneratedValue(generator = "generator")

    public Stuff() {
    }


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
    @Column(name = "Area_id", nullable = false)
    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    @Basic
    @Column(name = "Area_name", nullable = false, length = 64)
    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Basic
    @Column(name = "provider_id", nullable = false)
    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 200)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "image_id", nullable = true)
    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    @Basic
    @Column(name = "deal_level", nullable = false)
    public int getDealLevel() {
        return dealLevel;
    }

    public void setDealLevel(int dealLevel) {
        this.dealLevel = dealLevel;
    }

    @Basic
    @Column(name = "max_exchange_count", nullable = true)
    public Integer getMaxExchangeCount() {
        return maxExchangeCount;
    }

    public void setMaxExchangeCount(Integer maxExchangeCount) {
        this.maxExchangeCount = maxExchangeCount;
    }

    @Basic
    @Column(name = "publish_status", nullable = false)
    public int getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(int publishStatus) {
        this.publishStatus = publishStatus;
    }

    @Basic
    @Column(name = "inventory_amount", nullable = false)
    public int getInventoryAmount() {
        return inventoryAmount;
    }

    public void setInventoryAmount(int inventoryAmount) {
        this.inventoryAmount = inventoryAmount;
    }

    @Basic
    @Column(name = "start_time", nullable = false)
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time", nullable = true)
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "exchange_moment", nullable = true)
    public Date getExchangeMoment() {
        return exchangeMoment;
    }

    public void setExchangeMoment(Date exchangeMoment) {
        this.exchangeMoment = exchangeMoment;
    }

    @Basic
    @Column(name = "merchant_code", nullable = true, length = 15)
    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
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

    @Basic
    @Column(name = "category_id", nullable = false)
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }


    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER) //, mappedBy="Stuff"
    @OrderBy("eId")
    public Set<StuffDetail> getStuffDetails() {
    return this.stuffDetails;

    }

    public void setStuffDetails(Set<StuffDetail> stuffDetails) {
        this.stuffDetails = stuffDetails;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stuff stuff = (Stuff) o;

        if (id != stuff.id) return false;
        if (areaId != stuff.areaId) return false;
        if (providerId != stuff.providerId) return false;
        if (dealLevel != stuff.dealLevel) return false;
        if (publishStatus != stuff.publishStatus) return false;
        if (inventoryAmount != stuff.inventoryAmount) return false;
        if (categoryId != stuff.categoryId) return false;
        if (areaName != null ? !areaName.equals(stuff.areaName) : stuff.areaName != null) return false;
        if (title != null ? !title.equals(stuff.title) : stuff.title != null) return false;
        if (imageId != null ? !imageId.equals(stuff.imageId) : stuff.imageId != null) return false;
        if (maxExchangeCount != null ? !maxExchangeCount.equals(stuff.maxExchangeCount) : stuff.maxExchangeCount != null)
            return false;
        if (startTime != null ? !startTime.equals(stuff.startTime) : stuff.startTime != null) return false;
        if (endTime != null ? !endTime.equals(stuff.endTime) : stuff.endTime != null) return false;
        if (exchangeMoment != null ? !exchangeMoment.equals(stuff.exchangeMoment) : stuff.exchangeMoment != null)
            return false;
        if (merchantCode != null ? !merchantCode.equals(stuff.merchantCode) : stuff.merchantCode != null) return false;
        if (createTime != null ? !createTime.equals(stuff.createTime) : stuff.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(stuff.updateTime) : stuff.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (areaId ^ (areaId >>> 32));
        result = 31 * result + (areaName != null ? areaName.hashCode() : 0);
        result = 31 * result + (int) (providerId ^ (providerId >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (imageId != null ? imageId.hashCode() : 0);
        result = 31 * result + dealLevel;
        result = 31 * result + (maxExchangeCount != null ? maxExchangeCount.hashCode() : 0);
        result = 31 * result + publishStatus;
        result = 31 * result + inventoryAmount;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (exchangeMoment != null ? exchangeMoment.hashCode() : 0);
        result = 31 * result + (merchantCode != null ? merchantCode.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (int) (categoryId ^ (categoryId >>> 32));
        return result;
    }
}
