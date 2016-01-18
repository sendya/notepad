package com.loacg.notepad.utils;

import java.util.UUID;

/**
 * UUID 生成工具
 * @author Sendya
 *
 */
public class UUIDUtil {

	public static String getUId(){
		return UUID.randomUUID().toString();
	}
}
