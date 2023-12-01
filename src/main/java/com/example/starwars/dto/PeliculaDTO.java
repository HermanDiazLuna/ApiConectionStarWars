package com.example.starwars.dto;

import lombok.*;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PeliculaDTO {
    private Integer episode_id;
    private String title;
    private Date release_date;
}
