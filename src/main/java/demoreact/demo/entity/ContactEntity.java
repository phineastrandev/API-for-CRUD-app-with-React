package demoreact.demo.entity;

import javax.persistence.*;
import java.util.Objects;
/**
 * ContactEntity
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
 * 06-07-2021          Anhtp8           Create contact
 */

@Entity
@Table(name = "Contact", schema = "dbo", catalog = "MyProfile")
public class ContactEntity {

    private int id;
    private String name;
    private String email;
    private String content;
    private Integer isContacted;

    /**
     *
     * @return
     */

    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @Basic
    @Column(name = "Name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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
     *
     * @return
     */
    @Basic
    @Column(name = "Content", nullable = true, length = 2147483647)
    public String getContent() {
        return content;
    }

    /**
     *
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }


    @Basic
    @Column(name = "isContacted", nullable = true)
    public Integer getIsContacted() {
        return isContacted;
    }

    /**
     *
     * @param isContacted
     */
    public void setIsContacted(Integer isContacted) {
        this.isContacted = isContacted;
    }

    /**
     *
     * @param o
     * @return true false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactEntity that = (ContactEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Objects.equals(content, that.content) &&
                Objects.equals(isContacted, that.isContacted);
    }

    /**
     *
     * @return objects
     */

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, content, isContacted);
    }
}
