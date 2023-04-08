package by.yanodincov.goat.user.db.entity;

import by.yanodincov.goat.user.db.type.annotation.GeneratedUUIDV7;
import by.yanodincov.goat.user.db.type.enums.UserRole;
import io.hypersistence.utils.hibernate.type.array.EnumArrayType;
import io.hypersistence.utils.hibernate.type.array.internal.AbstractArrayType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import java.util.UUID;

@Entity(name = "User")
@Table(name = "user_data", indexes = {
        @Index(name = "user_login_idx", columnList = "login")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedUUIDV7
    @Column(name = "user_uuid", updatable = false, nullable = false, columnDefinition = "uuid")
    private UUID userUUID;

    @Id
    @GeneratedUUIDV7
    @Column(name = "login", updatable = false, nullable = false, columnDefinition = "varchar(32)")
    private String login;

    @Id
    @Column(name = "hash_password", updatable = false, nullable = false, columnDefinition = "varchar(256)")
    private String hashPassword;

    @Type(
            value = EnumArrayType.class,
            parameters = @Parameter(
                    name = AbstractArrayType.SQL_ARRAY_TYPE,
                    value = "user_roles"
            )
    )
    @Column(name = "user_roles", columnDefinition = "user_role[]")
    private UserRole[] userRoles;
}
