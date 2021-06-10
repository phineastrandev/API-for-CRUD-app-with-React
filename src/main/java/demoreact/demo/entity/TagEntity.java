package demoreact.demo.entity;

import javax.persistence.*;

/**
 * TagEntity
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
 * 06-07-2021          Anhtp8
 */
@Entity
@Table(name = "Tag")
public class TagEntity {
    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "Tag_Name", nullable = true, length = 50)
    private String tagName;

    public TagEntity() {
    }

    /**
     * @param tagName
     */
    public TagEntity(String tagName) {
        this.tagName = tagName;
    }

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return tagName
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * @param tagName
     */
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }


}
