@Slf4j
@Component
@Order(1)
public class TestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // 自訂RequestWrapper
        RequestWrapper requestWrapper = new RequestWrapper(request);
        // 添加header
        requestWrapper.addHeader("from", "wrapper");
        // 添加parameter
        requestWrapper.addParameter("param2", "wrapper");
      
        filterChain.doFilter(requestWrapper, servletResponse);
    }
}
