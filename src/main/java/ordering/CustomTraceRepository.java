/*
package ordering;

import java.util.Map;
import java.util.logging.Logger;

import org.springframework.boot.actuate.trace.InMemoryTraceRepository;
import org.springframework.stereotype.Repository;

import com.google.common.collect.ordering;

@Repository
public class CustomTraceRepository extends InMemoryTraceRepository {
	
	private static Logger logger = Logger.getLogger(ordering.class.getName());
	
    public CustomTraceRepository() {
        super.setCapacity(1000);
    }

    @Override
    public void add(Map<String, Object> map) {
        super.add(map);
        
        
        logger.info("traced object: " + map);
    }
}
*/
