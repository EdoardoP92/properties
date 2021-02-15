package properties.getter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/refresh")
public class PropsController {
	
	@Value("${internal.property}")
	private String props;

	@GetMapping
	public String refresh() {
		return props;
	}
}
