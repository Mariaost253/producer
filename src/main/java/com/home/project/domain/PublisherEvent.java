package com.home.project.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Builder
public class PublisherEvent {

    private Integer publisherID;
    private String time;
    private Integer readings;
}
