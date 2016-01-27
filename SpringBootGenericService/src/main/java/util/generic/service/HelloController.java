package util.generic.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

  @RequestMapping("/")
  @ResponseBody
  public String index() {
    return "Hello World!!!";
  }

}