package Request;

public class ManagerRequest extends HRRequest {
    public void handleRequest(Request request) {
        if (request.getType() == RequestType.NEW_HIRE) {
            System.out.println("WELCOME from manager!!!");
            // handle request
        } else {
            nextRequest.handleRequest(request);
        }
    }
}
