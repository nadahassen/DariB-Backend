package tn.dari.spring.jwt;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.rsocket.RSocketSecurity.JwtSpec;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import tn.dari.spring.entity.User;

@Component
public class JwtTokenUtil {
	
	private static final long EXPIRE_DURATION = 24 *60 * 60 *1000;// 24h
	
	@Value("${app.jwt.secret}")
	private String secretKey;
	public String generateAccessToken(User user) {
		return Jwts.builder()
				.setSubject(user.getId()+","+user.getUsername())
				.setIssuer("DARI")
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
				.signWith(SignatureAlgorithm.HS512, secretKey)
				.compact();
				}
	
}
