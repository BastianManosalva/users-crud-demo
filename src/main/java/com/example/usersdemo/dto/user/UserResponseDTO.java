package com.example.usersdemo.dto.user;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.example.usersdemo.dto.phone.PhoneResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Relation(collectionRelation = "users")
public class UserResponseDTO extends RepresentationModel<UserResponseDTO> {

    private UUID id;
    private String name;
    private String email;
    private List<PhoneResponseDTO> phones;
    private boolean isActive;
    private Date createdAt;
    private Date modified;
    private Date lastLogin;
    private String token;

}
