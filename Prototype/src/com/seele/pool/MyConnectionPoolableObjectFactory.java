package com.seele.pool;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyConnectionPoolableObjectFactory implements PooledObjectFactory {
	
	private static Logger logger = LoggerFactory.getLogger(MyConnectionPoolableObjectFactory.class);  
	
	private static int count = 0;  	
	
	//
	private synchronized String generateName() {  
        return "conn_" + (++count);  
    }

	public PooledObject makeObject() throws Exception {
		MyConnection connection = new MyConnection(generateName());
		logger.info(connection.getName());  
		connection.connect();
		return  (PooledObject) connection;
	}

	public void destroyObject(PooledObject pooledobject) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean validateObject(PooledObject pooledobject) {
		// TODO Auto-generated method stub
		return false;
	}

	public void activateObject(PooledObject pooledobject) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void passivateObject(PooledObject pooledobject) throws Exception {
		// TODO Auto-generated method stub
		
	}  
}
