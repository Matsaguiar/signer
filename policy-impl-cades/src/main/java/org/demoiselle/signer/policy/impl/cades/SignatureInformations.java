package org.demoiselle.signer.policy.impl.cades;

import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.TimeZone;

import org.demoiselle.signer.core.extension.BasicCertificate;
import org.demoiselle.signer.policy.engine.asn1.etsi.SignaturePolicy;
import org.demoiselle.signer.timestamp.Timestamp;

/**
 * Basic informations about a signature 
 * 
 *
 */
public class SignatureInformations {
	
	private LinkedList<X509Certificate> chain;
	private Date signDate;
    private Timestamp timeStampSigner = null;
    private SignaturePolicy signaturePolicy;
    private Date notAfter;
    private LinkedList<String> validatorErrors = new LinkedList<String>();


    /**
     * 
     * @return list of Certificate chain stored on signature
     */
	public LinkedList<X509Certificate> getChain() {
		return chain;
	}

	public void setChain(LinkedList<X509Certificate> chain) {
		this.chain = chain;
	}

	/**
	 * 
	 * @return Date when signature was generated (it is NOT a timestamp date) 
	 *
	 */
	public Date getSignDate() {
		return signDate;
	}

	/**
	 * 
	 * @return String DateGMT when signature was generated (it is NOT a timestamp date) 
	 *
	 */
	public String getSignDateGMT() {
		if (this.signDate != null) {
			SimpleDateFormat dateFormatGmt = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss:S z");
			dateFormatGmt.setTimeZone(TimeZone.getTimeZone("GMT"));
			return dateFormatGmt.format(this.getSignDate());
		} else {
			return null;
		}
    }
	
	
	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	/**
	 * 
	 * @return TimeStamp stored on signature
	 */
	public Timestamp getTimeStampSigner() {
		return timeStampSigner;
	}

	public void setTimeStampSigner(Timestamp timeStampSigner) {
		this.timeStampSigner = timeStampSigner;
	}
	
	/** 
	 * 
	 * @return list of Signers BasicCertificates
	 */
	public BasicCertificate getSignerBasicCertificate(){
		
		for(X509Certificate cert : getChain()){
			BasicCertificate certificate = new BasicCertificate(cert);
			if (!certificate.isCACertificate()){
				return certificate;
			}												
		}
		return null;		
	}

	/**
	 *  
	 * @return the Signature Policy used 
	 */
	public SignaturePolicy getSignaturePolicy() {
		return signaturePolicy;
	}

	/**
	 * 
	 * @param signaturePolicy
	 */
	public void setSignaturePolicy(SignaturePolicy signaturePolicy) {
		this.signaturePolicy = signaturePolicy;
	}

	/**
	 * 
	 * @return a list of Validator Errors
	 */
	public LinkedList<String> getValidatorErrors() {
		return validatorErrors;
	}

	/**
	 * 
	 * @param validatorErrors
	 */
	public void setValidatorErrors(LinkedList<String> validatorErrors) {
		this.validatorErrors = validatorErrors;
	}

	/**
	 * @return the notAfter certificate date
	 */
	public Date getNotAfter() {
		return notAfter;
	}

	/**
	 * @param notAfter the notAfter to set
	 */
	public void setNotAfter(Date notAfter) {
		this.notAfter = notAfter;
	}	
}