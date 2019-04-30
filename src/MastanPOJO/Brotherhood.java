package MastanPOJO;

import java.sql.Date;

public class Brotherhood {

	private int EMPLOYEE_ID;
	private String FIRST_NAME;
	private String LAST_NAME ;
	private String EMAIL ;
	private String PHONE_NUMBER ;
	private Date HIRE_DATE;
	private String JOB_ID ;
	private int SALARY;
	private int COMMISSION_PCT ;
	private int MANAGER_ID  ;
	private int DEPARTMENT_ID  ;

	public Brotherhood(String fIRST_NAME, String lAST_NAME, String eMAIL, String pHONE_NUMBER) {
		this.FIRST_NAME = fIRST_NAME;
		this.LAST_NAME = lAST_NAME;
		this.EMAIL = eMAIL;
		this.PHONE_NUMBER = pHONE_NUMBER;

	}
	public Brotherhood() {
	}
	public Brotherhood(int eMPLOYEE_ID, String fIRST_NAME, String lAST_NAME, String eMAIL, String pHONE_NUMBER) {
		this.EMPLOYEE_ID = eMPLOYEE_ID;
		this.FIRST_NAME = fIRST_NAME;
		this.LAST_NAME = lAST_NAME;
		this.EMAIL = eMAIL;
		this.PHONE_NUMBER = pHONE_NUMBER;
	}
	public int getEMPLOYEE_ID() {
		return EMPLOYEE_ID;
	}
	public void setEMPLOYEE_ID(int eMPLOYEE_ID) {
		EMPLOYEE_ID = eMPLOYEE_ID;
	}
	public String getFIRST_NAME() {
		return FIRST_NAME;
	}
	public void setFIRST_NAME(String fIRST_NAME) {
		FIRST_NAME = fIRST_NAME;
	}
	public String getLAST_NAME() {
		return LAST_NAME;
	}
	public void setLAST_NAME(String lAST_NAME) {
		LAST_NAME = lAST_NAME;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getPHONE_NUMBER() {
		return PHONE_NUMBER;
	}
	public void setPHONE_NUMBER(String pHONE_NUMBER) {
		PHONE_NUMBER = pHONE_NUMBER;
	}
	public Date getHIRE_DATE() {
		return HIRE_DATE;
	}
	public void setHIRE_DATE(Date hIRE_DATE) {
		HIRE_DATE = hIRE_DATE;
	}
	public String getJOB_ID() {
		return JOB_ID;
	}
	public void setJOB_ID(String jOB_ID) {
		JOB_ID = jOB_ID;
	}
	public int getSALARY() {
		return SALARY;
	}
	public void setSALARY(int sALARY) {
		SALARY = sALARY;
	}
	public int getCOMMISSION_PCT() {
		return COMMISSION_PCT;
	}
	public void setCOMMISSION_PCT(int cOMMISSION_PCT) {
		COMMISSION_PCT = cOMMISSION_PCT;
	}
	public int getMANAGER_ID() {
		return MANAGER_ID;
	}
	public void setMANAGER_ID(int mANAGER_ID) {
		MANAGER_ID = mANAGER_ID;
	}
	public int getDEPARTMENT_ID() {
		return DEPARTMENT_ID;
	}
	public void setDEPARTMENT_ID(int dEPARTMENT_ID) {
		DEPARTMENT_ID = dEPARTMENT_ID;
	}
	@Override
	public String toString() {
		return "Brotherhood [EMPLOYEE_ID=" + EMPLOYEE_ID + ", FIRST_NAME=" + FIRST_NAME + ", LAST_NAME=" + LAST_NAME
				+ ", EMAIL=" + EMAIL + ", PHONE_NUMBER=" + PHONE_NUMBER + ", HIRE_DATE=" + HIRE_DATE + ", JOB_ID="
				+ JOB_ID + ", SALARY=" + SALARY + ", COMMISSION_PCT=" + COMMISSION_PCT + ", MANAGER_ID=" + MANAGER_ID
				+ ", DEPARTMENT_ID=" + DEPARTMENT_ID + "]";
	}



}
