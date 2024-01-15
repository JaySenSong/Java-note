@Slf4j
@ControllerAdvice
public class ExceptionControllerAdvice {


    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity handler(Exception e) {
      
        //if use @SneakyThrows throws Exceptio，, because @SneakyThrows can accept RuntimeException only.
        if(e instanceof UndeclaredThrowableException) {
           e = (Exception) e.getCause();
        }
      
        log.error(e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(....));
    }


    /**
     * valid hanlder
     */
    @ResponseBody
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseVo<String> handlerConstraintViolationException(Exception e) {
        ConstraintViolationException constraintViolationException = (ConstraintViolationException) e;
        String msg = StringUtils.collectionToCommaDelimitedString(
                constraintViolationException.getConstraintViolations()
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .collect(Collectors.toList()));

        log.error(msg, e);
        return ResponseEntity.status(HttpStatus.INTERNAL_BAD_REQUEST).body(new ErrorResponse(....));
    }


    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseVo<String> handlerMethodArgumentNotValidException(Exception e) {
        StringBuilder message = new StringBuilder();
        MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
        List<ObjectError> errors = exception.getBindingResult().getAllErrors();
        for (ObjectError objectError : errors) {
            if (objectError instanceof FieldError) {
                FieldError fieldError = (FieldError) objectError;
                message.append(StrUtil.toUnderlineCase(fieldError.getField())).append(":").append(fieldError.getDefaultMessage()).append(",");
            } else {
                message.append(objectError.getDefaultMessage()).append(",");
            }

        }
        log.error(message.toString(), e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(....));
    }




}
