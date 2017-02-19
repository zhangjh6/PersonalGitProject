package com.jerry.frame.aspect;


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import com.jerry.frame.util.ObjectCopyUtil;

import net.sf.json.JSONObject;

public class TestAspect   {
	public static final Logger log = Logger.getLogger(ObjectCopyUtil.class);
	 public void doAfter(JoinPoint jp) {  
		 log.info("log Ending method: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());  
	    }  
	  
	    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {  
	        long time = System.currentTimeMillis();  
	        Object retVal = pjp.proceed();  
	        time = System.currentTimeMillis() - time;  
	        log.info("process time: " + time + " ms");  
	        return retVal;  
	    }  
	  
	    public void doBefore(JoinPoint jp) {  
	    	Object [] objects = jp.getArgs();
	    	StringBuffer params = new StringBuffer(",params:");
	    	if(objects.length > 0){
	    		for(Object o :objects){
	    			params.append(JSONObject.fromObject(o).toString() + "--->");
	    		}
	    	}else{
	    		params = new StringBuffer();
	    	}
	    	log.info("log Begining method: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName() + params );  
	    }  
	  
	    public void doThrowing(JoinPoint jp, Throwable ex) {  
	    	log.info("method " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName() + " throw exception");  
	    	log.info(ex.getMessage());  
	    }  
}
