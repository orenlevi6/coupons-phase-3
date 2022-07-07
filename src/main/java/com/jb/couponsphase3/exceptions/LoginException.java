package com.jb.couponsphase3.exceptions;

import com.jb.couponsphase3.beans.ClientType;

public class LoginException extends Exception {

    public LoginException(String message) {
        super(message);
    }

    public LoginException(ClientType clientType) {
        super("Invalid login " + clientType.toString());
    }

}
