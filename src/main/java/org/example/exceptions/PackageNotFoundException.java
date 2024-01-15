package org.example.exceptions;

public class PackageNotFoundException extends Throwable {
    public PackageNotFoundException(String s) {
        super(s);
    }
}
