package com.study.util;

import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

public class AccessControl {
	public static boolean isInternalAccess(HttpServletRequest request) throws UnknownHostException {
		//String ipaddr = (String) request.getRemoteAddr();
		String ip = request.getHeader("X-FORWARDED-FOR");
		if(ip==null || ip.length() == 0)
			ip = request.getHeader("Proxy-Client-IP");
		if(ip==null || ip.length()==0)
			ip = request.getHeader("WL-Proxy-Client-IP");
		if(ip==null || ip.length()==0)
			ip=request.getRemoteAddr();
		String[] temp = ip.split("\\.");
		
		if(ip.equals("127.0.0.1") || ip.equals("0:0:0:0:0:0:0:1")) {
			//System.out.println("내부접속입니다. 데이터 조작 작업(등록,수정,삭제 등)이 가능합니다.");
			return true;
		}else {
			long ipaddrLong = (Long.parseLong(temp[0])<<24)
					+ (Long.parseLong(temp[1])<<16)
					+ (Long.parseLong(temp[2])<<8)
					+ Long.parseLong(temp[3]);
			
			
			//각 공유기 별로 대역을 지정하는데 새로운 것이 발견되면 그 뒤에 추가.
			if(ipaddrLong>3232235520L) {
				//iptime 대역
				if(ipaddrLong>3232235521L && ipaddrLong<=3240000000L) {
					//System.out.println("내부접속입니다. 데이터 조작 작업(등록,수정,삭제 등)이 가능합니다.");
					return true;
				}else {
					//System.out.println("외부접속입니다. 데이터 조작 작업을 하실 수 없습니다.");
					return false;
				}
			}
			else {
				//kt homehub
				if(ipaddrLong>=2887647489L && ipaddrLong<2887647742L) {
					return true;
				}else {
					return false;
				}
			}
		}
	}
}
