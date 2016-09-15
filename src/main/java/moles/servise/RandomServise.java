package moles.servise;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by moles on 27.07.2016.
 */
@Service
public class RandomServise {
    private SecureRandom random;
    public String randomAlfaNumString(int markNumber){
        random = new SecureRandom();
       return new BigInteger(8*markNumber, random).toString(32);
    }
}
