package com.yushu.study.component;

import com.yushu.study.util.configuration.MailSenderImpl;
import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;


/**
 *
 * 实现多账号轮询发送
 *
 * @author yushu.zhao
 * @create 2021-01-13 15:32
 */
@Component
public class MailComponent {
	private static final String template = "mail/fzy.ftl";

	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
	@Autowired
	private MailSenderImpl mailSender;

	public void sendMail(String email) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email", email);
		try {
			String text = getTextByTemplate(template, map);
			send(email, text);
		} catch (IOException | TemplateException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	private String getTextByTemplate(String template, Map<String, Object> model) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		return FreeMarkerTemplateUtils
        .processTemplateIntoString(freeMarkerConfigurer.getConfiguration().getTemplate(template), model);
	}

	private String send(String email, String text) throws MessagingException, UnsupportedEncodingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		InternetAddress from = new InternetAddress();
		from.setAddress(mailSender.getUsername());
		from.setPersonal("yushu.zhao", "UTF-8");
		helper.setFrom(from);
		helper.setTo(email);
		helper.setSubject("测试邮件");
		helper.setText(text, true);
		mailSender.send(message);
		return text;
	}

}
