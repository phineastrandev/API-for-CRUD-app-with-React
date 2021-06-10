package demoreact.demo.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * InforAccEntity
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
 * 06-07-2021          Anhtp8           Information of account
 */
@Entity
@Table(name = "InforAcc", schema = "dbo", catalog = "MyProfile",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class InforAccEntity {

    private Long id;
    private Integer age;
    private String birthday;
    private String city;
    private String country;
    private String email;
    private String name;
    private String password;
    private String username;
    private String avatar;
    private String phone;

    /**
     * @return
     */

    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return age
     */
    @Basic
    @Column(name = "Age", nullable = true)
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return birthday
     */
    @Basic
    @Column(name = "Birthday", nullable = true, length = 255)
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * @return country
     */
    @Basic
    @Column(name = "Country", nullable = true, length = 255, columnDefinition = "nvarchar(20)")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return email
     */
    @Basic
    @Column(name = "Email", nullable = true, length = 255)
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return name
     */
    @Basic
    @Column(name = "Name", nullable = true, length = 255, columnDefinition = "nvarchar(255)")
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return password
     */
    @Basic
    @Column(name = "Password", nullable = true, length = 255)
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return username
     */
    @Basic
    @Column(name = "Username", nullable = true, length = 255)
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return avatar
     */
    @Basic
    @Column(name = "Avatar", nullable = true, columnDefinition = "nvarchar(MAX)")
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param avatar
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * @return phone number
     */
    @Basic
    @Column(name = "Phone", nullable = true, length = 20)
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }


    public InforAccEntity() {
    }

    /**
     * @param email
     * @param password
     * @param username
     */
    public InforAccEntity(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    /**
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InforAccEntity that = (InforAccEntity) o;
        return id == that.id &&
                Objects.equals(age, that.age) &&
                Objects.equals(birthday, that.birthday) &&
                Objects.equals(country, that.country) &&
                Objects.equals(email, that.email) &&
                Objects.equals(name, that.name) &&
                Objects.equals(password, that.password) &&
                Objects.equals(username, that.username) &&
                Objects.equals(avatar, that.avatar) &&
                Objects.equals(phone, that.phone);
    }

    /**
     * @return object
     */

    @Override
    public int hashCode() {
        return Objects.hash(id, age, birthday, country, email, name, password, username, avatar, phone);
    }
}
