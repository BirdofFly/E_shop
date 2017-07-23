package pers.linxi.shop.util;

import java.util.UUID;

/**
 * 生成随机字符串的工具类
 * @author 林曦
 *
 */
public class UUIDUtil {
	/**
	 * 获得随机字符串的方法
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-","");
	}
}
