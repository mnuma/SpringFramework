package jp.co.axiz.app.web.controller;

import java.util.HashMap;
import java.util.logging.Logger;

import jp.co.axiz.app.biz.LoginService;
import jp.co.axiz.app.web.form.UsrDetailForm;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * ���O�C������{@code Controller}�N���X�B
 *
 * @author {@code AxiZ} ����
 * @see Controller
 * @see ModelAttribute
 * @see RequestMapping
 */

@Controller
public class LoginController {

	/** {@code Bean}��`�t�@�C������\���萔�B */
	private static final String BEANS_XML = "beans.xml";

	/** ���O�C��{@code Form}�o���f�[�^��ێ����܂��B */
	@Autowired
	private Validator loginFormValidator;

	/** ���O�o�͂Ɏg�p����{@link Logger}��\���萔�B */
	private static final Log LOG = LogFactory.getLog(LoginController.class);

	/**
	 * ���O�C����ʓ��͒l�i�[�I�u�W�F�N�g��ԋp���܂��B
	 *
	 * @return ���O�C����ʓ��͒l�I�u�W�F�N�g
	 */
	@ModelAttribute("usrDetailForm")
	public UsrDetailForm returnForm() {
		return new UsrDetailForm();
	}

	/**
	 * �p�X��{@code /}�܂���{@code /login}�ŁA���N�G�X�g��{@code GET}�ł���ꍇ�̏��������s���܂��B
	 *
	 * @return �J�ڐ�
	 */
	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String showLogin() {
		return "login";
	}

	/**
	 * ���O�C����ʂ̃��O�C���{�^���������ꂽ���̏��������s���܂��B �p�X��{@code /login}�Ń��N�G�X�g��{@code POST}�ł���ꍇ
	 *
	 * @param usrDetailForm
	 *            ���O�C����ʓ��͒��i�[�I�u�W�F�N�g
	 * @return �J�ڏ��
	 *
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView onSubmit(UsrDetailForm usrDetailForm, BindingResult bindingResult) {

		// ���͌��؏���.
		loginFormValidator.validate(usrDetailForm, bindingResult);

		String resultMsg = "���O�C���ł��܂���ł���";
		String viewName = "login";

		final ModelAndView modelAndView = new ModelAndView();

		// �s�����͂��������Ă���ꍇ.
		if (bindingResult.hasErrors()) {
			modelAndView.getModel().putAll(bindingResult.getModel());
			modelAndView.setViewName(viewName);
			modelAndView.addObject("resultMsg", resultMsg);
			return modelAndView;
		}

		final ApplicationContext appContext = new ClassPathXmlApplicationContext(BEANS_XML);
		final LoginService loginService = appContext.getBean(LoginService.BEAN_ID, LoginService.class);
		final boolean isAllowLogin = loginService.isAllowLogin(usrDetailForm.getUsrId(), usrDetailForm.getUsrPwd());
		boolean isAdminLogin = false;

		if (isAllowLogin) {
			System.out.println("***** ���O�C�����܂����D");

			resultMsg = usrDetailForm.getUsrId() + " ���񂪃��O�C�����܂���.";
			viewName = "menu";
			modelAndView.addObject("resultMsg", resultMsg);

			// �Ǘ��҂̃`�F�b�N
			isAdminLogin = loginService.isAdminLogin(usrDetailForm.getUsrId());

			if (isAdminLogin) {
				System.out.println(isAdminLogin);
				System.out.println("admin");
				resultMsg = usrDetailForm.getUsrId() + " ����y�Ǘ��ҁz�����O�C�����܂���.";
				modelAndView.addObject("resultMsg", resultMsg);
				viewName = "admin_menu";
			}

		} else {
			System.out.println("***** ���O�C���ł��܂���D");
			final HashMap<String, Object> modelMap = new HashMap<String, Object>();
			modelMap.put("resultMsg", resultMsg);
			modelMap.put("usrDetailForm", usrDetailForm);
			modelAndView.addAllObjects(modelMap);
		}

		modelAndView.setViewName(viewName);
		return modelAndView;

	}
}