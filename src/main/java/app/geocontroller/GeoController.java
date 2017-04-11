package app.geocontroller;
import app.model.IpGeoLocation;
import app.service.IpGeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GeoController {

	@Autowired
	private IpGeoService ipGeoService;

	@RequestMapping(value="/home")
	public String home(){
		return "index";
	}


	@RequestMapping(value="/getipaddressinfo", method=RequestMethod.GET)
	public String IpGeoLocation (Model model, String ipaddress){

		model.addAttribute("enteredIp", ipaddress);
		IpGeoLocation thedata = ipGeoService.getLocation(ipaddress);
		model.addAttribute("allinfo", thedata);
		return  "index";
	}



}
