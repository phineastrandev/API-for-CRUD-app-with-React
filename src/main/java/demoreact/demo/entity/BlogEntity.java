package demoreact.demo.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * BlogEntity
 * <p>
 * Version 1.0
 * <p>
 * Date: 06-07-2021
 * <p>
 * Copyright
 * <p>
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * 06-07-2021          Anhtp8           Create Entity
 */

@Entity
@Table(name = "Blog", schema = "dbo", catalog = "MyProfile")
public class BlogEntity {

    /**
     * Id of Blog and auto increament
     */
    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //  Content of blog, content detail
    @Column(name = "Content", nullable = true, columnDefinition = "nvarchar(max)")
    private String content;

    // date create blog
    private Date createDate;

    // Image title of blog
    @Column(name = "Img_Front", nullable = true, columnDefinition = "nvarchar(MAX)")
    private String imgFront;

    // Tag name
    @Column(name = "Tag", nullable = true, columnDefinition = "nvarchar(MAX)")
    private String tag;
    private String title;
    private Integer viewer;
    private int isDeleted;

    /**
     * @param id
     * @param content
     * @param createDate
     * @param imgFront
     * @param tag
     * @param title
     * @param viewer
     * @param isDeleted
     */
    public BlogEntity(int id, String content, Date createDate, String imgFront, String tag, String title, Integer viewer, int isDeleted) {
        this.id = id;
        this.content = content;
        this.createDate = createDate;
        this.imgFront = imgFront;
        this.tag = tag;
        this.title = title;
        this.viewer = viewer;
        this.isDeleted = isDeleted;
    }


    // relationship with Comment
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "")
    private List<CommentBlogEntity> items = new ArrayList<CommentBlogEntity>();


    public List<CommentBlogEntity> getItems() {
        return items;
    }

    /**
     * @param items
     */
    public void setItems(List<CommentBlogEntity> items) {
        this.items = items;
    }

    public BlogEntity() {

    }

    /**
     * @param id
     */
    public BlogEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "Create_date", nullable = true)
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getImgFront() {
        return imgFront;
    }

    /**
     * @param imgFront
     */
    public void setImgFront(String imgFront) {
        this.imgFront = imgFront;
    }

    public String getTag() {
        return tag;
    }

    /**
     * @param tag
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    @Basic
    @Column(name = "Title", nullable = true, columnDefinition = "nvarchar(MAX)")
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "Viewer", nullable = true)
    public Integer getViewer() {
        return viewer;
    }

    /**
     * @param viewer
     */
    public void setViewer(Integer viewer) {
        this.viewer = viewer;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    /**
     * @param isDeleted
     */
    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

  
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tagId")
    private TagEntity tagEntity;

    public TagEntity getTagEntity() {

        return tagEntity;
    }

    /**
     * @param tagEntity
     */
    public void setTagEntity(TagEntity tagEntity) {

        this.tagEntity = tagEntity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlogEntity that = (BlogEntity) o;
        return id == that.id &&
                Objects.equals(content, that.content) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(imgFront, that.imgFront) &&
                Objects.equals(tag, that.tag) &&
                Objects.equals(title, that.title) &&
                Objects.equals(viewer, that.viewer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, createDate, imgFront, tag, title, viewer);
    }
}
