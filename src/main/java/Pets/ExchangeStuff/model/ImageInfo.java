package Pets.ExchangeStuff.model;

import javax.persistence.*;

/**
 * Created by Student on 2017/6/1.
 */
@Entity
public class ImageInfo {
    private Integer id;
    private Integer width;
    private Integer height;
    private String sourcePath;

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
    @Column(name = "width", nullable = true)
    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @Basic
    @Column(name = "height", nullable = true)
    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Basic
    @Column(name = "source_path", nullable = true, length = 100)
    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImageInfo imageInfo = (ImageInfo) o;

        if (id != imageInfo.id) return false;
        if (width != null ? !width.equals(imageInfo.width) : imageInfo.width != null) return false;
        if (height != null ? !height.equals(imageInfo.height) : imageInfo.height != null) return false;
        if (sourcePath != null ? !sourcePath.equals(imageInfo.sourcePath) : imageInfo.sourcePath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (width != null ? width.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (sourcePath != null ? sourcePath.hashCode() : 0);
        return result;
    }
}
