import React, { useState } from "react";
import styles from "./loginBox.module.css";
const LoginBox = () => {
  const [loginState, setLoginState] = useState(true);
  const onClickLoginButton = (e) => {
    e.preventDefault();
    setLoginState(true);
  };
  const onClickSignUpButton = (e) => {
    e.preventDefault();
    setLoginState(false);
  };
  return (
    <div className={styles.main}>
      <div className={styles.loginBox}>
        <div className={styles.imgDiv}>
          <img src="/img/logo.png" alt="네캔만원" className={styles.loginImg} />
        </div>
        {loginState === true ? ( // 로그인 화면
          <>
            <form>
              <button className={styles.Button} onClick={onClickSignUpButton}>
                회원가입
              </button>
              <button
                className={styles.onClickButton}
                onClick={onClickLoginButton}
              >
                로그인
              </button>
              <label className={styles.label}>아이디</label>
              <input type="text" className={styles.loginInput} name="id" />
              <label className={styles.label}>비밀번호</label>
              <input
                type="password"
                className={styles.passwordInput}
                name="password"
              />
              <button className={styles.submitButton} type="submit">
                로그인
              </button>
            </form>
            <div className={styles.loginAnother}>
              <div className={styles.loginAnotherLine}></div>
              <div className={styles.loginAnotherTitle}>
                다른 서비스로 로그인
              </div>
            </div>
            <div className={styles.loginAnotherButtonBox}>
              <button
                className={[styles.loginAnotherButton, styles.naver].join(" ")}
              >
                {/* 라이브러리 classnames 설치해도 된다.*/}
              </button>
              <button
                className={[styles.loginAnotherButton, styles.google].join(" ")}
              ></button>
            </div>
          </>
        ) : (
          // 회원가입 화면
          <>
            <form>
              <button
                className={styles.onClickButton}
                onClick={onClickSignUpButton}
              >
                회원가입
              </button>
              <button className={styles.Button} onClick={onClickLoginButton}>
                로그인
              </button>
              <label className={styles.label}>아이디</label>
              <input type="text" className={styles.loginInput} />
              <label className={styles.label}>닉네임</label>
              <input type="text" className={styles.loginInput} />
              <label className={styles.label}>비밀번호</label>
              <input type="password" className={styles.loginInput} />
              <label className={styles.label}>비밀번호 확인</label>
              <input type="password" className={styles.loginInput} />
              <button className={styles.submitButton} type="submit">
                회원가입
              </button>
            </form>
          </>
        )}
      </div>
    </div>
  );
};

export default LoginBox;
