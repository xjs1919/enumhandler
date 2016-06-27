/**
 * 
 */
package com.chrhc.mybatis.handler.util;

import java.util.EnumSet;

import com.chrhc.mybatis.handler.Identifiable;

/**
 * @author 605162215@qq.com
 *
 * 2016年6月27日 上午9:24:58
 */
public class EnumFactory {
	
	public static <T extends Enum<T> & Identifiable<K> , K > T getEnum(Class<T> type, K id) { 
		T[] arr = type.getEnumConstants();
		if(arr == null || arr.length <= 0){
			return null;
		}
        for (T t : arr) {  
            if(t.getId().equals(id)) {  
                return t;  
            }  
        }  
        return null;
    }  
	
    public static <T extends Enum<T> & Identifiable<K> , K > T get(Class<T> type, K id) {  
        EnumSet<T> set = EnumSet.allOf(type);  
        if(set == null || set.size() <= 0){  
            return null;  
        }  
        for(T t: set){  
            if(t.getId().equals(id)){  
                return t;  
            }  
        }  
        return null;  
    }  
}
