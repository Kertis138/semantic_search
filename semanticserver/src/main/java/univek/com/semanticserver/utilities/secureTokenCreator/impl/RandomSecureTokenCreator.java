package univek.com.semanticserver.utilities.secureTokenCreator.impl;

import java.security.SecureRandom;

public class RandomSecureTokenCreator extends AbstractSecureToken {

    private static SecureRandom random = new SecureRandom();

    @Override
    public String getToken() {
        final int defaultLength = 13;
        StringBuilder token = new StringBuilder();
        for (int i = 0; i < 1+tokenLength%defaultLength; i++) {
            token.append(Long.toString(random.nextLong(), 16));
        }
        return token.toString().substring(0, tokenLength);
    }
}
