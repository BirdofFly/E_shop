package pers.linxi.shop.util;

import java.util.UUID;

/**
 * ��������ַ����Ĺ�����
 * @author ����
 *
 */
public class UUIDUtil {
	/**
	 * �������ַ����ķ���
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-","");
	}
}
