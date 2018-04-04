package com.intention.sqtwin.utils.conmonUtil;

import android.util.Base64;
import android.util.Log;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * copy from
 * http://www.awaysoft.com/taor/aes-cbc-%E7%9B%B8%E4%BA%92%E5%8A%A0%E8%A7%A3%E5%
 * AF%86-javaphpc.html
 *
 * @author Tom
 */
public class AesUtil {

//	private static Logger LOG = LoggerFactory.getLogger(AesUtil.class);

    public static String iv = "Ehu76%#*hn!jfi8D";

    public static String encrypt(String sSrc, String sKey) {
        if (sKey == null) {
            throw new RuntimeException("Key为空null");
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            throw new RuntimeException("Key长度不是16位");
        }

        try {

            byte[] raw = sKey.getBytes();
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");//"算法/模式/补码方式"
            IvParameterSpec iv = new IvParameterSpec(AesUtil.iv.getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] srawt = sSrc.getBytes("utf-8");
            int len = srawt.length;
            /* 计算补0后的长度 */
            while (len % 16 != 0)
                len++;
            byte[] sraw = new byte[len];
            /* 在最后补0 */
            for (int i = 0; i < len; ++i) {
                if (i < srawt.length) {
                    sraw[i] = srawt[i];
                } else {
                    sraw[i] = 0;
                }
            }
            byte[] encrypted = cipher.doFinal(sraw);

            return Base64.encodeToString(encrypted, Base64.DEFAULT);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
        } catch (Exception e) {
            Log.d("AesUtil", "加密步骤出错 . src:{} key:{}" + e + sSrc + sKey);
            return null;
        }
    }

    // 解密
    public static String decrypt(String sSrc, String sKey) {
        if (sSrc == null) {
            return null;
        }
        // 判断Key是否正确
        if (sKey == null) {
            throw new RuntimeException("Key为空null");
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            throw new RuntimeException("Key长度不是16位");
        }

        try {
            //			System.out.println("key is:" + sKey);
            byte[] raw = sKey.getBytes("ASCII");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            IvParameterSpec iv = new IvParameterSpec(AesUtil.iv.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 = Base64.decode(sSrc, Base64.DEFAULT);//先用base64解密
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original, "utf-8");
            return originalString.trim();
        } catch (Exception e) {
            Log.i("", "解密步骤出错 . src:{} key:{}" + e + sSrc + sKey);
            return null;
        }
    }

    public static void main(String[] args) {
//		String key = StringUtil.fullTo16(1000111L);
        /*String content = "北京欢乐之旅";
		String result = encrypt(content, key);
		System.out.println("原本内容 : " + content);
		System.out.println("encrypt : " + result);
		System.out.println("decrypt : " + decrypt(result, key));*/


	/*	System.out.println("解密  bF1Stt4axNVv4klqskANIGG4RX+lL4XDTr5vIOm5vJs= ： "
				+ AesUtil.decrypt("bF1Stt4axNVv4klqskANIGG4RX+lL4XDTr5vIOm5vJs=", StringUtil.fullTo16(1000111L)));*/

	/*	System.out.println("URLEncoder 32070638jcpu :" + URLEncoder.encode(encrypt("32070638jcpu", key)));

		System.out.println("encrypt 32070638jcpu : " + encrypt("32070638jcpu", key));*/
    }
}
