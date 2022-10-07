package com.booker.backend.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Message<T> {

    private StatusEnum statusEnum;
    private String message;
    private T data;

    public Message(StatusEnum statusEnum, String message) {
        this.statusEnum = statusEnum;
        this.message = message;
    }

    @Builder
    public Message(StatusEnum statusEnum, String message, T data) {
        this.statusEnum = statusEnum;
        this.message = message;
        this.data = data;
    }
}
