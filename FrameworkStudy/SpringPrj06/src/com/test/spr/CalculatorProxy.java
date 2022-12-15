/*======================================
 * CalculatorProxy.java
 * - 프록시 클래스
 * - 보조 업무 적용 및 주 업무 호출 과정
======================================*/

package com.test.spr;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

// ※ Proxy 클래스를 만드는 방법 중 비교적 쉽고 직관적인 방법은
//	  InvocationHandler 인터페이스를 구현하는 클래스를 만드는 것이다

public class CalculatorProxy implements InvocationHandler
{
	private Object target;
	
	// 생성자 정의
	public CalculatorProxy(Object target)
	{
		this.target = target;
	}

	// 보조 업무 적용 및 주 업무 호출 과정 추가
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		// 보조 업무 (cross-cutting concern) 설정
		//-- 시간 측정 (Around Advice)
		Log log = LogFactory.getLog(this.getClass());
		//-- 
		StopWatch sw = new StopWatch();
		
		sw.start();
		log.info("처리 시간 측정 시작 ------------------------");
		//-- 서버쪽에서만 내용이 기록되는 것
		
		// 주 업무 (core concern) 실행 내용
		Object result = method.invoke(target, args);
		//-- method = 두번째 파라미터 (매개변수)
		//-- target =  따라해야하는 대상
		//-- args = 세번째 파라미터 (=그 객체가 가지고 있는 주변 속성들)
		
		sw.stop();
		log.info("처리시간 측정 종료--------------------------");
		log.info(String.format("경과시간 : %s/1000초", sw.getTotalTimeMillis()));
		//-- sw.getTotalTimeMillis() : long 형으로 반환 → %s, %f 모두 상관X
		
		return result;
	}
	
	
}
