package com.capslock.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by capslock.
 */
@Entity
@Data
public final class UserInfo {
    @Id
    private Long id;
    private String nickname;
}
