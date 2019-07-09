/*
 * Demoiselle Framework
 * Copyright (C) 2016 SERPRO
 * ----------------------------------------------------------------------------
 * This file is part of Demoiselle Framework.
 *
 * Demoiselle Framework is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License version 3
 * along with this program; if not,  see <http://www.gnu.org/licenses/>
 * or write to the Free Software Foundation, Inc., 51 Franklin Street,
 * Fifth Floor, Boston, MA  02110-1301, USA.
 * ----------------------------------------------------------------------------
 * Este arquivo é parte do Framework Demoiselle.
 *
 * O Framework Demoiselle é um software livre; você pode redistribuí-lo e/ou
 * modificá-lo dentro dos termos da GNU LGPL versão 3 como publicada pela Fundação
 * do Software Livre (FSF).
 *
 * Este programa é distribuído na esperança que possa ser útil, mas SEM NENHUMA
 * GARANTIA; sem uma garantia implícita de ADEQUAÇÃO a qualquer MERCADO ou
 * APLICAÇÃO EM PARTICULAR. Veja a Licença Pública Geral GNU/LGPL em português
 * para maiores detalhes.
 *
 * Você deve ter recebido uma cópia da GNU LGPL versão 3, sob o título
 * "LICENCA.txt", junto com esse programa. Se não, acesse <http://www.gnu.org/licenses/>
 * ou escreva para a Fundação do Software Livre (FSF) Inc.,
 * 51 Franklin St, Fifth Floor, Boston, MA 02111-1301, USA.
 */
package org.demoiselle.signer.policy.impl.cades;

import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;

/**
 * Basic specification for implementation of digital signatures in CADES format.
 */
public interface Signer {

    /**
     * Indicates which Provider will be used.
     *
     * @param provider provider to be used
     */
    abstract public void setProvider(Provider provider);

    /**
     * Private key required for asymmetric cryptography
     *
     * @param privateKey private key to be used
     */
    abstract public void setPrivateKey(PrivateKey privateKey);

    /**
     * Public key needed for asymmetric cryptography
     *
     * @param publicKey public key to be used
     */
    abstract public void setPublicKey(PublicKey publicKey);

    /**
     * Set a Signature Algorithm. Ex: SHA256withRSA
     *
     * @param algorithm algorithm to be used
     */
    abstract public void setAlgorithm(String algorithm);

    /**
     * Set an algorithm pre-defined in enumeration. Compatible with ICP-Brasil
     *
     * @param algorithm algorithm representation to be used
     */
    abstract public void setAlgorithm(SignerAlgorithmEnum algorithm);

    /**
     * Generates a digital signature from a content and attaches this content on result file
     * @param content content to be signed
     * @return attached signature
     */
    abstract public byte[] doAttachedSign(byte[] content);

    /**
     * 
     * Generates a digital signature from a content, 
     * the result file does not contains the content that was signed
     * @param content content to be signed
     * @return detached signature
     */
    abstract public byte[] doDetachedSign (byte[] content);
    
    /**
     * Returns the provider.
     *
     * @return current provider
     */
    abstract public Provider getProvider();

    /**
     * Returns the private key.
     *
     * @return current private key
     */
    abstract public PrivateKey getPrivateKey();

    /**
     * Returns the algorithm to be used in the signature
     *
     * @return current algorithm
     */
    abstract public String getAlgorithm();

    /**
     * Returns the public key.
     *
     * @return current public key
     */
    abstract public PublicKey getPublicKey();

    /**
     * 
     * Generates a digital signature from a previous calculated hash for a content, 
     * the result file does not contains the original content that was signed
     * @param hash hash to be signed
     * @return detached PCKS7 signature
     */
    abstract public byte[] doHashSign (byte[] hash);
}
