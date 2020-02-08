package com.home.project.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Builder
public class Publisher {

    private Integer publisherID;
    private String time; //date
    private String readings;


}
