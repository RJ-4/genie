package com.naehas.genie.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "n_files")
@Audited(withModifiedFlag = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class File extends BaseEntity {
    /**
     * Code of the offer.
     *
     * <p>
     * Cannot be null or empty.
     * </p>
     */
    @Pattern(regexp = "^[^/?,<>\\:*|\"^]*",
            message = "Following characters: /?,<>\\:*|\"^ are not allowed")
    @Column(nullable = false)
    private String name;

    /**
     * Status of the offer.
     *
     * <p>
     * Cannot be null or empty.
     * </p>
     */
    @Pattern(regexp = "^[^/?,<>\\:*|\"^]*",
            message = "Following characters: /?,<>\\:*|\"^ are not allowed")
    @Column(nullable = false)
    private String type;

    /**
     * Whether file is active?.
     *
     * <p>
     * Cannot be null or empty.
     * </p>
     */
    @Column(name = "is_active")
    private boolean active = true;


    @Column
    private String subdirectory;

    /**
     * Parent folder.
     *
     * <p>
     * Cannot be null or empty.
     * </p>
     */
    @ManyToOne
    @JoinColumn(name = "parent_file_id")
    @JsonBackReference
    private File parentFile;
}
