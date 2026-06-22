package org.exaple.like_lion_pbl.class5.domain;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoleType {
    LION("아기사자"),
    STAFF("운영진");

    private final String displayName;
}
