package demoreact.demo.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * CommentBlogEntity
 *
 * Version 1.0
 *
 * Date: 06-07-2021
 *
 * Copyright
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * 06-07-2021          Anhtp8           Create Comment
 */

@Entity
@Table(name = "CommentBlog", schema = "dbo", catalog = "MyProfile")
public class CommentBlogEntity {

    @Id
    @Column(name = "Id_comment", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComment;
    @Basic
    @Column(name = "idBlog", nullable = true)
    private Integer idBlog;
    // this is save conntent of comment
    private String comment;
    private String author;
    private Date dateComment;
    private String timeComment;
    private String email;


    /**
     *
     * @return
     */
    public int getIdComment() {
        return idComment;
    }

    /**
     *
     * @param idComment
     */
    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    /**
     *
     * @return
     */
    public Integer getIdBlog() {
        return idBlog;
    }

    /**
     *
     * @param idBlog
     */
    public void setIdBlog(Integer idBlog) {
        this.idBlog = idBlog;
    }

    /**
     *
     * @return
     */
    @Basic
    @Column(name = "Comment", nullable = true, length = 2147483647)
    public String getComment() {
        return comment;
    }

    /**
     *
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     *
     * @return
     */
    @Basic
    @Column(name = "Author", nullable = true, length = 50)
    public String getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     *
     * @return
     */
    @Basic
    @Column(name = "DateComment", nullable = true)
    public Date getDateComment() {
        return dateComment;
    }

    /**
     *
     * @param dateComment
     */
    public void setDateComment(Date dateComment) {
        this.dateComment = dateComment;
    }

    /**
     *
     * @return
     */
    @Basic
    @Column(name = "TimeComment", nullable = true, length = 50)
    public String getTimeComment() {
        return timeComment;
    }

    /**
     *
     * @param timeComment
     */
    public void setTimeComment(String timeComment) {

        this.timeComment = timeComment;
    }

    /**
     *
     * @return
     */
    @Basic
    @Column(name = "Email", nullable = true, length = 100)
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Relationship with Blog
     */
//    @ManyToOne()
//    @JoinColumn(name= "Id_blog")
//    private BlogEntity blogEntity;
//
//    public BlogEntity getBlogEntity() {
//        return blogEntity;
//    }
//
//    public void setBlogEntity(BlogEntity blogEntity) {
//        this.blogEntity = blogEntity;
//    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentBlogEntity that = (CommentBlogEntity) o;
        return idComment == that.idComment &&
                Objects.equals(idBlog, that.idBlog) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(author, that.author) &&
                Objects.equals(dateComment, that.dateComment) &&
                Objects.equals(timeComment, that.timeComment) &&
                Objects.equals(email, that.email);
    }

    /**
     *
     * @param idComment
     * @param idBlog
     * @param comment
     * @param author
     * @param dateComment
     * @param timeComment
     * @param email
     */
    public CommentBlogEntity(int idComment, Integer idBlog, String comment, String author, Date dateComment, String timeComment, String email) {
        this.idComment = idComment;
        this.idBlog = idBlog;
        this.comment = comment;
        this.author = author;
        this.dateComment = dateComment;
        this.timeComment = timeComment;
        this.email = email;
    }


    public CommentBlogEntity() {
    }


    @Override
    public int hashCode() {
        return Objects.hash(idComment, idBlog, comment, author, dateComment, timeComment, email);
    }

}
