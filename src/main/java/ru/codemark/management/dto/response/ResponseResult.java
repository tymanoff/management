package ru.codemark.management.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ResponseResult {
    private boolean success;
    private List<String> errors;
}
