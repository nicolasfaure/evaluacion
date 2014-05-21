package com.bumeran.evaluacion.cache;



public class BumexMemcached {
	private static volatile BumexMemcached instance = null;	
	private BumexMemcached()
	{
	}

    public static BumexMemcached getInstance() {
        if (instance == null) {
            synchronized (BumexMemcached.class) {
               instance = new BumexMemcached();
            }
        }
        return instance;
    }
    
    public void set(String key, Object value){
    	
    }
    
    public Object get(String key){
    	return null;
    }
    
    public void delete(String key){
    	
    }
}
