public class ExceptionHandling {
    private String message;

    public ExceptionHandling(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void handleException() {
        System.out.println("Error: " + message);
    }
}
