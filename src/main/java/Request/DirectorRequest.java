package Request;


public class DirectorRequest extends HRRequest {
    public void handleRequest(Request request) {
        if (request.getType() == RequestType.SALARY) {
            System.out.println("Salary Increased approved by director!!!");
            // handle request
        } else {
            nextRequest.handleRequest(request);
        }
    }
}
