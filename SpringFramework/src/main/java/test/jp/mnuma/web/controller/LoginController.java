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
 * ログイン処理{@code Controller}クラス。
 *
 * @author {@code AxiZ} 小川
 * @see Controller
 * @see ModelAttribute
 * @see RequestMapping
 */

@Controller
public class LoginController {

	/** {@code Bean}定義ファイル名を表す定数。 */
	private static final String BEANS_XML = "beans.xml";

	/** ログイン{@code Form}バリデータを保持します。 */
	@Autowired
	private Validator loginFormValidator;

	/** ログ出力に使用する{@link Logger}を表す定数。 */
	private static final Log LOG = LogFactory.getLog(LoginController.class);

	/**
	 * ログイン画面入力値格納オブジェクトを返却します。
	 *
	 * @return ログイン画面入力値オブジェクト
	 */
	@ModelAttribute("usrDetailForm")
	public UsrDetailForm returnForm() {
		return new UsrDetailForm();
	}

	/**
	 * パスが{@code /}または{@code /login}で、リクエストが{@code GET}である場合の処理を実行します。
	 *
	 * @return 遷移先
	 */
	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String showLogin() {
		return "login";
	}

	/**
	 * ログイン画面のログインボタンが押された時の処理を実行します。 パスが{@code /login}でリクエストが{@code POST}である場合
	 *
	 * @param usrDetailForm
	 *            ログイン画面入力直格納オブジェクト
	 * @return 遷移情報
	 *
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView onSubmit(UsrDetailForm usrDetailForm, BindingResult bindingResult) {

		// 入力検証処理.
		loginFormValidator.validate(usrDetailForm, bindingResult);

		String resultMsg = "ログインできませんでした";
		String viewName = "login";

		final ModelAndView modelAndView = new ModelAndView();

		// 不正入力が発生している場合.
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
			System.out.println("***** ログインしました．");

			resultMsg = usrDetailForm.getUsrId() + " さんがログインしました.";
			viewName = "menu";
			modelAndView.addObject("resultMsg", resultMsg);

			// 管理者のチェック
			isAdminLogin = loginService.isAdminLogin(usrDetailForm.getUsrId());

			if (isAdminLogin) {
				System.out.println(isAdminLogin);
				System.out.println("admin");
				resultMsg = usrDetailForm.getUsrId() + " さん【管理者】がログインしました.";
				modelAndView.addObject("resultMsg", resultMsg);
				viewName = "admin_menu";
			}

		} else {
			System.out.println("***** ログインできません．");
			final HashMap<String, Object> modelMap = new HashMap<String, Object>();
			modelMap.put("resultMsg", resultMsg);
			modelMap.put("usrDetailForm", usrDetailForm);
			modelAndView.addAllObjects(modelMap);
		}

		modelAndView.setViewName(viewName);
		return modelAndView;

	}
}