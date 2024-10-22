package com.amirabadi.chapar_practice_project.data.dto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;

    @NotNull
    private UUID customerId;

    @NotNull
    private Long productId;

    @NotNull
    private Integer count;

}
