package com.guo.sra;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;


public class HttpParamUtils {

	/**
	 * 
	 * 方法用途: 对所有传入参数按照字段名的Unicode码从小到大排序（字典序），并且生成url参数串<br>
	 * 实现步骤: <br>
	 * 
	 * @param paraMap
	 *            要排序的Map对象
	 * @param urlEncode
	 *            是否需要URLENCODE
	 * @param keyToLower
	 *            是否需要将Key转换为全小写 true:key转化成小写，false:不转化
	 * @return
	 */
	public static String formatUrlMap(Map<String, String> paraMap, boolean urlEncode, boolean keyToLower) {
		String buff = "";
		Map<String, String> tmpMap = paraMap;
		try {
			List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(tmpMap.entrySet());
			// 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
			Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>() {

				@Override
				public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
					return (o1.getKey()).toString().compareTo(o2.getKey());
				}
			});
			// 构造URL 键值对的格式
			StringBuilder buf = new StringBuilder();
			for (Map.Entry<String, String> item : infoIds) {
				if (StringUtils.isNotBlank(item.getKey())) {
					String key = item.getKey();
					String val = item.getValue();
					if (urlEncode) {
						val = URLEncoder.encode(val, "utf-8");
					}
					if (keyToLower) {
						buf.append(key.toLowerCase() + "=" + val);
					} else {
						buf.append(key + "=" + val);
					}
					buf.append("&");
				}

			}
			buff = buf.toString();
			if (buff.isEmpty() == false) {
				buff = buff.substring(0, buff.length() - 1);
			}
		} catch (Exception e) {
			return null;
		}
		return buff;
	}

	/**
	 * 获取URL 上面所有参数，直接分割，返回参数 map
	 * 
	 * @param url
	 * @return
	 */
	private static Map<String, String> getUrlParams(String url) {
		Map<String, String> map = new HashMap<String, String>();
		url = url.replace("?", ";");
		if (!url.contains(";")) {
			return map;
		}
		if (url.split(";").length > 0) {
			String[] arr = url.split(";")[1].split("&");
			for (String s : arr) {
				String key = s.split("=")[0];
				String value = s.split("=")[1];
				map.put(key, value);
			}
			return map;

		} else {
			return map;
		}
	}

	/**
	 * 参数校验,排除signatureAlgorithm和signatureInfo
	 * 
	 * @param request
	 * @return
	 */
	public static Map<String, String> checkRepeatParametersAndRemoveSignatureInfo(HttpServletRequest request) {
		// 检查传来的参数中有没有重复的
		Map<String, String[]> parameterMap = request.getParameterMap();
		Map<String, String> distinctParameters = new HashMap<String, String>(parameterMap.size());
		String[] values = null;
		for (String key : parameterMap.keySet()) {
			values = parameterMap.get(key);
			if (values.length > 1) {
				continue;
			}
			if ("signatureAlgorithm".equals(key) || "signatureInfo".equals(key)) {
				continue;
			}
			distinctParameters.put(key, values[0]);
		}
		return distinctParameters;
	}

	public static void main(String[] args) throws Exception {

		SecurityUtil rsaEncrypt = new SecurityUtil();
		String source;
		Map<String, String> urlMap = new HashMap<String, String>();

//		 String signatureInfo =
//		 "certNo=91440300MA5EJQQC7P&merchantId=2019080703339525&merchantProperty=2service=amp_secmerchant_query&version=1.0.0-PRD";


		urlMap.put("certNo", "93560105MB195A0YXN");
		urlMap.put("merchantId", "20190205033XXXXXX");
		urlMap.put("merchantProperty", "2");
		urlMap.put("service", "amp_secmerchant_query");
		urlMap.put("version", "1.0.0-PRD");
		// 1.要加密的url字符串
		String urlStr = HttpParamUtils.formatUrlMap(urlMap, false, false);
		System.out.println("加密:" + urlStr);

		// //加密后的结果
		source = SecurityUtil.encrypt(rsaEncrypt.getPublicKey(), urlStr);
		System.out.println("公钥加密:" + source);
	}

}
