package univek.com.semanticserver.utilities.secureTokenCreator.impl;

import univek.com.semanticserver.utilities.propertyWorker.PropertyWorker;
import univek.com.semanticserver.utilities.secureTokenCreator.SecureTokenCreator;

public abstract class AbstractSecureToken implements SecureTokenCreator {

    static final Integer tokenLength;

    static {
        tokenLength = PropertyWorker.getInt("secureToken.length", 30);
    }
}
