/*====================
	RecordView.java
	- 인터페이스
====================*/

package com.test.spr;

public interface RecordView
{
	// setter() 메소드 선언
	public void setRecord(Record record);
	// 레코드 타입을 넘겨받음 (= Record가 필요)
	
	// 입력 액션 전용 메소드 선언
	public void input();
	
	// 출력 액션 전용 메소드 선언
	public void output();

}
