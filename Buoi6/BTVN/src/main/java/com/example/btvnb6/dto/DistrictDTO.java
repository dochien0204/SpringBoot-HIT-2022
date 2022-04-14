package com.example.btvnb6.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDTO
{
    private String name;
    private String type;
    private Long code;
    private Long provinceId;

}
