package com.example.demo.service;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardVo {

    long id;
    String ttl;
    String wrt_id;
    Date wrt_dt;
    
}
