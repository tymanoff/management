package ru.codemark.management.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ResponseAllPerson {
    private List<ResponsePerson> allPerson;
}
