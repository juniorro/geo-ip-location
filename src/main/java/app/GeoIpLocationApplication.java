package app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.net.UnknownHostException;
import app.service.IpGeoService;

@SpringBootApplication
public class GeoIpLocationApplication {

	public static void main(String[] args) throws UnknownHostException {
		SpringApplication.run(GeoIpLocationApplication.class, args);

		System.out.println(IpGeoService.getLocation("108.231.25.75"));
		
	}
}
