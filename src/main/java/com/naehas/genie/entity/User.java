package com.naehas.genie.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "n_users")
@Audited(withModifiedFlag = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity{
    /**
     * Username of the user.
     *
     * <p>
     * Cannot be null or empty.
     * </p>
     */
    @Pattern(regexp = "^[^/?,<>\\:*|\"^]*",
            message = "Following characters: /?,<>\\:*|\"^ are not allowed")
    @Column(nullable = false)
    private String userName;

    /**
     * Email of the user.
     *
     * <p>
     * Cannot be null or empty.
     * </p>
     */
    @Pattern(regexp = "^[^/?,<>\\:*|\"^]*",
            message = "Following characters: /?,<>\\:*|\"^ are not allowed")
    @Column(nullable = false)
    private String email;




}
