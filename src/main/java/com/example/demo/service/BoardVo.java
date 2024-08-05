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
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTtl() {
		return ttl;
	}
	public void setTtl(String ttl) {
		this.ttl = ttl;
	}
	public String getWrt_id() {
		return wrt_id;
	}
	public void setWrt_id(String wrt_id) {
		this.wrt_id = wrt_id;
	}
	public Date getWrt_dt() {
		return wrt_dt;
	}
	public void setWrt_dt(Date wrt_dt) {
		this.wrt_dt = wrt_dt;
	}
    
    
}
