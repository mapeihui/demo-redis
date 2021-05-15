package com.maph.demoredis.domain;

import java.io.Serializable;
import lombok.Data;

@Data
public class NbaPlayerDO implements Serializable {
    private Integer id;

    private String countryEn;

    private String teamName;

    private Long birthDay;

    private static final long serialVersionUID = 1523578200509819795L;
}