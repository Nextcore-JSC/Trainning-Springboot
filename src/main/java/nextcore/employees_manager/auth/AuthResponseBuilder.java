package nextcore.employees_manager.auth;

public class AuthResponseBuilder {
    private String token;

    public AuthResponseBuilder token(String token) {
        this.token = token;
        return this;
    }

    public AuthResponse build() {
        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(this.token);
        return authResponse;
    }
}