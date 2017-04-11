package app.service;
import java.io.IOException;
import app.model.IpGeoLocation;
import org.springframework.stereotype.Service;
import com.maxmind.geoip.LookupService;

@Service
public class IpGeoService {

    private static LookupService lookUp;

    static {
        try {
            lookUp = new LookupService(
            		IpGeoService.class.getResource("/GeoLiteCity.dat").getFile(),
                    LookupService.GEOIP_MEMORY_CACHE);
                    
                    //GEOIP_STANDARD - Read database from file system. This uses the least memory.
                    //GEOIP_MEMORY_CACHE - Load database into memory. Provides faster performance but uses more memory.
                    //GEOIP_CHECK_CACHE - Check for updated database. If database has been updated, reload file handle and/or memory cache.
                    //GEOIP_INDEX_CACHE - Cache only the the most frequently accessed index portion of the database, resulting in faster lookups than GEOIP_STANDARD, but less memory usage than GEOIP_MEMORY_CACHE. This is useful for larger databases such as GeoIP Organization and GeoIP City. Note: for GeoIP Country, Region and Netspeed databases, GEOIP_INDEX_CACHE is equivalent to GEOIP_MEMORY_CACHE.
                    //GEOIP_MMAP_CACHE - Load database into mmap shared memory. MMAP is not available for 32bit Windows.

            System.out.println("Database loaded... " + lookUp.getDatabaseInfo());
        } catch (IOException e) {
            System.out.println("Something went wrong while loading the Geolite Database" + e.getMessage());
        }
    }

    public static IpGeoLocation getLocation(String ipAddress) {
        return IpGeoLocation.map(lookUp.getLocation(ipAddress));
    		
    	}
    }
 
