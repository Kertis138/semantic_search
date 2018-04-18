package univek.com.semanticserver.server.responses.impl;


public class AuthControllerTokenizeResponse extends AbstractServerResponse {

    public enum Status {
        TooFrequentRequest
    }

    private String secure_token = null;

    public String getSecure_token() {
        return secure_token;
    }

    public void setSecure_token(String secure_token) {
        this.secure_token = secure_token;
    }

}
