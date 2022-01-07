package org.albumshop.security;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.albumshop.domain.User;
import org.albumshop.persistence.UserRepository;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class SendEmailService {

	@Autowired
	private UserRepository urepo;

	@Autowired
	PasswordEncoder passwordEncoder;

	public void sendEmail(User user, String div, String pw) throws Exception {
		// Mail Server 설정
		String charSet = "utf-8";
		String hostSMTP = "smtp.gmail.com"; // 네이버 이용시 smtp.naver.com
		String hostSMTPid = "ghjs7511@gmail.com";
		String hostSMTPpwd = "ghjs@4528";

		// 보내는 사람 EMail, 제목, 내용
		String fromEmail = "ghjs7511@gmail.com";
		String fromName = "AlbumShop";
		String subject = "";
		String msg = "";

		if (div.equals("findpw")) {
			subject = "Album Shop 임시 비밀번호 입니다.";
			msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
			msg += "<h3 style='color: blue;'>";
			msg += user.getId() + "님의 임시 비밀번호 입니다. 비밀번호를 변경하여 사용하세요.</h3>";
			msg += "<p>임시 비밀번호 : " + pw  + "</p></div>";
		}

		// 받는 사람 E-Mail 주소
		String mail = user.getEmail();
		try {
			HtmlEmail email = new HtmlEmail();
			email.setDebug(true);
			email.setCharset(charSet);
			email.setSSL(true);
			email.setHostName(hostSMTP);
			email.setSmtpPort(465); // 네이버 이용시 587

			email.setAuthentication(hostSMTPid, hostSMTPpwd);
			email.setTLS(true);
			email.addTo(mail, charSet);
			email.setFrom(fromEmail, fromName, charSet);
			email.setSubject(subject);
			email.setHtmlMsg(msg);
			email.send();
		} catch (Exception e) {
			System.out.println("메일발송 실패 : " + e);
		}
	}

	public int  updatePw(String id,String email) throws Exception {
		User user = urepo.findByIdAndEmail(id, email).orElse(null);
		System.out.println("user=" + user);
		if(user == null) return 0;
		// 임시 비밀번호 생성
		String pw = "";
		for (int i = 0; i < 12; i++) {
			pw += (char) ((Math.random() * 26) + 97);
		}
        
		// 비밀번호 변경

		user.setPass(passwordEncoder.encode(pw));
		urepo.save(user);

		// 비밀번호 변경 메일 발송
		sendEmail(user, "findpw", pw);
		return 1;
	}

	 

}
