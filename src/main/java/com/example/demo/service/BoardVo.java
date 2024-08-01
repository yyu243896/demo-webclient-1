package com.example.demo.service;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardVo {

    long id;
    String ttl;
    String wrt_id;
    Date wrt_dt;
}
