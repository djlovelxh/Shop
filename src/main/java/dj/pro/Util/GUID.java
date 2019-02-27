package dj.pro.Util;

import java.util.UUID;

public class GUID {

	public static String getText() {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		String uuidStr = str.replace("-", "");
		return uuidStr;
	}

}
