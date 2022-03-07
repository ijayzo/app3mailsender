package com.example.demo.Model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CancelMailTemplate {
    private String emailTo;
    private String cancelReason;
    private String packageDesc;
}
