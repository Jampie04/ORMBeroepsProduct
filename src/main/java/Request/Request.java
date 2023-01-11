package Request;

import entity.Employee;

public class  Request {
    private RequestType requestType;
    public Request(RequestType requestType, Employee employee){
        this.requestType=requestType;
    }
    public RequestType getType(){

        return requestType;
    }

}
