package hu.gaborbalazs.practice.exception;

import javax.ejb.ApplicationException;

@SuppressWarnings("serial")
@ApplicationException(rollback = true)
public class BaseCheckedException extends Exception {

}
