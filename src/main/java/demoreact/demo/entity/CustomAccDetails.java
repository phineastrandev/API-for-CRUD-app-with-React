package demoreact.demo.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * CustomAccDetails
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
 * 06-07-2021          Anhtp8           Custome user
 */

public class CustomAccDetails implements UserDetails {

    InforAccEntity user;

    /**
     *
     * @param user
     */
    public CustomAccDetails(InforAccEntity user) {
        this.user = user;
    }

    public InforAccEntity getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(InforAccEntity user) {
        this.user = user;
    }

    /**
     *
     * @return ROLE
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }


    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     *
     * @return username
     */
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    /**
     *
     * @return true
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     *
     * @return true
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     *
     * @return true
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     *
     * @return true
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
