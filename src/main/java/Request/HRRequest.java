package Request;

public abstract class HRRequest {
    protected HRRequest nextRequest;

    public void setNextRequest(HRRequest nextRequest) {
        this.nextRequest = nextRequest;
    }

    public abstract void handleRequest(Request request);
}
