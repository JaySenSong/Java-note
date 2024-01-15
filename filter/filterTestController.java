@Slf4j
@RestController
public class TestController {
  
    @PostMapping("/testRequestWrapper")
    public String testRequestWrapper(HttpServletRequest request) {
      
        // 獲取header
        String name = request.getHeader("name");

        // 獲取header list
        Enumeration<String> from = request.getHeaders("from");
        List<String> fromList = Collections.list(from);
        log.info("header from: {}", fromList.toString());
      
        // 獲取Parameter
        String param1 = request.getParameter("param1");
        log.info("parameter param1: {}", param1);
      
        // 獲取Parameter array
        String[] param2Arr = request.getParameterValues("param2");
        log.info("parameter param2: {}", Arrays.asList(param2Arr).toString());

        

      
        return "SUCCESS";
    }
}
